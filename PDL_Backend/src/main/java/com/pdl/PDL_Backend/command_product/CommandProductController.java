package com.pdl.PDL_Backend.command_product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/command_product")
@RequiredArgsConstructor
public class CommandProductController implements ICommandProduct {
    private final CommandProductService productService;

    @GetMapping(path = "/details/{id}")
    @Override
    public List<CommandProduct> getAComandDetails(@PathVariable("id") UUID id) {
        try {
            return productService.getAComandDetails(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}
