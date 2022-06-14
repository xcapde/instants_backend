package com.xevicorp1.demo1.controllers;

import com.xevicorp1.demo1.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class itemController {

    @GetMapping("/health")

    String healthcheck(){
        return "hola, tinc health";
    }

    private List<Item> getItemList() {
        return List.of(new Item("Title 1", "First description", "URL1", 1L), new Item("Title 2", "Second description", "URL2", 2L));
    }

    @GetMapping("/items")
    List<Item> getItem(){
        var itemList = this.getItemList();
        return itemList;
    }

    @GetMapping("/items/{id}")
    Item getById(@PathVariable Long id) {
        var itemList = this.getItemList();
        var item =  itemList.stream().filter(i -> i.getId() == id).findFirst().get();
        return item;
    }

//  @GetMapping("/items/search?title=title")
//  List<Item> getBySearch(@RequestParam String title) {
//  var itemList = this.getItemList();


    @GetMapping(value ="/items" , params="title")

    List<Item> getTitleBySearch(@RequestParam String title) {
        var itemList = this.getItemList();
        return itemList.stream().filter(i -> i.getTitle().contains(title)).collect(Collectors.toList());
    }

    @GetMapping(value ="/items" ,params="description")

    List<Item> getDescriptionBySearch(@RequestParam String description) {
        var itemList = this.getItemList();
        return itemList.stream().filter(i -> i.getDescription().contains(description)).collect(Collectors.toList());
    }

// 1 GET BY ID (/items/id) -> objecte json Item
// 2 SEARCH (/items/search?title=title) --> Pista: @RequestParam // content, no igual // ÚS D'STREAMS O BUCLES
// cars.stream().anyMatch(car -> car.getColor().equals("Grey")).collect(Collectors.toList());

// 3 REFACTOR a Repository (S.O.L.I.D.)
}
