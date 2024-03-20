package com.vozniak.trialnotes.domain.usecases;

import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.domain.NoteListRepository;

public class DeleteNoteItemUseCase {
    NoteListRepository noteListRepository;

    public DeleteNoteItemUseCase(NoteListRepository noteListRepository) {
        this.noteListRepository = noteListRepository;
    }
    public void deleteNoteItem(Integer id) {
        noteListRepository.deleteNoteItem(id);
    }
}
