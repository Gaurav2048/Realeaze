package com.realeaze.realeaze.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realeaze.realeaze.ClientRequActivity;
import com.realeaze.realeaze.R;
import com.realeaze.realeaze.model.client;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by saurav on 6/3/2018.
 */

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.viewHolder> {
   Context context;
   ArrayList<client> clientArrayList;
   Activity activity;
    public ClientAdapter(Context context, ArrayList<client> clientArrayList, Activity activity) {
        this.context = context;
        this.clientArrayList = clientArrayList;
        this.activity = activity;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_client, parent, false));

    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
        holder.client_number.setTypeface(typeface);
        holder.client_email.setTypeface(typeface);
        holder.requirement_client.setTypeface(typeface);
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf");
        holder.price.setTypeface(typeface1);

        Locale locale = Locale.getDefault();
        Currency currency = Currency.getInstance(locale);
        String symbol = currency.getSymbol().replaceAll("\\w", "");
        holder.price.setText(symbol+" "+clientArrayList.get(position).getClient_price());
        holder.text_clinae_.setText(clientArrayList.get(position).getClient_name());
        holder.client_number.setText(clientArrayList.get(position).getClient_phone());
        holder.client_email.setText(clientArrayList.get(position).getClient_email());
        holder.requirement_client.setText("Looking for "+clientArrayList.get(position).getClient_requirement());
  holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent = new Intent(context, ClientRequActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          activity.startActivity(intent);
      }
  });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
       TextView price;
       TextView text_clinae_;
       TextView client_number;
       TextView client_email;
       TextView requirement_client;
        public viewHolder(View itemView) {
            super(itemView);
            price = (TextView) itemView.findViewById(R.id.client_price);
            text_clinae_ = (TextView) itemView.findViewById(R.id.text_clinae_);
            client_number = (TextView) itemView.findViewById(R.id.client_number);
            client_email = (TextView) itemView.findViewById(R.id.client_email);
            requirement_client = (TextView) itemView.findViewById(R.id.requirement_client);
        }
    }
}
