package Lab3;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshLogin implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String type = httpServletRequest.getParameter("action");
        Cookie[] cookies = httpServletRequest.getCookies();
        String username = null;
        String password = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username"))
                username = cookie.getValue();
            if (cookie.getName().equals("password"))
                password = cookie.getValue();
        }
        if (username != null && password != null && username.equals("admin") && password.equals("admin"))
            return new ModelAndView("searchCourse");
        else
            return new ModelAndView("index");
    }
}
