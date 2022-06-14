package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dataHelper.DataGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyOnCredit {

    private final SelenideElement heading = $x("//*[@id='root']/div/h3");
    private final SelenideElement title = $(".notification__title");
    private final SelenideElement positiveReply = $(".notification__content");
    private final SelenideElement negativeReply = $(".notification__content");
    private final SelenideElement cardNumber = $(".input__control[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $(".input__control[placeholder='08']");
    private final SelenideElement year = $(".input__control[placeholder='22']");
    private final SelenideElement cardOwner = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private final SelenideElement cvvCode = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    private final SelenideElement buttonNext = $(withText("Продолжить"));

    private SelenideElement clientResponse = $(".input__sub");


    public void fillIn() {
        var info = DataGenerator.Registration.generateInfo("ru");
        cardNumber.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        cardOwner.setValue(info.getName());
        cvvCode.setValue(info.getCvv());

    }

    public void clearField(SelenideElement field) {
        field.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
    }

    public void applyFormWithCard() {
        var info = DataGenerator.Registration.generateInfo("ru");
        heading.shouldBe(Condition.text("Оплата по карте"));
        cardNumber.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        cardOwner.setValue(info.getName());
        cvvCode.setValue(info.getCvv());
        buttonNext.click();
        title.shouldBe(Condition.visible, Duration.ofSeconds(15));
        negativeReply.shouldBe(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }


    public void sendEmptyFormCredit() {
        buttonNext.click();
    }

    public void shouldNavigateWithTabKey() {
        Configuration.holdBrowserOpen = true;
        year.click();
        cardNumber.setValue("2133 1231 2123 1233").sendKeys(Keys.TAB);
    }

    public void checkValidCard() {
        cardNumber.setValue("1233 3333 3333 333");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cardNumber);
        cardNumber.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cardNumber);
        cardNumber.setValue("#$#$#");
        cardNumber.shouldBe(Condition.empty);
        cardNumber.setValue("asdas");
        cardNumber.shouldBe(Condition.empty);


    }

    public void checkValidMonth() {
        fillIn();
        clearField(month);
        month.setValue("№!%");
        month.shouldBe(Condition.empty);
        month.setValue("asd");
        month.shouldBe(Condition.empty);
        month.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        month.setValue("13");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));

    }

    public void checkValidYear() {
        fillIn();
        clearField(year);
        year.setValue("№!%");
        year.shouldBe(Condition.empty);
        year.setValue("asd");
        year.shouldBe(Condition.empty);
        year.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        year.setValue("22");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Истёк срок действия карты"));

    }

    public void checkValidName() {
        cardNumber.setValue("");
    }

    public void checkValidCvv() {
        cardNumber.setValue("");
    }
}
