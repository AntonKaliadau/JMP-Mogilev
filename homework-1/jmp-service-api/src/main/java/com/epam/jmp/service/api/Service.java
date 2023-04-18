package com.epam.jmp.service.api;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {

    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);

    List<User> getAllUsers();

    default double getAverageUsersAge() {
        var users = getAllUsers();
        return users.stream()
                .mapToLong(user -> Period.between(user.getBirthdate(), LocalDate.now()).getYears())
                .average()
                .orElse(0);
    }

    static boolean isPayableUser(User user) {
        return Period.between(user.getBirthdate(), LocalDate.now()).getYears() > 18;
    }
}
