package edu.temple.transferapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

        Context context;
        ArrayList<String> items;
        ArrayList<Integer> pics;


    public ImageAdapter(Context context, ArrayList items, ArrayList pics){
            this.context = context;
            this.items = items;
            this.pics = pics;

        }


        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            //Pair<String, Integer> dogs = new Pair(items.get(position), pics.get(position));
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {

        RelativeLayout relativeLayout = new RelativeLayout(context);
            TextView textView = new TextView(context);
            ImageView pic = new ImageView(context);
            pic.setImageResource(pics.get(position));
            textView.setText(items.get(position));
        textView.setTextColor(Color.parseColor("#FFFFFF"));

        relativeLayout.addView(pic);
        RelativeLayout.LayoutParams prams=  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);
        prams.addRule(RelativeLayout.CENTER_IN_PARENT);
        pic.getLayoutParams().width = 350;
        pic.getLayoutParams().height = 350;
        textView.setLayoutParams(prams);


        relativeLayout.addView(textView);


        textView.setPadding(20,0,0,0);
        LinearLayout.LayoutParams paramsss = new LinearLayout.LayoutParams(5,5);
        //pic.setLayoutParams(paramss);

            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(25);
        textView.setText(items.get(position));




            return relativeLayout;
        }



    }
