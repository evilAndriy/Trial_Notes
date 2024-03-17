package com.vozniak.trialnotes.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.vozniak.trialnotes.data.entities.NoteItem;

import java.util.List;
import java.util.concurrent.Flow;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insertItem(NoteItem noteItem);

    @Query("SELECT * FROM note_item")
    LiveData<List<NoteItem>> getAllList();
}
