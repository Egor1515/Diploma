package page;

import com.codeborne.selenide.ElementsCollection;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormFill {


    public static int getError() {
        ElementsCollection error = $$(".input__sub");
        return error.size();

    }

    public static Point getMouseLocation() {
        var location = MouseInfo.getPointerInfo().getLocation();
        return location;
    }
}

