package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Data
public class OrderPage {
    static public SelenideElement cartIsEmptyMessage = $(By.cssSelector("p.alert.alert-warning"));
}
