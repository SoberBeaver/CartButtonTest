package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.StartPage.*;
import static pages.OrderPage.*;

public class CartButtonStepdefs {

    @BeforeAll
    public static void setBrowserConfig(){
        Configuration.browser = "chrome";
        Configuration.timeout = 4000;
    }

    @After
    public static void clearingCart() {
        clearCart();
    }

    @Given("I open main page")
    public void iOpenMainPage() {
        open(getBASE_URL());
    }

    @And("Cart is empty")
    public void cartIsEmpty() {
        cartNoProduct.shouldBe(visible);
    }

    @When("I click on cart button")
    public void iClickOnCartButton() {
        cartButton.click();
    }

    @Then("I see the empty Shopping-cart summary page")
    public void iSeeTheEmptyShoppingCartSummaryPage() {
        cartIsEmptyMessage.click();
    }

    @When("I add product to cart")
    public void iAddProductToCart() {
        productBlocks.get(0).hover();
        productAddButtons.get(0).click();
    }

    @Then("Added product should be visible in cart dropdown")
    public void addedProductShouldBeVisibleInCartDropdown() {
        showCartDropdown();
        cardBlockProducts.get(0).should(visible);
    }

    @And("I click remove product from cart dropdown")
    public void iClickRemoveProductFromCartDropdown() {
        clearCart();
    }

    @When("^I add (\\d).+ product to cart with quick view button$")
    public void iAddFirstProductToCartWithQuickViewButton(int productNumber) {
        productBlocks.get(productNumber-1).hover();
        quickViewButtons.get(productNumber-1).click();
    }

    @And("Increase quantity to {int}")
    public void increaseQuantityToQuantity(int quantity) {
        iframeQuickViewElem.shouldBe(visible, exist);
        switchTo().frame(iframeQuickViewElem);
        quantityQuickViewBInput.shouldBe(visible);
        quantityQuickViewBInput.setValue(String.valueOf(quantity));
        switchTo().defaultContent();
    }

    @And("I click add to cart button")
    public void iClickAddToCartButton() {
        iframeQuickViewElem.shouldBe(visible, exist);
        switchTo().frame(iframeQuickViewElem);
        addToCartQuickViewButton.click();
        switchTo().defaultContent();
    }

    @And("I click continue shopping button")
    public void iClickContinueShoppingButton() {
        continueShoppingButton.shouldBe(visible, enabled).click();
    }

    @Then("Check product counter on cart button is {int}")
    public void checkProductCounterOnCartButtonIsProductCounter(int productCounter) {
        Assert.assertEquals(getCartProductCounter(), productCounter);
    }
}
