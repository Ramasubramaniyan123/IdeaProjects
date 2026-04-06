package com.example.sample_java_assignment_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class SpringbootSampleAppApplicationTests {
	private final SpringbootSampleAppApplication spring = new SpringbootSampleAppApplication();
	@Test
	void login_checker(){
		String response = spring.login("User");
		assertNotNull(response);
		assertEquals("Please share your credentials for login...", response);
	}
	@Test
	void register_checker(){
		String response = spring.register("User");
		assertNotNull(response);
		assertEquals("Please share your credentials for register", response);
	}

}
