package com.example.myfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by M-K on 23.8.2017.
 */

public class FragmentDetail extends Fragment {

    public FragmentDetail (){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        TextView detailView = (TextView)view.findViewById(R.id.detailView);

        //getting the data from previous fragment:
        Bundle bundle = getArguments();
        if (bundle != null) {
            detailView.setText(bundle.getString("YourKey"));
        }

        return view;
    }
}
