package com.eti.nucleus.app10medidas.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.fragments.TenMeasures;
import com.eti.nucleus.app10medidas.modules.DrawerNavigator;
import com.eti.nucleus.app10medidas.modules.MyToolbar;
import com.mikepenz.materialdrawer.Drawer;

public class MainActivity extends AppCompatActivity {

    public static Toolbar myToolbar;
    public Drawer result;

    private void start_toolbar() {
        MyToolbar toolbar = new MyToolbar(MainActivity.this,R.string.tenMeasures);
        myToolbar =  toolbar.createToolbar();
    }

    private void start_navigator_drawer() {
        DrawerNavigator drawerNavigator = new DrawerNavigator(MainActivity.this,myToolbar);
        result = drawerNavigator.createDrawerNavigator();
    }

    private void start_fragment(Bundle savedInstanceState){
        if(savedInstanceState==null){
            Fragment f = new TenMeasures();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_fragment(savedInstanceState);
        start_toolbar();
        start_navigator_drawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}