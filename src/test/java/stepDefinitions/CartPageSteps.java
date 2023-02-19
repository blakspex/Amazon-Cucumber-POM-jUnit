package stepDefinitions;

import com.qa.factory.DriverFactory;

import org.junit.Assert;

import com.pages.CartPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CartPageSteps {
	private CartPage cartPage = new CartPage(DriverFactory.getDriver());
	private String noSignIn = "Sign in";
	private String currUrl;
	
	
	public static String signInStatus;
	
	@Given("^user is on Amazon page$")
	public void user_is_on_amazon_website() {
		DriverFactory.getDriver().get("http://www.amazon.com");
	}
	
	@When ("user is not signed in")
	public void user_not_signed_in() {
		signInStatus = cartPage.getLoginStatus();
		Assert.assertTrue(signInStatus.contains(noSignIn));
	}
	
	@When ("user tries to access cart")
	public void user_accesses_cart() {
		cartPage.clickOnCart();
	}
	
	@When ("user clicks on Proceed to Buy")
	public void user_proceeds_to_buy() {
		cartPage.proceedToBuy();
	}
	@Then ("user must be asked to sign in")
	public void sign_in_request() {
		currUrl = cartPage.getCurrentUrl();
		Assert.assertTrue(currUrl.contains("https://www.amazon.in/ap/signin?"));
	}
	
	
}
