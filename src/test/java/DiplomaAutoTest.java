import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DiplomaAutoTest {

    @Test
    void shouldOpen() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }
}
