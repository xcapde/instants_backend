package com.xevicorp1.demo1.repositories;

import com.xevicorp1.demo1.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IItemRepository extends JpaRepository < Item, Long > {
//    List<Item> findAll();

    Optional <Item> findById(Long id);
}
