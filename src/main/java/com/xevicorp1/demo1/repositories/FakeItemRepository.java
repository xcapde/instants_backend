package com.xevicorp1.demo1.repositories;

import com.xevicorp1.demo1.models.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

// LLISTA FAKER DE LA BASE DE DADES
// @Repository injecta un BEAN que fa que es facin automàticament news de l'ItemRepository i igualar-lo..
// ..igualar-lo a ItemController (constructor itemController). SÓN COM COMPONENTS --> es pot "injectar" a qualsevol..
// .. qualsevol mètode i funció sense haver de fer un "new" abans.
@Repository
public class FakeItemRepository implements IItemRepository {

    @Override
    public List<Item> findAll() {
        return getItemList();
    }

    @Override
    public Item findById(Long id){
        var itemList = this.getItemList();
        var item =  itemList.stream().filter(i -> i.getId() == id).findFirst().get();
        return item;
    }

    private List<Item> getItemList() {
        return List.of(new Item("Title1", "First description", "URL1", 1L),
                new Item("Title2", "Second description", "URL2", 2L),
                new Item("Title3", "Third description", "URL3", 3L));
    }
}
