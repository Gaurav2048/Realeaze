package com.realeaze.realeaze.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realeaze.realeaze.R;

/**
 * Created by saurav on 6/5/2018.
 */

public class RemarkAdapter extends RecyclerView.Adapter<RemarkAdapter.viewHolder> {
    Context context;
    public RemarkAdapter(Context context) {
     this.context = context;
     }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_remark, parent, false));

    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
    holder.textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            createDialog();
        }
    });
    }

    private void createDialog() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertLayout = inflater.inflate(R.layout.status_dialog, null);



        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);


        AlertDialog dialog = alert.create();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
  TextView textView;
        public viewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.status);
        }
    }
}
