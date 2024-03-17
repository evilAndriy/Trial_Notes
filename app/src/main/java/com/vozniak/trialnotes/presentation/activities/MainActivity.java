package com.vozniak.trialnotes.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vozniak.trialnotes.data.NoteListRepositoryImpl;
import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }



}