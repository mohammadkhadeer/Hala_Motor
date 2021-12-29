package com.cars.halamotor_obeidat.view.adapters.userAds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.SimilarNeeded;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.permission.CheckPermission;
import com.cars.halamotor_obeidat.utils.BaseViewHolderUser;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

import static com.cars.halamotor_obeidat.algorithms.ArrangingLists.checkFavouriteOrNot1;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertItemsToFCS;
import static com.cars.halamotor_obeidat.fireBaseDB.UpdateFireBase.setFavouriteCallSearchOnServer;
import static com.cars.halamotor_obeidat.functions.Functions.convertCategoryToCategoryS;
import static com.cars.halamotor_obeidat.functions.Functions.openWhatsApp;
import static com.cars.halamotor_obeidat.functions.NewFunction.callAds;

public class AdapterSuggestedItems extends RecyclerView.Adapter<BaseViewHolderUser> {
  private static final int VIEW_TYPE_LOADING = 0;
  private static final int VIEW_TYPE_NORMAL = 1;
  private boolean isLoaderVisible = false;

  private List<SuggestedItem> suggestedItemsList;
  Context context;
  String comeFrom;
  SimilarNeeded similarNeededR;

  public AdapterSuggestedItems(List<SuggestedItem> postItems, Context context, String comeFrom, SimilarNeeded similarNeeded) {
    this.suggestedItemsList = postItems;
    this.context = context;
    this.comeFrom = comeFrom;
    this.similarNeededR = similarNeeded;
  }

  @NonNull
  @Override
  public BaseViewHolderUser onCreateViewHolder(ViewGroup parent, int viewType) {

    switch (viewType) {
      case VIEW_TYPE_NORMAL:
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_suggested_items, parent, false));
      case VIEW_TYPE_LOADING:
        return new ProgressHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading_h, parent, false));
      default:
        return null;
    }
  }

  @Override
  public void onBindViewHolder(@NonNull BaseViewHolderUser holder, int position) {
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

  public void addItems(List<SuggestedItem> postItems,SimilarNeeded similarNeeded) {
    suggestedItemsList.addAll(postItems);
    similarNeededR = similarNeeded;
    notifyDataSetChanged();
  }

  public void addLoading() {
    isLoaderVisible = true;
    suggestedItemsList.add(new SuggestedItem());
    notifyItemInserted(suggestedItemsList.size() - 1);
  }

  public void removeLoading() {
    isLoaderVisible = false;
    ////////////here
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

  public class ViewHolder extends BaseViewHolderUser {
    CardView cardView;
    ImageView itemImage,userImage,fireIV,favoriteIV;
    TextView text1, text2, text3
            , text4,itemTitleTV,itemPriceTV,itemCityTV
            ,userNameTV,itemNewPriceTV,oldPriceTV;
    RelativeLayout text2RL,text3RL,text4RL,itemCityRL,favoriteRL,cardButton
            ,callButtonRL,personInfoRL,itemInfoRL,messageInfo,cardShowFCS,whatsAppRL;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      cardView = (CardView) itemView.findViewById(R.id.adapter_user_item_cv);
      userImage = (ImageView) itemView.findViewById(R.id.adapter_user_item_user_image);
      fireIV = (ImageView) itemView.findViewById(R.id.adapter_user_item_fire_iv);
      favoriteIV = (ImageView) itemView.findViewById(R.id.adapter_user_item_favorite_iv);
      itemImage = (ImageView) itemView.findViewById(R.id.adapter_user_item_image_view);

      text1 = (TextView) itemView.findViewById(R.id.adapter_user_item_text1);
      text2 = (TextView) itemView.findViewById(R.id.adapter_user_item_text2);
      text3 = (TextView) itemView.findViewById(R.id.adapter_user_item_text3);
      text4 = (TextView) itemView.findViewById(R.id.adapter_user_item_text4);
      itemCityTV = (TextView) itemView.findViewById(R.id.adapter_user_item_city);

      text2RL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_container_text2);
      text3RL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_container_text3);
      text4RL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_container_text4);
      itemCityRL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_container_city);
      cardButton = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_card_button);
      personInfoRL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_personInfo);
      itemInfoRL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_itemInfo);
      messageInfo = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_messageInfo);
      cardShowFCS = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_item_card);
      whatsAppRL = (RelativeLayout) itemView.findViewById(R.id.adapter_car_for_sale_m_rl);

      itemTitleTV = (TextView) itemView.findViewById(R.id.adapter_user_item_car_title);
      itemPriceTV = (TextView) itemView.findViewById(R.id.adapter_user_item_car_price);
      itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_user_item_new_price);
      oldPriceTV = (TextView) itemView.findViewById(R.id.adapter_user_item_old_price);
      userNameTV = (TextView) itemView.findViewById(R.id.adapter_user_item_user_name);

      favoriteRL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_favorite_rl);
      callButtonRL = (RelativeLayout) itemView.findViewById(R.id.adapter_user_item_call_button);
    }

    protected void clear() {

    }

    public void onBind(int position) {
      super.onBind(position);

      if (getObject(position).getItemActiveOrNot().equals("1")
          && getObject(position).getItemBurnedPrice().equals("0")) {
        messageInfo.setVisibility(View.GONE);
        itemInfoRL.setVisibility(View.VISIBLE);
        personInfoRL.setVisibility(View.VISIBLE);
        makeAllTextViewVISIBLE(text1, text2, text3, text4, itemCityTV, text2RL, text3RL, text4RL, itemCityRL);
        fillImage(itemImage, userImage, position, context);
        fillTitleAndUserName(itemTitleTV, userNameTV, position);
        fillPrice(itemPriceTV, oldPriceTV, fireIV, itemNewPriceTV, position, context);
        changeFont(context, text1, text2, text3, text4, itemCityTV, userNameTV, itemPriceTV, itemTitleTV);
        checkTypeAndFillTypeDetails(context, text1, text2, text3, text4, text2RL, text3RL, text4RL
                , itemCityTV, itemCityRL, position);
        checkIfFavouriteOrNot(context,favoriteIV,favoriteRL,position);

        actionListenerToCallButton(context, callButtonRL, position);
        actionListenerToWhatsAap(context, whatsAppRL, position);
        actionListenerToFavorite(context, favoriteRL, position,favoriteIV);
        actionListenerToGoShowItemDetails(context, cardShowFCS, position);
      }else{
        personInfoRL.setVisibility(View.GONE);
        itemInfoRL.setVisibility(View.GONE);
        messageInfo.setVisibility(View.VISIBLE);

        fillImageView(itemImage);
      }

    }
  }

  private void actionListenerToWhatsAap(final Context context, RelativeLayout whatsAppRL, final int position) {
    whatsAppRL.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        insertItemsToFCS(getObject(position).getItemIdInServer(),convertCategoryToCategoryS(getObject(position).getItemType(),context)
                ,getDataBaseInstance(context),"message",context);
        setFavouriteCallSearchOnServer(context,getObject(position).getItemIdInServer(),getObject(position).getItemType(),"message");
        openWhatsApp(getObject(position).getItemUserPhoneNumber(),context);
      }
    });
  }

  private void checkIfFavouriteOrNot(Context context, ImageView favoriteIV, RelativeLayout favoriteRL
          , int position) {
    if (comeFrom.equals("favorite"))
    {
          favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
    }else{
      if (checkFavouriteOrNot1(context,getItem(position).getItemIdInServer()).equals("not_favorite"))
      {
        favoriteIV.setBackgroundResource(R.drawable.item_favu);
      }else
      {
        favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
      }
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

  private void actionListenerToFavorite(final Context context, RelativeLayout favoriteRL
          , final int position, final ImageView favoriteIV) {
    favoriteRL.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (comeFrom.equals("favorite"))
        {
          getDataBaseInstance(context).deleteFCS(getObject(position).getItemIdInServer());
          removeAt(position);
        }else{
          if (checkFavouriteOrNot1(context,getItem(position).getItemIdInServer()).equals("not_favorite"))
          {
            favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
            insertItemsToFCS(getItem(position).getItemIdInServer(),convertCategoryToCategoryS(getItem(position).getItemType(),context)
                    ,getDataBaseInstance(context),"favorite",context);

            setFavouriteCallSearchOnServer(context,getItem(position).getItemIdInServer()
                    ,getItem(position).getItemType(),"favorite");
          }else
          {
            favoriteIV.setBackgroundResource(R.drawable.item_favu);
            getDataBaseInstance(context).deleteFCS(getItem(position).getItemIdInServer());
          }
        }
      }
    });
  }

  public void removeAt(int position) {
    suggestedItemsList.remove(position);
    notifyItemRemoved(position);
    notifyItemRangeChanged(position, suggestedItemsList.size());
  }

  private void actionListenerToCallButton(final Context context, RelativeLayout callButtonRL, final int position) {
    callButtonRL.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        insertItemsToFCS(getObject(position).getItemIdInServer(),convertCategoryToCategoryS(getObject(position).getItemType(),context)
                ,getDataBaseInstance(context),"call",context);

        if (CheckPermission.checkPermissionMethodToPhone((Activity) context) == true) {
          setFavouriteCallSearchOnServer(context,getObject(position).getItemIdInServer(),getObject(position).getItemType(),"call");
          callAds(context,getObject(position).getItemUserPhoneNumber());
        }
      }
    });
  }

  private void actionListenerToGoShowItemDetails(final Context context, RelativeLayout cardButton, final int position) {
    cardButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (getObject(position).getItemActiveOrNot().equals("1")
                && getObject(position).getItemBurnedPrice().equals("0")) {
          Bundle bundle = new Bundle();
          if (comeFrom.equals("search"))
          {
            insertItemsToFCS(getObject(position).getItemIdInServer(),convertCategoryToCategoryS(getObject(position).getItemType(),context)
                    ,getDataBaseInstance(context),"search",context);

            setFavouriteCallSearchOnServer(context,getObject(position).getItemIdInServer()
                    ,getObject(position).getItemType(),"search");
            bundle.putParcelable("similarNeeded", similarNeededR);
          }
          bundle.putString("category", getObject(position).getItemType());
          if (comeFrom.equals("search"))
          {
            bundle.putString("from", "search");
          }else{
            bundle.putString("from", "stu");
          }
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
          , TextView text4, TextView itemCityTV, TextView userNameTV
          , TextView itemPriceTV, TextView itemTitleTV) {
    text1.setTypeface(Functions.changeFontGeneral(context));
    text2.setTypeface(Functions.changeFontGeneral(context));
    text3.setTypeface(Functions.changeFontGeneral(context));
    text4.setTypeface(Functions.changeFontGeneral(context));
    itemCityTV.setTypeface(Functions.changeFontGeneral(context));
    userNameTV.setTypeface(Functions.changeFontGeneral(context));

    itemPriceTV.setTypeface(Functions.changeFontGeneral(context));
    itemTitleTV.setTypeface(Functions.changeFontBold(context));
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

  private void fillTitleAndUserName(TextView itemTitleTV,TextView userNameTV, int position) {
    String title = getObject(position).getItemName().replace("\n","");
    if (title.length()>20)
    {
      String newTitle="";
      char[] charArray = title.toCharArray();
      for (int i =0;i<20;i++)
      {
        newTitle =newTitle+charArray[i];
      }
      newTitle = newTitle+"...";
      title =newTitle;
    }
    itemTitleTV.setText(title);
    userNameTV.setText(getObject(position).getUserName());
  }

  private void fillImage(ImageView itemImage, ImageView userImage,
                         int position, Context context) {

    Picasso.get()
            .load(getObject(position).getItemImage())
            .fit()
            .centerCrop()
            .into(itemImage);

    Picasso.get()
            .load(getObject(position).getUserImage())
            .fit()
            .centerCrop()
            .into(userImage);
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


  public class ProgressHolder extends BaseViewHolderUser {
    CardView cardView;
    ImageView shinImageView,imageView,shinImageView2,imageView2,shinImageView3,imageView3
            ,shinImageView4,imageView4;
    TextView textViewNoMoreMessage;
    RelativeLayout relativeLayout,relativeLayout2,relativeLayout3,relativeLayout4,relativeLayoutNoMoreItem;
    ProgressHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      cardView = (CardView) itemView.findViewById(R.id.adapter_show_user_item_cv);
      relativeLayoutNoMoreItem = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_no_more_cv);
      textViewNoMoreMessage = (TextView) itemView.findViewById(R.id.adapter_show_user_no_more_tv);
      shinImageView = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin);
      imageView = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load);
      relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl);

      shinImageView2 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin2);
      imageView2 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load2);
      relativeLayout2 = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl2);

      shinImageView3 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin3);
      imageView3 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load3);
      relativeLayout3 = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl3);

      shinImageView4 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin4);
      imageView4 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load4);
      relativeLayout4 = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl4);
    }

    @Override
    protected void clear() {
    }

    public void onBind(int position) {
      super.onBind(position);
      Log.i("TAN","Size: "+String.valueOf(suggestedItemsList.size()));
      int a=suggestedItemsList.size()-1, x = 0,mod=0;
      if (9 == suggestedItemsList.size())
      {
        x= 0;
        mod = 0;
      }else{
        x= a/8;
        mod = a % 8;
      }
      if (suggestedItemsList.size() ==1)
      {
        cardView.setVisibility(View.GONE);
        relativeLayoutNoMoreItem.setVisibility(View.GONE);
      }else {
        if(mod>0)
        {
          cardView.setVisibility(View.GONE);
          relativeLayoutNoMoreItem.setVisibility(View.VISIBLE);
          changeFont(textViewNoMoreMessage);
        }else {
          AddShineEffect(relativeLayout, shinImageView);
          AddShineEffect(relativeLayout2, shinImageView2);
          AddShineEffect(relativeLayout3, shinImageView3);
          AddShineEffect(relativeLayout4, shinImageView4);
        }
      }
    }
  }
  private void changeFont(TextView textView) {
    textView.setTypeface(Functions.changeFontGeneral(context));
  }
  String loadedOrDownloading="downloading";

  private void AddShineEffect(final RelativeLayout father, final ImageView child) {
    new Handler().postDelayed(new Runnable() {

      @Override
      public void run() {
        animationEffect(father,child);
        if (loadedOrDownloading.equals("downloading"))
          AddShineEffect(father,child);
      }
    }, 400);
  }

  private void animationEffect(RelativeLayout father, ImageView child) {
    Animation animation = new TranslateAnimation(0,
            father.getWidth()+child.getWidth(),0, 0);
    animation.setDuration(550);
    animation.setFillAfter(false);
    animation.setInterpolator(new AccelerateDecelerateInterpolator());
    child.startAnimation(animation);
  }

}