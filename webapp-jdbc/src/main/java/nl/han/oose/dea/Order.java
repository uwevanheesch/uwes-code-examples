package nl.han.oose.dea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uwe on 17/05/17.
 */
public class Order {

    private int id;
    private String description;
    private List<Item> stockItems;

    public Order(int id, String description){
        this.id = id;
        this.description = description;
        stockItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getStockItems(){
        return this.stockItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (description != null ? !description.equals(order.description) : order.description != null) return false;
        return stockItems != null ? stockItems.equals(order.stockItems) : order.stockItems == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (stockItems != null ? stockItems.hashCode() : 0);
        return result;
    }
}
