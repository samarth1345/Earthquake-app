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

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import android.graphics.drawable.GradientDrawable;

public class Adapter extends ArrayAdapter<news> {


    public Adapter(@NonNull Context context, int resource, @NonNull List<news> objects) {
        super(context, 0, objects);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View currentview = convertView;
        if (currentview == null) {
            currentview = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_layout, parent, false);
        }
        news currentquake = getItem(position);

        TextView currentplace = (TextView) currentview.findViewById(R.id.place);
        String place = currentquake.getPlace();
        //spliting received place into two halves for better readability
        if (place.contains(" of ")) {
            String[] parts = place.split(" of ");
            currentplace.setText(parts[0] + " of" + "\n" + parts[1]);
        }

        Date date = new Date(currentquake.getTime());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(date);

        SimpleDateFormat timeformatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeformatter.format(date);

        TextView currentDate = (TextView) currentview.findViewById(R.id.date);
        currentDate.setText(dateToDisplay + "\n" + timeToDisplay);

        TextView currentmag = (TextView) currentview.findViewById(R.id.magnitude);
        double magnitude=currentquake.getMagnitude();
        GradientDrawable magnitudeCircle = (GradientDrawable) currentmag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getcolor(magnitude);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        currentmag.setText(magnitude+"");


        return currentview;
    }
    //different color coding for different magnitudes
    public int getcolor(Double magnitude)
    {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch(magnitudeFloor)
        {
            case 0:
                magnitudeColorResourceId= android.R.color.darker_gray;
                break;
            case 1:
                magnitudeColorResourceId=R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId=R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId=R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId=R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId=R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId=R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId=R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId=R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId=R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId=R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
