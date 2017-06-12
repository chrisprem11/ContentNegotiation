package app.project.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Employee {

	private int employeeId;
	private String employeeName;
	private String employeeDept;
	private String employeeDesignation;
	
	
	public Employee(String empName){
		this.employeeId = 10391;
		this.employeeName = empName;
		this.employeeDept = "Spring Development";
		this.employeeDesignation= "Software Engineer";
	}
	
	public Employee() {}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeDept() {
		return employeeDept;
	}
	public void setEmployeeDept(String employeeDept) {
		this.employeeDept = employeeDept;
	}
	
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	
	
}
