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

public class SeleniumLanguageAndHelpTests {
	
	// Seleniumi kood
	private static SeleniumLanguageAndHelp seleniumLanguageAndHelp;
	private String expectedTitle = "About Baeldung | Baeldung";
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		seleniumLanguageAndHelp = new SeleniumLanguageAndHelp();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		seleniumLanguageAndHelp.closeWindow();
	}

	@Test
	public void testCheckEnglishLanguage() {
		seleniumLanguageAndHelp.clickLanguageButton();
		seleniumLanguageAndHelp.clickLanguageChoice("English");
		boolean actualTab = seleniumLanguageAndHelp.checkLanguage("Previous");
		assertTrue(actualTab);
	}
	
	@Test
	public void testCheckEstonianLanguage() {
		seleniumLanguageAndHelp.clickLanguageButton();
		seleniumLanguageAndHelp.clickLanguageChoice("English");
		seleniumLanguageAndHelp.clickLanguageButton();
		seleniumLanguageAndHelp.clickLanguageChoice("Estonian");
		boolean actualTab = seleniumLanguageAndHelp.checkLanguage("Eelmine");
		assertTrue(actualTab);
	}
	
	@Test
	public void testCheckTutorialInputFile() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("inputFile");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("inputFile", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialCreateNewProject() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("newProject");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("newProject", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialCreateExampleTables() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("generateExampleTable");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("generateExampleTable", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialCreateTableTemplates() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("generateTemplateTable");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("generateTemplateTable", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialAddRow() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("addRow");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("addRow", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialAddColumn() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("addColumn");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("addColumn", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialDeleteRow() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("deleteRow");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("deleteRow", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialDeleteColumn() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("deleteColumn");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("deleteColumn", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialAddTable() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("addTable");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("addTable", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialAddTab() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("addTab");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("addTab", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialDeleteTab() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("deleteTab");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("deleteTab", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialSaveProject() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("saveProject");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("saveProject", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialPlanProject() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("planProject");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("planProject", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialErrorMessages() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("errorMessageArea");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("errorMessageArea", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialNext() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("next");
		seleniumLanguageAndHelp.clickTutorialButton("next");
		seleniumLanguageAndHelp.clickTutorialButton("next");
		seleniumLanguageAndHelp.clickTutorialButton("next");
		seleniumLanguageAndHelp.clickTutorialButton("next");
		seleniumLanguageAndHelp.clickTutorialButton("next");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("deleteRow", "rgb(195, 228, 247)");
		assertTrue(check);
	}
	
	@Test
	public void testCheckTutorialLast() {
		seleniumLanguageAndHelp.clickHelpButton();
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		seleniumLanguageAndHelp.clickTutorialButton("previous");
		boolean check = seleniumLanguageAndHelp.checkTutorialColour("deleteRow", "rgb(195, 228, 247)");
		assertTrue(check);
	}
}
