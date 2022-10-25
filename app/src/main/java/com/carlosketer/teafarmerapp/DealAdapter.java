package com.carlosketer.teafarmerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.DealHolder>  {
    ArrayList<LoanDeal> deals;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;

    public  DealAdapter(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("loandeals");
        deals = FirebaseUtil.mDeals;
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //  TextView tvDeals = findViewById(R.id.tvDeals);
                LoanDeal td = snapshot.getValue(LoanDeal.class);
                td.setId(snapshot.getKey());
                // tvDeals.setText(tvDeals.getText()+"\n"+td.getTitle());
                deals.add(td);
              //  notifyItemInserted(deals.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildEventListener);
    }
    @NonNull
    @Override
    public DealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.rv_row,parent,false);

        return new DealHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealHolder holder, int position) {
        LoanDeal deal = deals.get(position);
        holder.bind(deal);
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }

    public class DealHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvLocation,tvAmount,tvPhone,tvSacco ;

        public DealHolder(@NonNull View itemView) {
            super(itemView);
            /*tvSacco = (TextView) itemView.findViewById(R.id.tvSacco);
            tvAmount = (TextView) itemView.findViewById(R.id.tvAmount);
            tvLocation = (TextView) itemView.findViewById(R.id.tvLocation);*/
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            /*tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);*/

        }
             public  void bind(LoanDeal deal) {
                 tvTitle.setText(deal.getTitle());
                /* tvAmount.setText(deal.getAmount());
                 tvPhone.setText(deal.getAccountNo());
                 tvLocation.setText(deal.getLocation());
                 tvSacco.setText(deal.getSacco());
*/

             }
    }
}
