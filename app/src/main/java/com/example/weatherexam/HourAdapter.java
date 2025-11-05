package com.example.weatherexam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.ViewHolder> {
    public List<HourItem> hourItemList;
    public HourAdapter(List<HourItem> hourItemList) {
        this.hourItemList = hourItemList;
    }
    public void UpdateData(List<HourItem> hourItemList) {
        this.hourItemList = hourItemList;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HourItem item = hourItemList.get(position);

        holder.timeText.setText(item.time);
        holder.tempText.setText(item.temperature);
        holder.conditionText.setText(item.condition);
    }


    @Override
    public int getItemCount() {
        return hourItemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView timeText, tempText, conditionText;
        public ViewHolder(View itemView) {
            super(itemView);
            timeText = itemView.findViewById(R.id.timeText);
            tempText = itemView.findViewById(R.id.tempText);
            conditionText = itemView.findViewById(R.id.conditionText);
        }
    }
}