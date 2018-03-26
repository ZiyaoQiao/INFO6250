package controller;

import DAO.MovieDao;
import POJO.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.regex.Pattern;


@Controller
public class searchMovieController {
    @RequestMapping("showSearchMovie.html")
    public ModelAndView show(){
        return new ModelAndView("SearchMovie");
    }
    @RequestMapping("searchMovie.html")
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value = "keyword", required = true) String keyword,
                                 @RequestParam(value = "searchBy", required = false) String value
    ) {
        if(keyword == "" || value == null)
            return new ModelAndView("Error");
        if(isValid(keyword)) {
            String searchWords = keyword + " in " + value;
            MovieDao movieDao = new MovieDao();
            ArrayList<Movie> movieList = (ArrayList<Movie>) movieDao.getMoviesBy(value, keyword);
            request.getSession().setAttribute("keyword", searchWords);
            request.getSession().setAttribute("movieList", movieList);
            return new ModelAndView("MovieDetail");
        }
        else
            return new ModelAndView("Error");
    }

    /**正则表达式**/
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
