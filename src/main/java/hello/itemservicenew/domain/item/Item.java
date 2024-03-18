package hello.itemservicenew.domain.item;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer Quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        Quantity = quantity;
    }
}
