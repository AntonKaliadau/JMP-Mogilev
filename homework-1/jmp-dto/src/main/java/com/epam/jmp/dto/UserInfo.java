package com.epam.jmp.dto;

public class UserInfo {
    private String cardNumber;
    private User user;

    public UserInfo(String cardNumber, User user) {
        this.cardNumber = cardNumber;
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
