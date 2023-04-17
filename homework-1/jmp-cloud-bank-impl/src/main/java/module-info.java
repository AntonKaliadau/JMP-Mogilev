module jmp.cloud.bank.impl {
    requires transitive jmp.bank.api;
    provides com.epam.jmp.bank.api.Bank with com.epam.jmp.cloud.bank.impl.BankImpl;
    exports com.epam.jmp.cloud.bank.impl;
}