package com.transactional.util;


import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum TypeAmountEnum implements Valuable<String> {

    A("AHORRO"),
    C("CORRIENTE");


    private final String type;

    private static final Map<String, TypeAmountEnum> hash = Arrays.stream(TypeAmountEnum.values())
            .collect(Collectors.toMap(TypeAmountEnum::getValue, e -> e));


    TypeAmountEnum(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }

    public static TypeAmountEnum getByValue(String value) {
        return Optional
                .ofNullable(hash.get(value))
                .orElseThrow(() -> new IllegalArgumentException(String.format(
                        "Value %s is not a valid value for %s ", value, TypeAmountEnum.class.getSimpleName()
                )));
    }
}