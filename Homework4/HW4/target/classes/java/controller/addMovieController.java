package controller;

import DAO.MovieDao;
import POJO.Movie;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addMovieController extends SimpleFormController {

    public addMovieController() {
        setCommandClass(POJO.Movie.class);
        setCommandName("add");
        setFormView("AddMovie");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {

        HttpSession session = request.getSession();
        Movie movie = (Movie) command;
        if (movie.getTitle() == null || movie.getActor() == null || movie.getActress() == null || movie.getGenre() == null || movie.getYear() == 0) {
            return new ModelAndView("Error");
        }
//        int y = Integer.parseInt(year);
//        Movie movie = new Movie();
//        movie.setYear(y);
//        movie.setGenre(genre);
//        movie.setActress(actress);
//        movie.setActor(actor);
//        movie.setTitle(title);
        MovieDao movieDao = (MovieDao)this.getApplicationContext().getBean("MovieDao");
        movieDao.getMovies().add(movie);
        movieDao.addMovie(movie);
        session.setAttribute("list", movieDao.getMovies());
        return new ModelAndView("Notification");
    }
}
