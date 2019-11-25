package com.socgen.employeeportal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socgen.employeeportal.domain.Employee;
import com.socgen.employeeportal.domain.Response;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeePortalApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addEmployeeTest() throws Exception {

        Employee employee = new Employee();
        employee.setFirstName("arun");
        employee.setLastName("sharma");
        employee.setGender("male");
        employee.setDepartment("IT");
        employee.setdOBStr("1999-11-21");

        String jsonRequest = objectMapper.writeValueAsString(employee);
        MvcResult result = mockMvc.perform(post("/employee").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String resultConstant = result.getResponse().getContentAsString();
        Response response = objectMapper.readValue(resultConstant, Response.class);
        assertTrue(response.isStatus() == Boolean.TRUE);

    }

    @Test
    public void getEmployeeTest() throws Exception {
        MvcResult result = mockMvc.perform
                (get("/employee").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        String resultConstant = result.getResponse().getContentAsString();

        Iterable<Employee> employees = objectMapper.readValue(resultConstant, Iterable.class);
        Assertions
                .assertThat(employees)
                .hasSize(1);
    }
}
