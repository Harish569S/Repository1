package com.mindtree.college;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.mindtree.college.repository.CollegeRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CollegeServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	
	@Autowired
	CollegeRepository collegeRepositorye;
	
	
	@Test
	void contextLoads() throws Exception {
		
		String str="{\"id\":1,\"collegeName\":\"kains\",\"totalStudents\":3}";
		
		 mockMvc.perform(get("http://localhost:8083/college/1")).andExpect(status().isOk())
		.andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().string(str));
	}


	

}
