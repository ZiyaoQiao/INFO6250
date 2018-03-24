<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="my" uri="/WEB-INF/customTag.tld" %>
<html>
<body>
<h2>read the csv</h2>
<c:if test="${requestScope.displayType eq 0}">
    <form action="readCSV.html">
        <input type="text" name="file">
        <input type="submit"/>
    </form>

    <br/>
    <br/>
    <br/>
    <form action="customTag.html">
        <input type="text" name="file">
        <input type="submit"/>
    </form>
</c:if>
<c:if test="${requestScope.displayType eq 1}">
    <form action="saveDB.html">
        <input type="submit">
        <table border="1">
            <tr>
                <th>salesOrderID</th>
                <th>revisionNumber</th>
                <th>orderDate</th>
                <th>dueDate</th>
                <th>shipDate</th>
                <th>status</th>
                <th>onlineOrderFlag</th>
                <th>salesOrderNumber</th>
                <th>purchaseOrderNumber</th>
                <th>accountNumber</th>
                <th>customerID</th>
                <th>salesPersonID</th>
                <th>territoryID</th>
                <th>billToAddressID</th>
                <th>shipToAddressID</th>
                <th>shipMethodID</th>
                <th>creditCardID</th>
                <th>creditCardApprovalCode</th>
                <th>currencyRateID</th>
                <th>subTotal</th>
                <th>taxAmt</th>
                <th>freight</th>
                <th>totalDue</th>
                <th>comment</th>
                <th>modifiedDate</th>
            </tr>
            <c:forEach items="${sessionScope.orderList}" var="order">
                <tr>
                    <td>${order.salesOrderID}</td>
                    <td>${order.revisionNumber}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.dueDate}</td>
                    <td>${order.shipDate}</td>
                    <td>${order.status}</td>
                    <td>${order.onlineOrderFlag}</td>
                    <td>${order.salesOrderNumber}</td>
                    <td>${order.purchaseOrderNumber}</td>
                    <td>${order.accountNumber}</td>
                    <td>${order.customerID}</td>
                    <td>${order.salesPersonID}</td>
                    <td>${order.territoryID}</td>
                    <td>${order.billToAddressID}</td>
                    <td>${order.shipToAddressID}</td>
                    <td>${order.shipMethodID}</td>
                    <td>${order.creditCardID}</td>
                    <td>${order.creditCardApprovalCode}</td>
                    <td>${order.currencyRateID}</td>
                    <td>${order.subTotal}</td>
                    <td>${order.taxAmt}</td>
                    <td>${order.freight}</td>
                    <td>${order.totalDue}</td>
                    <td>${order.comment}</td>
                    <td>${order.modifiedDate}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</c:if>
<c:if test="${requestScope.displayType eq 2}">
    <c:set var="number" value="${sessionScope.number}"/>
    <p>${number} data saved to databse</p>
</c:if>
<c:if test="${requestScope.displayType eq 3}">
    <my:custom>${sessionScope.file}</my:custom>
</c:if>
</body>
</html>
