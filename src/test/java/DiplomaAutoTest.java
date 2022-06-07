import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiplomaAutoTest {
    private final SelenideElement replyFromBank = $(".notification__content");
    private final SelenideElement buyInCredit = $x("//*[@id='root']/div/button[2]");
    private final SelenideElement buyWithCard = $("[class='button button_size_m button_theme_alfa-on-white']");
    private final SelenideElement cardNumber = $(".input__control[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $(".input__control[placeholder='08']");
    private final SelenideElement year = $(".input__control[placeholder='22']");
    private final SelenideElement cardOwner = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private final SelenideElement cvvCode = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    private final SelenideElement buttonNext = $(withText("Продолжить"));


    FormFill fill = new FormFill();

    @BeforeEach
    void setUp() {
        open("http://localhost:9090");
    }

    @Test
    void buyWithCard() {
        Configuration.holdBrowserOpen = true;
        var info = DataGenerator.Registration.generateInfo("ru");
        buyWithCard.click();
        cardNumber.val(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        cardOwner.setValue(info.getName());
        cvvCode.setValue(info.getCvv());
        buttonNext.click();
        String expected = "Операция одобрена банком";
        String actual = String.valueOf(replyFromBank.shouldBe(Condition.visible, Duration.ofSeconds(15)));
        assertEquals(expected, actual);
    }

    @Test
    void buyInCredit() {
        var info = DataGenerator.Registration.generateInfo("ru");
        Configuration.holdBrowserOpen = true;
        buyInCredit.click();
        cardNumber.val(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        cardOwner.setValue(info.getName());
        cvvCode.setValue(info.getCvv());
        buttonNext.click();
        String expected = "Операция одобрена банком";
        String actual = replyFromBank.getText();
        assertEquals(expected, actual);
    }

    @Test
    void sendEmptyForm() {
        buyWithCard.click();
        buttonNext.click();
        String expected = fill.getError();
        String actual = "Неверный формат";
        assertEquals(actual, expected);     //TODO Дописать перебор цикла с каждым элементом формы, для проверки ошибки
    }

    @Test
    void shouldNavigateWithTabKey() {
        Configuration.holdBrowserOpen = true;
        buyWithCard.click();
        cardNumber.click();
        Point expected = fill.getMouseLocation();
        cardNumber.setValue("2133 1231 2123 1233").sendKeys(Keys.TAB);
        Point actual = fill.getMouseLocation();                         //TODO Доработать тест
        assertEquals(expected, actual);


    }

    @Test
    void shouldDeleteWithBackspace() {
        Configuration.holdBrowserOpen = true;
        var info = DataGenerator.Registration.generateInfo("ru");
        buyWithCard.click();
        cardNumber.setValue(info.getCardNumber()).sendKeys(Keys.chord(Keys.COMMAND, "A"));
        cardNumber.sendKeys(Keys.BACK_SPACE);
        cardNumber.shouldBe(Condition.empty);
    }

    @Test
    void shouldCheckValidName() {

    }

    @Test
    void shouldCheckValidCard() {

    }

    @Test
    void shouldCheckValidMonth() {

    }

    @Test
    void shouldCheckValidYear() {

    }

    @Test
    void shouldCheckValidCvv() {

    }


}

