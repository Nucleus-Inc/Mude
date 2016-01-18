package br.eti.nucleus.mude.modules;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import br.eti.nucleus.mude.R;

public class MyToolbar {

    private int id;
    public AppCompatActivity activity;

    public MyToolbar(AppCompatActivity activity,int id) {
        this.activity = activity;
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
