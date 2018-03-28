package Controller;

import DAO.BookDAO;
import POJO.Books;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

@Controller
public class BookController implements ApplicationContextAware {
    @RequestMapping("index.html")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @Autowired
    @Qualifier("BookDAO")
    BookDAO bookDAO;

    @RequestMapping("addBookPage.html")
    public ModelAndView responseAddBookPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            askForPassword(response);
        } else {
            String userInfo = authorization.substring(6).trim();
            BASE64Decoder decoder = new BASE64Decoder();
            String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
            int index = nameAndPassword.indexOf(":");
            String user = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index + 1);
            if(user.equals("admin") && password.equals("admin")) {
                int num = Integer.parseInt(request.getParameter("num"));
                if (num < 1)
                    return new ModelAndView("index");
                request.getSession().setAttribute("num", num);
                return new ModelAndView("addBook");
            }
            else
                askForPassword(response);
        }
        return new ModelAndView("index");
    }


    private void askForPassword(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "BASIC realm=\"Insider-Trading\"");
    }


    @RequestMapping("addBook.html")
    public ModelAndView addBook(@RequestParam(value = "isbn", required = true) String[] isbnList,
                                @RequestParam(value = "title", required = true) String[] titleList,
                                @RequestParam(value = "authors", required = true) String[] authorsList,
                                @RequestParam(value = "price", required = true) double[] priceList
    ) throws SQLException {
        if (isValid(isbnList) && isValid(titleList) && isValid(authorsList)) {
            ArrayList<Books> bookArrayList = new ArrayList<>();
            //BookDAO bookDAO = (BookDAO) ctx.getBean("BookDAO");
            for (int i = 0; i < isbnList.length; i++) {
                Books book = (Books) ctx.getBean("Books");
                book.setPrice(priceList[i]);
                book.setTitle(titleList[i]);
                book.setIsbn(isbnList[i]);
                book.setAuthors(authorsList[i]);
                bookArrayList.add(book);
            }
            bookDAO.addBook(bookArrayList);
            return new ModelAndView("success");
        } else
            return new ModelAndView("error");
    }


    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }


    private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
            + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

    private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

    private boolean isValid(String[] str) {
        for (String s : str) {
            if (sqlPattern.matcher(s).find()) {
                return false;
            }
        }
        return true;
    }
}
