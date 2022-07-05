package hello.itemservice.dmain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }
    @Test
    void save() {

        //given
        Item item = new Item("itemA", 10000, 10);
        Item item1 = new Item("itemA", 10000, 10);
        //when
        Item savedItem = itemRepository.save(item);
        Item savedItem2 = itemRepository.save(item1);
        //then
        Item findItem = itemRepository.findById(item.getId());
        Item findItem2 = itemRepository.findById(item1.getId());
        assertThat(savedItem2).isEqualTo(findItem2);
    }
    @Test
    void findAll() {

        //given
        Item item = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 10);
        itemRepository.save(item);
        itemRepository.save(item2);
        //when
        List<Item> items = itemRepository.findAll();
        //then
        assertThat(items.size()).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(items).contains(item, item2);

    }

    @Test
    void update() {
        //given
        Item item = new Item("itemA", 10000, 10);
        Item updatedItemName = new Item("updatedItemName", 20000, 15);
        itemRepository.save(item);

        //when
        itemRepository.update(item.getId(), updatedItemName);

        //then
        assertThat(item.getItemName()).isEqualTo(updatedItemName.getItemName());
        System.out.println("item = " + item);

    }


}