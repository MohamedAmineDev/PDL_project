package com.pdl.PDL_Backend.command;

import com.pdl.PDL_Backend.command_product.CommandProduct;
import com.pdl.PDL_Backend.command_product.CommandProductRepository;
import com.pdl.PDL_Backend.product.Product;
import com.pdl.PDL_Backend.product.ProductRepository;
import com.pdl.PDL_Backend.user.User;
import com.pdl.PDL_Backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommandService implements ICommand {
    private final CommandRepository commandRepository;
    private final CommandProductRepository commandProductRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Command> getAll() throws Exception {
        List<Command> commands = commandRepository.findAll();
        return commands
                .stream()
                .map((c) -> new Command(c.getId(), c.getCreatedAt(), c.getTotalPrice(), c.getType(), new User(c.getClient().getId(), c.getClient().getNom(), c.getClient().getPrenom(), c.getClient().getEmail(), c.getClient().getRole(),c.getClient().isUnlocked())))
                .toList();
    }

    @Override
    public String add(Command command, boolean payed, User user) throws Exception {
        List<Product> productList = new ArrayList<>();
        List<CommandProduct> commandProductList = new ArrayList<>();
        double totalPrice=0;
        for (CommandProduct cp : command.getCommandProducts()
        ) {
            var found = productRepository.findById(cp.getProduct().getId()).orElseThrow(() -> new Exception("Product not found !"));
            found.setQuantity(found.getQuantity() - cp.getQuantity());
            cp.setCommand(command);
            commandProductList.add(cp);
            productList.add(found);
            totalPrice+=cp.getQuantity()* found.getPrice();
        }
        productRepository.saveAllAndFlush(productList);
        command.setCreatedAt(LocalDateTime.now());
        if (!payed) {
            command.setType(CommandType.WaitingForPayment);
        } else {
            command.setType(CommandType.PayedButWaitingForDelivery);
        }
        //command.setClient(userRepository.findByEmail(user.getUsername()).orElseThrow(() -> new Exception("User not found !")));
        command.setClient(user);
        command.setTotalPrice(totalPrice);
        commandRepository.saveAndFlush(command);
        commandProductRepository.saveAllAndFlush(commandProductList);
        return "true";
    }

    @Override
    public String update(UUID id, boolean delivered) throws Exception {
        var found = commandRepository.findById(id).orElseThrow(() -> new Exception("Command not found !"));
        if (delivered) {
            found.setType(CommandType.PayedAndDelivered);
        }
        commandRepository.saveAndFlush(found);
        return "true";
    }

    @Override
    public String delete(UUID id) throws Exception {
        var found = commandRepository.findById(id).orElseThrow(() -> new Exception("Command not found !"));
        commandRepository.delete(found);
        commandRepository.flush();
        return "true";
    }

    @Override
    public List<Command> getAllCommandsThatAreWaitingForPayment() throws Exception {
        return commandRepository.findByType(CommandType.WaitingForPayment)
                .stream()
                .map((c) -> new Command(c.getId(), c.getCreatedAt(), c.getTotalPrice(), c.getType(), new User(c.getClient().getId(), c.getClient().getNom(), c.getClient().getPrenom(), c.getClient().getEmail(), c.getClient().getRole(),c.getClient().isUnlocked())))
                .toList();
    }

    @Override
    public List<Command> getAllCommandsThatArePayedWaitingForDelivery() throws Exception {
        return commandRepository.findByType(CommandType.PayedButWaitingForDelivery)
                .stream()
                .map((c) -> new Command(c.getId(), c.getCreatedAt(), c.getTotalPrice(), c.getType(), new User(c.getClient().getId(), c.getClient().getNom(), c.getClient().getPrenom(), c.getClient().getEmail(), c.getClient().getRole(),c.getClient().isUnlocked())))
                .toList();
    }

    @Override
    public List<Command> getAllCommandsThatArePayedAndDelivered() throws Exception {
        return commandRepository.findByType(CommandType.PayedAndDelivered)
                .stream()
                .map((c) -> new Command(c.getId(), c.getCreatedAt(), c.getTotalPrice(), c.getType(), new User(c.getClient().getId(), c.getClient().getNom(), c.getClient().getPrenom(), c.getClient().getEmail(), c.getClient().getRole(),c.getClient().isUnlocked())))
                .toList();
    }

    @Override
    public List<Command> getAllCommandsOfAUser(User user) throws Exception {
        return commandRepository.findByUserEmail(user.getUsername())
                .stream()
                .map((c) -> new Command(c.getId(), c.getCreatedAt(), c.getTotalPrice(), c.getType(), new User(c.getClient().getId(), c.getClient().getNom(), c.getClient().getPrenom(), c.getClient().getEmail(), c.getClient().getRole(),c.getClient().isUnlocked())))
                .toList();
    }
}
