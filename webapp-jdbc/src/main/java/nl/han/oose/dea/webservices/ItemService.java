package nl.han.oose.dea.webservices;

import nl.han.oose.dea.database.ItemDAOMySQL;

import javax.ws.rs.*;
import java.util.Collection;

@Path("/items")
public class ItemService {

    private ItemDAOMySQL itemDAO = new ItemDAOMySQL();

    @GET
    @Produces("application/json")
    public Collection<Item> getItems(){
        return itemDAO.getItems();
    }

    @POST
    @Consumes("application/json")
    public void addItem(Item item){
        itemDAO.addItem(item);
    }


    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Item getItem(@PathParam("name") String itemName){
        return itemDAO.findItemByName(itemName);
    }


}
