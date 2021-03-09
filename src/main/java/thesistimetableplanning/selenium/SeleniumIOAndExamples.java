package thesistimetableplanning.selenium;

public class SeleniumIOAndExamples {

	private SeleniumConfig config;
	private String url = "http://127.0.0.1:80";
	
	public SeleniumIOAndExamples() {
		config = new SeleniumConfig();
		config.getDriver().get(url);
	}
	
	public SeleniumIOAndExamples(SeleniumConfig config) {
		this.config = config;
		config.getDriver().get(url);
	}
	
	public void closeWindow() {
		this.config.getDriver().close();
	}
}
