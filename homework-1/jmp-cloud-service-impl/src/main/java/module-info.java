module jmp.cloud.service.impl {
    exports com.epam.jmp.cloud.service.impl;
    requires transitive jmp.service.api;
    provides com.epam.jmp.service.api.Service with com.epam.jmp.cloud.service.impl.ServiceImpl;
}