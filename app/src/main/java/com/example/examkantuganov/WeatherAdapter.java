package com.example.examkantuganov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    List<WeatherItem> weatherItemList;
    public OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void OnItemClick(WeatherItem item);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public WeatherAdapter(List<WeatherItem> weatherItemList) {
        this.weatherItemList = weatherItemList;
    }
    public void UpdateData(List<WeatherItem> weatherItemList) {
        this.weatherItemList = weatherItemList;
        notifyDataSetChanged();
    }
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.ViewHolder holder, int position) {
        WeatherItem item = weatherItemList.get(position);

        holder.tempText.setText(item.temperature);
        holder.conditionText.setText(item.condition);

        holder.itemView.setOnClickListener(itemer -> {
            onItemClickListener.OnItemClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return weatherItemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tempText, conditionText;
        public ViewHolder(View itemView) {
            super(itemView);
            tempText = itemView.findViewById(R.id.tempText);
            conditionText = itemView.findViewById(R.id.conditionText);
        }
    }
}
