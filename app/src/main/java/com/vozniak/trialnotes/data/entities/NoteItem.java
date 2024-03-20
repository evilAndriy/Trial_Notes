package com.vozniak.trialnotes.data.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "note_item")
public class NoteItem implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "content")
    private String content;


    public NoteItem( String title, String content) {

        this.title = title;
        this.content = content;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    // Методи equals, hashCode і toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteItem noteItem = (NoteItem) o;
        return id == noteItem.id &&
                title.equals(noteItem.title) &&
                content.equals(noteItem.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content);
    }


    @Override
    public String toString() {
        return "NoteItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
