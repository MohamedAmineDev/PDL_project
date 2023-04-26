package com.pdl.PDL_Backend.supply_product;

import java.util.List;
import java.util.UUID;

public interface ISupplyProduct {
    List<SupplyProduct> getDetails(UUID supplyId);
}
