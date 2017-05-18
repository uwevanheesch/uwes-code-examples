package nl.han.oose.dea.webservices;

import nl.han.oose.dea.Item;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class ItemServiceOLD {

    private ItemService sut;

    @Before
    public void setUp() throws Exception {
        sut = new ItemService();
       // sut.itemDAO = new LocalItemDAO();
    }

    @Test
    public void testGetItems() throws Exception {
        List<Item> actualItems = sut.getItems();
        assertEquals(3,actualItems.size());
        assertEquals("Berliner",actualItems.get(0).getName());
    }

}