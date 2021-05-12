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

public class SeleniumTableButtonsTests {
	
	// Seleniumi kood
	private static SeleniumTableButtons seleniumTableButtons;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		seleniumTableButtons = new SeleniumTableButtons();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		seleniumTableButtons.closeWindow();
	}
/*
	@Test
	public void testAddTabButton() {
		seleniumTableButtons.clickAddTab("test");
		boolean actualTab = seleniumTableButtons.getTab("test");
		
		//assertNotNull(actualTab);
		//assertEquals(expectedTitle, actualTitle);
		assertTrue(actualTab);
	}
	
	@Test
	public void testAddTableButton() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		boolean actualTable = seleniumTableButtons.checkRow("1-1");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddRowButton() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddRow();
		boolean actualTable = seleniumTableButtons.checkRow("5-1");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddRowToMiddle() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.selectMiddleRow("2-1");
		seleniumTableButtons.clickAddRow();
		boolean actualTable = seleniumTableButtons.checkRow("5-1");
		boolean colourCheck = seleniumTableButtons.checkColour("#e6d8c3", "2-1");
		assertTrue(actualTable);
	}

	@Test
	public void testAddMultipleRows() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddMultipleRows(2);
		seleniumTableButtons.clickAddRow();
		boolean actualTable = seleniumTableButtons.checkRow("6-1");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddMultipleRowsToMiddle() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddMultipleRows(2);
		seleniumTableButtons.selectMiddleRow("2-1");
		seleniumTableButtons.clickAddRow();
		boolean actualTable = seleniumTableButtons.checkRow("6-1");
		boolean colourCheck = seleniumTableButtons.checkColour("#e6d8c3", "2-1");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddColumnButton() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-6");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddColumnToMiddle() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.selectMiddleColumn("2-2");
		seleniumTableButtons.clickAddColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-6");
		boolean colourCheck = seleniumTableButtons.checkColour("#e6d8c3", "2-2");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddMultipleColumns() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddMultipleColumns(2);
		seleniumTableButtons.clickAddColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-7");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddMultipleColumnsToMiddle() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddMultipleColumns(2);
		seleniumTableButtons.selectMiddleColumn("2-2");
		seleniumTableButtons.clickAddColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-7");
		boolean colourCheck = seleniumTableButtons.checkColour("#e6d8c3", "2-2");
		assertTrue(actualTable);
	}
	
	@Test
	public void testRemoveRowButton() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickRemoveRow();
		boolean actualTable = seleniumTableButtons.checkRow("4-1");
		assertTrue(actualTable);
	}
	
	@Test
	public void testRemoveMiddleRow() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.selectMiddleRow("2-1");
		seleniumTableButtons.clickRemoveRow();
		boolean actualTable = seleniumTableButtons.checkRow("4-1");
		assertFalse(actualTable);
	}
*/
	/*
	@Test
	public void testRemoveFirstRow() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.selectMiddleRow("1-1");
		seleniumTableButtons.clickRemoveRow();
		boolean actualTable = seleniumTableButtons.checkRow("4-1");
		assertFalse(actualTable);
	}
	*/
/*
	@Test
	public void testAddRowThenRemoveRow() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddRow();
		seleniumTableButtons.clickRemoveRow();
		boolean actualTable = seleniumTableButtons.checkRow("5-1");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddRowThenRemoveMiddleRow() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddRow();
		seleniumTableButtons.selectMiddleRow("2-1");
		seleniumTableButtons.clickRemoveRow();
		boolean actualTable = seleniumTableButtons.checkRow("5-1");
		assertFalse(actualTable);
	}
	
	@Test
	public void testRemoveColumnButton() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickRemoveColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-5");
		assertTrue(actualTable);
	}
	
	@Test
	public void testRemoveMiddleColumn() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.selectMiddleColumn("2-2");
		seleniumTableButtons.clickRemoveColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-5");
		assertFalse(actualTable);
	}
*/
	/*
	@Test
	public void testRemoveFirstColumn() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.selectMiddleColumn("1-1");
		seleniumTableButtons.clickRemoveColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-5");
		assertFalse(actualTable);
	}
	*/
/*
	@Test
	public void testAddColumnThenRemoveColumn() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddColumn();
		seleniumTableButtons.clickRemoveColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-6");
		assertTrue(actualTable);
	}
	
	@Test
	public void testAddColumnThenRemoveMiddleColumn() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickAddTable(4, 5);
		seleniumTableButtons.clickAddColumn();
		seleniumTableButtons.selectMiddleColumn("2-2");
		seleniumTableButtons.clickRemoveColumn();
		boolean actualTable = seleniumTableButtons.checkRow("1-6");
		assertFalse(actualTable);
	}
	
	@Test
	public void testRemoveTabButton() {
		seleniumTableButtons.clickAddTab("test");
		seleniumTableButtons.clickRemoveTab();
		boolean actualTable = seleniumTableButtons.checkTab("test");
		assertFalse(actualTable);
	}
*/
}
