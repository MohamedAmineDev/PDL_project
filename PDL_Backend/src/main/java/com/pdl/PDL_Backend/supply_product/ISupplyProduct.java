package com.pdl.PDL_Backend.supply_product;

import java.util.List;
import java.util.UUID;

public interface ISupplyProduct {
    //TODO  implement getDetails method in the supply service and then in the supply controller
    List<SupplyProduct> getDetails(UUID supplyId);
}
