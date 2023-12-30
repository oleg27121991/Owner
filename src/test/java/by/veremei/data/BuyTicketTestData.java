package by.veremei.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class BuyTicketTestData {
    private final Faker faker = new Faker(new Locale("en"));
    public String ticketCount = String.valueOf(faker.number().numberBetween(1,8));
}
