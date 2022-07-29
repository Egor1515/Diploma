package tests;

import dataBase.DataBaseConnections;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.BuyFormPage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class BuyOnCreditTest {
    StartPage page = new StartPage();
    BuyFormPage form = new BuyFormPage();

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @AfterAll
    static void clearTables() {
        DataBaseConnections.shouldClearTables();
    }

    @Test
    void applyCredit() {
        page.buyOnCredit();
        form.applyFormOnCredit();
    }

    @Test
    void sendEmptyForm() {

        page.buyOnCredit();
        form.sendEmptyFormCredit();
        form.getError();
    }

    @Test
    void checkValidCard() {
        page.buyOnCredit();
        form.checkValidCard();
    }

    @Test
    void checkValidMonth() {
        page.buyWithCard();
        form.checkValidMonth();
    }

    @Test
    void checkValidYear() {
        page.buyWithCard();
        form.checkValidYear();
    }

    @Test
    void shouldCheckValidCvv() {
        page.buyWithCard();
        form.checkValidCvv();
    }

    @Test
    void shouldCheckValidName() {
        page.buyWithCard();
        form.checkValidName();

    }

    @Test
    void shouldGetStatus() {
        page.buyOnCredit();
        form.applyFormOnCredit();
        DataBaseConnections.getStatus();
    }

    @Test
    void shouldGetAmount(){
        page.buyOnCredit();
        form.applyFormOnCredit();
        DataBaseConnections.getAmount();
    }
}
