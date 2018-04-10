package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class redirectController {
    @RequestMapping("index.html")
    public ModelAndView index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //if(httpServletRequest.getRemoteUser() != null)
            return new ModelAndView("MovieStore");
        //return new ModelAndView("login");
    }

    @RequestMapping("selection.html")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String select = httpServletRequest.getParameter("selection");
        if (select.equals("browse")) {
            return new ModelAndView("redirect:/showSearchMovie.html");
        } else if (select.equals("add")) {
            return new ModelAndView("redirect:/showAddMovie.html");
        } else
            return null;
    }
}
