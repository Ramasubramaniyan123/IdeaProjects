package com.example.sample_java_assignment_app;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SpringbootSampleAppApplicationTests {

	private final SpringbootSampleAppApplication controller=new SpringbootSampleAppApplication();
	@Test
	void contextLoads(){
			SpringbootSampleAppApplication.main(new String[]{});
	}
	@Test
	void testLoginResponse(){
		String response=controller.login("TestUser");
		assertThat(response).isEqualTo("Please input your credentials for login...");
	}
	@Test
	void testRegisterResponse(){
		String response=controller.register("TestUser");
		assertThat(response).isEqualTo("Please follow registration process...");
	}

}
