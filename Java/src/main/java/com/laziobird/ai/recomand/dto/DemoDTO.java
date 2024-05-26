package com.laziobird.ai.recomand.dto;

import lombok.Data;

@Data
public class DemoDTO {
    private String name;
    public DemoDTO(String format) {
        name = format;
    }
}
