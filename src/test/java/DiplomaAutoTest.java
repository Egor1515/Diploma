import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DiplomaAutoTest{

    @Test
     void shouldOpen(){
    open("localhost:8080");
}
}
