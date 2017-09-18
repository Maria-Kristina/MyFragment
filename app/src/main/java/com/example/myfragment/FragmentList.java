package com.example.myfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User1 on 23.8.2017.
 */

public class FragmentList extends ListFragment {
    private List<President> presidentList; //fragmentin oma presidenttilista
    private FragmentDetail fragmentDetail;

    public FragmentList (){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);

        fragmentDetail = new FragmentDetail();
        presidentList = new ArrayList<>();
        makePresidents();
        ArrayAdapter<President> adapter = new ArrayAdapter<President>(
                getActivity(),
                android.R.layout.simple_list_item_1, presidentList);
        setListAdapter(adapter);


        return view;
    }


    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        President itemValue = (President) listView.getItemAtPosition(position);
        String info = itemValue.lastName + ", "
                + itemValue.firstName + " "
                + itemValue.aloitusVuosi + " "
                + itemValue.lopetusVuosi + "\n"
                + itemValue.detail;


        FragmentTransaction fragmentTransaction =
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, fragmentDetail);

        Bundle args = new Bundle();
        args.putString("YourKey", info);
        fragmentDetail.setArguments(args);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void makePresidents (){
        presidentList.add(new President("K. J.","Ståhlberg",1919,1925,"Esihistoriaa"));
        presidentList.add(new President("Lauri Kristian","Relander",1925,1931,"Kuka tietää"));
        presidentList.add(new President("P. E.","Svinhufvud",1931,1937,"Varmasti jokaiselle tuttu"));
        presidentList.add(new President("Kyösti","Kallio",1937,1940,"Kova jätkä"));
        presidentList.add(new President("Risto","Ryti",1940,1944,"Vielä kovempi jätkä"));
        presidentList.add(new President("Gustaf","Mannerheim",1944,1946,"Patsas, junou"));
        presidentList.add(new President("J. K.","Paasikivi",1946,1956,"Kivinen tyyppi"));
        presidentList.add(new President("Urho","Kekkonen",1956,1982,"isoisosetä!"));
        presidentList.add(new President("Mauno","Koivisto",1982,1994,"Vai Männikkö, heh heh"));
        presidentList.add(new President("Martti","Ahtisaari",1994,2000,"Nobel voittaja"));
        presidentList.add(new President("Tarja","Halonen",2000,2012,"Setan entinen puheenjohtaja!"));
        presidentList.add(new President("Sauli","Niinistö",2012,2018,"Nykyinen"));

    }
}
