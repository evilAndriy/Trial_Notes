package com.vozniak.trialnotes.domain;

import androidx.lifecycle.LiveData;

import com.vozniak.trialnotes.data.entities.NoteItem;

import java.util.List;

public interface NoteListRepository {

    void addNoteItem(NoteItem noteItem);
    LiveData<List<NoteItem>> getNoteList();

    public void updateNoteItem(NoteItem noteItem);

    // Метод для видалення запису
    public void deleteNoteItem(int id);

}
