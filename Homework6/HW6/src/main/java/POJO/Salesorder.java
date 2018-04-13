package POJO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Scope("prototype")
@Component("Sales")
public class Salesorder {
    private String salesOrderId;
    private String revisionNumber;
    private String orderDate;
    private String dueDate;
    private String shipDate;
    private String status;
    private String onlineOrderFlag;
    private String salesOrderNumber;
    private String purchaseOrderNumber;
    private String accountNumber;
    private String customerId;
    private String salesPersonId;
    private String territoryId;
    private String billToAddressId;
    private String shipToAddressId;
    private String shipMethodId;
    private String creditCardId;
    private String creditCardApprovalCode;
    private String currencyRateId;
    private String subTotal;
    private String taxAmt;
    private String freight;
    private String totalDue;
    private String comment;
    private String modifiedDate;

    @Id
    @Column(name = "salesOrderID", nullable = false, length = 255)
    public String getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    @Basic
    @Column(name = "revisionNumber", nullable = true, length = 255)
    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    @Basic
    @Column(name = "orderDate", nullable = true, length = 255)
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "dueDate", nullable = true, length = 255)
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "shipDate", nullable = true, length = 255)
    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "onlineOrderFlag", nullable = true, length = 255)
    public String getOnlineOrderFlag() {
        return onlineOrderFlag;
    }

    public void setOnlineOrderFlag(String onlineOrderFlag) {
        this.onlineOrderFlag = onlineOrderFlag;
    }

    @Basic
    @Column(name = "salesOrderNumber", nullable = true, length = 255)
    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    @Basic
    @Column(name = "purchaseOrderNumber", nullable = true, length = 255)
    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    @Basic
    @Column(name = "accountNumber", nullable = true, length = 255)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "customerID", nullable = true, length = 255)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "salesPersonID", nullable = true, length = 255)
    public String getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(String salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    @Basic
    @Column(name = "territoryID", nullable = true, length = 255)
    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    @Basic
    @Column(name = "billToAddressID", nullable = true, length = 255)
    public String getBillToAddressId() {
        return billToAddressId;
    }

    public void setBillToAddressId(String billToAddressId) {
        this.billToAddressId = billToAddressId;
    }

    @Basic
    @Column(name = "shipToAddressID", nullable = true, length = 255)
    public String getShipToAddressId() {
        return shipToAddressId;
    }

    public void setShipToAddressId(String shipToAddressId) {
        this.shipToAddressId = shipToAddressId;
    }

    @Basic
    @Column(name = "shipMethodID", nullable = true, length = 255)
    public String getShipMethodId() {
        return shipMethodId;
    }

    public void setShipMethodId(String shipMethodId) {
        this.shipMethodId = shipMethodId;
    }

    @Basic
    @Column(name = "creditCardID", nullable = true, length = 255)
    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    @Basic
    @Column(name = "creditCardApprovalCode", nullable = true, length = 255)
    public String getCreditCardApprovalCode() {
        return creditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String creditCardApprovalCode) {
        this.creditCardApprovalCode = creditCardApprovalCode;
    }

    @Basic
    @Column(name = "currencyRateID", nullable = true, length = 255)
    public String getCurrencyRateId() {
        return currencyRateId;
    }

    public void setCurrencyRateId(String currencyRateId) {
        this.currencyRateId = currencyRateId;
    }

    @Basic
    @Column(name = "subTotal", nullable = true, length = 255)
    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    @Basic
    @Column(name = "taxAmt", nullable = true, length = 255)
    public String getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(String taxAmt) {
        this.taxAmt = taxAmt;
    }

    @Basic
    @Column(name = "freight", nullable = true, length = 255)
    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "totalDue", nullable = true, length = 255)
    public String getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(String totalDue) {
        this.totalDue = totalDue;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "modifiedDate", nullable = true, length = 255)
    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesorder that = (Salesorder) o;
        return Objects.equals(salesOrderId, that.salesOrderId) &&
                Objects.equals(revisionNumber, that.revisionNumber) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(shipDate, that.shipDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(onlineOrderFlag, that.onlineOrderFlag) &&
                Objects.equals(salesOrderNumber, that.salesOrderNumber) &&
                Objects.equals(purchaseOrderNumber, that.purchaseOrderNumber) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(salesPersonId, that.salesPersonId) &&
                Objects.equals(territoryId, that.territoryId) &&
                Objects.equals(billToAddressId, that.billToAddressId) &&
                Objects.equals(shipToAddressId, that.shipToAddressId) &&
                Objects.equals(shipMethodId, that.shipMethodId) &&
                Objects.equals(creditCardId, that.creditCardId) &&
                Objects.equals(creditCardApprovalCode, that.creditCardApprovalCode) &&
                Objects.equals(currencyRateId, that.currencyRateId) &&
                Objects.equals(subTotal, that.subTotal) &&
                Objects.equals(taxAmt, that.taxAmt) &&
                Objects.equals(freight, that.freight) &&
                Objects.equals(totalDue, that.totalDue) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(salesOrderId, revisionNumber, orderDate, dueDate, shipDate, status, onlineOrderFlag, salesOrderNumber, purchaseOrderNumber, accountNumber, customerId, salesPersonId, territoryId, billToAddressId, shipToAddressId, shipMethodId, creditCardId, creditCardApprovalCode, currencyRateId, subTotal, taxAmt, freight, totalDue, comment, modifiedDate);
    }
}
