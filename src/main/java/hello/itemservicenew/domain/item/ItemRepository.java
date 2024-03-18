package hello.itemservicenew.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long findId) {
        return store.get(findId);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public Item updateItem(Long itemId, Item updateItem) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateItem.getItemName());
        findItem.setPrice(updateItem.getPrice());
        findItem.setQuantity(updateItem.getQuantity());

        return findItem;
    }

    public void clearStore() {
        store.clear();
    }

}
