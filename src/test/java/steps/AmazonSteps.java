package steps;

import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.*;
import pages.AmazonPage;

public class AmazonSteps {
	
	AmazonPage amazon = new AmazonPage();
	
	@Given ("the user navigates to www.amazon.com")
	public void navigate() {
		amazon.navigateToSandbox();
	}
	
    @And ("^searches for (.*)$")
    public void searches_for_item(String item) {
    	amazon.writeAResult(item);
    	amazon.clickButtonSearch();
    }
    
    @And ("navigates to the second page")
    public void navigates_to_the_second_page() {
    	amazon.clickNextPage();
    }
    
    @And ("selects the third item")
    public void selects_the_third_item() {
    	amazon.clickAProduct();
    }
    
    @Then ("the user is able to add it to the cart") 
    public void the_user_is_able_to_add_it_to_the_cart() {
    	assertTrue("Añadir al carro no disponible", amazon.elementIsVisible());
    }
}