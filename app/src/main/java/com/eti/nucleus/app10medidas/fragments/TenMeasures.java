package com.eti.nucleus.app10medidas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.activity.MainActivity;

public class TenMeasures extends Fragment {

    public Button participate;
    public Button know_more;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ten_measures,container,false);
    }

    /*private void listen_buttons(){
        participate = (Button) getActivity().findViewById(R.id.ten_measure_participate);
        participate.setOnClickListener(this);
        know_more = (Button) getActivity().findViewById(R.id.ten_measure_know_more);
        know_more.setOnClickListener(this);
    }*/

    private void set_title(){
        MainActivity.myToolbar.setTitle(R.string.tenMeasures);
    }

    @Override
    public void onResume() {
        super.onResume();
        set_title();
        //listen_buttons();
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ten_measure_know_more:
                Toast.makeText(getActivity(),"SAIBA MAIS",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ten_measure_participate:
                Toast.makeText(getActivity(),"PARTICIPE",Toast.LENGTH_SHORT).show();
                break;
        }
    }*/
}
