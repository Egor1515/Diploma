package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StartPage {
    private final SelenideElement heading = $("heading heading_size_l heading_theme_alfa-on-white");
    private final SelenideElement buyCreditButton = $x("//*[@id='root']/div/button[2]");
    private final SelenideElement buyCardButton = $("[class='button button_size_m button_theme_alfa-on-white']");

    public void buyWithCard(){
        buyCardButton.click();
    }
    public void buyOnCredit(){
        buyCreditButton.click();
    }
    public void heading(){
        heading.shouldBe(Condition.visible);
    }
}
