module application {
    requires jmp.dto;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    uses com.epam.jmp.service.api.Service;
    uses com.epam.jmp.bank.api.Bank;
}