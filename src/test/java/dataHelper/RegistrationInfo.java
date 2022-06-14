package dataHelper;

import lombok.Value;

@Value

public class RegistrationInfo {
    String name;
    String cardNumber;
    String month;
    String year;
    String cvv;


    public RegistrationInfo(String name, String cardNumber, String month, String year, String cvv) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getCvv() {
        return cvv;
    }
}

