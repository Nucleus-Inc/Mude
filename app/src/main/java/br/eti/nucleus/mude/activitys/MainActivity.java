package br.eti.nucleus.mude.activitys;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import br.eti.nucleus.mude.R;
import br.eti.nucleus.mude.fragments.About;
import br.eti.nucleus.mude.fragments.CarlinhosCachoeira;
import br.eti.nucleus.mude.fragments.Corruption;
import br.eti.nucleus.mude.fragments.Downloads;
import br.eti.nucleus.mude.fragments.LuizEstevao;
import br.eti.nucleus.mude.fragments.Mensalao;
import br.eti.nucleus.mude.fragments.Multimedia;
import br.eti.nucleus.mude.fragments.News;
import br.eti.nucleus.mude.fragments.Sanguessuga;
import br.eti.nucleus.mude.fragments.TenMeasures;
import br.eti.nucleus.mude.modules.MyToolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static Toolbar myToolbar;
    public static ActionBar actionBar;
    public static boolean isOpenDrawer = true;
    public DrawerLayout drawerLayout;

    private void set_display_home_button(){
        setSupportActionBar(myToolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void start_toolbar(int title) {
        MyToolbar toolbar = new MyToolbar(this,title);
        myToolbar =  toolbar.createToolbar();
        set_display_home_button();
    }

    private void start_navigator_drawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void start_fragment(){
        Fragment f = new TenMeasures();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null) {
            start_fragment();
        }
        start_toolbar(R.string.tenMeasures);
        start_navigator_drawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(isOpenDrawer)
                    drawerLayout.openDrawer(GravityCompat.START);
                else
                    onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        boolean flag = false;
        Fragment f = null;

        switch (item.getItemId()){

            case R.id.navigation_drawer_idea:
                item.setChecked(true);
                f = new TenMeasures();
                drawerLayout.closeDrawer(GravityCompat.START);
                flag = true;
                break;
            case R.id.navigation_drawer_fraud:
                item.setChecked(true);
                f = new Corruption();
                drawerLayout.closeDrawer(GravityCompat.START);
                flag = true;
                break;
            case R.id.navigation_drawer_download_2:
                item.setChecked(true);
                f = new Downloads();
                drawerLayout.closeDrawer(GravityCompat.START);
                flag = true;
                break;
            case R.id.navigation_drawer_picture:
                item.setChecked(true);
                f = new Multimedia();
                drawerLayout.closeDrawer(GravityCompat.START);
                flag = true;
                break;
            case R.id.navigation_drawer_news:
                item.setChecked(true);
                f = new News();
                drawerLayout.closeDrawer(GravityCompat.START);
                flag = true;
                break;
            case R.id.navigation_drawer_help:
                item.setChecked(true);
                f = new About();
                drawerLayout.closeDrawer(GravityCompat.START);
                flag = true;
                break;
        }

        if (f != null) {
            clearBackStack();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
        }

        return flag;
    }

    public void clearBackStack(){
        for(int i=0;i<getSupportFragmentManager().getBackStackEntryCount();i++){
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onBackPressed() {
        if(CarlinhosCachoeira.fullscreen) {
            CarlinhosCachoeira.player.setFullscreen(false);
        }else{
            if(LuizEstevao.fullscreen){
                LuizEstevao.player.setFullscreen(false);
            }else {
                if (Mensalao.fullscreen) {
                    Mensalao.player.setFullscreen(false);
                } else{
                    if (Sanguessuga.fullscreen) {
                        Sanguessuga.player.setFullscreen(false);
                    } else
                        super.onBackPressed();
                }

            }
        }

    }
}
