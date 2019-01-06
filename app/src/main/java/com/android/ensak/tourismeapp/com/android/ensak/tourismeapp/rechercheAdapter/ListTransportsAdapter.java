package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Transport;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ArtisanatActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.TransportActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ListTransportsAdapter extends ArrayAdapter<Transport> {
    ArrayList<Transport> transports;
    Context context;
    public ListTransportsAdapter( Context context, int resource, ArrayList<Transport> transports) {
        super(context, resource, transports);
        this.transports=transports;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_list_transports_adapter),parent,false);

        TextView textView=(TextView) convertView.findViewById(R.id.name_transport);
        textView.setText(transports.get(position).getType());
        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),TransportActivity.class);
                intent.putExtra("transport", transports.get(position));
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
