package com.eti.nucleus.app10medidas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.activity.MainActivity;
import com.eti.nucleus.app10medidas.modules.MyToolbar;

public class KnowMore extends Fragment{

    @Override
    public void onAttach(Context context) {
        MainActivity.myToolbar.setTitle("Saiba Mais");
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = false;
        return inflater.inflate(R.layout.fragment_ten_measures_know_more,container,false);
    }

}
