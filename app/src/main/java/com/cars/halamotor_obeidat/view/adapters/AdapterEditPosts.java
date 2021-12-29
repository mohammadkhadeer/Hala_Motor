package com.cars.halamotor_obeidat.view.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.view.activity.EditPostActivity;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.BaseViewHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getObjectPathInServerFireStore;
import static com.cars.halamotor_obeidat.functions.FCSFunctions.convertCat;

public class AdapterEditPosts extends RecyclerView.Adapter<BaseViewHolder> {
  private static final int REQUEST_EDIT_POST = 55;

  private static final int VIEW_TYPE_LOADING = 0;
  private static final int VIEW_TYPE_NORMAL = 1;
  private boolean isLoaderVisible = false;

  private List<SuggestedItem> suggestedItemsList;
  Context context;

  public AdapterEditPosts(List<SuggestedItem> postItems, Context context) {
    this.suggestedItemsList = postItems;
    this.context = context;
  }

  @NonNull
  @Override
  public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    switch (viewType) {
      case VIEW_TYPE_NORMAL:
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_edit_items, parent, false));
      case VIEW_TYPE_LOADING:
        return new ProgressHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
      default:
        return null;
    }
  }

  @Override
  public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    holder.onBind(position);
    switch (getItemViewType(position)) {
      case VIEW_TYPE_NORMAL:

      case VIEW_TYPE_LOADING:

      default:
        break;
    }
  }

  @Override
  public int getItemViewType(int position) {
    if (isLoaderVisible) {
      return position == suggestedItemsList.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
    } else {
      return VIEW_TYPE_NORMAL;
    }
  }

  @Override
  public int getItemCount() {
    return suggestedItemsList == null ? 0 : suggestedItemsList.size();
  }

  public void addItems(List<SuggestedItem> postItems) {
    suggestedItemsList.addAll(postItems);
    notifyDataSetChanged();
  }

  public void addLoading() {
    isLoaderVisible = true;
    suggestedItemsList.add(new SuggestedItem());
    notifyItemInserted(suggestedItemsList.size() - 1);
  }

  public void removeLoading() {
    isLoaderVisible = false;
    int position = suggestedItemsList.size() - 1;
    SuggestedItem item = getItem(position);
    if (item != null) {
      suggestedItemsList.remove(position);
      notifyItemRemoved(position);
    }
  }

  public void clear() {
    suggestedItemsList.clear();
    notifyDataSetChanged();
  }

  SuggestedItem getItem(int position) {
    return suggestedItemsList.get(position);
  }

  public class ViewHolder extends BaseViewHolder {
    CardView cardView;
    ImageView itemImage,fireIV;
    TextView text1, text2, text3
            , text4,itemTitleTV,itemPriceTV,itemCityTV
            ,itemNewPriceTV,oldPriceTV,editTV,deleteTV;
    RelativeLayout text2RL,text3RL,text4RL,itemCityRL,cardButton
            ,itemInfoRL,messageInfo,editRL,deleteRL;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      cardView = (CardView) itemView.findViewById(R.id.adapter_edit_item_CV);
      fireIV = (ImageView) itemView.findViewById(R.id.adapter_edit_fire_iv);
      itemImage = (ImageView) itemView.findViewById(R.id.adapter_edit_item_image_view);

      text1 = (TextView) itemView.findViewById(R.id.adapter_edit_item_text1);
      text2 = (TextView) itemView.findViewById(R.id.adapter_edit_item_text2);
      text3 = (TextView) itemView.findViewById(R.id.adapter_edit_item_text3);
      text4 = (TextView) itemView.findViewById(R.id.adapter_edit_item_text4);
      itemCityTV = (TextView) itemView.findViewById(R.id.adapter_edit_item_city);
      editTV = (TextView) itemView.findViewById(R.id.adapter_edit_edit_tv);
      deleteTV = (TextView) itemView.findViewById(R.id.adapter_edit_delete_tv);

      text2RL = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_item_container_text2);
      text3RL = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_item_container_text3);
      text4RL = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_item_container_text4);
      itemCityRL = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_item_container_city);
      cardButton = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_item_card_button);
      itemInfoRL = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_itemInfo);
      messageInfo = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_messageInfo);
      editRL = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_edit_button);
      deleteRL = (RelativeLayout) itemView.findViewById(R.id.adapter_edit_delete_button);

      itemTitleTV = (TextView) itemView.findViewById(R.id.adapter_edit_item_car_title);
      itemPriceTV = (TextView) itemView.findViewById(R.id.adapter_edit_item_car_price);
      itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_edit_item_car_new_price);
      oldPriceTV = (TextView) itemView.findViewById(R.id.adapter_edit_item_car_old_price);

    }

    protected void clear() {

    }

    public void onBind(int position) {
      super.onBind(position);

      if (getObject(position).getItemActiveOrNot().equals("1")
          && getObject(position).getItemBurnedPrice().equals("0")) {
        messageInfo.setVisibility(View.GONE);
        itemInfoRL.setVisibility(View.VISIBLE);
        makeAllTextViewVISIBLE(text1, text2, text3, text4, itemCityTV, text2RL, text3RL, text4RL, itemCityRL);
        fillImage(itemImage, position, context);
        fillTitleAndUserName(itemTitleTV, position);
        fillPrice(itemPriceTV, oldPriceTV, fireIV, itemNewPriceTV, position, context);
        changeFont(context, text1, text2, text3, text4, itemCityTV, itemPriceTV, itemTitleTV,editTV,deleteTV);
        checkTypeAndFillTypeDetails(context, text1, text2, text3, text4, text2RL, text3RL, text4RL
                , itemCityTV, itemCityRL, position);
        actionListenerToGoShowItemDetails(context, cardButton, position);
        deleteActionListener(context,position,deleteRL,itemInfoRL,messageInfo,itemImage);
        editeActionListener(context,position,editRL);

      }else{
        itemInfoRL.setVisibility(View.GONE);
        messageInfo.setVisibility(View.VISIBLE);

        fillImageView(itemImage);
      }

    }

    private void editeActionListener(final Context context, final int position, RelativeLayout editRL) {
      editRL.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          final String category = convertCat(suggestedItemsList.get(position).getItemType());
          Bundle bundle = new Bundle();
          bundle.putString("category",category);
          bundle.putString("itemID",suggestedItemsList.get(position).getItemIdInServer());
          bundle.putString("imagePath",suggestedItemsList.get(position).getItemImage());

          Intent intent = new Intent(context, EditPostActivity.class);
          intent.putExtras(bundle);
          ((Activity)context).startActivityForResult(intent , REQUEST_EDIT_POST);
          ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        }
      });
    }

    private void deleteActionListener(final Context context, final int position, RelativeLayout deleteRL
            , final RelativeLayout itemInfoRL, final RelativeLayout messageInfo, final ImageView itemImage) {

      deleteRL.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          String message = context.getResources().getString(R.string.delete_message) +" "+ suggestedItemsList.get(position).getItemName();
          AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
          alertDialog.setTitle("Message");
          alertDialog.setMessage(message);
          alertDialog.setNegativeButton("no",
                  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                    }
                  });
          alertDialog.setPositiveButton("yes",
                  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                      final String category = convertCat(suggestedItemsList.get(position).getItemType());
                      //cos have mistake on CCEMT object model we set acution alternative to active
                      DocumentReference documentReference=getObjectPathInServerFireStore(category,suggestedItemsList.get(position).getItemIdInServer());
                      documentReference.update("activeOrNotS","0").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                          if (task.isSuccessful())
                          {
                            itemInfoRL.setVisibility(View.GONE);
                            messageInfo.setVisibility(View.VISIBLE);

                            fillImageView(itemImage);
                            suggestedItemsList.get(position).setItemActiveOrNot("0");
                          }
                        }
                      }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                          Log.i("TAG","erorr "+ e.toString());
                        }
                      });

                      dialog.dismiss();
                      //perform action
                    }
                  });
          final AlertDialog alert = alertDialog.create();
          alert.show();

          //((Activity)context).finish();
        }
      });
    }

  }




  private void fillImageView(ImageView itemImage) {
    String noImage = "https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d";
    Picasso.get()
            .load(noImage)
            .fit()
            .centerCrop()
            .into(itemImage);
  }

  private SuggestedItem getObject(int position){
    SuggestedItem item = suggestedItemsList.get(position);
    return item;
  }

  public void removeAt(int position) {
    suggestedItemsList.remove(position);
    notifyItemRemoved(position);
    notifyItemRangeChanged(position, suggestedItemsList.size());
  }


  private void actionListenerToGoShowItemDetails(final Context context, RelativeLayout cardButton, final int position) {
    cardButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (getObject(position).getItemActiveOrNot().equals("1")
                && getObject(position).getItemBurnedPrice().equals("0")) {
          Bundle bundle = new Bundle();
          bundle.putString("category", getObject(position).getItemType());
          bundle.putString("from", "stu");
          bundle.putString("itemID", getObject(position).getItemIdInServer());

          Intent intent = new Intent(context, ShowItemDetails.class);
          intent.putExtras(bundle);
          ((Activity) context).startActivity(intent);
          ((Activity) context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        }else{
          Toast.makeText(context,context.getResources().getString(R.string.can_not_see_content),Toast.LENGTH_SHORT).show();
        }

      }
    });
  }

  private void checkTypeAndFillTypeDetails(Context context, TextView text1, TextView text2
          , TextView text3, TextView text4, RelativeLayout text2RL, RelativeLayout text3RL
          , RelativeLayout text4RL, TextView itemCityTV, RelativeLayout itemCityRL, int position) {
    if (getObject(position).getItemType().equals("Car for sale")
            ||getObject(position).getItemType().equals("Car for rent")
            ||getObject(position).getItemType().equals("Exchange car")
            ||getObject(position).getItemType().equals("Motorcycle")
            ||getObject(position).getItemType().equals("Trucks")
    ) {
      fillCarDetails(position,text1,text2,text3,text4);
    }
    if (getObject(position).getItemType().equals("Plates"))
    {
      fillCarPlates(context,position,text1,text2,text3,text3RL,text4RL,text4,itemCityTV,itemCityRL);
    }
    if (getObject(position).getItemType().equals("Wheels_Rim"))
    {
      fillWheelsRim(context,position,text1,text2,text3,text4,itemCityTV,text3RL,text4RL,itemCityRL);
    }
    if (getObject(position).getItemType().equals("Accessories"))
    {
      fillAccAndJunk(text1,text2,text3,text4,itemCityTV,text2RL,text3RL,text4RL,itemCityRL,position);
    }
    if (getObject(position).getItemType().equals("Junk car"))
    {
      fillAccAndJunk(text1,text2,text3,text4,itemCityTV,text2RL,text3RL,text4RL,itemCityRL,position);
    }
  }

  private void fillAccAndJunk(TextView text1, TextView text2, TextView text3, TextView text4
          , TextView itemCityTV, RelativeLayout text2RL, RelativeLayout text3RL
          , RelativeLayout text4RL, RelativeLayout itemCityRL, int position) {
    text1.setText(getObject(position).getItemCity());
    text2.setAlpha(0);
    text3.setAlpha(0);
    text4.setAlpha(0);
    itemCityTV.setAlpha(0);

    text2RL.setAlpha(0);
    text3RL.setAlpha(0);
    text4RL.setAlpha(0);
    itemCityRL.setAlpha(0);
  }


  private void fillWheelsRim(Context context, int position, TextView text1, TextView text2
          , TextView text3, TextView text4, TextView itemCityTV, RelativeLayout text3RL
          , RelativeLayout text4RL, RelativeLayout itemCityRL) {
    text1.setText(getObject(position).getItemCity());
    text2.setText(getObject(position).getItemWheelsSize());
    text3.setAlpha(0);
    text4.setAlpha(0);
    itemCityTV.setAlpha(0);

    text3RL.setAlpha(0);
    text4RL.setAlpha(0);
    itemCityRL.setAlpha(0);
  }

  private void fillCarPlates(Context context, int position, TextView text1, TextView text2
          , TextView text3, RelativeLayout text3RL, RelativeLayout text4RL, TextView text4
          , TextView itemCityTV, RelativeLayout itemCityRL) {
    text1.setText(getObject(position).getItemCarPlatesCity());
    text2.setText(getObject(position).getItemCarPlatesNumber().replace(".0",""));
    if(getObject(position).getItemCarPlatesSpecial().equals(context.getResources().getString(R.string.special)))
    {
      text3.setText(context.getResources().getString(R.string.special));
    }else{
      text3.setAlpha(0);
      text3RL.setAlpha(0);
    }
    text4RL.setAlpha(0);
    text4.setAlpha(0);
    itemCityTV.setAlpha(0);
    itemCityRL.setAlpha(0);
    itemCityTV.setText(getObject(position).getItemCity());
  }

  private void fillCarDetails(int position, TextView text1, TextView text2,
                              TextView text3, TextView text4) {
    text1.setText(getObject(position).getItemCarMake());
    text2.setText(getObject(position).getItemCarYear());
    text3.setText(getObject(position).getItemType());
    text4.setText(getObject(position).getItemCarKilometers());
  }

  private void changeFont(Context context, TextView text1, TextView text2, TextView text3
          , TextView text4, TextView itemCityTV
          , TextView itemPriceTV, TextView itemTitleTV
          ,TextView editTV,TextView deleteTV) {
    text1.setTypeface(Functions.changeFontGeneral(context));
    text2.setTypeface(Functions.changeFontGeneral(context));
    text3.setTypeface(Functions.changeFontGeneral(context));
    text4.setTypeface(Functions.changeFontGeneral(context));
    itemCityTV.setTypeface(Functions.changeFontGeneral(context));

    itemPriceTV.setTypeface(Functions.changeFontGeneral(context));
    itemTitleTV.setTypeface(Functions.changeFontBold(context));
    editTV.setTypeface(Functions.changeFontBold(context));
    deleteTV.setTypeface(Functions.changeFontBold(context));
  }

  private void fillPrice(TextView itemPriceTV, TextView oldPriceTV, ImageView fireIV
          , TextView itemNewPriceTV, int position, Context context) {
    if (getObject(position).getItemPostEdit().equals("0"))
    {
      itemPriceTV.setVisibility(View.VISIBLE);
      oldPriceTV.setVisibility(View.GONE);
      fireIV.setVisibility(View.GONE);
      itemPriceTV.setText(getObject(position).getItemPrice()
              +" "+context.getResources().getString(R.string.price_contry));
      itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);

      itemNewPriceTV.setText("");
      itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
    }else{
      itemPriceTV.setVisibility(View.GONE);
      oldPriceTV.setVisibility(View.VISIBLE);

      oldPriceTV.setText(getObject(position).getItemPrice());
      oldPriceTV.setTextColor(context.getResources().getColor(R.color.colorSilver));
      oldPriceTV.setPaintFlags(itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
      itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
      itemNewPriceTV.setText(getObject(position).getItemNewPrice()
              +" "+context.getResources().getString(R.string.price_contry));
      itemPriceTV.setText(getObject(position).getItemPrice()
              +" "+context.getResources().getString(R.string.price_contry));
      fireIV.setVisibility(View.VISIBLE);

    }
  }

  private void fillTitleAndUserName(TextView itemTitleTV, int position) {
    itemTitleTV.setText(getObject(position).getItemName());
  }

  private void fillImage(ImageView itemImage,
                         int position, Context context) {

    Picasso.get()
            .load(getObject(position).getItemImage())
            .fit()
            .centerCrop()
            .into(itemImage);
  }

  private void makeAllTextViewVISIBLE(TextView text1, TextView text2, TextView text3, TextView text4
          , TextView itemCityTV, RelativeLayout text2RL, RelativeLayout text3RL
          , RelativeLayout text4RL, RelativeLayout itemCityRL) {
    //we use this method because some time need to gone some textView
    text1.setAlpha(1);
    text2.setAlpha(1);
    text3.setAlpha(1);
    text4.setAlpha(1);
    itemCityTV.setAlpha(1);

    text2RL.setAlpha(1);
    text3RL.setAlpha(1);
    text4RL.setAlpha(1);
    itemCityRL.setAlpha(1);
  }


  public class ProgressHolder extends BaseViewHolder {
    ProgressHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @Override
    protected void clear() {
    }

    public void onBind(int position) {
      super.onBind(position);
    }
  }

}