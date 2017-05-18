package nl.han.oose.dea.database;

import nl.han.oose.dea.Item;

import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@Alternative
public class LocalItemDAO implements IItemDAO {

    private static List<Item> allItems = new ArrayList<>();

    public LocalItemDAO() {
        if (allItems.size() == 0) {
            allItems.add(new Item("Berliner", "Deutsches Fettgebaeck"));
            allItems.add(new Item("Amerikaner", "Deutsches Gebaeck"));
            allItems.add(new Item("Hamburger", "Fleischbrötchen"));
        }
    }

    @Override
    public List<Item> getItems() {
        return allItems;
    }

    @Override
    public void addItem(Item item) {
        allItems.add(item);

    }

    @Override
    public Item findItemByName(String name) {
        return allItems.get(0);
    }
}
