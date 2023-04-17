package com.pdl.PDL_Backend.command_product;

import java.util.List;
import java.util.UUID;

public interface ICommandProduct {
    List<CommandProduct> getAComandDetails(UUID id) throws Exception;
}
