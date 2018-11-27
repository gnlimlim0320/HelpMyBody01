package com.example.dlarb.helpmybody01.ImageAdpater;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dlarb.helpmybody01.R;

public class ImageAdapter_leg extends ArrayAdapter<String> {
    public ImageAdapter_leg(Context context, String[] items) {
        super(context, R.layout.bodypart_image_layout, items);
    }

    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        final Integer[] images = {R.drawable._leg1,R.drawable._leg2,R.drawable._leg3,R.drawable._leg4,R.drawable._leg5,R.drawable._leg6};
        LayoutInflater imageinflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View view = imageinflater.inflate(R.layout.bodypart_image_layout, parent, false);
        String item = getItem(position);
        TextView textView = (TextView) view.findViewById(R.id.textView2);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
        textView.setText(item);
        imageView.getLayoutParams().width=800;
        imageView.requestLayout();
        imageView.setImageResource(images[position]);
        return view;
    }
}

