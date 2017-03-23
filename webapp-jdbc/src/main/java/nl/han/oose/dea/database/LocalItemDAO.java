package nl.han.oose.dea.database;

import nl.han.oose.dea.webservices.Item;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;

@Alternative
public class LocalItemDAO implements IItemDAO{

    private List<Item> allItems = new ArrayList<>();

    public LocalItemDAO() {
        allItems.add(new Item("Berliner","Deutsches Fettgebaeck"));
        allItems.add(new Item("Amerikaner","Deutsches Gebaeck"));
        allItems.add(new Item("Hamburger","Fleischbrötchen"));
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
