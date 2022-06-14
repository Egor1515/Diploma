package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import page.BuyOnCredit;
import page.FormFill;
import page.StartPage;

import java.awt.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiplomaAutoTest {

    StartPage page = new StartPage();
    BuyOnCredit credit = new BuyOnCredit();


    @BeforeEach
    void setUp() {
        open("http://localhost:9090");
    }

    @Test
    void applyCard() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        credit.applyFormWithCard();
    }

    @Test
    void applyCredit() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        credit.applyFormWithCard();
    }


    @Test
    void checkValidCard() {
        Configuration.holdBrowserOpen = true;
        page.buyOnCredit();
        credit.checkValidCard();
    }

    @Test

    void shouldMonth(){
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        credit.checkValidMonth();
    }

//    @Test
//    void applyCredit() {
//        Configuration.holdBrowserOpen = true;
//        var credit = new BuyOnCredit();
//        page.buyOnCredit();
//        credit.applyFormOnCredit();
//    }
//
    @Test
    void sendEmpty() {
        Configuration.holdBrowserOpen = true;
        page.buyOnCredit();
        credit.sendEmptyFormCredit();
        int expected = 5;
        int actual = FormFill.getError();
        assertEquals(expected, actual);
    }
}

