package Controller;


import POJO.SalesOrder;
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

@Controller
public class readCSVController implements ApplicationContextAware {
    @RequestMapping("index.html")
    public ModelAndView index() {
        return new ModelAndView("index", "displayType", 0);
    }

    @RequestMapping("customTag.html")
    public ModelAndView custom(@RequestParam("file") String file, HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        ModelAndView tmp = readCSV(file, request, response);
        request.getSession().setAttribute("file", file);
        return new ModelAndView("index", "displayType", 3);
    }


    @RequestMapping("readCSV.html")
    public ModelAndView readCSV(@RequestParam("file") String file, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        if(!file.equals("SalesOrder"))
            return new ModelAndView("index","displayType",0);
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + "C:\\Users\\qiaoz\\IdeaProjects\\HW4Part6\\src\\main\\webapp\\WEB-INF");
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM " + file);
        ArrayList<SalesOrder> orderList = new ArrayList<>();
        while (results.next()) {
            SalesOrder order = (SalesOrder) ctx.getBean("SalesOrder");
            order.setSalesOrderID(results.getString("SalesOrderID"));
            order.setRevisionNumber(results.getString("RevisionNumber"));
            order.setOrderDate(results.getString("OrderDate"));
            order.setDueDate(results.getString("DueDate"));
            order.setShipDate(results.getString("ShipDate"));
            order.setStatus(results.getString("Status"));
            order.setOnlineOrderFlag(results.getString("OnlineOrderFlag"));
            order.setSalesOrderNumber(results.getString("SalesOrderNumber"));
            order.setPurchaseOrderNumber(results.getString("PurchaseOrderNumber"));
            order.setAccountNumber(results.getString("AccountNumber"));
            order.setCustomerID(results.getString("CustomerID"));
            order.setSalesPersonID(results.getString("SalesPersonID"));
            order.setTerritoryID(results.getString("TerritoryID"));
            order.setBillToAddressID(results.getString("BillToAddressID"));
            order.setShipToAddressID(results.getString("ShipToAddressID"));
            order.setShipMethodID(results.getString("ShipMethodID"));
            order.setCreditCardID(results.getString("CreditCardID"));
            order.setCreditCardApprovalCode(results.getString("CreditCardApprovalCode"));
            order.setCurrencyRateID(results.getString("CurrencyRateID"));
            order.setSubTotal(results.getString("SubTotal"));
            order.setTaxAmt(results.getString("TaxAmt"));
            order.setFreight(results.getString("Freight"));
            order.setTotalDue(results.getString("TotalDue"));
            order.setComment(results.getString("Comment"));
            order.setModifiedDate(results.getString("ModifiedDate"));
            orderList.add(order);
        }
        request.getSession().setAttribute("orderList", orderList);
        request.getSession().setAttribute("number", orderList.size());
        return new ModelAndView("index", "displayType", 1);
    }

    @RequestMapping("saveDB.html")
    public ModelAndView saveDB(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArrayList<SalesOrder> orderList = (ArrayList<SalesOrder>) request.getSession().getAttribute("orderList");
        java.sql.Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SalesOrder", "root", "86557060");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO sales (salesOrderID, revisionNumber, orderDate, dueDate, shipDate,status ,onlineOrderFlag ,salesOrderNumber ,purchaseOrderNumber , accountNumber, customerID, salesPersonID,territoryID , billToAddressID,shipToAddressID ,shipMethodID ,creditCardID , creditCardApprovalCode,currencyRateID ,subTotal , taxAmt,freight, totalDue,comment,modifiedDate) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        for (SalesOrder order : orderList) {
            ps.setString(1, order.getSalesOrderID());
            ps.setString(2, order.getRevisionNumber());
            ps.setString(3, order.getOrderDate());
            ps.setString(4, order.getDueDate());
            ps.setString(5, order.getShipDate());
            ps.setString(6, order.getStatus());
            ps.setString(7, order.getOnlineOrderFlag());
            ps.setString(8, order.getSalesOrderNumber());
            ps.setString(9, order.getPurchaseOrderNumber());
            ps.setString(10, order.getAccountNumber());
            ps.setString(11, order.getCustomerID());
            ps.setString(12, order.getSalesPersonID());
            ps.setString(13, order.getTerritoryID());
            ps.setString(14, order.getBillToAddressID());
            ps.setString(15, order.getShipToAddressID());
            ps.setString(16, order.getShipMethodID());
            ps.setString(17, order.getCreditCardID());
            ps.setString(18, order.getCreditCardApprovalCode());
            ps.setString(19, order.getCurrencyRateID());
            ps.setString(20, order.getSubTotal());
            ps.setString(21, order.getTaxAmt());
            ps.setString(22, order.getFreight());
            ps.setString(23, order.getTotalDue());
            ps.setString(24, order.getComment());
            ps.setString(25, order.getModifiedDate());
            ps.executeUpdate();
        }


        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ModelAndView("index", "displayType", 2);
    }

    ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
