package Lab3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginServlet{



    @RequestMapping(value = "loginAction.do", method = RequestMethod.POST)
    protected ModelAndView loginRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //Normally, we will need to connect to the DB to validate username/password
            //DB Connection will be discussed later
            //For now, we assume, username: admin, password: secret
            if (username.equals("admin") && password.equals("admin")) {
                //username/password correct, go to search page
                //add username to the session
                if (request.getParameter("rememberMe")!= null && request.getParameter("rememberMe").equals("remember")){
                    Cookie cookie = new Cookie("username",username);
                    response.addCookie(cookie);
                    cookie = new Cookie("password",password);
                    response.addCookie(cookie);

                }
                session.setAttribute("username", username);
                //response.sendRedirect("searchCourse.jsp");
                return new ModelAndView("searchCourse");
            } else {
                return new ModelAndView("index");
                //response.sendRedirect("index.jsp");
                //username/password not correct, send user to error-page or login page
            }

    }

    @RequestMapping(value="logout.do", method=RequestMethod.GET)
    protected ModelAndView logoutRequest(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i = 0; i<cookies.length; i++){
                if(cookies[i].getName().equals("username")){
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
                if(cookies[i].getName().equals("password")){
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
        }
        return new ModelAndView("index");
        //response.sendRedirect("index.jsp");
    }

//
//    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        String type = httpServletRequest.getParameter("action");
//            Cookie[] cookies = httpServletRequest.getCookies();
//            String username = null;
//            String password = null;
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("username"))
//                    username = cookie.getValue();
//                if (cookie.getName().equals("password"))
//                    password = cookie.getValue();
//            }
//            if (username != null && password != null && username.equals("admin") && password.equals("admin"))
//                return new ModelAndView("searchCourse");
//            else
//                return new ModelAndView("index");
//    }
//


}
