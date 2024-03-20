package com.vozniak.trialnotes.presentation.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.vozniak.trialnotes.data.database.NoteDao;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private final NoteDao dao;

    public MainViewModelFactory(NoteDao dao) {
        this.dao = dao;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(dao);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}