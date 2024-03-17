package com.vozniak.trialnotes.domain.usecases;

import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.domain.NoteListRepository;

public class AddNoteItemUseCase {
    private final NoteListRepository noteListRepository;
    public AddNoteItemUseCase(NoteListRepository noteListRepository) {
        this.noteListRepository = noteListRepository;
    }
    void addNoteItem(NoteItem noteItem) {
        noteListRepository.addNoteItem(noteItem);
    }

}
