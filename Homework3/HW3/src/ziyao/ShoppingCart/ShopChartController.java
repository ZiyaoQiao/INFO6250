package ShoppingCart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class ShopChartController {
//    @RequestMapping("Books")
//    protected String Books(){
//        return "/WEB-INF/jsp/Books";
//    }
//    @RequestMapping("Computers")
//    protected ModelAndView Computers(){
//        return new ModelAndView("/WEB-INF/jsp/Computers");
//    }
//    @RequestMapping("Music")
//    protected ModelAndView Music(){
//        return new ModelAndView("Music");
//    }


    @RequestMapping(value="addCart.act")
    protected ModelAndView addCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
        if (cart == null)
            cart = new ArrayList<>();
        String str = request.getParameter("type");
        String[] goods = request.getParameterValues(str);
        if (goods == null){
            session.setAttribute("list",goods);
            return new ModelAndView("notification");
        }
        for (String s : goods) {
            cart.add(s);
        }
        session.setAttribute("list",goods);
        session.setAttribute("cart", cart);
        return new ModelAndView("notification");
    }

    @RequestMapping(value="removeCart.act")
    protected ModelAndView removeCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String[] remove = request.getParameterValues("remove");
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
        Iterator iter = cart.iterator();
        if (remove != null) {
            for (String s : remove) {
                while (iter.hasNext()) {
                    if (s.equals((String) iter.next())) {
                        iter.remove();
                        break;
                    }
                }
                iter = cart.iterator();
            }
        }
        session.setAttribute("cart",cart);
        return new ModelAndView("cart");
    }

    @RequestMapping(value="viewCart.act")
    protected ModelAndView viewCart(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        ArrayList<String> cart = (ArrayList<String>)session.getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<>();
        return new ModelAndView("cart");
    }
}
