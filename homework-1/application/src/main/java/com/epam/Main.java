package com.epam;

import com.epam.jmp.cloud.bank.impl.BankImpl;
import com.epam.jmp.cloud.service.impl.NoSuchBankCardException;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.User;
import com.epam.jmp.dto.UserInfo;
import com.epam.jmp.service.api.Service;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

public class Main {

    private static final Service service = ModuleLoader.readClass(Service.class);
    public static void main(String[] args) {

        var user1 = new User("Frank", "Sinatra", LocalDate.of(1915, 12, 12));
        var user2 = new User("Nancy", "Sinatra", LocalDate.of(1940, 6, 8));

        var bank = new BankImpl();

        var card1 = bank.createBankCard(user1, BankCardType.DEBIT);
        var card2 = bank.createBankCard(user2, BankCardType.DEBIT);

        var userInfo = new UserInfo(UUID.randomUUID().toString(), user1);
        var cardViaMethodReference = Stream.of(userInfo)
                .map(bank::createDebitBankCard)
                .findFirst()
                .get();

        service.subscribe(card1);
        service.subscribe(card2);

        var subscription = service.getSubscriptionByBankCardNumber(card1.getNumber()).orElseThrow(NoSuchBankCardException::new);

        var allUsers = service.getAllUsers();

        System.out.println(String.format("Subscription with number %s successfully created.", subscription.getNumber()));

        System.out.println("All users:");
        allUsers.forEach(System.out::println);
        System.out.println(String.format("Average age is: %s", service.getAverageUsersAge()));

        var registrationDatesAfter2000 = service.getAllSubscriptionsByCondition(sub -> sub.getStartDate().isAfter(LocalDate.of(2000, 1, 1)));
        System.out.println(String.format("Number of registered cards after 2000 is %d", registrationDatesAfter2000.size()));
    }
}
