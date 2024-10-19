package com.example.hf4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context; // Javítottam az Activity-ről Context-re
    private Integer[] imageArray;
    private String[] nameArray;
    private String[] infoArray;
    private final String[] buyArray;
    private final String[] sellArray;

    public CustomAdapter(@NonNull Context context, String[] names,
                         String[] infos, Integer[] images,String[] buyArray, String[] sellArray) {
        super(context, R.layout.listview_row, names);
        this.context = context;  // Itt már nem kell castolni Activity-re
        this.nameArray = names;
        this.infoArray = infos;
        this.imageArray = images;
        this.buyArray = buyArray;
        this.sellArray = sellArray;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Ellenőrizzük, hogy a convertView újrahasznosítható-e, ha nem, akkor inflálunk újat
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.listview_row, parent, false);
        }



        // Adatok összekapcsolása a listview_row nézet elemeivel
        TextView name = view.findViewById(R.id.name);
        TextView info = view.findViewById(R.id.info);
        ImageView image = view.findViewById(R.id.imageView);
        TextView text3 = view.findViewById(R.id.textView3);
        TextView text4 = view.findViewById(R.id.textView4);



        // A megfelelő értékek beállítása a pozíciónak megfelelően
        name.setText(nameArray[position]);
        info.setText(infoArray[position]);
        image.setImageResource(imageArray[position]);
        text3.setText(buyArray[position]);
        text4.setText(sellArray[position]);


        return view;
    }
}
