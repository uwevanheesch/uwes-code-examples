package nl.han.oose.dea.webservices;


import nl.han.oose.dea.Item;
import nl.han.oose.dea.database.IItemDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/items")
public class ItemService {

    @Inject
    IItemDAO itemDAO;

    @GET
    @Produces("application/json")
    public List<Item> getItems() {
        return itemDAO.getItems();
    }


    @POST
    @Consumes("application/json")
    public void addItem(Item item) {
        itemDAO.addItem(item);
    }


    public String generateListOfItemNames(){
        StringBuilder builder = new StringBuilder();
        for(Item item: itemDAO.getItems()){
            builder.append(item.getName()).append(",");
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 1);
    }

    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Item getItem(@PathParam("name") String itemName) {
        return itemDAO.findItemByName(itemName);
    }




}
