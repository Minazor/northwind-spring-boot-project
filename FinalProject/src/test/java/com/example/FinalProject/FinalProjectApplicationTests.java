package com.example.FinalProject;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Answers.values;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.FinalProject.domain.CustomerDO;
import com.example.FinalProject.domain.EmployeeDO;
import com.example.FinalProject.domain.OrderDO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class FinalProjectApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

  /*************************** CUSTOMER TESTS ***************************/
	@Test
	public void testGetAllCustomers() throws Exception{
		mockMvc.perform(get("/api/customers")
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].companyName").exists())
						.andExpect(jsonPath("$[*].contactName").exists())
						.andExpect(jsonPath("$[*].contactTitle").exists())
						.andExpect(jsonPath("$[*].address").exists());
		
	}
	@Test
	public void testGetCustomerById() throws Exception {
		String customerId = "TRAIH";

		mockMvc.perform(get("/api/customers-by-id/{customerId}", customerId)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.companyName").exists())
						.andExpect(jsonPath("$.contactName").exists())
						.andExpect(jsonPath("$.contactTitle").exists())
						.andExpect(jsonPath("$.address").exists());

	}
	@Test
	public void testGetCustomerByCompanyName() throws Exception {
		String companyName = "Die Wandernde Kuh";

		mockMvc.perform(get("/api/customers-by-company-name/{companyName}", companyName)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.companyName").exists())
						.andExpect(jsonPath("$.contactName").exists())
						.andExpect(jsonPath("$.contactTitle").exists())
						.andExpect(jsonPath("$.address").exists());

	}
	@Test
	public void testCreateCustomer() throws Exception {
		CustomerDO newCustomer = new CustomerDO();
		newCustomer.setId("MIMU");
		newCustomer.setAddress("Mutlukent");
		newCustomer.setCompanyName("Minazor");
		newCustomer.setContactName("Murat");
		newCustomer.setContactTitle("Dr.");

		mockMvc.perform(post("/api/customer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newCustomer)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.companyName").exists())
						.andExpect(jsonPath("$.contactName").exists())
						.andExpect(jsonPath("$.address").exists())
						.andExpect(jsonPath("$.contactTitle").exists())
						.andExpect(jsonPath("$.id").value("MIMU"));
	}
	@Test
	public void testUpdateCustomer() throws Exception {
		CustomerDO newCustomer = new CustomerDO();
		newCustomer.setId("MIMU");
		newCustomer.setAddress("Alacaatlı");
		newCustomer.setCompanyName("Minazor");
		newCustomer.setContactName("Melek");
		newCustomer.setContactTitle("Accounting Manager");

		mockMvc.perform(put("/api/customer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newCustomer)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.companyName").exists())
						.andExpect(jsonPath("$.contactName").exists())
						.andExpect(jsonPath("$.address").exists())
						.andExpect(jsonPath("$.contactTitle").exists());
	}

	@Test
	public void testDeleteCustomer() throws Exception {
		String customerId = "MIMU";

		mockMvc.perform(delete("/api/customers/{customerId}", customerId)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
	}
 		/*************************** CUSTOMER TESTS ***************************/

	    /*************************** ORDER TESTS ***************************/
	@Test
	public void testGetAllOrders() throws Exception{
		mockMvc.perform(get("/api/orders")
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].customer").exists())
						.andExpect(jsonPath("$[*].employee").exists())
						.andExpect(jsonPath("$[*].orderDate").exists())
						.andExpect(jsonPath("$[*].requiredDate").exists())
						.andExpect(jsonPath("$[*].shippedDate").exists());		;		;
		
	}
	@Test
	public void testCreateOrder() throws Exception {
		OrderDO newOrder=new OrderDO();
		newOrder.setId(7777L);
		Date orderDate= new Date(2020-02-02);
		Date requiredDate= new Date(2020-02-02);
		Date shippedDate= new Date(2020-02-02);
		newOrder.setOrderDate(orderDate);
		newOrder.setRequireDate(requiredDate);
		newOrder.setShippedDate(shippedDate);
		CustomerDO newCustomer = new CustomerDO();
		newCustomer.setId("MIMU");
		newCustomer.setAddress("Mutlukent");
		newCustomer.setCompanyName("Minazor");
		newCustomer.setContactName("Murat");
		newCustomer.setContactTitle("Dr.");
		newOrder.setCustomer(newCustomer);
		EmployeeDO newEmployee=new EmployeeDO();
		newEmployee.setFirstName("Mina");
		newEmployee.setLastName("Inal");
		newEmployee.setId((long) 10);
		newEmployee.setTitle("Dr.");
		newEmployee.setTitleOfCourtesy("Mrs.");
		Date hireDate= new Date(2020-02-02);
		newEmployee.setHireDate(hireDate);
		newOrder.setEmployee(newEmployee);

		mockMvc.perform(post("/api/order")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newOrder)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.orderDate").exists())
						.andExpect(jsonPath("$.requiredDate").exists())
						.andExpect(jsonPath("$.shippedDate").exists())
						.andExpect(jsonPath("$.customer.id").exists())
						.andExpect(jsonPath("$.customer.companyName").exists())
						.andExpect(jsonPath("$.customer.contactName").exists())
						.andExpect(jsonPath("$.customer.address").exists())
						.andExpect(jsonPath("$.customer.contactTitle").exists())
						.andExpect(jsonPath("$.employee.id").exists())
						.andExpect(jsonPath("$.employee.firstName").exists())
						.andExpect(jsonPath("$.employee.lastName").exists())
						.andExpect(jsonPath("$.employee.title").exists())
						.andExpect(jsonPath("$.employee.titleOfCourtesy").exists())
						.andExpect(jsonPath("$.employee.hireDate").exists())
						.andExpect(jsonPath("$.customer.id").value("MIMU"))
						.andExpect(jsonPath("$.employee.id").value(10))
						.andExpect(jsonPath("$.id").value(7777L));
	}
	@Test
	public void testUpdateOrder() throws Exception {
		OrderDO newOrder=new OrderDO();
		newOrder.setId(7777L);
		Date orderDate= new Date(1990-01-01);
		Date requiredDate= new Date(1990-01-06);
		Date shippedDate= new Date(1990-02-01);
		newOrder.setOrderDate(orderDate);
		newOrder.setRequireDate(requiredDate);
		newOrder.setShippedDate(shippedDate);
		CustomerDO newCustomer = new CustomerDO();
		newCustomer.setId("MIMU");
		newCustomer.setAddress("Mutlukent");
		newCustomer.setCompanyName("Minazor");
		newCustomer.setContactName("Murat");
		newCustomer.setContactTitle("Dr.");
		newOrder.setCustomer(newCustomer);
		EmployeeDO newEmployee=new EmployeeDO();
		newEmployee.setFirstName("Nancy");
		newEmployee.setLastName("Davolio");
		newEmployee.setId((long) 1);
		newEmployee.setTitle("Sales Representative");
		newEmployee.setTitleOfCourtesy("Ms.");
		Date hireDate= new Date(2020-02-02);
		newEmployee.setHireDate(hireDate);
		newOrder.setEmployee(newEmployee);

		mockMvc.perform(put("/api/order")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newOrder)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.orderDate").exists())
						.andExpect(jsonPath("$.requiredDate").exists())
						.andExpect(jsonPath("$.shippedDate").exists())
						.andExpect(jsonPath("$.customer").exists())
						.andExpect(jsonPath("$.customer.companyName").exists())
						.andExpect(jsonPath("$.customer.contactName").exists())
						.andExpect(jsonPath("$.customer.address").exists())
						.andExpect(jsonPath("$.customer.contactTitle").exists())
						.andExpect(jsonPath("$.employee").exists())
						.andExpect(jsonPath("$.employee.firstName").exists())
						.andExpect(jsonPath("$.employee.lastName").exists())
						.andExpect(jsonPath("$.employee.title").exists())
						.andExpect(jsonPath("$.employee.titleOfCourtesy").exists())
						.andExpect(jsonPath("$.employee.hireDate").exists());
	}
	@Test
	public void testGetOrderById() throws Exception {
		long orderId= 10248;

		mockMvc.perform(get("/api/orders-by-id/{orderId}", orderId)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.customer").exists())
						.andExpect(jsonPath("$.employee").exists())
						.andExpect(jsonPath("$.orderDate").exists())
						.andExpect(jsonPath("$.requiredDate").exists())
						.andExpect(jsonPath("$.shippedDate").exists());

	}
	@Test
	public void testGetOrderByOrderDate() throws Exception {

		mockMvc.perform(get("/api/orders-by-date/1996-07-04")
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].customer").exists())
						.andExpect(jsonPath("$[*].employee").exists())
						.andExpect(jsonPath("$[*].orderDate").exists())
						.andExpect(jsonPath("$[*].requiredDate").exists())
						.andExpect(jsonPath("$[*].shippedDate").exists());

	}
	@Test
	public void testGetOrderByRequiredDate() throws Exception {

		mockMvc.perform(get("/api/orders-by-required-date/1996-08-15")
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].customer").exists())
						.andExpect(jsonPath("$[*].employee").exists())
						.andExpect(jsonPath("$[*].orderDate").exists())
						.andExpect(jsonPath("$[*].requiredDate").exists())
						.andExpect(jsonPath("$[*].shippedDate").exists());

	}
	@Test
	public void testGetOrderByShippedDate() throws Exception {

		mockMvc.perform(get("/api/orders-by-shipped-date/1996-07-23")
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].customer").exists())
						.andExpect(jsonPath("$[*].employee").exists())
						.andExpect(jsonPath("$[*].orderDate").exists())
						.andExpect(jsonPath("$[*].requiredDate").exists())
						.andExpect(jsonPath("$[*].shippedDate").exists());

	}
	@Test
	public void testGetOrderByCustomerId() throws Exception {
		String customerId="VICTE";

		mockMvc.perform(get("/api/orders-by-customer-id/{customerId}", customerId)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].customer").exists())
						.andExpect(jsonPath("$[*].employee").exists())
						.andExpect(jsonPath("$[*].orderDate").exists())
						.andExpect(jsonPath("$[*].requiredDate").exists())
						.andExpect(jsonPath("$[*].shippedDate").exists());

	}
	@Test
	public void testGetOrderByEmployeeId() throws Exception {
		long employeeId=3;

		mockMvc.perform(get("/api/orders-by-employee-id/{employeeId}", employeeId)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].customer").exists())
						.andExpect(jsonPath("$[*].employee").exists())
						.andExpect(jsonPath("$[*].orderDate").exists())
						.andExpect(jsonPath("$[*].requiredDate").exists())
						.andExpect(jsonPath("$[*].shippedDate").exists());

	}
	@Test
	public void testDeleteOrder() throws Exception {
		long orderId = 7777;

		mockMvc.perform(delete("/api/order/{orderId}", orderId)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
	}
	    /*************************** ORDER TESTS ***************************/

		/*************************** EMPLOYEE TESTS ***************************/
	@Test
	public void testGetAllEmployee() throws Exception{
		mockMvc.perform(get("/api/employees")
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].lastName").exists())
						.andExpect(jsonPath("$[*].firstName").exists())
						.andExpect(jsonPath("$[*].title").exists())
						.andExpect(jsonPath("$[*].titleOfCourtesy").exists())
                        .andExpect(jsonPath("$[*].hireDate").exists());	
		
	}
	@Test
	public void testCreateEmployee() throws Exception {
		EmployeeDO newEmployee=new EmployeeDO();
		newEmployee.setFirstName("Mina");
		newEmployee.setLastName("Inal");
		newEmployee.setId((long) 10);
		newEmployee.setTitle("Dr.");
		newEmployee.setTitleOfCourtesy("Mrs.");
		Date hireDate= new Date(2020-02-02);
		newEmployee.setHireDate(hireDate);

		mockMvc.perform(post("/api/employee")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newEmployee)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.firstName").exists())
						.andExpect(jsonPath("$.lastName").exists())
						.andExpect(jsonPath("$.title").exists())
						.andExpect(jsonPath("$.titleOfCourtesy").exists())
						.andExpect(jsonPath("$.id").value(10));
	}
	@Test
	public void testUpdateEmployee() throws Exception {
		EmployeeDO newEmployee=new EmployeeDO();
		newEmployee.setId(10L);
		newEmployee.setFirstName("Mina");
		newEmployee.setLastName("Inal");
		newEmployee.setTitle("Sales Representative");
		Date hireDate= new Date(2020-02-02);
		newEmployee.setHireDate(hireDate);
		newEmployee.setTitleOfCourtesy("Ms.");

		mockMvc.perform(put("/api/employee")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newEmployee)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.firstName").exists())
						.andExpect(jsonPath("$.lastName").exists())
						.andExpect(jsonPath("$.title").exists())
						.andExpect(jsonPath("$.titleOfCourtesy").exists())
						.andExpect(jsonPath("$.hireDate").exists());
	}
	@Test
	public void testGetEmployeeById() throws Exception {
		long employeeId= 4;

		mockMvc.perform(get("/api/employees-by-id/{employeeId}", employeeId)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.lastName").exists())
						.andExpect(jsonPath("$.firstName").exists())
						.andExpect(jsonPath("$.title").exists())
						.andExpect(jsonPath("$.titleOfCourtesy").exists())
						.andExpect(jsonPath("$.hireDate").exists());

	}
	@Test
	public void testGetEmployeeByFirstName() throws Exception {
		String employeeFirstName="Margaret";

		mockMvc.perform(get("/api/employees-by-first-name/{employeeFirstName}", employeeFirstName)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.lastName").exists())
						.andExpect(jsonPath("$.firstName").exists())
						.andExpect(jsonPath("$.title").exists())
						.andExpect(jsonPath("$.titleOfCourtesy").exists())
						.andExpect(jsonPath("$.hireDate").exists());

	}
	@Test
	public void testGetEmployeeByLastName() throws Exception {
		String employeeLastName="Peacock";

		mockMvc.perform(get("/api/employees-by-last-name/{employeeLastName}", employeeLastName)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.lastName").exists())
						.andExpect(jsonPath("$.firstName").exists())
						.andExpect(jsonPath("$.title").exists())
						.andExpect(jsonPath("$.titleOfCourtesy").exists())
						.andExpect(jsonPath("$.hireDate").exists());

	}
	@Test
	public void testGetEmployeeByTitle() throws Exception {
		String title="Sales Representative";
		mockMvc.perform(get("/api/employees-by-title/{title}",title))
						.andExpect(status().isOk())
						.andDo(print())
						.andExpect(content().contentType("application/json"))
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].lastName").exists())
						.andExpect(jsonPath("$[*].firstName").exists())
						.andExpect(jsonPath("$[*].title").exists())
						.andExpect(jsonPath("$[*].titleOfCourtesy").exists())
						.andExpect(jsonPath("$[*].hireDate").exists());

	}
	@Test
	public void testGetEmployeeByTitleOfCourtesy() throws Exception {
		String employeeTitleOfCourtesy="Mrs.";
		mockMvc.perform(get("/api/employees-by-title-of-courtesy/{employeeTitleCourtesy}",employeeTitleOfCourtesy))
						.andExpect(status().isOk())
						.andDo(print())
						.andExpect(content().contentType("application/json"))
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].lastName").exists())
						.andExpect(jsonPath("$[*].firstName").exists())
						.andExpect(jsonPath("$[*].title").exists())
						.andExpect(jsonPath("$[*].titleOfCourtesy").exists())
						.andExpect(jsonPath("$[*].hireDate").exists());

	}
	
	@Test
	public void testDeleteEmployee() throws Exception {
		Long employeeId = 10L;

		mockMvc.perform(delete("/api/employee/{employeeId}", employeeId)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
	}
	    /*************************** EMPLOYEE TESTS ***************************/
	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
