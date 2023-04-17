package com.epam.jmp.dto;

import java.time.LocalDate;

public class Subscription {

    private String number;
    private LocalDate startDate;

    public Subscription(String number, LocalDate startDate) {
        this.number = number;
        this.startDate = startDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "number='" + number + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
