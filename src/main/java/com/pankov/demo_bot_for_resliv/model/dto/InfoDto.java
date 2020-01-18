package com.pankov.demo_bot_for_resliv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoDto {

    private Long id;
    private String cityName;
    private String description;
}
