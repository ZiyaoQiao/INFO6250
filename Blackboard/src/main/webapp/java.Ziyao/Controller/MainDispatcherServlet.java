package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainDispatcherServlet {

    @RequestMapping("index.html")
    public String index(){
        return "index";
    }



}
