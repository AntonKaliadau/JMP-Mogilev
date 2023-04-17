package com.epam.jmp.bank.api;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.User;
import com.epam.jmp.dto.UserInfo;

public interface Bank {

    BankCard createBankCard(User user, BankCardType bankCardType);
    BankCard createDebitBankCard(UserInfo userInfo);
}
