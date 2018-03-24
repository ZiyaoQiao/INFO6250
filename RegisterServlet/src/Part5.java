import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Part5 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>All Parameter</title></head>");
        out.println("<body>");

        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()){
            String tmp = (String)names.nextElement();
            out.println("<p>" + tmp + " : ");
            String[] values = request.getParameterValues(tmp);
            for(String str: values){
                out.println(str + " ; ");
            }
        }
    }
}
