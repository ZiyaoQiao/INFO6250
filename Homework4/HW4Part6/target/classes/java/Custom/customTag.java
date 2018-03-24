package Custom;

import Controller.readCSVController;
import POJO.SalesOrder2;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class customTag extends SimpleTagSupport{
    String file;
    StringWriter sw = new StringWriter();

    public void setFile(String i) {
        this.file = i;
    }

    public void doTag() throws JspException, IOException {

        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
        Connection conn = null;
        Statement stmt = null;

        getJspBody().invoke(sw);
        String file = sw.toString();

        if(!file.equals("SalesOrder"))
            return;

        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            conn = DriverManager.getConnection("jdbc:relique:csv:" + "C:\\Users\\qiaoz\\IdeaProjects\\HW4Part6\\src\\main\\webapp\\WEB-INF");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<SalesOrder2> orderList = new ArrayList<>();
        ResultSet results = null;
        try {
            results = stmt.executeQuery("SELECT * FROM " + file);

            while (results.next()) {
                SalesOrder2 order = new SalesOrder2(results.getString("SalesOrderID"),
                        results.getString("RevisionNumber"),
                        results.getString("OrderDate"),
                        results.getString("DueDate"),
                        results.getString("ShipDate"),
                        results.getString("Status"),
                        results.getString("OnlineOrderFlag"),
                        results.getString("SalesOrderNumber"),
                        results.getString("PurchaseOrderNumber"),
                        results.getString("AccountNumber"),
                        results.getString("CustomerID"),
                        results.getString("SalesPersonID"),
                        results.getString("TerritoryID"),
                        results.getString("BillToAddressID"),
                        results.getString("ShipToAddressID"),
                        results.getString("ShipMethodID"),
                        results.getString("CreditCardID"),
                        results.getString("CreditCardApprovalCode"),
                        results.getString("CurrencyRateID"),
                        results.getString("SubTotal"),
                        results.getString("TaxAmt"),
                        results.getString("Freight"),
                        results.getString("TotalDue"),
                        results.getString("Comment"),
                        results.getString("ModifiedDate")
                );
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        out.print("<form action=\"saveDB.html\">\n" +
                "        <input type=\"submit\">\n" +
                "        <table border=\"1\">\n" +
                "            <tr>\n" +
                "                <th>SalesOrderID</th>\n" +
                "                <th>revisionNumber</th>\n" +
                "                <th>orderDate</th>\n" +
                "                <th>dueDate</th>\n" +
                "                <th>shipDate</th>\n" +
                "                <th>status</th>\n" +
                "                <th>onlineOrderFlag</th>\n" +
                "                <th>SalesOrderNumber</th>\n" +
                "                <th>purchaseOrderNumber</th>\n" +
                "                <th>accountNumber</th>\n" +
                "                <th>customerID</th>\n" +
                "                <th>salesPersonID</th>\n" +
                "                <th>territoryID</th>\n" +
                "                <th>billToAddressID</th>\n" +
                "                <th>shipToAddressID</th>\n" +
                "                <th>shipMethodID</th>\n" +
                "                <th>creditCardID</th>\n" +
                "                <th>creditCardApprovalCode</th>\n" +
                "                <th>currencyRateID</th>\n" +
                "                <th>subTotal</th>\n" +
                "                <th>taxAmt</th>\n" +
                "                <th>freight</th>\n" +
                "                <th>totalDue</th>\n" +
                "                <th>comment</th>\n" +
                "                <th>modifiedDate</th>\n" +
                "            </tr>");
        for(SalesOrder2 order : orderList){
            out.print("<tr>");
            out.print("<td>" + order.getSalesOrderID() +"</td>");
            out.print("<td>" + order.getRevisionNumber() +"</td>");
            out.print("<td>" + order.getOrderDate() +"</td>");
            out.print("<td>" + order.getDueDate() +"</td>");
            out.print("<td>" + order.getShipDate() +"</td>");
            out.print("<td>" + order.getStatus() +"</td>");
            out.print("<td>" + order.getOnlineOrderFlag() +"</td>");
            out.print("<td>" + order.getSalesOrderNumber() +"</td>");
            out.print("<td>" + order.getPurchaseOrderNumber() +"</td>");
            out.print("<td>" + order.getAccountNumber() +"</td>");
            out.print("<td>" + order.getCustomerID() +"</td>");
            out.print("<td>" + order.getSalesPersonID() +"</td>");
            out.print("<td>" + order.getTerritoryID() +"</td>");
            out.print("<td>" + order.getBillToAddressID() +"</td>");
            out.print("<td>" + order.getShipToAddressID() +"</td>");
            out.print("<td>" + order.getShipMethodID() +"</td>");
            out.print("<td>" + order.getCreditCardID() +"</td>");
            out.print("<td>" + order.getCreditCardApprovalCode() +"</td>");
            out.print("<td>" + order.getCurrencyRateID() +"</td>");
            out.print("<td>" + order.getSubTotal() +"</td>");
            out.print("<td>" + order.getTaxAmt() +"</td>");
            out.print("<td>" + order.getFreight() +"</td>");
            out.print("<td>" + order.getTotalDue() +"</td>");
            out.print("<td>" + order.getComment() +"</td>");
            out.print("<td>" + order.getModifiedDate() +"</td>");
        }
        out.print("</table></form>");

    }
}
