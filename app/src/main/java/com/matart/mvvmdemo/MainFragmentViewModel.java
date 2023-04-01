package com.matart.mvvmdemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainFragmentViewModel extends ViewModel {
    final MutableLiveData<Double> counter = new MutableLiveData<>(0.0);

    private Disposable priceDisposable;

    void onButtonClicked() {
        priceDisposable = CurrencyRepository.getPriceData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            // Установка нового значения в лайвдату
            .subscribe(priceData -> counter.setValue(priceData.Valute.USD.Value));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        priceDisposable.dispose();
    }
}
