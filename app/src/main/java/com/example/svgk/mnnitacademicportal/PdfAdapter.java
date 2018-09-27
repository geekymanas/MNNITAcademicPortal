package com.example.svgk.mnnitacademicportal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class PdfAdapter extends ArrayAdapter<Pdf>
{
    private Activity activity;
    private int layoutResourceId;
    ArrayList<Pdf> data;
    private Pdf pdf;
    private static int count = -1;
    public PdfAdapter(Activity activity, int layoutResourceId, ArrayList<Pdf> data) {
        super(activity, layoutResourceId, data);

        this.activity=activity;
        this.layoutResourceId=layoutResourceId;
        this.data=data;

    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        PdfHolder holder=null;


        if(row==null)
        {

            LayoutInflater inflater=LayoutInflater.from(activity);

            row=inflater.inflate(layoutResourceId,parent,false);

            holder=new PdfHolder();

            holder.textViewName= (TextView) row.findViewById(R.id.textViewName);
            holder.textViewUrl= (TextView) row.findViewById(R.id.textViewUrl);

            row.setTag(holder);

        }
        else
        {
            holder= (PdfHolder) row.getTag();
        }

        pdf = data.get(position);
        holder.textViewName.setText((count++)+" "+pdf.getName());
        //holder.textViewUrl.setText(pdf.getUrl());

        return row;
    }


    class PdfHolder
    {

        TextView textViewName,textViewUrl;


    }

}

