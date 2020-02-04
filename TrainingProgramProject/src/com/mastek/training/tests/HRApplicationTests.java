package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.packone.Circle;
import com.mastek.training.packone.Rectangle;
import com.mastek.training.packone.Shape;



class HRApplicationTests {
	
	Employee ex1;
	
	@BeforeEach
	public void setupEmpTestCase() {
		System.out.println("Before Test Case");
		//Employee.DEFAULT_ZERO; //Class_name.<static_member>
		ex1 = new Employee();
		ex1.setEmpno(1002);
		ex1.setName("Example");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);
		
		Employee ex2 = new Employee(1122);
		
		Employee ex3 = new Employee(2233,"Example", 344.0, Designations.DEVELOPER);
		
		ex2=null;// release the object to mark as garbage.
		ex3=null;
		System.gc(); //notify system to collect garbage
		
		//ex2.getEmpno(); will throw NullPointerExecption
		
	}
	
	@AfterEach
	public void tearDownEmpTestCase() {
		System.out.println("After Test Case");
		
	}
	
	
	@Test
	void testCreateAndPrintExampleEmployeeObject() {
		System.out.println("Test Case Create");
		/* Employee ex1 = new Employee();
		ex1.setEmpno(1002);
		ex1.setName("Example");
		ex1.setUnitDaySalary(3434);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8); */
		
		System.out.println(
				"Number: "+ex1.getEmpno()+
				"\nName: "+ex1.getName()+
				"\nDay Salary: "+ex1.getUnitDaySalary()+
				"\nDesignation: "+ex1.getDesignation()+
				"\nGrade: "+ex1.getGrade());
	}
	
	@Test
	void testCreateAndComputeSalaryEmployeeObject() throws Exception {
		System.out.println("Test Case Compute");
		/*Employee ex1 = new Employee();
		ex1.setEmpno(1002);
		ex1.setName("Example");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);*/
		
		//to get the "9000" value we times 30 by 300
		assertEquals(9000.0,ex1.getNetSalary(30),"Invalid Net Salary Computation");
		assertEquals(0,ex1.getNetSalary(-30),"Invalid Net Salary Computation");
	}

	
	@Test
	void testSalesEmployeeObjectUsage() throws Exception {
		SalesEmployee saleEx1= new SalesEmployee();
		saleEx1.setEmpno(224);
		saleEx1.setName("Example");
		saleEx1.setUnitDaySalary(100);
		saleEx1.setDesignation(Designations.MANAGER);
		saleEx1.setGrade(Grades.G8);
		saleEx1.setCommission(0.8);
		saleEx1.setTarget(1000000000);
		
		assertEquals(1620,saleEx1.getNetSalary(9),"Invalid Salary calculated");
		
	}
	
	@Test
	void testObjectFeaturesOnEmployee() {
		System.out.println("<====Object Features Start====>");
		
		System.out.println(ex1);
		System.out.println("HashCode: "+ex1.hashCode());

		System.out.println("<====Object Features End====>");
	}

	@Test
	void testSendAnnouncementToEmployees() {
		//We cannot create an object of abstract class using new keyword
		//Announcement exAnnouncement = new Announcement();
		
		//to use an abstract class object you must extend it with derived class
		//and override ALL abstract methods defined in base/parent class.
		Announcement exSMS = new SMSAnnouncement();
		exSMS.setFrom("UK-HR");
		exSMS.setForGroup("MASTEKEER_AT_GLASGOW");
		exSMS.setSubject("Inclement Weather Conditions at Glasgow");
		exSMS.setContentText("All employees are advised to opt for Work From Home, tomorrow");
		
		Announcement exEmail = new EmailAnnouncement();
		exEmail.setFrom("Leadership Team");
		exEmail.setForGroup("MASTEKEERS");
		exEmail.setSubject("QMEET JAN 2020");
		exEmail.setContentText("You are all invited to attend Quarterly Meet Online via WEBEX");
		
		if(exSMS instanceof SMSAnnouncement) {
			System.out.println("Connect to Telecome SMS Service");
			exSMS.sendAnnouncement(); // connect to SMS and use Send from SMSAnnouncement
		}
		
		if(exEmail instanceof EmailAnnouncement) {
			System.out.println("Connect to Email Service");
		exEmail.sendAnnouncement(); // connect to Email and use Send from EmailAnnouncement
		}
		assertTrue(exSMS instanceof SMSAnnouncement, "Invalid Announcement Implementation");
		assertTrue(exEmail instanceof EmailAnnouncement, "Invalid Announcement Implementation");
		
	}
	
	
	@Test
	void testShapeExample() {
		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(20);
		
		Circle circle = new Circle();
		circle.setRadius(20);
		
		Shape shRect = rect;
		Shape shCircle = circle;
		
		System.out.println("Rectange Area: "+shRect.getArea());
		System.out.println("Rectange Area: "+shRect.getPerimeter());
		
		System.out.println("Circle Area: "+shCircle.getArea());
		System.out.println("Circle Area: "+shCircle.getPerimeter());
		
		assertTrue(rect instanceof Shape, "invalid Type of Shape");
		assertTrue(circle instanceof Shape, "Invalid Type of Shape");
	
	}
	
}

