package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Data
public class OrderPage {
    static public SelenideElement cartIsEmptyMessage = $(By.cssSelector("p.alert.alert-warning"));
    static public SelenideElement proceedToCheckoutOrderPageButton = $(By.cssSelector("p.cart_navigation > a[title=\"Proceed to checkout\"]"));
    static public SelenideElement emailInput = $(By.id("email"));
    static public SelenideElement passwordInput = $(By.id("passwd"));
    static public SelenideElement signInButton = $(By.id("SubmitLogin"));
    static public SelenideElement proceedToCheckoutAprocessAddressButton = $(By.name("processAddress"));
    static public SelenideElement proceedToCheckoutprocessCarrierButton = $(By.name("processCarrier"));
    static public SelenideElement termsOfServiceCheckbox = $(By.id("cgv"));
    static public SelenideElement payBankWireButton = $(By.cssSelector("a.bankwire"));
    static public SelenideElement submitButton = $(By.cssSelector("a.bankwire"));
    static public SelenideElement iConfirmMyOrderButton = $(By.cssSelector("p#cart_navigation >button"));

}
