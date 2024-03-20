package com.vozniak.trialnotes.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.vozniak.trialnotes.R;
import com.vozniak.trialnotes.data.entities.NoteItem;
import com.vozniak.trialnotes.databinding.MyNoteBinding;

public class NoteListAdapter extends ListAdapter<NoteItem, NoteItemViewHolder> {
    private final InitClickDelete initClickDelete;
    private final InitClickUpdate initClickUpdate;

    public NoteListAdapter(@NonNull DiffUtil.ItemCallback<NoteItem> diffCallback, InitClickDelete initClickDelete, InitClickUpdate initClickUpdate) {
        super(diffCallback);
        this.initClickDelete = initClickDelete;
        this.initClickUpdate = initClickUpdate;
    }

    MyNoteBinding binding;

    @NonNull
    @Override
    public NoteItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_note, parent, false);
        binding = MyNoteBinding.bind(view);
        return new NoteItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteItemViewHolder holder, int position) {
        NoteItem noteItem = getItem(position);
        holder.bindView(noteItem);
        binding.bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initClickDelete.initClick(noteItem.getId());
            }

        });
        binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initClickUpdate.initClick(noteItem);
            }
        });
    }


    public interface InitClickDelete {
        void initClick(Integer id);
    }

    public interface InitClickUpdate {
        void initClick(NoteItem noteItem);
    }
}
