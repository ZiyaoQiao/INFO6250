import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

public class Part6 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part6</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Page 1</h2>");
        out.println("<form action = 'Part6?page=p1' method = 'post'>");
        out.println("<p>How many children do you have?</p>"
                + "<input name='ans' />");
        out.println("<input type = 'submit' value = 'Next' name = 'Submit Query'/><br /></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    //Service method
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession sessions = request.getSession();

        String page = request.getParameter("page");

        if(page.equals("p1")){
            //page2
            String ans = request.getParameter("ans");
            sessions.setAttribute("ans",ans);

            int num = Integer.parseInt(ans);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Part6</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Page 2</h2>");
            out.println("<form action = 'Part6?page=result' method = 'post'>");
            for(int i = 1; i <= num; i++) {
                out.println("<p>Please enter the name of child number " +i +"</p>"
                        + "<input name='ansName'/></p>");
            }
            //out.println("<input type='hidden' name='page' value='p2' />");
            out.println("<input type =  'submit' value = 'Next' name = 'button'/><br />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }

        else if(page.equals("result")){
            String[] ans = request.getParameterValues("ansName");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Quiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Results here:</h2>");
            out.println("<ul>");
            int i = 1;
            for(String str:ans) {
                out.println("<li>Answer" + i +": "+ str + "</li>");
                i++;
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
