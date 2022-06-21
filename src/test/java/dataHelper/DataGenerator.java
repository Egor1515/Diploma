package dataHelper;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            var user = new RegistrationInfo(faker.name().fullName(), faker.numerify("4444 4444 4444 4441"), faker.numerify("11"), faker.numerify("23"),
                    faker.numerify("###"));
            return user;
        }

    }
}