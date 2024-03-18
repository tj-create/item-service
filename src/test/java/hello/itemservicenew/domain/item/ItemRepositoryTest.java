package hello.itemservicenew.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void after() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("ItemA", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Item findItem = itemRepository.findById(savedItem.getId());

        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 10);

        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> findItems = itemRepository.findAll();

        assertThat(findItems.size()).isEqualTo(2);
        assertThat(findItems).contains(item1, item2);
    }

    @Test
    void updateItem() {
        Item item = new Item("itemA", 10000, 10);
        itemRepository.save(item);

        Item updateItem = new Item("updateItem", 20000, 20);
        Item updatedItem = itemRepository.updateItem(item.getId(), updateItem);
        assertThat(updatedItem.getItemName()).isEqualTo(updateItem.getItemName());
    }

}