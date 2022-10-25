package com.carlosketer.teafarmerapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToolAdapter extends RecyclerView.Adapter<ToolAdapter.ToolsHolder> {
    @NonNull
    @Override
    public ToolsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ToolsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ToolsHolder extends RecyclerView.ViewHolder {

        public ToolsHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(ToolsDeal toolsDeal){

        }
    }
}
