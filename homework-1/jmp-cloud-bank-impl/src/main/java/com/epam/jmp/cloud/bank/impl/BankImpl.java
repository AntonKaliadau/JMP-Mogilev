package com.epam.jmp.cloud.bank.impl;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.CreditBankCard;
import com.epam.jmp.dto.DebitBankCard;
import com.epam.jmp.dto.User;
import com.epam.jmp.dto.UserInfo;
import com.epam.jmp.bank.api.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Supplier;

public class BankImpl implements Bank {

    private static final Map<BankCardType, Supplier<BankCard>> map = new HashMap<>();

    static {
        map.put(BankCardType.CREDIT, CreditBankCard::new);
        map.put(BankCardType.DEBIT, DebitBankCard::new);
    }

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        var creator = map.get(cardType);
        if (creator != null) {
            var bankCard = creator.get();
            bankCard.setNumber(UUID.randomUUID().toString());
            bankCard.setUser(user);
            return bankCard;
        }
        throw new NoSuchElementException();
    }


    public BankCard createDebitBankCard(UserInfo userInfo) {
        var bankCard = new DebitBankCard();
        bankCard.setNumber(userInfo.getCardNumber());
        bankCard.setUser(userInfo.getUser());
        return bankCard;

    }
}
