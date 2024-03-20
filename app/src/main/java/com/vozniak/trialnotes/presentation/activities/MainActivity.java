package com.vozniak.trialnotes.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Dao;

import android.os.Bundle;

import com.vozniak.trialnotes.data.NoteListRepositoryImpl;
import com.vozniak.trialnotes.data.database.MainDB;
import com.vozniak.trialnotes.data.database.NoteDao;
import com.vozniak.trialnotes.databinding.ActivityMainBinding;
import com.vozniak.trialnotes.presentation.viewmodel.MainViewModel;
import com.vozniak.trialnotes.presentation.viewmodel.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

}