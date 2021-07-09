package com.example.demo.Model;

import com.opencsv.bean.CsvBindByName;

public class Stock {

    @CsvBindByName
    private String symbol;
    @CsvBindByName
    private String series;
    @CsvBindByName
    private float openprice;
    @CsvBindByName
    private float avgprice;
    @CsvBindByName
    private long trades;

    public Stock() {
    }

    public Stock(String symbol, String series, float openprice,float avgprice,long trades) {
        this.symbol = symbol;
        this.series = series;
        this.openprice = openprice;
        this.avgprice = avgprice;
        this.trades = trades;
    }

    public String getSymbol(){
        return symbol;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getSeries(){
        return series;
    }
    public void setSeries(String series){
        this.series = series;
    }

    public float getOpenPrice(){
        return openprice;
    }
    public void setOpenPrice(float openprice){
        this.openprice = openprice;
    }

    public float getAvgPrice(){
        return avgprice;
    }
    public void setAvgPrice(float avgprice){
        this.avgprice = avgprice;
    }

    public long getTrades() {
        return trades;
    }
    public void setTrades(long trades) {
        this.trades = trades;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "Symbol = " + symbol +
                " Series = " + series +
                " Open Price = " + openprice + 
                " Average Price = " + avgprice + 
                " Trades = " + trades + 
                "}";
    }

}