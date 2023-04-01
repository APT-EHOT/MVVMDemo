package com.matart.mvvmdemo;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CurrencyAPI {

    String BASE_URL = "https://www.cbr-xml-daily.ru";
    @GET("/daily_json.js")
    Observable<PriceData> getPrice();
}
