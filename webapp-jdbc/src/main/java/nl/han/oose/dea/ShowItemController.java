package nl.han.oose.dea;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/showItems")
public class ShowItemController extends HttpServlet {

    @Inject
    private RestServiceDelegate serviceDelegate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if("ADD".equals(request.getParameter("method"))){
            String itemName = request.getParameter("itemName");
            String itemDescription = request.getParameter("itemDescription");

            Item newItem = new Item(itemName,itemDescription);
            serviceDelegate.postItem(newItem);
        }

        request.setAttribute("allItems", serviceDelegate.getAllItems());

        request.getRequestDispatcher("showItems.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
