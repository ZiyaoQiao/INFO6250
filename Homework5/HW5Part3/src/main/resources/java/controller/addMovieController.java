package controller;

import DAO.MovieDao;
import POJO.Movie;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@Controller
public class addMovieController implements ApplicationContextAware{
    @RequestMapping("showAddMovie.html")
    protected ModelAndView show(){
        return new ModelAndView("AddMovie");
    }
    @RequestMapping("addMovie.html")
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(value = "title", required = true) String title,
                                    @RequestParam(value = "actor", required = true) String actor,
                                    @RequestParam(value = "actress", required = true) String actress,
                                    @RequestParam(value = "genre", required = true) String genre,
                                    @RequestParam(value = "year", required = true) int year){

        if (title == "" || actor == "" || actor == "" || genre == "" || year == 0) {
            return new ModelAndView("Error");
        }
        if(isValid(title) && isValid(actor) && isValid(actress) && isValid(genre)) {
            HttpSession session = request.getSession();
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setActor(actor);
            movie.setActress(actress);
            movie.setGenre(genre);
            movie.setYear(year);

//        int y = Integer.parseInt(year);
//        Movie movie = new Movie();
//        movie.setYear(y);
//        movie.setGenre(genre);
//        movie.setActress(actress);
//        movie.setActor(actor);
//        movie.setTitle(title);
            MovieDao movieDao = (MovieDao) ctx.getBean("MovieDao");
            movieDao.addMovie(movie);
            movieDao.getMovies().add(movie);
            session.setAttribute("list", movieDao.getMovies());
            return new ModelAndView("Notification");
        }
        else
            return new ModelAndView("Error");
    }


    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
            + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

    private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

    private boolean isValid(String str)
    {
        if (sqlPattern.matcher(str).find())
        {
            return false;
        }
        return true;
    }
}
