package com.xevicorp1.items.controllers;

import com.xevicorp1.items.models.Item;
import com.xevicorp1.items.repositories.IItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class itemController {

    // DEPENDENCY INJECTION (DI) -> INVERSION OF CONTROL (IOC) -> SpringBoot..
    // ..SprinBoot -> Utilitza sistema de BEANS -> injecten i fan news.
    private IItemRepository itemRepository;

    public itemController(IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/health")
    String healthcheck(){
        return "Estic sa :p";
    }

    @GetMapping("/items")
    List<Item> getAll(){
        var itemList = this.itemRepository.findAll();
        return itemList;
    }

    @GetMapping("/items/{id}")
        Item getById(
                @PathVariable Long id){
        Item item =  this.itemRepository.findById(id).get();
        return item;
    }

    @PostMapping("/items")
        Item createItem(
                @RequestBody Item newItem){
        var item  = this.itemRepository.save(newItem);
        return item;
    }

    @PutMapping("/items/{id}")
        Item updateItem(
                @PathVariable Long id,
                @RequestBody Item itemDetails) {
        Item item = this.itemRepository.findById(id).get();

        item.setTitle(itemDetails.getTitle());
        item.setDescription(itemDetails.getDescription());
        item.setImage_url(itemDetails.getImage_url());
        final Item updatedItem = this.itemRepository.save(item);
        return updatedItem;
    }

    @DeleteMapping("/items/{id}")
        Item deleteEmployee(
                @PathVariable Long id){
        Item item = this.itemRepository.findById(id).get();

        this.itemRepository.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return item;
    }

   /*@GetMapping(value ="/items" , params="search")
        Item getSearchItem(
            @RequestParam String search) {
        var items = FakeItemRepository.getItemList();
        var itemsSearched = items.stream()
               .filter(i -> i.getTitle().contains(search) || i.getDescription().contains(search))
               .collect((Collectors.toList()));
        return itemsSearched;
   }*/



    // ELIMINEM D'AQUÍ PERQUÈ NO ÉS REPONSABILITAT D'AQUEST OBJECTE, HO TRASLLADEM A FAKEITEMREPOSITORY I IMPORTEM A GETALL I A ON CALGUI
/*    private List<Item> getItemList() {
        return List.of(new Item("Title1", "First description", "URL1", 1L),
                new Item("Title2", "Second description", "URL2", 2L),
                new Item("Title3", "Third description", "URL3", 3L));
    }*/

// 1 GET BY ID (/items/id) -> objecte json Item

// 2 SEARCH (/items/search?name=alex) --> Pista: @RequestParam // content, no igual // ÚS D'STREAMS O BUCLES
// cars.stream().anyMatch(car -> car.getColor().equals("Grey")).collect(Collectors.toList());

// 3 REFACTOR a Repository (S.O.L.I.D.)

// 4 CAPA ADO
// REFACTOR A REPOSITORY

}
