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
    BuyFormPage form = new BuyFormPage();


    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void applyCard() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        form.applyFormWithCard();
    }

    @Test
    void applyCredit() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        form.applyFormWithCard();
    }

    @Test
    void sendEmptyForm() {
        Configuration.holdBrowserOpen = true;
        page.buyOnCredit();
        form.sendEmptyFormCredit();
        form.getError();


    }


    @Test
    void checkValidCard() {
        Configuration.holdBrowserOpen = true;
        page.buyOnCredit();
        form.checkValidCard();
    }

    @Test
    void checkValidMonth() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        form.checkValidMonth();
    }

    @Test
    void checkValidYear() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        form.checkValidYear();
    }

    @Test
    void shouldCheckValidCvv() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        form.checkValidCvv();
    }

    @Test
    void shouldCheckValidName() {
        Configuration.holdBrowserOpen = true;
        page.buyWithCard();
        form.checkValidName();

    }


}

