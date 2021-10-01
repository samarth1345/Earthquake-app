package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class Adapter extends ArrayAdapter<news> {


    public Adapter(@NonNull Context context, int resource, @NonNull List<news> objects) {
        super(context, 0, objects);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentview=convertView;
        if(currentview == null)
        {
            currentview = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_layout, parent, false);
        }
        news currentquake=getItem(position);

        TextView currentplace=(TextView)currentview.findViewById(R.id.place);
        currentplace.setText(currentquake.getPlace());

        Date date = new Date(currentquake.getTime());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(date);

        SimpleDateFormat timeformatter= new SimpleDateFormat("h:mm a");
        String timeToDisplay= timeformatter.format(date);

        TextView currentDate=(TextView)currentview.findViewById(R.id.date);
        currentDate.setText(dateToDisplay+"\n"+timeToDisplay);

        TextView currentmag=(TextView)currentview.findViewById(R.id.magnitude);
        currentmag.setText(currentquake.getMagnitude()+"");

        return currentview;
    }
}
