package com.vozniak.trialnotes.presentation.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.vozniak.trialnotes.data.NoteListRepositoryImpl;
import com.vozniak.trialnotes.data.database.NoteDao;
import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.domain.usecases.AddNoteItemUseCase;
import com.vozniak.trialnotes.domain.usecases.DeleteNoteItemUseCase;
import com.vozniak.trialnotes.domain.usecases.GetNoteListUseCase;
import com.vozniak.trialnotes.domain.usecases.UpdateNoteItemUseCase;

import java.util.List;


public class MainViewModel extends ViewModel {
    private NoteListRepositoryImpl noteListRepositoryImpl;
    private AddNoteItemUseCase addNoteItemUseCase;
    private GetNoteListUseCase getNoteListUseCase;
    private UpdateNoteItemUseCase updateNoteItemUseCase;
    private DeleteNoteItemUseCase deleteNoteItemUseCase;

    public MainViewModel(NoteDao dao) {
        this.noteListRepositoryImpl = NoteListRepositoryImpl.getInstance(dao);
        this.addNoteItemUseCase = new AddNoteItemUseCase(noteListRepositoryImpl);
        this.getNoteListUseCase = new GetNoteListUseCase(noteListRepositoryImpl);
        this.updateNoteItemUseCase = new UpdateNoteItemUseCase(noteListRepositoryImpl);
        this.deleteNoteItemUseCase = new DeleteNoteItemUseCase(noteListRepositoryImpl);

    }

    // Метод для додавання нового запису
    public void addNoteItem(NoteItem noteItem) {addNoteItemUseCase.addNoteItem(noteItem);}

//     Метод для отримання списку записів
    public LiveData<List<NoteItem>> getNoteList() {return getNoteListUseCase.getNoteList();}

    // Метод для оновлення запису
    public void updateNoteItem(NoteItem noteItem) {
        updateNoteItemUseCase.updateNoteItem(noteItem);
    }

    // Метод для видалення запису
    public void deleteNoteItem(int id) {
        deleteNoteItemUseCase.deleteNoteItem(id);
    }
}


