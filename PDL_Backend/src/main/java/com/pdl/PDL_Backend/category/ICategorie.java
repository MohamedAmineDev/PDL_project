package com.pdl.PDL_Backend.category;

import java.util.List;
import java.util.UUID;

public interface ICategorie {
    List<Category> getAll() throws Exception;

    String add(Category category) throws Exception;

    String update(UUID id, Category category) throws Exception;

    String delete(UUID id) throws Exception;
}
