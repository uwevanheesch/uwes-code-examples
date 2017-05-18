package nl.han.oose.dea.database;

import nl.han.oose.dea.Item;

import java.util.List;


public interface IItemDAO {
    List<Item> getItems();

    void addItem(Item item);

    Item findItemByName(String name);
}
