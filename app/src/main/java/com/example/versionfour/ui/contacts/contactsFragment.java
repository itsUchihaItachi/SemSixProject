package com.example.versionfour.ui.contacts;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.versionfour.R;

public class contactsFragment extends Fragment {

    ListView contactlistView;
    String[] mTitle =
            {"Dean","Hos","Hod","Office","Programme head","Lab head","Exam Co-ordinator"};
    String[] mDescription =
            {"1234567890", "1472583690", "3692581470", "7894561230", "1478520369","9812348756","9812348756"};
    int[] images =
            {R.drawable.contact1,R.drawable.contact1,R.drawable.contact1,R.drawable.contact1,R.drawable.contact1,R.drawable.contact1,R.drawable.contact1};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

        contactlistView = root.findViewById(R.id.contactListView);
        MyAdapter contactAdapter = new MyAdapter(getContext(), mTitle, mDescription, images);
        contactlistView.setAdapter(contactAdapter);

        contactlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Uri u= Uri.parse("tel:"+mDescription[position]);
                Intent i=new Intent(Intent.ACTION_DIAL,u);
                startActivity(i);
                /*if(position == 0){
                    Toast.makeText(getContext() ,"Dean Som", Toast.LENGTH_SHORT).show();
                    Uri u= Uri.parse("tel:"+mDescription[position]);
                    Intent i=new Intent(Intent.ACTION_DIAL,u);
                    startActivity(i);
                }

                if(position == 1){
                    Toast.makeText(getContext() ,"HoS Som", Toast.LENGTH_SHORT).show();
                    Uri u= Uri.parse("tel:"+mDescription[position]);
                    Intent i=new Intent(Intent.ACTION_DIAL,u);
                    startActivity(i);
                }

                if(position == 2){
                    Toast.makeText(getContext() ,"HoD Som", Toast.LENGTH_SHORT).show();
                    Uri u= Uri.parse("tel:"+mDescription[position]);
                    Intent i=new Intent(Intent.ACTION_DIAL,u);
                    startActivity(i);
                }

                if(position == 3){
                    Toast.makeText(getContext() ,"Office Som", Toast.LENGTH_SHORT).show();
                    Uri u= Uri.parse("tel:"+mDescription[position]);
                    Intent i=new Intent(Intent.ACTION_DIAL,u);
                    startActivity(i);
                }

                if(position == 4){
                    Toast.makeText(getContext() ,"program Som", Toast.LENGTH_SHORT).show();
                    Uri u= Uri.parse("tel:"+mDescription[position]);
                    Intent i=new Intent(Intent.ACTION_DIAL,u);
                    startActivity(i);
                }
                if(position == 5){
                    Toast.makeText(getContext() ,"Lab head", Toast.LENGTH_SHORT).show();
                }
                if(position == 6){
                    Toast.makeText(getContext() ,"Exam co-ordinator", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

        return root;
    }

    private class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        String[] description;
        int[] img;

        public MyAdapter(Context contactsFragment, String[] title, String[] desc, int[] imgs) {
            super( contactsFragment,R.layout.contact_row, R.id.contactMainText,title);
            this.context=contactsFragment;
            this.rTitle =title;
            this.description = desc;
            this.img = imgs;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater contactlayoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View contactRow = contactlayoutInflater.inflate(R.layout.contact_row, parent, false);
            ImageView imageView = contactRow.findViewById(R.id.contactIcon);
            TextView myTitle = contactRow.findViewById(R.id.contactMainText);
            TextView myDesc = contactRow.findViewById(R.id.contactSubText);

            imageView.setImageResource(img[position]);
            myTitle.setText(rTitle[position]);
            myDesc.setText(description[position]);

            return contactRow;
        }
    }
}
