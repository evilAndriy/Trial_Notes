package com.vozniak.trialnotes.data.database;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vozniak.trialnotes.data.entities.NoteItem;

@Database(entities = {NoteItem.class}, version = 1)
public abstract class MainDB extends RoomDatabase {
    public abstract NoteDao getDao();

    private static volatile MainDB INSTANCE;

    public static MainDB getDataBase(Context context) {
        if (INSTANCE == null) {
            synchronized (MainDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MainDB.class,
                            "shopping_list.db"
                    ).allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
