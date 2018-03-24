import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Part2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Enumeration names = request.getHeaderNames();
        Enumeration headers;
        out.println("<html>");
        out.println("<head><title>All Headers</title></head>");
        out.println("<body>");
        while(names.hasMoreElements()){
            String tmp = (String)names.nextElement();
            headers = request.getHeaders(tmp);
            out.println(tmp + ":");
            while(headers.hasMoreElements()){
                String str = (String)headers.nextElement();
                out.println("<p>"+str+"</p>");
            }
        }
        out.println("</body></html>");
    }
}
