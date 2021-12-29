package com.cars.halamotor_obeidat.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.PlatesChar;

import java.util.ArrayList;

public class AdapterPlatesChar extends RecyclerView.Adapter<AdapterPlatesChar.ViewHolder>{

    private final Context context;
    public ArrayList<PlatesChar> charArrayL ;
    String fromWhereCome;
    PassChar passChar;

    public AdapterPlatesChar
            (Context context, ArrayList<PlatesChar> charArrayL
            ,PassChar passChar)
    {   this.context = context;
        this.charArrayL = charArrayL;
        this.passChar = passChar;
    }

    public AdapterPlatesChar.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_filter_content, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterPlatesChar.ViewHolder holder, final int position) {
        holder.filterContentTV.setText(charArrayL.get(position).getCharStr());
        holder.filterContentTV.setTypeface(Functions.changeFontGeneral(context));
        actionListenerToPlatesChar(context,position,holder);
    }

    private void updateListChar(int position,final ViewHolder holder) {
        for (int i=0;i<charArrayL.size();i++)
        {
            if (!charArrayL.get(position).getCharStr().equals(charArrayL.get(i).getCharStr()))
            {
                charArrayL.get(position).setSelectedOrNot(false);
            }
        }
    }

    private void actionListenerToPlatesChar(Context context, final int position, final ViewHolder holder) {
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charArrayL.get(position).setSelectedOrNot(true);
                updateListChar(position,holder);
                passChar.onClicked(charArrayL.get(position).getCharStr());
            }
        });
    }

    @Override
    public int getItemCount() {
        return charArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView filterContentTV;
        RelativeLayout relativeLayout;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            filterContentTV = (TextView) itemView.findViewById(R.id.adapter_filter_content_text_view);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.coverRL);
        }
    }

    public interface PassChar {
        void onClicked(String platesChar);
    }

}