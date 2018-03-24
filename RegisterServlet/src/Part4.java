import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Part4 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> formContent = request.getParameterMap();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>All Parameter</title></head>");
        out.println("<body>");
        for (Map.Entry<String, String[]> entry : formContent.entrySet()) {
            String name = entry.getKey();
            String[] value = entry.getValue();
            out.println("<p>" + name + ": " );
            if(value.length == 0)
                out.println("Empty");
            else {
                for (String str : value) {
                    out.println(str + " ; ");
                }
            }
            out.println("</p>");
        }
    }
}
