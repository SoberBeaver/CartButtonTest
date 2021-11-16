package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import config.UserConfig;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.StartPage.*;
import static pages.OrderPage.*;

public class CartButtonStepDefs {

    UserConfig user = new UserConfig();

    @BeforeAll
    public static void setBrowserConfig(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
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
        Assert.assertTrue(cartNoProduct.isDisplayed());
    }

    @When("I click on cart button")
    public void iClickOnCartButton() {
        cartButton.click();
    }

    @Then("I see the empty Shopping-cart summary page")
    public void iSeeTheEmptyShoppingCartSummaryPage() {
        Assert.assertTrue(cartIsEmptyMessage.isDisplayed());
    }

    @When("I add product to cart")
    public void iAddProductToCart() {
        productBlocks.get(0).hover();
        productAddButtons.get(0).click();
    }

    @Then("Added product should be visible in cart dropdown")
    public void addedProductShouldBeVisibleInCartDropdown() {
        showCartDropdown();
        Assert.assertTrue(cardBlockProducts.get(0).isDisplayed());
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

    @And("I click proceed to checkout button")
    public void iClickProceedToCheckoutButton() {
        proceedToCheckoutButton.shouldBe(visible).click();
    }

    @And("I click proceed to checkout button at order page")
    public void iClickProceedToCheckoutButtonAtOrderPage() {
        proceedToCheckoutOrderPageButton.shouldBe(visible).click();
    }

    @And("I enter email")
    public void iEnterEmail() {
        emailInput.shouldBe(visible).setValue(user.getUserEmail());
    }

    @And("I enter password")
    public void iEnterPassword() {
        passwordInput.setValue(user.getUserPassword());
    }

    @And("I click sing in button")
    public void iClickSingInButton() {
        signInButton.click();
    }

    @And("I confirm address clicking on proceed to checkout button")
    public void iConfirmAddressClickingOnProceedToCheckoutButton() {
        proceedToCheckoutAprocessAddressButton.shouldBe(visible).click();
    }

    @And("I click on terms of service check box and proceed to checkout button")
    public void iClickOnTermsOfServiceCheckBoxAndProceedToCheckoutButton() {
        termsOfServiceCheckbox.click();
        proceedToCheckoutprocessCarrierButton.click();
    }

    @And("I click pay by bank wire button")
    public void iClickPayByBankWireButton() {
        payBankWireButton.shouldBe(visible).click();
    }

    @And("I confirm order")
    public void iConfirmOrder() {
        iConfirmMyOrderButton.shouldBe(visible).click();
    }
}
