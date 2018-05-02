package com.abhishek.sample.controller.test;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.abhishek.sample.application.AccountApplication;
import com.abhishek.sample.controller.CustomerController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @ContextConfiguration(classes=AccountApplication.class)
@ActiveProfiles("mock")
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = AccountApplication.class)
public class AccountApplicationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private MockMvc mockMvc;

	@InjectMocks
	CustomerController CustomerControllerTest;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(CustomerControllerTest).build();

	}

	@Test
	public void testRetrieveStudentCourse() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/acconts/1"), HttpMethod.GET, entity,
				String.class);

		String expected = "{id:Course1,name:Spring,description:10 Steps}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	/*
	 * @Test public void createTest() { ResponseEntity<Account> respEntit =
	 * restTemplate.postForEntity("/accounts", new Account(), Account.class);
	 * Account acc = respEntit.getBody(); assertEquals(HttpStatus.CREATED,
	 * respEntit.getStatusCode()); }
	 */

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
