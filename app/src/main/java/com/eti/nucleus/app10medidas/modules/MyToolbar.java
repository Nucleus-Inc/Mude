package com.eti.nucleus.app10medidas.modules;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.eti.nucleus.app10medidas.R;

public class MyToolbar{

    private int id;
    public static AppCompatActivity activity;

    public MyToolbar(AppCompatActivity activity,int id) {
        MyToolbar.activity = activity;
        setId(id);
    }

    public Toolbar createToolbar(){
        Toolbar myToolbar = (Toolbar) activity.findViewById(R.id.my_toolbar);
        activity.setSupportActionBar(myToolbar);
        if(activity.getSupportActionBar()!=null) {
            activity.getSupportActionBar().setTitle(getId());
        }
        return myToolbar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
