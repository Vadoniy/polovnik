package com.polovnikbot.polovnik.rest.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MarketChange {

    private BigDecimal raw;

    private String fmt;

    private String longFmt;
}
