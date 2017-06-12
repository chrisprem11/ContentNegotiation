package app.project.viewResolver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import app.project.model.Employee;

@SuppressWarnings("deprecation")
public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Employee employee = (Employee) model.get("emp");

		Sheet sheet = workbook.createSheet("sheet 1");
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		Row row = null;
		Cell cell = null;
		int rowCount = 0;
		int colCount = 0;

		// Create header cells
		row = sheet.createRow(rowCount++);

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("EmpId");

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("Emp Name");

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("Emp Department");

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("Emp Designation");

		// Create data cells
		row = sheet.createRow(rowCount++);
		colCount = 0;
		row.createCell(colCount++).setCellValue(employee.getEmployeeId());
		row.createCell(colCount++).setCellValue(employee.getEmployeeName());
		row.createCell(colCount++).setCellValue(employee.getEmployeeDept());
		row.createCell(colCount++).setCellValue(employee.getEmployeeDesignation());

	}

}
