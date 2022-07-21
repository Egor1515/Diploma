package tests;

import dataBase.DataBaseConnections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.BuyFormPage;
import page.StartPage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.open;

public class FormApply {

    StartPage page = new StartPage();
    BuyFormPage form = new BuyFormPage();
//
//    @BeforeEach
//    void setUp() {
//        open("http://localhost:8080");
//    }

    @Test
    void startMysql() throws ClassNotFoundException, SQLException {
       DataBaseConnections.connectDataBase("jdbc:mysql://localhost:3306/app","app","9mREsvXDs9Gk89E","com.mysql.jdbc.Driver");
    }

    @Test
    void applyCard() {
        page.buyWithCard();
        form.applyFormWithCard();
    }

    @Test
    void applyCredit() {
        page.buyWithCard();
        form.applyFormWithCard();
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


}

