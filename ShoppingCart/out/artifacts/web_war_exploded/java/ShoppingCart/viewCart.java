package ShoppingCart;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class viewCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<>();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cart</title>");
        out.println("</head>");
        out.println("<body>");
        if(cart.size()==0)
            out.println("<p>Empty Cart!</p>");
        else {
            out.println("<form action='removeCart' method='get'>");
            for (String str : cart) {
                out.println("<p><input type='checkbox' name='remove' value='"+str+"'>");
                out.println(str + "</p>");
            }
            out.println("<input type='submit' value='remove'/>");
            out.println("</form>");
        }
        out.println("<br/><input type=\"button\" value=\"Books\" onClick=\"location.href='Books.html'\"><br/>");
        out.println("<input type=\"button\" value=\"Music\" onClick=\"location.href='Music.html'\"><br/>");
        out.println("<input type=\"button\" value=\"Computer\" onClick=\"location.href='Computers.html'\"><br/>");
        out.println("</body>");
        out.println("</html>");
    }
}
