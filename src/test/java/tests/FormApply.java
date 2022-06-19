package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.BuyFormPage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormApply {

    StartPage page = new StartPage();
    BuyFormPage credit = new BuyFormPage();


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
    void sendEmptyForm() {
        Configuration.holdBrowserOpen = true;
        page.buyOnCredit();
        credit.sendEmptyFormCredit();
        int expected = 5;
        int actual = credit.getError();
        assertEquals(expected, actual);
    }


    @Test
    void checkValidCard() {
        Configuration.holdBrowserOpen = true;
        page.buyOnCredit();
        credit.checkValidCard();
    }

    @Test
    void checkValidMonth() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        credit.checkValidMonth();
    }

    @Test
    void checkValidYear() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        credit.checkValidYear();
    }

    @Test
    void shouldCheckValidCvv() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        credit.checkValidCvv();
    }

    @Test
    void shouldCheckValidName() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        credit.checkValidName();

    }


}

