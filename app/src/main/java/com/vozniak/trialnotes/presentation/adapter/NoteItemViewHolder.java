package com.vozniak.trialnotes.presentation.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.databinding.MyNoteBinding;


public class NoteItemViewHolder extends RecyclerView.ViewHolder {
    private final MyNoteBinding binding;

    public NoteItemViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = MyNoteBinding.bind(itemView);
    }

    public void bindView(NoteItem noteItem) {
        binding.tvText.setText(noteItem.getTitle());
        binding.tvContent.setText(noteItem.getContent());
    }
}
