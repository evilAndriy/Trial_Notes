package com.vozniak.trialnotes.domain.usecases;

import androidx.lifecycle.LiveData;

import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.domain.NoteListRepository;

import java.util.List;

public class GetNoteListUseCase {
    private final NoteListRepository noteListRepository;
    public GetNoteListUseCase(NoteListRepository noteListRepository) {
        this.noteListRepository = noteListRepository;
    }
    LiveData<List<NoteItem>> getNoteList(){
      return noteListRepository.getNoteList();
    }
}
