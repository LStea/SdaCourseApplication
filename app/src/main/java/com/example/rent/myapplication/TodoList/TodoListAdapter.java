package com.example.rent.myapplication.TodoList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.rent.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-02-22.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.MyViewHolder> {

    List<CheckItem> items = new ArrayList<>();
    private OnItemCheckStateChenged checkListener;

    public void setCheckListener(OnItemCheckStateChenged checkListener) {
        this.checkListener = checkListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CheckItem listItem = items.get(position);
        holder.text.setText((items.get(position).getText().toString()));
        holder.checkBox.setChecked(listItem.isChecked());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listItem.setChecked(isChecked);
                if (checkListener != null) {
                    checkListener.onItemCheckStateChenged(getCheckedItemsCount());
                }
            }
        });
    }

    public void deselectAllItems() {
        for (CheckItem item : items) {
            item.setChecked(false);
        }
        notifyDataSetChanged();
    }

    private int getCheckedItemsCount() {
        int count = 0;

        for (CheckItem item : items) {
            if (item.isChecked()) {
                count++;
            }
        }
        return count;
    }

    public int getItemCount() {
        return items.size();
    }

    public void addItem(String item) {
        items.add(new CheckItem(item));
        notifyDataSetChanged();
    }

    public void deleteAllCheckedItems() {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.item_text);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}