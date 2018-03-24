package controller;

import DAO.MovieDao;
import POJO.Movie;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class searchMovieController extends SimpleFormController {
    public searchMovieController() {
        setCommandClass(Movie.class);
        setFormView("SearchMovie");
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {
        String keyword = request.getParameter("keyword");
        String value = request.getParameter("searchBy");
        String searchWords = keyword + " in " + value;
        MovieDao movieDao = new MovieDao();
        ArrayList<Movie> movieList = movieDao.getMoviesBy(value, keyword);
        request.getSession().setAttribute("keyword", searchWords);
        request.getSession().setAttribute("movieList", movieList);
        return new ModelAndView("MovieDetail");
    }
}
