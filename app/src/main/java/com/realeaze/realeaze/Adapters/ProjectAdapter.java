package com.realeaze.realeaze.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.realeaze.realeaze.R;

/**
 * Created by saurav on 6/5/2018.
 */

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.viewHolder> {
    public ProjectAdapter(Context context) {
     }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_project, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        public viewHolder(View itemView) {
            super(itemView);
        }
    }
}
