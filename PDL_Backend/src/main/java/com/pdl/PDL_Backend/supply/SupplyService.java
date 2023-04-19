package com.pdl.PDL_Backend.supply;

import com.pdl.PDL_Backend.product.Product;
import com.pdl.PDL_Backend.product.ProductRepository;
import com.pdl.PDL_Backend.supply_product.SupplyProduct;
import com.pdl.PDL_Backend.supply_product.SupplyProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplyService implements ISupply {
    private final SupplyRepository supplyRepository;
    private final ProductRepository productRepository;
    private final SupplyProductRepository supplyProductRepository;

    @Override
    public List<Supply> getAll() {
        return supplyRepository.findAll().stream()
                .map(supply -> new Supply(supply.getId(), supply.getInterventionDate()))
                .toList();
    }

    @Override
    public String add(Supply supply) throws Exception {
        List<Product> productList = new ArrayList<>();
        List<SupplyProduct> supplyProductList = new ArrayList<>();
        for (SupplyProduct sp : supply.getSupplyProductList()
        ) {
            Product p = productRepository.findById(sp.getProduct().getId()).orElseThrow(() -> new Exception("Product not found !"));
            p.setQuantity(p.getQuantity() + sp.getQuantity());
            productList.add(p);
            sp.setSupply(supply);
            supplyProductList.add(sp);
        }
        productRepository.saveAllAndFlush(productList);
        supply.setInterventionDate(LocalDateTime.now());
        supplyRepository.saveAndFlush(supply);
        supplyProductRepository.saveAllAndFlush(supplyProductList);
        return "true";
    }

    @Override
    public String delete(UUID id) throws Exception {
        List<SupplyProduct> supplyProductList = supplyProductRepository.findBySupplyId(id);
        List<Product> productList = new ArrayList<>();
        //List<SupplyProduct> newSupplyProductList = new ArrayList<>();
        for (SupplyProduct sp : supplyProductList
        ) {
            Product p = productRepository.findById(sp.getProduct().getId()).orElseThrow(() -> new Exception("Product not found !"));
            p.setQuantity(p.getQuantity() - sp.getQuantity());
            productList.add(p);
            //newSupplyProductList.add(sp);
        }
        productRepository.saveAllAndFlush(productList);
        supplyProductRepository.deleteAll(supplyProductList);
        supplyProductRepository.flush();
        supplyRepository.deleteById(id);
        supplyRepository.flush();
        return "true";
    }
}
