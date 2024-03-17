package com.vozniak.trialnotes.presentation.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.vozniak.trialnotes.data.NoteListRepositoryImpl;
import com.vozniak.trialnotes.data.database.Dao;
import com.vozniak.trialnotes.domain.usecases.AddNoteItemUseCase;
import com.vozniak.trialnotes.domain.usecases.GetNoteListUseCase;

import java.io.Closeable;

public class MainViewModel extends ViewModel {
  NoteListRepositoryImpl noteListRepositoryImpl;
    public MainViewModel(Dao dao) {
        this.noteListRepositoryImpl = NoteListRepositoryImpl.getInstance(dao);
    }
    AddNoteItemUseCase addNoteItemUseCase = new AddNoteItemUseCase(noteListRepositoryImpl);
    GetNoteListUseCase getNoteListUseCase = new GetNoteListUseCase(noteListRepositoryImpl);

}
