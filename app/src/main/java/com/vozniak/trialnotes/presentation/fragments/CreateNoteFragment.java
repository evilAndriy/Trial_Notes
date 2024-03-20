package com.vozniak.trialnotes.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vozniak.trialnotes.R;
import com.vozniak.trialnotes.data.NoteListRepositoryImpl;
import com.vozniak.trialnotes.data.database.MainDB;
import com.vozniak.trialnotes.data.database.NoteDao;
import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.databinding.FragmentCreateNoteBinding;
import com.vozniak.trialnotes.databinding.FragmentNoteListBinding;
import com.vozniak.trialnotes.presentation.viewmodel.MainViewModel;
import com.vozniak.trialnotes.presentation.viewmodel.MainViewModelFactory;

public class CreateNoteFragment extends Fragment {
    NoteItem noteItem;
    private FragmentCreateNoteBinding binding;
    NoteDao dao;
    MainViewModel viewModel;
    private String arg1_createFrag;
    private String arg2_updateFrag;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.noteItem = (NoteItem) getArguments().getSerializable("noteItem");
            this.arg1_createFrag = (String) getArguments().getString(CREATE_FRAG_KEY);
            this.arg2_updateFrag = (String) getArguments().getString(UPDATE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createRepository();
        MainViewModelFactory factory = new MainViewModelFactory(dao);
        this.viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
        bindParams();
        initClickApply();
    }

    private void initClickApply() {
        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (arg1_createFrag != null){
                   if (noteItem != null) {
                       binding.MyNameText.setText(noteItem.getTitle());
                       binding.MyNote.setText(noteItem.getContent());
                   }
                   String name = binding.MyNameText.getText().toString();
                   String note = binding.MyNote.getText().toString();
                   Thread thread = new Thread(new Runnable() {
                       @Override
                       public void run() {
                           viewModel.addNoteItem(new NoteItem(name, note));
                       }
                   });
                   thread.start();

                   requireActivity().getSupportFragmentManager().popBackStack();
               } else {
                   noteItem.setTitle(binding.textName.getEditText().getText().toString());
                   noteItem.setContent(binding.MyNote.getText().toString());
                   Thread thread = new Thread(new Runnable() {
                       @Override
                       public void run() {
                           viewModel.updateNoteItem(noteItem);
                       }
                   });
                   thread.start();

                   requireActivity().getSupportFragmentManager().popBackStack();
                   Toast.makeText(getContext(), "updating", Toast.LENGTH_SHORT).show();

               }
            }
        });

    }

    private NoteListRepositoryImpl createRepository() {
        MainDB database = MainDB.getDataBase(requireContext().getApplicationContext());
        this.dao = database.getDao();
        return NoteListRepositoryImpl.getInstance(dao);
    }

    private void bindParams(){
        if (noteItem != null) {
            binding.MyNameText.setText(noteItem.getTitle());
            binding.MyNote.setText(noteItem.getContent());
        }
    }

    public static CreateNoteFragment createFragmentWithoutArguments() {
        CreateNoteFragment fragment = new CreateNoteFragment();
        Bundle args = new Bundle();
        args.putString(CREATE_FRAG_KEY,CREATE_FRAGMENT_WITHOUT_ARGUMENTS);
        fragment.setArguments(args);
        return fragment;
    }
    public static CreateNoteFragment createFragmentWithArguments(NoteItem noteItem) {
        CreateNoteFragment fragment = new CreateNoteFragment();
        Bundle args = new Bundle();
        args.putSerializable(NOTE_ITEM_KEY, noteItem);
        args.putString(UPDATE_KEY,CREATE_FRAGMENT_WITH_ARGUMENTS);
        fragment.setArguments(args);
        return fragment;
    }
    private static final String CREATE_FRAG_KEY = "create_frag_key";
    private static final String CREATE_FRAGMENT_WITHOUT_ARGUMENTS = "createFragmentWithoutArguments";
    private static final String NOTE_ITEM_KEY = "noteItem";
    private static final String UPDATE_KEY = "update_key";
    private static final String CREATE_FRAGMENT_WITH_ARGUMENTS = "createFragmentWithArguments";
}