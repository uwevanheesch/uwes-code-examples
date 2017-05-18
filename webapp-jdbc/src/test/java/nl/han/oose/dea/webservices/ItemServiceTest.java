package nl.han.oose.dea.webservices;

import nl.han.oose.dea.Item;
import nl.han.oose.dea.database.LocalItemDAO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ItemServiceTest {

    private ItemService sut; // system under test

    @Before
    public void setUp() throws Exception {
        sut = new ItemService();
        sut.itemDAO = new LocalItemDAO();
    }

    @Test
    public void testGetAllItems() throws Exception {
        List<Item> itemList = sut.getItems();

        assertEquals(3,itemList.size());
        assertEquals("Berliner",itemList.get(0).getName());
    }


}