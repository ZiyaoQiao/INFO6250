package Controller;


import DAO.MainDAO;
import DAO.SalesOrderDAO;
import Excel.ExcelView;
import POJO.Salesorder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class readCSVController implements ApplicationContextAware {
    @RequestMapping("index.html")
    public ModelAndView index() {
        return new ModelAndView("index", "displayType", 0);
    }

    @RequestMapping("customTag.html")
    public ModelAndView custom(@RequestParam("file") String file, HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        ModelAndView tmp = readCSV(request, response);
        request.getSession().setAttribute("file", file);
        return new ModelAndView("index", "displayType", 3);
    }


    @RequestMapping("readCSV.html")
    public ModelAndView readCSV(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        String file = request.getParameter("file");
        if(file != null)
            request.getSession().setAttribute("file",file);
        file = (String) request.getSession().getAttribute("file");
        if(!file.equals("SalesOrder"))
            return new ModelAndView("index","displayType",0);
        ArrayList<Salesorder> orderList;
        if(request.getSession().getAttribute("orderList") != null)
            orderList = (ArrayList<Salesorder>) request.getSession().getAttribute("orderList");
        else {
            orderList = SalesOrderDAO.readCSV(file);
            request.getSession().setAttribute("orderList", orderList);
            request.getSession().setAttribute("number", orderList.size());
        }
        int totalCount = orderList.size();
        int currPage = 1;
        int pages;
        if(totalCount % 100 == 0)
            pages = totalCount / 100;
        else
            pages = totalCount / 100 + 1;

        if(request.getParameter("page") != null)
            currPage = Integer.parseInt(request.getParameter("page"));

        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= pages; i++){
            if(i == currPage)
                sb.append("[" + i + "]");
            else
                sb.append("<a href='readCSV.html?page=" + i + "'>" + i + "</a>");
            sb.append(" ");
        }
        request.setAttribute("bar", sb.toString());

        ArrayList<Salesorder> currList = SalesOrderDAO.getCurrentPage(currPage);
        request.setAttribute("currList",currList);

        return new ModelAndView("index", "displayType", 1);
    }

    @RequestMapping("saveDB.html")
    public ModelAndView saveDB(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArrayList<Salesorder> orderList = (ArrayList<Salesorder>) request.getSession().getAttribute("orderList");

        SalesOrderDAO.saveAll(orderList);

        return new ModelAndView("index", "displayType", 2);
    }

    ApplicationContext ctx;

    @RequestMapping("savetoXls.html")
    public ModelAndView savetoXls(HttpServletRequest request){
        ArrayList<Salesorder> list = (ArrayList<Salesorder>) request.getSession().getAttribute("orderList");

        Map<String, Object> model = new HashMap<>();
        model.put("members",list);
        model.put("name", "Sales Order");
        ExcelView excelView = new ExcelView();
        return new ModelAndView(excelView,model);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
