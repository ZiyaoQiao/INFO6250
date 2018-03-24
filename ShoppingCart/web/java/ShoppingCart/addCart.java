package ShoppingCart;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class addCart extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<>();
        String str = request.getParameter("type");
        String[] goods;
        if(str.equals("book")){
            goods = request.getParameterValues("Books");
            if (goods == null) {
                printHead(out);
                out.println("<p>Empty!</p><br/>");
                printFunction(out);
                return;
            }
            for(String s:goods) {
                cart.add(s);
            }
            session.setAttribute("cart",cart);
            printHTML(out,goods);
        }else if(str.equals("music")){
            goods = request.getParameterValues("Music");
            if (goods == null) {
                printHead(out);
                out.println("<p>Empty!</p><br/>");
                printFunction(out);
                return;
            }
            for(String s:goods) {
                cart.add(s);
            }
            session.setAttribute("cart",cart);
            printHTML(out,goods);
        }else if(str.equals("computer")){
            goods = request.getParameterValues("Computers");
            if (goods == null) {
                printHead(out);
                out.println("<p>Empty!</p><br/>");
                printFunction(out);
                return;
            }
            for(String s:goods) {
                cart.add(s);
            }
            session.setAttribute("cart",cart);
            printHTML(out,goods);
        }
    }
    public void printHead(PrintWriter out){
        out.println("<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <title>Result</title>\n" +
                "</head>\n" +
                "<body>\n");
    }
    public void printFunction(PrintWriter out){
        out.println("<br/><input type=\"button\" value=\"Books\" onClick=\"location.href='Books.html'\"><br/>");
        out.println("<input type=\"button\" value=\"Music\" onClick=\"location.href='Music.html'\"><br/>");
        out.println("<input type=\"button\" value=\"Computers\" onClick=\"location.href='Computers.html'\"><br/>" +
                "<form action=\"viewCart\"><input type=\"submit\" method=\"POST\" value=\"View Cart\"></form>\n" +
                "</body>\n" +
                "</html>");
    }
    public void printHTML(PrintWriter out,String[] list){
        printHead(out);
        out.println("<h1>Successfully Added to Cart</h1>\n");
        for(String str: list){
            out.println("<p>" + str + "</p>");
        }
        printFunction(out);
    }
}

