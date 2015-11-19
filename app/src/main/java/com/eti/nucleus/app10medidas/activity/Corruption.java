package com.eti.nucleus.app10medidas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.modules.DrawerNavigator;
import com.eti.nucleus.app10medidas.modules.MyToolbar;
import com.mikepenz.materialdrawer.Drawer;

public class Corruption extends AppCompatActivity {

    public Toolbar myToolbar;
    public Drawer result;

    private void start_toolbar() {
        MyToolbar toolbar = new MyToolbar(Corruption.this,R.string.corruption);
        myToolbar =  toolbar.createToolbar();
    }

    private void start_navigator_drawer() {
        DrawerNavigator drawerNavigator = new DrawerNavigator(Corruption.this,myToolbar);
        result = drawerNavigator.createDrawerNavigator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corruption);
        start_toolbar();
        start_navigator_drawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_corruption, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
