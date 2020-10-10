package com.polovnikbot.polovnik.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReplyToUser {

    private String name;

    private String openPrice;

    private String currentPrice;

    private String previousClosePrice;

    private String postmarketPrice;

    private String currency;

    @Override
    public String toString() {
        return "Имя акции: " + '\"' + name + '\"' +
                "\nЦена открытия: " + openPrice +
                "\nТекущая цена: " + currentPrice +
                "\nПредыдущая цена закрытия: " + previousClosePrice +
                "\nЦена на постмаркете: " + postmarketPrice +
                "\nВалюта акции: " + '\"' + currency + '\"';
    }
}
