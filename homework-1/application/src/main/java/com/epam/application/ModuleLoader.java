package com.epam.application;

import java.util.ServiceLoader;

public class ModuleLoader {

    private ModuleLoader() {

    }

    public static <T> T readClass(Class<T> aClass) {
        return ServiceLoader.load(aClass).iterator().next();
    }
}
