package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Data
public class StartPage {
    @Getter
    final static private String BASE_URL = "http://automationpractice.com/";

    final static public SelenideElement cartNoProduct = $(By.cssSelector("div.shopping_cart span.ajax_cart_no_product"));
    final static public SelenideElement cartButton = $(By.cssSelector("a[title=\"View my shopping cart\"]"));
    final static public SelenideElement cartProductCounter = $(By.cssSelector("div.shopping_cart span.ajax_cart_quantity"));

    final static public ElementsCollection productBlocks = $$(By.cssSelector("li.ajax_block_product"));
    final static public ElementsCollection productAddButtons = $$(By.cssSelector("a.ajax_add_to_cart_button"));

    final static public SelenideElement continueShoppingButton = $(By.cssSelector("span[title=\"Continue shopping\"]"));

    final static public ElementsCollection cardBlockProducts = $$(By.cssSelector("div.cart_block a.cart_block_product_name"));
    final static public ElementsCollection cardBlockRemoveButtons = $$(By.cssSelector("a.ajax_cart_block_remove_link"));

    final static public ElementsCollection quickViewButtons = $$(By.cssSelector("a.quick-view"));
    final static public SelenideElement iframeQuickViewElem = $(By.cssSelector("div > iframe"));
    final static public SelenideElement quantityQuickViewBInput = $(By.cssSelector("input#quantity_wanted"));
    final static public SelenideElement addToCartQuickViewButton = $(By.cssSelector("button.exclusive"));

    public static void showCartDropdown() {
        cartButton.scrollIntoView(true).hover();
    }

    public static int getCartProductCounter() {
        return Integer.parseInt(cartProductCounter.shouldBe(visible).getText());
    }

    public static void clearCart(){
        if (!cardBlockRemoveButtons.isEmpty()) {
            showCartDropdown();
            cardBlockRemoveButtons.forEach(SelenideElement::click);
        }
    }
}
