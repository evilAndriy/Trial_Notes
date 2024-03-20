package com.vozniak.trialnotes.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vozniak.trialnotes.data.entities.NoteItem;
import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertItem(NoteItem noteItem);

    @Query("SELECT * FROM note_item")
    LiveData<List<NoteItem>> getAllList();

    @Update
    public abstract void updateNote(NoteItem note);

    @Query("DELETE FROM note_item WHERE id IS :id ")
    public abstract void deleteNote(int id);

}
