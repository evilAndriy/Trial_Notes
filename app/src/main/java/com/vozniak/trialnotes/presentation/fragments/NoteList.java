package com.vozniak.trialnotes.presentation.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vozniak.trialnotes.R;
import com.vozniak.trialnotes.databinding.ActivityMainBinding;
import com.vozniak.trialnotes.databinding.FragmentNoteListBinding;

public class NoteList extends Fragment {
    private FragmentNoteListBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteListBinding.inflate(inflater);
        return binding.getRoot();
    }


    public static NoteList newInstance() {
        NoteList fragment = new NoteList();
        return fragment;
    }

}