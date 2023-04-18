module jmp.cloud.bank.impl {
    exports com.epam.jmp.cloud.bank.impl;
    requires jmp.bank.api;
    provides com.epam.jmp.bank.api.Bank with com.epam.jmp.cloud.bank.impl.BankImpl;
}