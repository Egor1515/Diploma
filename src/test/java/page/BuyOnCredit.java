package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import dataHelper.DataGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyOnCredit {

    private final SelenideElement heading = $x("//*[@id='root']/div/h3");
    private final SelenideElement title = $(".notification__title");
    private final SelenideElement serverReply = $(".notification__content");
    private final SelenideElement cardNumber = $(".input__control[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $x("//*[@id='root']/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
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
        serverReply.shouldBe(Condition.text("Ошибка! Банк отказал в проведении операции."));
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
        cardNumber.setValue("1233 3333 3333 3331 1");
        cardNumber.shouldHave(Condition.value("1233 3333 3333 3331"));
        clearField(cardNumber);
        cardNumber.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cardNumber);
        cardNumber.setValue("123 123");
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cardNumber);
        cardNumber.setValue("#$#$#");
        cardNumber.shouldBe(Condition.empty);
        cardNumber.setValue("asdas");
        cardNumber.shouldBe(Condition.empty);


    }

    public void checkValidMonth() {
        fillIn();
        clearField(year);
        year.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(year);
        year.setValue("12");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
        clearField(year);
        year.setValue("12313");
        year.shouldHave(Condition.value("12"));
        clearField(year);
        year.setValue("13");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверно указан срок действия карты"));
        clearField(year);
        year.setValue("№!%");
        year.shouldBe(Condition.empty);
        year.setValue("asd");
        year.shouldBe(Condition.empty);
    }

    public void checkValidYear() {
        fillIn();
        clearField(month);
        month.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(month);
        month.setValue("12313");
        month.shouldHave(Condition.value("12"));
        clearField(month);
        month.setValue("13");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверно указан срок действия карты"));
        clearField(month);
        month.setValue("№!%");
        month.shouldBe(Condition.empty);
        month.setValue("asd");
        month.shouldBe(Condition.empty);
        month.setValue("12");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void checkValidName() {
        fillIn();
        clearField(cardOwner);
        cardOwner.setValue("Eliza Fink Frank Helliot");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwner);
        cardOwner.setValue("213");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwner);
        cardOwner.setValue("a");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwner);
        cardOwner.setValue("En-oze");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwner);
        cardOwner.setValue("Elizabeth");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwner);
        cardOwner.setValue("!@#!@#");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));


    }

    public void checkValidCvv() {
        fillIn();
        clearField(cvvCode);
        cvvCode.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cvvCode);
        cvvCode.setValue("19");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cvvCode);
        cvvCode.setValue("12313");
        cvvCode.shouldHave(Condition.value("123"));
        clearField(cvvCode);
        cvvCode.setValue("№!%");
        cvvCode.shouldBe(Condition.empty);
        cvvCode.setValue("asd");
        cvvCode.shouldBe(Condition.empty);
        cvvCode.setValue("999");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
        clearField(cvvCode);
        cvvCode.setValue("998");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
        clearField(cvvCode);
        cvvCode.setValue("001");
        buttonNext.click();
        clientResponse.shouldBe(Condition.visible);

    }
}
