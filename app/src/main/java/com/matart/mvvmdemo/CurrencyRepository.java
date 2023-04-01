package com.matart.mvvmdemo;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyRepository {

    // Получаем реализацию интерфейса api
    private static CurrencyAPI getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(CurrencyAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

        return retrofit.create(CurrencyAPI.class);
    }

    // Загружаем данные о цене
    public static Observable<PriceData> getPriceData() {
        return getRetrofit().getPrice();
    }
}
