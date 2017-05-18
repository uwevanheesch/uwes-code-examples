package nl.han.oose.dea.webservices;

import nl.han.oose.dea.Item;
import nl.han.oose.dea.database.IItemDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTestMockito {

    @Mock
    private IItemDAO itemDAOMock;

    @InjectMocks
    private ItemService sut;

    @Test
    public void testGetItems() throws Exception {
        sut.getItems();
        verify(itemDAOMock).getItems();
    }

    @Test
    public void name() throws Exception {

    }

    @Test
    public void testGetCommaSeparatedItemsNames() throws Exception {

        ArrayList<Item> testItems = new ArrayList<>();
        testItems.add(new Item("item1","item1"));
        testItems.add(new Item("item2","item2"));
        testItems.add(new Item("item3","item3"));


        Mockito.when(itemDAOMock.getItems()).thenReturn(testItems);

        String actualResult = sut.generateListOfItemNames();

        String expectedResult = "item1,item2,item3";

        assertEquals(expectedResult,actualResult);

    }
}