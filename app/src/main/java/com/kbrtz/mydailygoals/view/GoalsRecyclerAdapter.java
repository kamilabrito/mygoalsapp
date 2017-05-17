package com.kbrtz.mydailygoals.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.constants.Constants;
import com.kbrtz.mydailygoals.interfaces.OnItemClickListener;
import com.kbrtz.mydailygoals.model.MyGoals;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.kbrtz.mydailygoals.presenter.PresenterMainActivity;

/**
 * Created by kamilabrito on 5/7/17.
 */

class GoalsRecyclerAdapter extends RecyclerView.Adapter<GoalsRecyclerAdapter.ViewHolder> {

    private List<MyGoals> goals;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private PresenterMainActivity presenterMainActivity;


    public GoalsRecyclerAdapter(@NonNull Context context) {
        this.context = context;
    }

    public void setGoalsList(List<MyGoals> goals) {
        this.goals = goals;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goals_row, null);
        ViewHolder viewHolder = new ViewHolder(view);
        presenterMainActivity = new PresenterMainActivity(context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final MyGoals currentGoal = goals.get(position);
        if (currentGoal != null) {
            holder.doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenterMainActivity.markGoalAsDone(currentGoal);
                    presenterMainActivity.countUserPoint(currentGoal.getGoalValue());
                    removeAt(position);
                }
            });
            holder.goalName.setText(currentGoal.getGoalName());

            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("OnClickListener adapter", "item: " + currentGoal.getId());
                    onItemClickListener.onItemClick(currentGoal);
                }
            };
            holder.goalName.setOnClickListener(listener);

            holder.addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenterMainActivity.addGoalToUserList(currentGoal);
                    removeAt(position);
                }
            });

            if (currentGoal.getGoalStatus() != Constants.STATUS_IN_PROGRESS) {
                holder.doneButton.setVisibility(View.GONE);
                holder.addButton.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return (null != goals ? goals.size() : 0);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.goal_name)
        TextView goalName;
        @BindView(R.id.done_button)
        Button doneButton;
        @BindView(R.id.add_button)
        Button addButton;
        @BindView(R.id.goal_card)
        CardView goalCard;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void removeAt(int position) {
        goals.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, goals.size());
    }

}
