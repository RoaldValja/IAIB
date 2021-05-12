package thesistimetableplanning.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumLanguageAndHelp {

	private SeleniumConfig config;
	//private String url = "http://127.0.0.1:80";
	private String url = "http://127.0.0.1:8080";
	
	public SeleniumLanguageAndHelp() {
		config = new SeleniumConfig();
		config.getDriver().get(url);
	}
	
	public void closeWindow() {
		this.config.getDriver().close();
	}
	
	public String getTitle() {
		return this.config.getDriver().getTitle();
	}
	
	public void clickLanguageButton() {
		WebElement elementLanguage = this.config.getDriver()
				.findElement(By.id("languageButton"));
		elementLanguage.click();
	}
	
	public void clickLanguageChoice(String language) {
		String id = "language" + language.substring(0,1).toUpperCase() + language.substring(1);
		WebElement elementLanguageChoice = this.config.getDriver()
				.findElement(By.id(id));
		elementLanguageChoice.click();
	}
	
	public boolean checkLanguage(String check) {
		check = check.substring(0, 1).toUpperCase() + check.substring(1);
		WebElement element = this.config.getDriver()
				.findElement(By.id("tutorialPrevious"));
		String innerHTML = element.getAttribute("innerHTML");
		if(innerHTML.equals(check)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void clickHelpButton() {
		WebElement element = this.config.getDriver()
				.findElement(By.id("helpButton"));
		element.click();
	}
	
	public void clickTutorialButton(String tutorialName) {
		String id = "tutorial" + tutorialName.substring(0,1).toUpperCase() + tutorialName.substring(1);
		WebElement element = this.config.getDriver()
				.findElement(By.id(id));
		element.click();
	}
	
	public boolean checkTutorialColour(String name, String colour) {
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
	/*
	public boolean checkTutorialText(String text) {
		WebElement element = this.config.getDriver()
				.findElement(By.partialLinkText("About Baeldung."));
		
	}
	*/
}
