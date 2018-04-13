package DAO;

import POJO.Salesorder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service("SalesOrderDAO")
public class SalesOrderDAO {
    static Session session;
    static String file = "";

    public static void saveAll(ArrayList<Salesorder> orderList){
        session = MainDAO.getSession();
        Transaction tx = session.beginTransaction();
        for(Salesorder o : orderList){
            session.save(o);
        }
        tx.commit();
        session.close();

    }

    public static ArrayList<Salesorder> readCSV(String file) throws ClassNotFoundException, SQLException {
        SalesOrderDAO.file = file;
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + "C:\\Users\\qiaoz\\IdeaProjects\\HW4Part6\\src\\main\\webapp\\WEB-INF");
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM " + file);
        ArrayList<Salesorder> result = resultToList(results);
        results.close();
        stmt.close();
        conn.close();
        return result;
    }

    public static ArrayList<Salesorder> resultToList(ResultSet results) throws SQLException {
        ArrayList<Salesorder> orderList = new ArrayList<>();
        while (results.next()) {
            Salesorder order = new Salesorder();
            order.setSalesOrderId(results.getString("SalesOrderID"));
            order.setRevisionNumber(results.getString("RevisionNumber"));
            order.setOrderDate(results.getString("OrderDate"));
            order.setDueDate(results.getString("DueDate"));
            order.setShipDate(results.getString("ShipDate"));
            order.setStatus(results.getString("Status"));
            order.setOnlineOrderFlag(results.getString("OnlineOrderFlag"));
            order.setSalesOrderNumber(results.getString("SalesOrderNumber"));
            order.setPurchaseOrderNumber(results.getString("PurchaseOrderNumber"));
            order.setAccountNumber(results.getString("AccountNumber"));
            order.setCustomerId(results.getString("CustomerID"));
            order.setSalesPersonId(results.getString("SalesPersonID"));
            order.setTerritoryId(results.getString("TerritoryID"));
            order.setBillToAddressId(results.getString("BillToAddressID"));
            order.setShipToAddressId(results.getString("ShipToAddressID"));
            order.setShipMethodId(results.getString("ShipMethodID"));
            order.setCreditCardId(results.getString("CreditCardID"));
            order.setCreditCardApprovalCode(results.getString("CreditCardApprovalCode"));
            order.setCurrencyRateId(results.getString("CurrencyRateID"));
            order.setSubTotal(results.getString("SubTotal"));
            order.setTaxAmt(results.getString("TaxAmt"));
            order.setFreight(results.getString("Freight"));
            order.setTotalDue(results.getString("TotalDue"));
            order.setComment(results.getString("Comment"));
            order.setModifiedDate(results.getString("ModifiedDate"));
            orderList.add(order);
        }
        return orderList;
    }

    public static ArrayList<Salesorder> getCurrentPage(int page) throws ClassNotFoundException, SQLException {
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + "C:\\Users\\qiaoz\\IdeaProjects\\HW4Part6\\src\\main\\webapp\\WEB-INF");
        String sql = "SELECT * FROM " + file + " limit ?,?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,(page-1) * 100);
        stmt.setInt(2, 100);
        ResultSet results = stmt.executeQuery();
        ArrayList<Salesorder> result = resultToList(results);
        results.close();
        stmt.close();
        conn.close();
        return result;
    }
}
