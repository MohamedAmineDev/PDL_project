package com.pdl.PDL_Backend.supply_product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/supply_product")
@RequiredArgsConstructor
public class SupplyProductController implements ISupplyProduct {
    private final SupplyProductService service;

    @GetMapping(path = "/admin/supply/details/{supplyId}")
    @Override
    public List<SupplyProduct> getDetails(@PathVariable("supplyId") UUID supplyId) {
        return service.getDetails(supplyId);
    }
}
