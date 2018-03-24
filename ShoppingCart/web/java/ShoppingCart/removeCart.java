package ShoppingCart;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class removeCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
        String[] remove = request.getParameterValues("remove");
        Iterator iter = cart.iterator();
        if(remove != null) {
            for (String s : remove) {
                while (iter.hasNext()) {
                    if (s.equals((String) iter.next())) {
                        iter.remove();
                        break;
                    }
                }
                iter = cart.iterator();
            }
            session.setAttribute("cart", cart);
        }
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