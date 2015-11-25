package com.eti.nucleus.app10medidas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.activity.MainActivity;
import com.eti.nucleus.app10medidas.modules.MyToolbar;

public class TenMeasures extends Fragment implements View.OnClickListener{

    public Button participate;
    public Button know_more;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MyToolbar.activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        MainActivity.result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ten_measures,container,false);
    }

    private void listen_buttons(){
        participate = (Button) getActivity().findViewById(R.id.ten_measure_participate);
        if(participate!=null) {
            participate.setOnClickListener(this);
            know_more = (Button) getActivity().findViewById(R.id.ten_measure_know_more);
            if(know_more!=null)
                know_more.setOnClickListener(this);
        }
    }

    private void set_title(){
        MainActivity.myToolbar.setTitle(R.string.tenMeasures);
    }

    @Override
    public void onResume() {
        super.onResume();
        set_title();
        listen_buttons();
    }

    @Override
    public void onClick(View v) {

        Fragment f = null;

        switch (v.getId()){
            case R.id.ten_measure_know_more:
                f = new KnowMore();
                break;
            case R.id.ten_measure_participate:
                f = new Participate();
                break;
        }

        if(f!=null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).addToBackStack(null).commit();

    }

}
