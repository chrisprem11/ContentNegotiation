package app.project.viewResolver;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import app.project.model.Employee;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Employee employee = (Employee) model.get("emp");
		
		PdfPTable table = new PdfPTable(4);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table.getDefaultCell().setBackgroundColor(Color.LIGHT_GRAY);
		
		
		table.addCell("Employee Id");
		table.addCell("Employee Name");
		table.addCell("Department");
		table.addCell("Designation");
		
		table.addCell(String.valueOf(employee.getEmployeeId()));
		table.addCell(employee.getEmployeeName());
		table.addCell(employee.getEmployeeDept());
		table.addCell(employee.getEmployeeDesignation());
		
		document.add(table);
		
		
	}

}
