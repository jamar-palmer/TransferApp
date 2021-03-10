package edu.temple.transferapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        //linearLayout.getLayoutParams().height = 50;
        //params;
        //params.width =50;
            TextView textView = new TextView(context);
            ImageView pic = new ImageView(context);
        linearLayout.addView(textView);
        //linearLayout.addView(pic);
        //pic.getLayoutParams().height= 50;


        textView.setPadding(20,0,0,0);
            textView.setText(items.get(position));
            linearLayout.setBackground(context.getDrawable(pics.get(position)));
          //  pic.
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(25);
        textView.setText(items.get(position));


            return linearLayout;
        }



    }
