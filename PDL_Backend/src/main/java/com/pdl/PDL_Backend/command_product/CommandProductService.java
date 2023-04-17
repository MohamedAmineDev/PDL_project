package com.pdl.PDL_Backend.command_product;

import com.pdl.PDL_Backend.command.Command;
import com.pdl.PDL_Backend.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommandProductService implements ICommandProduct {
    private final CommandProductRepository commandProductRepository;

    @Override
    public List<CommandProduct> getAComandDetails(UUID id) throws Exception {
        return commandProductRepository.getDetails(id).stream()
                .map(commandProduct -> new CommandProduct(commandProduct.getId(), commandProduct.getQuantity(), new Command(), new Product(commandProduct.getProduct().getId(), commandProduct.getProduct().getLabel(), commandProduct.getProduct().getQuantity(), commandProduct.getProduct().getPrice(), null, new ArrayList<>())))
                .toList()
                ;
    }
}
