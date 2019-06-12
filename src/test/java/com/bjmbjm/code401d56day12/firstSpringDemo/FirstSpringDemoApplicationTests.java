package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.jboss.logging.NDC.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstSpringDemoApplicationTests {

//	@Before
//	public HelloWorldController setup() {
//		HelloWorldController hc = new HelloWorldController();
//		System.out.println("Setup complete.");
//		return hc;
//	}
	@Test
	public void testGetHelloWorld() {
		HelloWorldController hc = new HelloWorldController();
		String expected = "Hello, world! It's a beautiful day today!";
		String actual = hc.getHelloWorld();

		assertEquals("getHellowWorld should return a hellow world greeting.", expected, actual);
	}

	@Test
	public void testCapitalizeStr() {
		HelloWorldController hc = new HelloWorldController();

		assertEquals("Passed in string should be returned capitalized.", "HELLO", hc.capitalizeStr("hello"));
		assertEquals("Passed in string should be returned capitalized.", "HELLO", hc.capitalizeStr("HELLO"));
		assertEquals("Passed in string should be returned capitalized.", "HELLO WORLD",
				hc.capitalizeStr("hello world"));
		assertEquals("Passed in string should be returned capitalized.", "   H   ",
				hc.capitalizeStr("   H   "));
		assertEquals("Passed in string should be returned capitalized.", "  ", hc.capitalizeStr("  "));

	}
	@Test(expected = IllegalArgumentException.class)
	public void testCapitalizeStr_fail() {
		HelloWorldController hc = new HelloWorldController();

		assertEquals("Passed in string should be returned capitalized.", "", hc.capitalizeStr(""));
	}

	@Test
	public void testReverseStr(){
		HelloWorldController hc = new HelloWorldController();

		assertEquals("Passed in string should be returned in reverse order.",
				"world hello", hc.reverseStr("hello world").getSentence());
		assertEquals("Passed in string should be returned in reverse order.",
				"f   r     ", hc.reverseStr("     r   f     ").getSentence());
		assertEquals("Passed in string should be returned in reverse order.",
				"", hc.reverseStr("   ").getSentence());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testReverseStr_fail(){
		HelloWorldController hc = new HelloWorldController();

		assertEquals("Passed in string should be returned in reverse order.",
				"", hc.reverseStr("").getSentence());


	}
// want to add later for route testing
//	//https://www.baeldung.com/integration-testing-in-spring
//	@Test
//	public void testRootPath() {
//		MvcResult mvcResult = this.mockMvc.perform(get("/greet"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.message").value("Hello World!!!"))
//				.andReturn();
//
//		assertEquals()
//	}

}
