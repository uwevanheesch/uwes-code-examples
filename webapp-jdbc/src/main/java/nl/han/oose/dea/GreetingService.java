package nl.han.oose.dea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GreetingService")
public class GreetingService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        try (
                PrintWriter out = response.getWriter();
        ) {
            out.println("<html>");
            out.println("<body>");
            out.println("Hello from a servlet DEA World </br>");

            for (int i = 1; i < 100; i++) {
                out.println("This is line " + i + " </br>");
                if (i % 100 == 0) {
                    out.flush();
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }
}
