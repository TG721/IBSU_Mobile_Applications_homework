package com.tengizmkcorp.ibsu_mobile_homework3.adapter;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tengizmkcorp.ibsu_mobile_homework3.R;
import com.tengizmkcorp.ibsu_mobile_homework3.databinding.TopUserButtonBinding;
import com.tengizmkcorp.ibsu_mobile_homework3.model.TopUserButton;

import java.util.List;

public class TopUserButtonAdapter extends RecyclerView.Adapter<TopUserButtonAdapter.ButtonViewHolder> {

    private List<TopUserButton> list;
    private Context mContext;

    public TopUserButtonAdapter(List<TopUserButton> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TopUserButtonAdapter.ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ButtonViewHolder(
                TopUserButtonBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TopUserButtonAdapter.ButtonViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ButtonViewHolder extends RecyclerView.ViewHolder{
        private TopUserButtonBinding binding;

        public ButtonViewHolder(TopUserButtonBinding topUserButtonBinding) {
            super(topUserButtonBinding.getRoot());
            this.binding = topUserButtonBinding;
        }
        void  bind(TopUserButton item){
        Integer pos = getAdapterPosition();
        if (item.getImageButton()==false){
            binding.btn.setText(item.getTitle());
            binding.btn.setVisibility(View.VISIBLE);
            if (item.getBlueBackground()) {
                binding.btn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(mContext, R.color.cyan)));
                binding.btn.setTextColor(ContextCompat.getColor(mContext, R.color.white));
            }
            if(item.getBold()) binding.btn.setTypeface(null, Typeface.BOLD);
        } else {
            binding.imageBtn.setVisibility(View.VISIBLE);
            binding.imageBtn.setImageResource(item.getImage());
            if (item.getBlueBackground()) {
                binding.imageBtn.setBackgroundColor(ContextCompat.getColor(mContext, R.color.cyan));
            }

        }
        }
    }
}
