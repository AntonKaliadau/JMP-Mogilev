package com.epam.jmp.cloud.service.impl;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {

    private final Map<User, List<Subscription>> storage = new HashMap<>();

    @Override
    public void subscribe(BankCard bankCard) {

        var user = bankCard.getUser();
        var subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
        if (storage.containsKey(user)) {
            storage.get(user).add(subscription);
        } else {
            storage.put(bankCard.getUser(), List.of(subscription));
        }
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return storage.values().stream()
                .flatMap(Collection::stream)
                .filter(subscription -> subscription.getNumber().equals(bankCardNumber))
                .findFirst();
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        return storage.values().stream()
                .flatMap(Collection::stream)
                .filter(predicate)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(storage.keySet());
    }

    @Override
    public double getAverageUsersAge() {
        return Service.super.getAverageUsersAge();
    }
}
