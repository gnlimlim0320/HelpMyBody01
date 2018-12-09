package com.example.dlarb.helpmybody01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends ArrayAdapter<String> { // youtube 메뉴에서 각 listview에 이미지를 첨부해주기 위한 클래스
    public ImageAdapter(Context context, String[] items) {
        super(context, R.layout.bodypart_image_layout, items);
    }

    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        final Integer[] images = {R.drawable.waist, R.drawable.neck, R.drawable.wrist, R.drawable.arm,R.drawable.leg,R.drawable.all};
        LayoutInflater imageinflater = LayoutInflater.from(getContext());
        View view = imageinflater.inflate(R.layout.bodypart_image_layout, parent, false);
        String item = getItem(position);
        TextView textView = (TextView) view.findViewById(R.id.textView2);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
        textView.setText(item);
        imageView.setImageResource(images[position]);
        return view;
    }
}

