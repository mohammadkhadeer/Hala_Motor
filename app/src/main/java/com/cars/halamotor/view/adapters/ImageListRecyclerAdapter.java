package com.cars.halamotor.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cars.halamotor.R;
import com.cars.halamotor.model.CustomGallery;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 */

public class ImageListRecyclerAdapter extends RecyclerView.Adapter<ImageListRecyclerAdapter.VerticalItemHolder> {

    private final Context mContext;
    private final ImageLoader imageLoader;
    private final DisplayImageOptions imageOptions;
    public ArrayList<CustomGallery> mItems = new ArrayList<>();
    private boolean isActionMultiplePick;

    public EventListener mEventListener;

    public ImageListRecyclerAdapter(Context mContext) {
        this.mContext = mContext;

        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext).build();
        imageLoader.init(config);
        imageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .showImageOnLoading(R.drawable.no_media)
                .showImageForEmptyUri(R.drawable.no_media)
                .showImageOnFail(R.drawable.no_media)
                .build();
    }

    public boolean isMultiSelected() {
        return isActionMultiplePick;
    }

    public interface EventListener {
        public void onItemClickListener(int position, VerticalItemHolder v);
    }

    public ArrayList<CustomGallery> getSelected() {
        ArrayList<CustomGallery> dataT = new ArrayList<CustomGallery>();

        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).isSeleted) {
                dataT.add(mItems.get(i));
            }
        }

        return dataT;
    }

    public void addAll(ArrayList<CustomGallery> files) {

        try {
            this.mItems.clear();
            this.mItems.addAll(files);

        } catch (Exception e) {
            e.printStackTrace();
        }

        notifyDataSetChanged();
    }

    public void changeSelection(VerticalItemHolder v, int position) {

        if (getSelected().size() > 14)
        {
            Log.i("TAG","MAX number of image");
                mItems.get(position).isSeleted = false;

        }else {
            Log.i("TAG", String.valueOf(mItems.size()));
            if (mItems.get(position).isSeleted) {
                mItems.get(position).isSeleted = false;
            } else {
                mItems.get(position).isSeleted = true;
            }
            v.imgQueueMultiSelected.setSelected(mItems.get(position).isSeleted);
        }
        //((ImageListRecyclerAdapter.VerticalItemHolder) v.getTag()).imgQueueMultiSelected.setSelected(mItems.get(position).isSeleted);
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public void setMultiplePick(boolean isMultiplePick) {
        this.isActionMultiplePick = isMultiplePick;
    }

    @Override
    public VerticalItemHolder onCreateViewHolder(ViewGroup container, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View root = inflater.inflate(R.layout.gallery_item, container, false);
        return new VerticalItemHolder(root, this);
    }

    @Override
    public void onBindViewHolder(final VerticalItemHolder holder, final int position) {
        CustomGallery item = mItems.get(position);
        holder.setImage(item.sdcardPath);

        if (isActionMultiplePick) {
            holder.imgQueueMultiSelected.setVisibility(View.VISIBLE);
        } else {
            holder.imgQueueMultiSelected.setVisibility(View.GONE);
        }
        if (isActionMultiplePick) {

            holder.imgQueueMultiSelected
                    .setSelected(item.isSeleted);

        }
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEventListener != null) {
                    mEventListener.onItemClickListener(position, holder);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public CustomGallery getItem(int position) {
        return mItems.get(position);
    }

    public class VerticalItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgQueue)
        ImageView imgQueue;
        @BindView(R.id.imgQueueMultiSelected)
        ImageView imgQueueMultiSelected;
        @BindView(R.id.container)
        View container;

        public VerticalItemHolder(View itemView, ImageListRecyclerAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setImage(String url) {
            imageLoader.displayImage("file://" + url,
                    imgQueue, new SimpleImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String imageUri, View view) {
                            imgQueue
                                    .setImageResource(R.drawable.no_media);
                            super.onLoadingStarted(imageUri, view);
                        }
                    });
        }
    }

    public void setEventListner(EventListener eventListner) {
        mEventListener = eventListner;
    }
}

