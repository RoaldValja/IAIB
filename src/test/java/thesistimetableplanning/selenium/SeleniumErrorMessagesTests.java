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

public class SeleniumErrorMessagesTests {
	
	// Seleniumi kood
	private static SeleniumTableButtons seleniumTableButtons;
	private static SeleniumErrorMessages seleniumErrorMessages;
	private String expectedTitle = "About Baeldung | Baeldung";
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		seleniumTableButtons = new SeleniumTableButtons();
		SeleniumConfig config = seleniumTableButtons.getConfig();
		seleniumErrorMessages = new SeleniumErrorMessages(config);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		seleniumTableButtons.closeWindow();
	}
/*
	@Test
	public void testMessageAddRow() {
		seleniumTableButtons.clickAddRow();
		boolean message = seleniumErrorMessages.getErrorMessage("Ei saa lisada tabeli rida tabelisse, mida pole olemas!");
		seleniumErrorMessages.clickErrorMessage();
		boolean button = seleniumErrorMessages.getErrorMessageButton("addRow", "rgba(240, 125, 93, 1)");
		assertTrue(message);
		assertTrue(button);
	}
	
	@Test
	public void testMessageAddColumn() {
		seleniumTableButtons.clickAddColumn();
		boolean message = seleniumErrorMessages.getErrorMessage("Ei saa lisada tabeli veergu tabelisse, mida pole olemas!");
		seleniumErrorMessages.clickErrorMessage();
		boolean button = seleniumErrorMessages.getErrorMessageButton("addColumn", "rgba(240, 125, 93, 1)");
		assertTrue(message);
		assertTrue(button);
	}
	
	@Test
	public void testMessageAddTab() {
		seleniumTableButtons.clickAddTab("");
		boolean message = seleniumErrorMessages.getErrorMessage("Ei saa lisada lipikut, kui pole talle antud nime!");
		seleniumErrorMessages.clickErrorMessage();
		boolean button = seleniumErrorMessages.getErrorMessageButton("addTab", "rgba(240, 125, 93, 1)");
		assertTrue(message);
		assertTrue(button);
	}
	
	@Test
	public void testMessageDeleteRow() {
		seleniumTableButtons.clickRemoveRow();
		boolean message = seleniumErrorMessages.getErrorMessage("Ei saa kustutada ridasid tabelist, mida pole olemas!");
		seleniumErrorMessages.clickErrorMessage();
		boolean button = seleniumErrorMessages.getErrorMessageButton("deleteRow", "rgba(240, 125, 93, 1)");
		assertTrue(message);
		assertTrue(button);
	}
	
	@Test
	public void testMessageDeleteColumn() {
		seleniumTableButtons.clickRemoveColumn();
		boolean message = seleniumErrorMessages.getErrorMessage("Ei saa kustutada veerge tabelist, mida pole olemas!");
		seleniumErrorMessages.clickErrorMessage();
		boolean button = seleniumErrorMessages.getErrorMessageButton("deleteColumn", "rgba(240, 125, 93, 1)");
		assertTrue(message);
		assertTrue(button);
	}
	*/
	// Vaja lisada testMessageRemoveTab, kus peab tegema lipiku aktiivseks, mille error puudub
	
	// Vaja lisada testMessageCreateNewProject, kus peab sisestama nime, mille error puudub
	
	// vaja lisada testMessageAddTable, kus on vaja sisestada rea number, veeru number või mõlemad, mille error puudub
	
	// vaja lisada testMessageAddRowNotNumber, kus üritatakse lisada tähti numbrite asemel, selleks on vaja muute addMultipleRows sisend stringiks.
	
	// vaja lisada testMessageAddColumnNotNumber, sama mis eelmine.

	// Vaja lisada testMessageAddTable siis kui pole lisatud lipikut. Selle error message puudub.
}
