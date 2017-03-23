package nl.han.oose.dea;

import nl.han.oose.dea.database.IItemDAO;
import nl.han.oose.dea.webservices.Item;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet("/showItems")
public class ShowItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebClient webClient = WebClient.create("http://localhost:8080/").path("/items").accept("application/json");
        List<Item> itemList = (List<Item>) webClient.getCollection(Item.class);
        request.setAttribute("allItems", itemList);
        request.getRequestDispatcher("showItems.jsp").forward(request, response);

    }
}
