package com.example.commtestnode.ui.big;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.commtestnode.R;

import java.util.ArrayList;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ActionViewHolder> {

    private ArrayList<ActionItem> mActionItem;
    private itemClickListener mListener;

    public void setItemClickListener(itemClickListener mListener) {
        this.mListener = mListener;
    }

    public interface itemClickListener {
        void onTalky(int position);

        void onMovey(int position);

        void onFacey(int position);
    }

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1; //talk
        public TextView mTextView2; //facey
        public TextView mTextView3; //move

        public ActionViewHolder(@NonNull View itemView, final itemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.text1);
            mTextView2 = itemView.findViewById(R.id.text2);
            mTextView3 = itemView.findViewById(R.id.text3);

            mTextView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) listener.onTalky(position);

                    }
                }
            });
            mTextView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) listener.onFacey(position);

                    }
                }
            });
            mTextView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) listener.onMovey(position);

                    }
                }
            });

        }
    }

    public ActionAdapter(ArrayList<ActionItem> actionItems) {
        mActionItem = actionItems;
    }

    @NonNull
    @Override
    public ActionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_item, parent, false);
        ActionViewHolder actVH = new ActionViewHolder(v, mListener);
        return actVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ActionViewHolder holder, int position) {
        ActionItem currAction = mActionItem.get(position);
        holder.mTextView1.setText(currAction.getText1());
        holder.mTextView2.setText(currAction.getText2());
        holder.mTextView3.setText(currAction.getText3());
    }

    @Override
    public int getItemCount() {
        return mActionItem.size();
    }
}
