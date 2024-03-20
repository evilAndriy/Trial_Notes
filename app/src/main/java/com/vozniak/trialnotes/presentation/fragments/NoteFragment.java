package com.vozniak.trialnotes.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vozniak.trialnotes.R;
import com.vozniak.trialnotes.data.NoteListRepositoryImpl;
import com.vozniak.trialnotes.data.database.MainDB;
import com.vozniak.trialnotes.data.database.NoteDao;
import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.databinding.FragmentNoteListBinding;
import com.vozniak.trialnotes.presentation.adapter.NoteListAdapter;
import com.vozniak.trialnotes.presentation.adapter.NoteListDiffCallback;
import com.vozniak.trialnotes.presentation.viewmodel.MainViewModel;
import com.vozniak.trialnotes.presentation.viewmodel.MainViewModelFactory;

public class NoteFragment extends Fragment  {
    private FragmentNoteListBinding binding;
    NoteListAdapter noteAdapter;
    NoteDao dao;
    MainViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteListBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createRepository();
        initRecyclerView();
        MainViewModelFactory factory = new MainViewModelFactory(dao);
        this.viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        viewModel.getNoteList().observe(getViewLifecycleOwner(), noteList -> {
            noteAdapter.submitList(noteList);
        });
        initClickAdd(CreateNoteFragment.createFragmentWithoutArguments());
    }



    private void createRepository() {
        MainDB database = MainDB.getDataBase(requireContext().getApplicationContext());
        this.dao = database.getDao();
//        return NoteListRepositoryImpl.getInstance(dao);
    }

    private void initRecyclerView(){
        this.noteAdapter = new NoteListAdapter(new NoteListDiffCallback(), new NoteListAdapter.InitClickDelete() {
            @Override
            public void initClick(Integer id) {
                viewModel.deleteNoteItem(id);
            }
        }, new NoteListAdapter.InitClickUpdate() {
            @Override
            public void initClick(NoteItem noteItem) {
//                requireActivity().getSupportFragmentManager().popBackStack();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_holder, CreateNoteFragment.createFragmentWithArguments(
                                noteItem
                        ))
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.recyclerView.setAdapter(noteAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
        ));
    }
    private void initClickAdd(Fragment fragment) {
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_holder, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public static NoteFragment newInstance() {
        NoteFragment fragment = new NoteFragment();
        return fragment;
    }


}