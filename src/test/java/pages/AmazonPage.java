package pages;

public class AmazonPage extends BasePage {
	
	private String fieldSearch = "//input[@id='twotabsearchtextbox']";
	private String searchButton = "//input[@id='nav-search-submit-button']";
	private String product = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]/div[2]/div[18]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]";
	private String addToCartButton = "//input[@id='add-to-cart-button']";
	
	public AmazonPage () {
		super(driver);
	}
	
	public void navigateToSandbox() {
		navigateTo("https://www.amazon.com/");
	}
	
	public void writeAResult(String textToWrite) {
		write(fieldSearch ,textToWrite);
	}
	
	public void clickButtonSearch() {
		clickElement(searchButton);
	}
	
	public void clickNextPage() {
		goToLinkText("2");
	}
	
	public void clickAProduct() {
		clickElement(product);
	}
	
	public boolean elementIsVisible() {
		return elementIsDisplayed(addToCartButton);
	}
}