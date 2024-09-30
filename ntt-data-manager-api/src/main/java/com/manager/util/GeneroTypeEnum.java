package com.manager.util;


import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum GeneroTypeEnum implements Valuable<String> {

    MASCULINO("M"),
    FEMENINO("F");


    private final String type;

    private static final Map<String, GeneroTypeEnum> hash = Arrays.stream(GeneroTypeEnum.values())
            .collect(Collectors.toMap(GeneroTypeEnum::getValue, e -> e));


    GeneroTypeEnum(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }

    public static GeneroTypeEnum getByValue(String value) {
        return Optional
                .ofNullable(hash.get(value))
                .orElseThrow(() -> new IllegalArgumentException(String.format(
                        "Value %s is not a valid value for %s ", value, GeneroTypeEnum.class.getSimpleName()
                )));
    }
}