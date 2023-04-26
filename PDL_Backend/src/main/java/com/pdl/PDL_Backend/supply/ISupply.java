package com.pdl.PDL_Backend.supply;

import java.util.List;
import java.util.UUID;

public interface ISupply {
    List<Supply> getAll();

    String add(Supply supply) throws Exception;

    String delete(UUID id) throws Exception;
}
