import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.awt.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class FormFill {


    private final SelenideElement buyInCredit = $x("//*[@id='root']/div/button[2]");
    private final SelenideElement buyWithCard = $("[class='button button_size_m button_theme_alfa-on-white']");
    private final SelenideElement cardNumber = $(".input__control[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $(".input__control[placeholder='08']");
    private final SelenideElement year = $(".input__control[placeholder='22']");
    private final SelenideElement cardOwner = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private final SelenideElement cvvCode = $x("//*[@id='root']/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    private final SelenideElement buttonNext = $(withText("Продолжить"));
    private final ElementsCollection error = $$(".input__sub");

    public String getError() {
        return error.first().getText();
    }
    public Point getMouseLocation(){
        var location = MouseInfo.getPointerInfo().getLocation();
        return location;
    }
}

