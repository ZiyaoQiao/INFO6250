package Excel;

import POJO.Salesorder;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class ExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String excelName = model.get("name").toString() + ".xls";
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(excelName,"utf-8"));
        response.setContentType("application/ms-excel; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Salesorder> list = (List<Salesorder>) model.get("members");
        Sheet sheet = workbook.createSheet("Sales Order");
        sheet.setDefaultColumnWidth(30);
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();

        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        //style.setFillPattern((short) 1);
        font.setBold(true);
        font.setColor(HSSFColor.BLACK.index);
        style.setFont(font);

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("SalesOrderId");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("RevisionNumber");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("OrderDate");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("DueDate");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("ShipDate");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Status");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("OnlineOrderFlag");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("SalesOrderNumber");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("PurchaseOrderNumber");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("AccountNumber");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("CustomerID");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("SalesPersonID");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("TerritoryID");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("BillToAddressID");
        header.getCell(13).setCellStyle(style);
        header.createCell(14).setCellValue("ShipToAddressID");
        header.getCell(14).setCellStyle(style);
        header.createCell(15).setCellValue("ShipMethodID");
        header.getCell(15).setCellStyle(style);
        header.createCell(16).setCellValue("CreditCardID");
        header.getCell(16).setCellStyle(style);
        header.createCell(17).setCellValue("CreditCardApprovalCode");
        header.getCell(17).setCellStyle(style);
        header.createCell(18).setCellValue("CurrencyRateID");
        header.getCell(18).setCellStyle(style);
        header.createCell(19).setCellValue("SubTotal");
        header.getCell(19).setCellStyle(style);
        header.createCell(20).setCellValue("TaxAmt");
        header.getCell(20).setCellStyle(style);
        header.createCell(21).setCellValue("Freight");
        header.getCell(21).setCellStyle(style);
        header.createCell(22).setCellValue("TotalDue");
        header.getCell(22).setCellStyle(style);
        header.createCell(23).setCellValue("Comment");
        header.getCell(23).setCellStyle(style);
        header.createCell(24).setCellValue("ModifiedDate");
        header.getCell(24).setCellStyle(style);
        int rowCount = 1;
        for (Salesorder order : list) {
            Row userRow = sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(order.getSalesOrderId());
            userRow.createCell(1).setCellValue(order.getRevisionNumber());
            userRow.createCell(2).setCellValue(order.getOrderDate());
            userRow.createCell(3).setCellValue(order.getDueDate());
            userRow.createCell(4).setCellValue(order.getShipDate());
            userRow.createCell(5).setCellValue(order.getStatus());
            userRow.createCell(6).setCellValue(order.getOnlineOrderFlag());
            userRow.createCell(7).setCellValue(order.getSalesOrderNumber());
            userRow.createCell(8).setCellValue(order.getPurchaseOrderNumber());
            userRow.createCell(9).setCellValue(order.getAccountNumber());
            userRow.createCell(10).setCellValue(order.getCustomerId());
            userRow.createCell(11).setCellValue(order.getSalesPersonId());
            userRow.createCell(12).setCellValue(order.getTerritoryId());
            userRow.createCell(13).setCellValue(order.getBillToAddressId());
            userRow.createCell(14).setCellValue(order.getShipToAddressId());
            userRow.createCell(15).setCellValue(order.getShipMethodId());
            userRow.createCell(16).setCellValue(order.getCreditCardId());
            userRow.createCell(17).setCellValue(order.getCreditCardApprovalCode());
            userRow.createCell(18).setCellValue(order.getCurrencyRateId());
            userRow.createCell(19).setCellValue(order.getSubTotal());
            userRow.createCell(20).setCellValue(order.getTaxAmt());
            userRow.createCell(21).setCellValue(order.getFreight());
            userRow.createCell(22).setCellValue(order.getTotalDue());
            userRow.createCell(23).setCellValue(order.getComment());
            userRow.createCell(24).setCellValue(order.getModifiedDate());
        }
    }
}
