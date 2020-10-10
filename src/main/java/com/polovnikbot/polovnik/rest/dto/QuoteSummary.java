package com.polovnikbot.polovnik.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuoteSummary {

    private List<Result> result;

    private Object error;

}
