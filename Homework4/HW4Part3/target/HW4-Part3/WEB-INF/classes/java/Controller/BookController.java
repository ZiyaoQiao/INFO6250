package Controller;

import DAO.BookDAO;
import POJO.Book;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class BookController implements ApplicationContextAware{
    @RequestMapping("index.html")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("addBookPage.html")
    public ModelAndView responseAddBookPage(HttpServletRequest request, HttpServletResponse response) {
        int num = Integer.parseInt(request.getParameter("num"));
        request.getSession().setAttribute("num",num);
        return new ModelAndView("addBook");
    }

    @RequestMapping("addBook.html")
    public ModelAndView addBook(@RequestParam(value = "isbn", required = true) String[] isbnList,
                                @RequestParam(value = "title", required = true) String[] titleList,
                                @RequestParam(value = "authors", required = true) String[] authorsList,
                                @RequestParam(value = "price", required = true) float[] priceList
    ) throws SQLException {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        BookDAO bookDAO = (BookDAO)ctx.getBean("BookDAO");
        for (int i = 0; i < isbnList.length; i++) {
            Book book = (Book)ctx.getBean("Book");
            book.setPrice(priceList[i]);
            book.setTitle(titleList[i]);
            book.setIsbn(isbnList[i]);
            book.setAuthors(authorsList[i]);
            bookArrayList.add(book);
        }
        bookDAO.addBook(bookArrayList);
        return new ModelAndView("success");
    }


    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
