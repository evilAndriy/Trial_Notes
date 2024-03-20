package com.vozniak.trialnotes.domain.usecases;

import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.domain.NoteListRepository;

public class UpdateNoteItemUseCase {
    private final NoteListRepository noteListRepository;

    public UpdateNoteItemUseCase(NoteListRepository noteListRepository) {
        this.noteListRepository = noteListRepository;
    }

    public void updateNoteItem(NoteItem noteItem) {
         noteListRepository.updateNoteItem(noteItem);
    }
}
