package nl.han.oose.dea.database;

import nl.han.oose.dea.Item;
import nl.han.oose.dea.Order;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ItemDAOMySQLTest {

    private IDBConnectionFactory factoryMock = new DBConnectionFactoryMock();
    private ItemDAOMySQL sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        sut = new ItemDAOMySQL();
        sut.dbConnectionFactory = factoryMock;

        File script = new File(getClass().getResource("/testDB_Create.sql").getFile());
        RunScript.execute(factoryMock.getConnection(), new FileReader(script));
    }

    @Test
    public void testGetItems() throws Exception {
        Item expectedItem = new Item("Item1", "Item1Description");
        assertEquals(expectedItem, sut.getItems().get(0));
    }

    @Test
    public void testGetOrderByID() throws Exception {
        Order expectedOrder = new Order(1, "Order1");
        expectedOrder.getStockItems().add(new Item("Item1", "Item1Description"));
        expectedOrder.getStockItems().add(new Item("Item2", "Item2Description"));
        assertEquals(expectedOrder, sut.getOrderById(1));
    }

    @Test
    public void testOrderNotExists() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No order with that id found: 2");

        sut.getOrderById(2);
    }


    public void testDatabaseProblem() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Values could not be retrieved due to database problem.");

        IDBConnectionFactory dbFactoryMock = Mockito.mock(IDBConnectionFactory.class);

        Mockito.when(dbFactoryMock.getConnection()).thenThrow(new SQLException());

        sut.dbConnectionFactory = dbFactoryMock;
        sut.getOrderById(1);
    }
}