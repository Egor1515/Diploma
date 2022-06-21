package page;

import com.codeborne.selenide.Condition;
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
public class BuyFormPage {

    private final SelenideElement heading = $x("//*[@id='root']/div/h3");
    private final SelenideElement title = $(".notification__title");
    private final SelenideElement serverReply = $(".notification__content");
    private final SelenideElement cardNumberField = $(".input__control[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $x("//*[@id='root']/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
    private final SelenideElement yearField = $(".input__control[placeholder='22']");
    private final SelenideElement cardOwnerField = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private final SelenideElement cvvCodeField = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    private final SelenideElement buttonNext = $(withText("Продолжить"));

    private SelenideElement clientResponse = $(".input__sub");

    public void fillIn() {
        var info = DataGenerator.Registration.generateInfo("ru");
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardOwnerField.setValue(info.getName());
        cvvCodeField.setValue(info.getCvv());

    }

    public void getError() {
        ElementsCollection clientError = $$(".input__sub");

        for (SelenideElement el : clientError) {
            el.should(Condition.visible, Condition.text("Неверный формат"));
        }


    }

    public void clearField(SelenideElement field) {
        field.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
    }

    public void applyFormWithCard() {
        var info = DataGenerator.Registration.generateInfo("ru");
        heading.shouldBe(Condition.text("Оплата по карте"));
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardOwnerField.setValue(info.getName());
        cvvCodeField.setValue(info.getCvv());
        buttonNext.click();
        title.shouldBe(Condition.visible, Duration.ofSeconds(15));
        serverReply.shouldBe(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }


    public void sendEmptyFormCredit() {
        buttonNext.click();
    }

    public void checkValidCard() {
        cardNumberField.setValue("1233 3333 3333 333");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cardNumberField);
        cardNumberField.setValue("1233 3333 3333 3331 1");
        cardNumberField.shouldHave(Condition.value("1233 3333 3333 3331"));
        clearField(cardNumberField);
        cardNumberField.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cardNumberField);
        cardNumberField.setValue("123 123");
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cardNumberField);
        cardNumberField.setValue("#$#$#");
        cardNumberField.shouldBe(Condition.empty);
        cardNumberField.setValue("asdas");
        cardNumberField.shouldBe(Condition.empty);


    }

    public void checkValidMonth() {
        fillIn();
        clearField(yearField);
        yearField.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(yearField);
        yearField.setValue("12");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
        clearField(yearField);
        yearField.setValue("12313");
        yearField.shouldHave(Condition.value("12"));
        clearField(yearField);
        yearField.setValue("13");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверно указан срок действия карты"));
        clearField(yearField);
        yearField.setValue("№!%");
        yearField.shouldBe(Condition.empty);
        yearField.setValue("asd");
        yearField.shouldBe(Condition.empty);
    }

    public void checkValidYear() {
        fillIn();
        clearField(monthField);
        monthField.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(monthField);
        monthField.setValue("12313");
        monthField.shouldHave(Condition.value("12"));
        clearField(monthField);
        monthField.setValue("13");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверно указан срок действия карты"));
        clearField(monthField);
        monthField.setValue("№!%");
        monthField.shouldBe(Condition.empty);
        monthField.setValue("asd");
        monthField.shouldBe(Condition.empty);
        monthField.setValue("12");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void checkValidName() {
        fillIn();
        clearField(cardOwnerField);
        cardOwnerField.setValue("Eliza Fink Frank Helliot");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwnerField);
        cardOwnerField.setValue("213");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwnerField);
        cardOwnerField.setValue("a");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwnerField);
        cardOwnerField.setValue("En-oze");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwnerField);
        cardOwnerField.setValue("Elizabeth");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));
        clearField(cardOwnerField);
        cardOwnerField.setValue("!@#!@#");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(15));


    }

    public void checkValidCvv() {
        fillIn();
        clearField(cvvCodeField);
        cvvCodeField.setValue("1");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cvvCodeField);
        cvvCodeField.setValue("19");
        buttonNext.click();
        clientResponse.shouldBe(Condition.text("Неверный формат"));
        clearField(cvvCodeField);
        cvvCodeField.setValue("12313");
        cvvCodeField.shouldHave(Condition.value("123"));
        clearField(cvvCodeField);
        cvvCodeField.setValue("№!%");
        cvvCodeField.shouldBe(Condition.empty);
        cvvCodeField.setValue("asd");
        cvvCodeField.shouldBe(Condition.empty);
        cvvCodeField.setValue("999");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
        clearField(cvvCodeField);
        cvvCodeField.setValue("998");
        buttonNext.click();
        serverReply.shouldBe(Condition.visible, Duration.ofSeconds(10));
        clearField(cvvCodeField);
        cvvCodeField.find("001");
        buttonNext.click();
        clientResponse.shouldBe(Condition.visible);

    }
}
