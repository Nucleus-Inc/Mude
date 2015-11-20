package com.eti.nucleus.app10medidas.modules;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.fragments.About;
import com.eti.nucleus.app10medidas.fragments.Corruption;
import com.eti.nucleus.app10medidas.fragments.Downloads;
import com.eti.nucleus.app10medidas.fragments.Multimedia;
import com.eti.nucleus.app10medidas.fragments.News;
import com.eti.nucleus.app10medidas.fragments.TenMeasures;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.RecyclerViewCacheUtil;

public class DrawerNavigator{

    private AppCompatActivity activity;
    public Toolbar myToolbar;

    public DrawerNavigator(AppCompatActivity activity,Toolbar myToolbar) {
        this.activity = activity;
        this.myToolbar = myToolbar;
    }

    public Drawer createDrawerNavigator(){

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.drawable.logompf)
                .build();

        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(myToolbar)
                .withSelectedItem(-1)
                .withAccountHeader(headerResult)
                .withTranslucentStatusBar(false)
                .withHasStableIds(true)
                .addDrawerItems(
                        new SecondaryDrawerItem().withName(R.string.tenMeasures).withIcon(R.mipmap.ic_action_done).withIdentifier(1).withSelectable(false),
                        new SecondaryDrawerItem().withName(R.string.corruption).withIcon(R.mipmap.ic_notifications_off).withIdentifier(2).withSelectable(false),
                        new SecondaryDrawerItem().withName(R.string.download).withIcon(R.mipmap.ic_file_download).withIdentifier(3).withSelectable(false),
                        new SecondaryDrawerItem().withName(R.string.multimedia).withIcon(R.mipmap.ic_perm_media).withIdentifier(4).withSelectable(false),
                        new SecondaryDrawerItem().withName(R.string.news).withIcon(R.mipmap.ic_today).withIdentifier(5).withSelectable(false),
                        new SecondaryDrawerItem().withName(R.string.about).withIcon(R.mipmap.ic_info_outline).withIdentifier(6).withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {

                        Fragment f = null;

                        if (iDrawerItem != null) {
                            switch (iDrawerItem.getIdentifier()) {
                                case 1:
                                    f = new TenMeasures();
                                    break;
                                case 2:
                                    f = new Corruption();
                                    break;
                                case 3:
                                    f = new Downloads();
                                    break;
                                case 4:
                                    f = new Multimedia();
                                    break;
                                case 5:
                                    f = new News();
                                    break;
                                case 6:
                                    f = new About();
                                    break;
                            }
                        }

                        if(f!=null)
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

                        return false;
                    }
                })
                .build();

        RecyclerViewCacheUtil.getInstance().withCacheSize(2).init(result);

        return result;
    }
}
