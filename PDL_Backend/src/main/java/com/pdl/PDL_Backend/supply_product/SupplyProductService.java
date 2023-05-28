package com.pdl.PDL_Backend.supply_product;

import com.pdl.PDL_Backend.product.Product;
import com.pdl.PDL_Backend.supply.Supply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplyProductService implements ISupplyProduct {
    private final SupplyProductRepository supplyProductRepository;

    @Override
    public List<SupplyProduct> getDetails(UUID supplyId) {
        return supplyProductRepository.findBySupplyId(supplyId).stream()
                .map(supplyProduct -> new SupplyProduct(supplyProduct.getId(), supplyProduct.getQuantity(), new Supply(supplyProduct.getSupply().getId(), supplyProduct.getSupply().getInterventionDate()), new Product(supplyProduct.getProduct().getId(), supplyProduct.getProduct().getLabel(), supplyProduct.getProduct().getQuantity(), supplyProduct.getProduct().getPrice(),supplyProduct.getProduct().getImageLink())))
                .toList();
    }
}
