package thesistimetableplanning.selenium;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeleniumIOAndExamplesTests {
	
	// Seleniumi kood
	private static SeleniumIOAndExamples seleniumIOAndExamples;
	private String expectedTitle = "About Baeldung | Baeldung";
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		seleniumIOAndExamples = new SeleniumIOAndExamples();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		seleniumIOAndExamples.closeWindow();
	}
	/*
	@Test
	public void testAddTabButton() {
		//seleniumIOAndExamples.clickAddTab("test");
		//boolean actualTab = seleniumIOAndExamples.getTab("test");
		//assertTrue(actualTab);
	}
	*/
	
}
