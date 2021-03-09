package thesistimetableplanning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumErrorMessages {

	private SeleniumConfig config;
	private String url = "http://127.0.0.1:80";
	
	public SeleniumErrorMessages() {
		config = new SeleniumConfig();
		config.getDriver().get(url);
	}
	
	public SeleniumErrorMessages(SeleniumConfig config) {
		this.config = config;
		config.getDriver().get(url);
	}
	
	public void closeWindow() {
		this.config.getDriver().close();
	}
	
	public boolean getErrorMessage(String message) {
		WebElement element = this.config.getDriver()
				.findElement(By.id("errorMessageNumber-0"));
		String actualMessage = element.getAttribute("innerHTML");
		System.out.println(actualMessage);
		if(message.equals(actualMessage)) {
			return true;
		}
		return false;
	}
	
	public void clickErrorMessage() {
		WebElement element = this.config.getDriver()
				.findElement(By.id("errorMessageNumber-0"));
		element.click();
	}
	
	public boolean getErrorMessageButton(String name, String colour) {
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		WebElement element = this.config.getDriver()
				.findElement(By.id(name));
		String actualColour = element.getCssValue("background-color");
		System.out.println("Siin on actual color: " + actualColour);
		if(colour.equals(actualColour)) {
			return true;
		}
		return false;
	}
	
}
