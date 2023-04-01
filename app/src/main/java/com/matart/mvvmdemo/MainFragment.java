package com.matart.mvvmdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.matart.mvvmdemo.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    MainFragmentViewModel viewModel;
    FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState
    ) {
        viewModel = new ViewModelProvider(this).get(MainFragmentViewModel.class); // инициализация вью-модели

        binding = FragmentMainBinding.inflate(inflater, container, false);

        binding.button.setOnClickListener(view -> viewModel.onButtonClicked()); // вызов метода вью-модели через лямбду

        // подписка на изменение значения лайв-даты во вью-модели
        viewModel.counter.observe(getViewLifecycleOwner(), counter -> binding.textView.setText(counter.toString()));

        return binding.getRoot();
    }
}
