package com.eti.nucleus.app10medidas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eti.nucleus.app10medidas.R;

/**
 * Created by Eduardo on 23/11/2015.
 */
public class Participate extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ten_measures_participate,container,false);
    }

}
