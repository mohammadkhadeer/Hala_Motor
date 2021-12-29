package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cars.halamotor_obeidat.R;

public class FragmentShare extends Fragment {

    public FragmentShare(){}

    String test;
    View view;
    String Facebook ="com.facebook.katana"
            ,Twitter = "com.twitter.android"
            ,Instagram = "com.instagram.android"
            ,sms = "vnd.android-dir/mms-sms"
            ,whats = "com.whatsapp"
            ,messageShare;
    RelativeLayout fb_RL,twitter_RL,whatsApp_RL,messages_RL,email_RL;
    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            test = getArguments().getString("category");
        }
        messageShare = "Text well share here";
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_selected_share, container, false);
//        Log.i("TAG",test);
        inti();
        actionListener();
        return view;
    }

    private void actionListener() {
        fb_RL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(Facebook);
            }
        });

        whatsApp_RL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(whats);
            }
        });
        twitter_RL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(Twitter);
            }
        });
        messages_RL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareSMS();
            }
        });
        email_RL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareEmail();
            }
        });
    }


    private void share(String application) {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage(application);
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, messageShare);
        try {
            getActivity().startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            //ToastHelper.MakeShortText("Whatsapp have not been installed.");
        }
    }

    private void shareSMS() {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra(Intent.EXTRA_TEXT, messageShare);
        try {
            getActivity().startActivity(smsIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            //ToastHelper.MakeShortText("Whatsapp have not been installed.");
        }
    }

    private void shareEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","", null));
        emailIntent.putExtra(Intent.EXTRA_TEXT, messageShare);
        startActivity(Intent.createChooser(emailIntent, "Send Email..."));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void inti() {
        fb_RL = (RelativeLayout) view.findViewById(R.id.share_fb_RL);
        twitter_RL = (RelativeLayout) view.findViewById(R.id.share_t_RL);
        whatsApp_RL = (RelativeLayout) view.findViewById(R.id.share_wa_RL);
        messages_RL = (RelativeLayout) view.findViewById(R.id.share_m_RL);
        email_RL = (RelativeLayout) view.findViewById(R.id.share_email_RL);
    }
}
