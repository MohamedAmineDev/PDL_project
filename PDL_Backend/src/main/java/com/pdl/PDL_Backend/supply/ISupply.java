package com.pdl.PDL_Backend.supply;

import java.util.List;
import java.util.UUID;

public interface ISupply {
    //TODO  implement getAll method in the supply service and then in the supply controller
    List<Supply> getAll();

    //TODO  implement add method in the supply service and then in the supply controller
    String add(Supply supply) throws Exception;

    //TODO  implement delete method in the supply service and then in the supply controller
    String delete(UUID id) throws Exception;
}
