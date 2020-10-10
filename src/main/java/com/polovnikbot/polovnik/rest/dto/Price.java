package com.polovnikbot.polovnik.rest.dto;

import lombok.Data;

@Data
public class Price {

    private Integer maxAge;

    private MarketChange preMarketChange;

    private MarketChange preMarketPrice;

    private String preMarketSource;

    private MarketChange postMarketChangePercent;

    private MarketChange postMarketChange;

    private Long postMarketTime;

    private MarketChange postMarketPrice;

    private String postMarketSource;

    private MarketChange regularMarketChangePercent;

    private MarketChange regularMarketChange;

    private Long regularMarketTime;

    private MarketChange priceHint;

    private MarketChange regularMarketPrice;

    private MarketChange regularMarketDayHigh;

    private MarketChange regularMarketDayLow;

    private MarketChange regularMarketVolume;

    private MarketChange averageDailyVolume10Day;

    private MarketChange averageDailyVolume3Month;

    private MarketChange regularMarketPreviousClose;

    private String regularMarketSource;

    private MarketChange regularMarketOpen;

    private MarketChange strikePrice;

    private MarketChange openInterest;

    private String exchange;

    private String exchangeName;

    private Integer exchangeDataDelayedBy;

    private String marketState;

    private String quoteType;

    private String symbol;

    private String underlyingSymbol;

    private String shortName;

    private String longName;

    private String currency;

    private String quoteSourceName;

    private String currencySymbol;

    private String fromCurrency;

    private String toCurrency;

    private String lastMarket;

    private MarketChange volume24Hr;

    private MarketChange volumeAllCurrencies;

    private MarketChange circulatingSupply;

    private MarketChange marketCap;

}
