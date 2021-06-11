package com.example.autoshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoshop.Models.MessageModel;
import com.example.autoshop.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter {

    boolean state = false;
    Context context;
    static final int user = 1, other = 2;
    List<MessageModel> list;
    String userId;

    public MessageAdapter(Context context, List<MessageModel> list, String userId) {
        this.context = context;
        this.list = list;
        this.userId = userId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == user) {

            view = LayoutInflater.from(context).inflate(R.layout.userlayout, parent, false);
            return new ViewHolder(view);

        } else {
            view = LayoutInflater.from(context).inflate(R.layout.otherlayout, parent, false);
            return new ViewHolder(view);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MessageModel m = list.get(position);
        ((ViewHolder) holder).setle(m);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView messageBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (state) {
                messageBody = itemView.findViewById(R.id.userText);
            } else {
                messageBody = itemView.findViewById(R.id.otherText);
            }
        }

        void setle(MessageModel messageModel) {

            messageBody.setText(messageModel.getMesaj());

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getFrom().equals(userId)) {
            state = true;
            return user;

        } else {
            state = false;
            return other;

        }
    }
}
