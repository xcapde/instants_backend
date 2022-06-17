package com.xevicorp1.demo1.repositories;

import com.xevicorp1.demo1.models.Item;

import java.util.List;

// GENERAT AUTO DES DE LA CLASSE DE REPOSITORY..
public interface IItemRepository {
    List<Item> findAll();

    Item findById(Long id);
}
