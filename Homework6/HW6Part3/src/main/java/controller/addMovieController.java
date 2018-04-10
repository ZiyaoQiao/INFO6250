package controller;

import DAO.MovieDao;
import POJO.Movie;
import Validator.movieValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@Controller
public class addMovieController implements ApplicationContextAware {
    @Autowired
    @Qualifier("movieValidator")
    movieValidator validator;


    @Autowired
    @Qualifier("MovieDao")
    MovieDao movieDao;

    @RequestMapping("showAddMovie.html")
    protected ModelAndView show(){
        return new ModelAndView("AddMovie");
    }


    @RequestMapping("addMovie.html")
    protected ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("movie") Movie movie, BindingResult result){

        validator.validate(movie, result);
        if(result.hasErrors())
            return new ModelAndView("Error");
//        if (title == "" || actor == "" || actor == "" || genre == "" || year == 0) {
//            return new ModelAndView("Error");
//        }
        if(!isValid(movie.getTitle()) && !isValid(movie.getActor()) && !isValid(movie.getActress()) && !isValid(movie.getGenre()))
            return new ModelAndView("Error");
//            HttpSession session = request.getSession();
//            Movie movie = new Movie();
//            movie.setTitle(title);
//            movie.setActor(actor);
//            movie.setActress(actress);
//            movie.setGenre(genre);
//            movie.setYear(year);

//        int y = Integer.parseInt(year);
//        Movie movie = new Movie();
//        movie.setYear(y);
//        movie.setGenre(genre);
//        movie.setActress(actress);
//        movie.setActor(actor);
//        movie.setTitle(title);
            //MovieDao movieDao = (MovieDao) ctx.getBean("MovieDao");
        HttpSession session = request.getSession();
        movieDao.addMovie(movie);
        movieDao.getMovies().add(movie);
        session.setAttribute("list", movieDao.getMovies());
        return new ModelAndView("Notification");
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
