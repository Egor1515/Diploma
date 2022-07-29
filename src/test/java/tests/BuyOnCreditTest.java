package tests;

import org.junit.jupiter.api.BeforeEach;
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

}
