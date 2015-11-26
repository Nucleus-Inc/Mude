package com.eti.nucleus.app10medidas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.activity.MainActivity;

public class News extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = true;
        return inflater.inflate(R.layout.fragment_news,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.myToolbar.setTitle(R.string.news);
    }
}
