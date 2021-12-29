package com.cars.halamotor_obeidat.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cars.halamotor_obeidat.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SelectedImageAdapter extends RecyclerView.Adapter<SelectedImageAdapter.ViewHolder>{

    private final Context context;
    public ArrayList<String> imagePath = new ArrayList<String>();


    public SelectedImageAdapter
            (Context context
                    ,ArrayList<String> imagePath
            )
    {
        this.context = context;
        this.imagePath = imagePath;

    }

    public SelectedImageAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_view_selected_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SelectedImageAdapter.ViewHolder holder, final int position) {

        fillImageInImageView(context,holder,position);
        deleteImageActionListener(context,holder,position);
    }

    private void deleteImageActionListener(Context context, ViewHolder holder, final int position) {
        holder.deletePhotoRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAt(position);
            }
        });
    }

    public void removeAt(int position) {
        imagePath.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, imagePath.size());
    }

    private void fillImageInImageView(Context context, ViewHolder holder, int position) {
        Picasso.get()
                .load("file://"+imagePath.get(position))
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return imagePath.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout deletePhotoRL;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.selected_image_IV) ;
            deletePhotoRL = (RelativeLayout) itemView.findViewById(R.id.adapter_view_s_delete_imageRL) ;

        }
    }

}
