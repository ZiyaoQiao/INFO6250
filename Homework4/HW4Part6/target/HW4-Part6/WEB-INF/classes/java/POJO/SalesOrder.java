package POJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("SalesOrder")
@Scope("prototype")
public class SalesOrder {
    String salesOrderID;
    String revisionNumber;
    String orderDate;
    String dueDate;
    String shipDate;
    String status;
    String onlineOrderFlag;
    String salesOrderNumber;
    String purchaseOrderNumber;
    String accountNumber;
    String customerID;
    String salesPersonID;
    String territoryID;
    String billToAddressID;
    String shipToAddressID;
    String shipMethodID;
    String creditCardID;
    String creditCardApprovalCode;
    String currencyRateID;
    String subTotal;
    String taxAmt;
    String freight;
    String totalDue;
    String comment;
    String modifiedDate;

//    @Autowired
//    public SalesOrder(String salesOrderID,
//                      String revisionNumber,
//                      String orderDate,
//                      String dueDate,
//                      String shipDate,
//                      String status,
//                      String onlineOrderFlag,
//                      String salesOrderNumber,
//                      String purchaseOrderNumber,
//                      String accountNumber,
//                      String customerID,
//                      String salesPersonID,
//                      String territoryID,
//                      String billToAddressID,
//                      String shipToAddressID,
//                      String shipMethodID,
//                      String creditCardID,
//                      String creditCardApprovalCode,
//                      String currencyRateID,
//                      String subTotal,
//                      String taxAmt,
//                      String freight,
//                      String totalDue,
//                      String comment,
//                      String modifiedDate) {
//        this.salesOrderID = salesOrderID;
//        this.revisionNumber = revisionNumber;
//        this.orderDate = orderDate;
//        this.dueDate = dueDate;
//        this.shipDate = shipDate;
//        this.status = status;
//        this.onlineOrderFlag = onlineOrderFlag;
//        this.salesOrderNumber = salesOrderNumber;
//        this.purchaseOrderNumber = purchaseOrderNumber;
//        this.accountNumber = accountNumber;
//        this.customerID = customerID;
//        this.salesPersonID = salesPersonID;
//        this.territoryID = territoryID;
//        this.billToAddressID = billToAddressID;
//        this.shipToAddressID = shipToAddressID;
//        this.shipMethodID = shipMethodID;
//        this.creditCardID = creditCardID;
//        this.creditCardApprovalCode = creditCardApprovalCode;
//        this.currencyRateID = currencyRateID;
//        this.subTotal = subTotal;
//        this.taxAmt = taxAmt;
//        this.freight = freight;
//        this.totalDue = totalDue;
//        this.comment = comment;
//        this.modifiedDate = modifiedDate;
//
//    }

    public String getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOnlineOrderFlag() {
        return onlineOrderFlag;
    }

    public void setOnlineOrderFlag(String onlineOrderFlag) {
        this.onlineOrderFlag = onlineOrderFlag;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(String salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public String getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(String territoryID) {
        this.territoryID = territoryID;
    }

    public String getBillToAddressID() {
        return billToAddressID;
    }

    public void setBillToAddressID(String billToAddressID) {
        this.billToAddressID = billToAddressID;
    }

    public String getShipToAddressID() {
        return shipToAddressID;
    }

    public void setShipToAddressID(String shipToAddressID) {
        this.shipToAddressID = shipToAddressID;
    }

    public String getShipMethodID() {
        return shipMethodID;
    }

    public void setShipMethodID(String shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public String getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(String creditCardID) {
        this.creditCardID = creditCardID;
    }

    public String getCreditCardApprovalCode() {
        return creditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String creditCardApprovalCode) {
        this.creditCardApprovalCode = creditCardApprovalCode;
    }

    public String getCurrencyRateID() {
        return currencyRateID;
    }

    public void setCurrencyRateID(String currencyRateID) {
        this.currencyRateID = currencyRateID;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(String taxAmt) {
        this.taxAmt = taxAmt;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(String totalDue) {
        this.totalDue = totalDue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
