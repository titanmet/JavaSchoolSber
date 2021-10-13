package com.ratnikov.lesson.fabric;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Handlers {
    FIRST_SERVICE("firstService",
            "firstServiceHandler",
            "Обработчик первого сервиса",
            0),
    SECOND_SERVICE("secondService",
            "secondServiceHandler",
            "Обработчик второго сервиса",
            2),
    THIRD_SERVICE("thirdService",
            "thirdServiceHandler",
            "Обработчик третьего сервиса",
            3);

    private static final Map<String, String> HANDLERS = Arrays.stream(Handlers.values())
            .map(handler -> new AbstractMap.SimpleEntry<>(handler.getServiceCode(), handler.getHandler()))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

    private final String serviceCode;
    private final String handler;
    private final String descriptions;
    private final int priority;

    Handlers(String serviceCode, String handler, String descriptions, int priority) {
        this.serviceCode = serviceCode;
        this.handler = handler;
        this.descriptions = descriptions;
        this.priority = priority;
    }

    public static String findHandlerByCode(final String code) {
        return HANDLERS.get(code);
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getHandler() {
        return handler;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public int getPriority() {
        return priority;
    }
}
