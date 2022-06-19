package dataHelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationInfo {
    String name;
    String cardNumber;
    String month;
    String year;
    String cvv;


}
