package com.xevicorp1.demo1.repositories;

import com.xevicorp1.demo1.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IItemRepository extends JpaRepository < Item, Long > {
//    List<Item> findAll();

//    Item findById(Long id);
}
