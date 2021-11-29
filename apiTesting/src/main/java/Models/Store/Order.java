package Models.Store;

import lombok.Getter;

@Getter
public class Order {
    private int id;
    private String petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}
