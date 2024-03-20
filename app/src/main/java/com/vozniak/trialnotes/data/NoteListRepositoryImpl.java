package com.vozniak.trialnotes.data;

import androidx.lifecycle.LiveData;

import com.vozniak.trialnotes.data.database.MainDB;
import com.vozniak.trialnotes.data.database.NoteDao;
import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.domain.NoteListRepository;

import java.util.List;

public class NoteListRepositoryImpl implements NoteListRepository {
    private static NoteListRepositoryImpl instance;
    protected NoteDao dao;

    private NoteListRepositoryImpl(NoteDao dao) {
        this.dao = dao;
    }

    /// Singleton
    public static NoteListRepositoryImpl getInstance(NoteDao dao) {
        if (instance == null) {
            instance = new NoteListRepositoryImpl(dao);
        }
        return instance;
    }

    @Override
    public void addNoteItem(NoteItem noteItem) {
        dao.insertItem(noteItem);
    }

    @Override
    public LiveData<List<NoteItem>> getNoteList() {
        return dao.getAllList();
    }

    @Override
    public void updateNoteItem(NoteItem noteItem) {
        dao.updateNote(noteItem);
    }

    @Override
    public void deleteNoteItem(int id) {
        dao.deleteNote(id);
    }


}
