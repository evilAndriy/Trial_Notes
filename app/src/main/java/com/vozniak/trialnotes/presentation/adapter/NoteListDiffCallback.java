package com.vozniak.trialnotes.presentation.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.presentation.fragments.NoteFragment;

import java.util.List;


public class NoteListDiffCallback extends DiffUtil.ItemCallback<NoteItem> {
    @Override
    public boolean areItemsTheSame(@NonNull NoteItem oldItem, @NonNull NoteItem newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull NoteItem oldItem, @NonNull NoteItem newItem) {
        return oldItem.equals(newItem);
    }
}
