package com.eti.nucleus.app10medidas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.activity.MainActivity;
import com.eti.nucleus.app10medidas.modules.MyToolbar;

public class KnowMore extends Fragment{

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity.result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
        MyToolbar.activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.i("Know More Class", "onAttach()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Know More Class", "onResume()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ten_measures_know_more,container,false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Know More Class", "onDestroy()");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.i("Know More Class", "onOptionsItemSelected()");
            default:
                return true;
        }
    }

}
