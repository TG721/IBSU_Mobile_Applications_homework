package com.tengizmkcorp.ibsu_mobile_homework3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tengizmkcorp.ibsu_mobile_homework3.R;
import com.tengizmkcorp.ibsu_mobile_homework3.databinding.StoryItemBinding;
import com.tengizmkcorp.ibsu_mobile_homework3.model.StoryItem;

import java.util.List;

public class StoryItemAdapter extends RecyclerView.Adapter<StoryItemAdapter.StoryItemViewHolder> {

    private List<StoryItem> list;
    private Context mContext;

    public StoryItemAdapter(List<StoryItem> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public StoryItemAdapter.StoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoryItemAdapter.StoryItemViewHolder(
                StoryItemBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull StoryItemAdapter.StoryItemViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class StoryItemViewHolder extends RecyclerView.ViewHolder {
        private StoryItemBinding binding;

        public StoryItemViewHolder(StoryItemBinding StoryItemBinding) {
            super(StoryItemBinding.getRoot());
            this.binding = StoryItemBinding;
        }

        void bind(StoryItem item) {
            Integer pos = getAdapterPosition();
            Glide.with(binding.storyContentIV)
                    .load(item.getImage())
                    .circleCrop()
                    .into(binding.storyContentIV);
            String title = item.getTitle();
            if(title.length()>7) {
                binding.titleTV.setText(item.getTitle().substring(0,7)+"...");
            } else binding.titleTV.setText(item.getTitle());
            if (!item.getAlreadyViewed())
                binding.backgroundImage.setBorderColor(ContextCompat.getColor(mContext, R.color.blue));
        }
    }
}
