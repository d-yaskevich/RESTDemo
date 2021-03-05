package com.myfirst.restdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myfirst.restdemo.rest.models.Repo;

import java.util.ArrayList;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoVH> {

    private final LayoutInflater inflater;
    private final ArrayList<Repo> repos = new ArrayList<>();

    public ReposAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void resetRepos(ArrayList<Repo> repos) {
        this.repos.clear();
        if (repos != null) {
            this.repos.addAll(repos);
        }
        notifyDataSetChanged();
    }

    public void notifyRepos(Repo repos) {
        this.repos.clear();
        if (repos != null) {
            this.repos.add(repos);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RepoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoVH holder, int position) {
        Repo item = repos.get(position);
        holder.onBind(item);
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    static class RepoVH extends RecyclerView.ViewHolder {

        private final TextView tvText;

        public RepoVH(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(android.R.id.text1);
        }

        public void onBind(Repo item) {
            tvText.setText(item.name);
        }
    }
}
