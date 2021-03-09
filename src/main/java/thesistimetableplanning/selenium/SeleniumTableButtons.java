package thesistimetableplanning.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTableButtons {

	private SeleniumConfig config;
	private String url = "http://127.0.0.1:80";
	
	public SeleniumTableButtons() {
		config = new SeleniumConfig();
		config.getDriver().get(url);
	}
	
	public void closeWindow() {
		this.config.getDriver().close();
	}
	
	public String getTitle() {
		return this.config.getDriver().getTitle();
	}
	
	public SeleniumConfig getConfig() {
		return config;
	}
	
	// Vaja muuta deleteColumn removeColumn-ks
	public void clickRemoveColumn() {
		WebElement elementRemoveColumn = this.config.getDriver()
				.findElement(By.id("deleteColumn"));
		elementRemoveColumn.click();
	}
	
	// Vaja muuta deleteRow removeRow-ks
	public void clickRemoveRow() {
		WebElement elementRemoveRow = this.config.getDriver()
				.findElement(By.id("deleteRow"));
		elementRemoveRow.click();
	}
	
	public void clickAddMultipleColumns(int numInt) {
		String num = String.valueOf(numInt);
		WebElement elementTableRow = this.config.getDriver()
				.findElement(By.id("tableColumn"));
		elementTableRow.sendKeys(num);
	}
	
	public void selectMiddleColumn(String slot) {
		String rowName = "table" + tabName.substring(0, 1).toUpperCase() + tabName.substring(1) + "-" + slot;
		WebElement elementSelectCol = this.config.getDriver()
				.findElement(By.id(rowName));
		elementSelectCol.click();
	}
	
	public void clickAddColumn() {
		WebElement elementAddColumn = this.config.getDriver()
				.findElement(By.id("addColumn"));
		elementAddColumn.click();
	}
	
	public void clickAddMultipleRows(int numInt) {
		String num = String.valueOf(numInt);
		WebElement elementTableRow = this.config.getDriver()
				.findElement(By.id("tableRow"));
		elementTableRow.sendKeys(num);
	}
	
	String tabName = "";
	
	public void selectMiddleRow(String slot) {
		String rowName = "table" + tabName.substring(0, 1).toUpperCase() + tabName.substring(1) + "-" + slot;
		System.out.println(rowName + " - SIIN ON ROWNAME");
		WebElement elementSelectRow = this.config.getDriver()
				.findElement(By.id(rowName));
		elementSelectRow.click();
	}
	
	public void clickAddRow() {
		WebElement elementAddRow = this.config.getDriver()
				.findElement(By.id("addRow"));
		elementAddRow.click();
	}
	
	public void clickAddTable(int rowInt, int colInt) {
		String row = String.valueOf(rowInt);
		String col = String.valueOf(colInt);
		WebElement elementTableRow = this.config.getDriver()
				.findElement(By.id("tableRow"));
		WebElement elementTableColumn = this.config.getDriver()
				.findElement(By.id("tableColumn"));
		elementTableRow.sendKeys(row);
		elementTableColumn.sendKeys(col);
		WebElement elementAddTable = this.config.getDriver()
				.findElement(By.id("addTable"));
		elementAddTable.click();
	}
	
	public boolean checkRow(String id) {
		String tab = tabName.substring(0, 1).toUpperCase() + tabName.substring(1);
		List<WebElement> rows = this.config.getDriver()
				.findElements(By.className("tableRowClass"));
		int i;
		for(i = 0; i < rows.size(); i++) {
			if(rows.get(i).getAttribute("id").contains("table" + tab + "-" + id)) {
				return true;
			}
		}
		return false;
	}
	// deleteTab to removeTab
	public void clickRemoveTab() {
		String tab = "tab" + tabName.substring(0, 1).toUpperCase() + tabName.substring(1);
		System.out.println(tab);
		WebElement elementTab = this.config.getDriver()
				.findElement(By.id(tab));
		elementTab.click();
		WebElement elementRemoveTab = this.config.getDriver()
				.findElement(By.id("deleteTab"));
		elementRemoveTab.click();
		tabName = "";
	}
	
	public void clickAddTab(String tab) {
		WebElement element = this.config.getDriver()
				.findElement(By.id("addTab"));
		WebElement elementName = this.config.getDriver()
				.findElement(By.id("tabName"));
		elementName.sendKeys(tab);
		element.click();
		tabName = tab;
	}
	
	public boolean checkTab(String tabName) {
		String tab = "tab" + tabName.substring(0, 1).toUpperCase() + tabName.substring(1);
		List<WebElement> tabs = this.config.getDriver()
				.findElements(By.className("tab"));
		int i;
		for(i = 0; i < tabs.size(); i++) {
			if(tabs.get(i).getAttribute("id").contains(tab)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkColour(String colour, String slot) {
		String rowName = "table" + tabName.substring(0, 1).toUpperCase() + tabName.substring(1) + "-" + slot;
		WebElement elementRow = this.config.getDriver()
				.findElement(By.id(rowName));
		String actualColour = elementRow.getCssValue("background-color");
		if(colour.equals(actualColour)) {
			return true;
		}
		return false;
	}
	
	public boolean getTab(String tab) {
		String tabUpper = tab.substring(0, 1).toUpperCase() + tab.substring(1);
		return this.config.getDriver()
				.findElement(By.id("tab" + tabUpper))
				.getAttribute("innerHTML")
				.contains(tab);
	}
	
	public void getAboutBaeldungPage() {
		closeOverlay();
		clickAboutLink();
		clickAboutUsLink();
	}
	
	private void closeOverlay() {
		List<WebElement> webElementList = this.config.getDriver()
				.findElements(By.tagName("a"));
		if(webElementList != null) {
			webElementList.stream()
			.filter(webElement -> "Close".equalsIgnoreCase(webElement.getAttribute("title")))
			.filter(WebElement::isDisplayed)
			.findAny()
			.ifPresent(WebElement::click);
		}
	}
	
	private void clickAboutLink() {
		Actions actions = new Actions(config.getDriver());
		WebElement aboutElement = this.config.getDriver()
				.findElement(By.id("menu-item-6138"));
		actions.moveToElement(aboutElement).perform();
	}
	
	private void clickAboutUsLink() {
		WebElement element = this.config.getDriver()
				.findElement(By.partialLinkText("About Baeldung."));
		element.click();
	}
	
	public boolean isAuthorInformationAvailable() {
		return this.config.getDriver()
				.getPageSource()
				.contains("Hey ! I'm Eugen");
	}
}
