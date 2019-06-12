package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

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

		assertEquals("Passed in string should be return capitalized.", "HELLO", hc.capitalizeStr("hello"));
		assertEquals("Passed in string should be return capitalized.", "HELLO", hc.capitalizeStr("HELLO"));
		assertEquals("Passed in string should be return capitalized.", "HELLO WORLD",
				hc.capitalizeStr("hello world"));
		assertEquals("Passed in string should be return capitalized.", "   H   ",
				hc.capitalizeStr("   H   "));
		assertEquals("Passed in string should be return capitalized.", "  ", hc.capitalizeStr("  "));

	}
	@Test(expected = IllegalArgumentException.class)
	public void testCapitalizeStr_fail() {
		HelloWorldController hc = new HelloWorldController();

		assertEquals("Passed in string should be return capitalized.", "", hc.capitalizeStr(""));
	}

	@Test
	public void testReverseStr(){
		HelloWorldController hc = new HelloWorldController();

		assertEquals("Passed in string should be return capitalized.", "", hc.capitalizeStr(""));

	}

}
