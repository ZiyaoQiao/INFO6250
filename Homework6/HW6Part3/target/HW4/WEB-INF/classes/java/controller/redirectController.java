package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class redirectController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String select = httpServletRequest.getParameter("selection");
        if (select.equals("browse")) {
            return new ModelAndView("redirect:/searchMovie.html");
        } else if (select.equals("add")) {
            return new ModelAndView("redirect:/addMovie.html");
        } else
            return null;
    }
}
