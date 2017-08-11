package com.example.d1mys1klapo4ka.retrofit2andormlite.adapter;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d1mys1klapo4ka.retrofit2andormlite.R;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.Auction;

import java.util.List;

/**
 * Created by d1mys1klapo4ka on 16.05.2017.
 */

public class RecyclerViewAdapter  extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private List<Auction> auctions;
    private View.OnClickListener onClickListener;

    public RecyclerViewAdapter(Context context, List<Auction> auctions) {
        this.context = context;
        this.auctions = auctions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder_activity, parent , false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Auction models = auctions.get(position);

        holder.tvCompanyName.setText(models.getCompanyName());
        holder.tvProductSubtype.setText(models.getProductSubtype());
        holder.tvBestBit.setText(models.getBestBid());
        holder.tvCurrencyPriceName.setText(models.getCurrencyPriceName());
        holder.tvTillTheEnd.setText(models.getTillTheEnd());
        holder.tvRegionName.setText(models.getRegionName());

        //*******************FIRST WAY*******************
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, SecondActivity.class);
//                intent.putExtra("student", studentsInit.get(position));
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
            return auctions.size();

    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvCompanyName, tvProductSubtype, tvBestBit, tvCurrencyPriceName, tvTillTheEnd, tvRegionName;
        CardView cardView;

        public ViewHolder(View itemView) {

            super(itemView);

            tvCompanyName = (TextView)itemView.findViewById(R.id.tv_company_name);
            tvProductSubtype = (TextView)itemView.findViewById(R.id.tv_product_subtype);
            tvBestBit = (TextView)itemView.findViewById(R.id.tv_best_price);
            tvCurrencyPriceName = (TextView)itemView.findViewById(R.id.tv_currency_price_name);
            tvTillTheEnd = (TextView)itemView.findViewById(R.id.tv_till_the_end);
            tvRegionName = (TextView)itemView.findViewById(R.id.tv_region_name);
            cardView = (CardView)itemView.findViewById(R.id.cv_item);

        }
    }
}
