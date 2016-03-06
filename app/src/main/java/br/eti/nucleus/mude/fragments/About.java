package br.eti.nucleus.mude.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.eti.nucleus.mude.R;
import br.eti.nucleus.mude.activitys.MainActivity;

public class About extends Fragment implements View.OnClickListener{

    LinearLayout viewPage;
    LinearLayout likeFanPage;
    LinearLayout mpf;
    LinearLayout ifc;
    LinearLayout materialDrawer;
    LinearLayout nucleus;

    private void listen_clickeds() {
        viewPage = (LinearLayout) getActivity().findViewById(R.id.mude_id_app_layout);
        if(viewPage!=null){
            viewPage.setOnClickListener(this);
            likeFanPage = (LinearLayout) getActivity().findViewById(R.id.mude_id_app_layout_2);
            if(likeFanPage!=null) {
                likeFanPage.setOnClickListener(this);
                mpf = (LinearLayout) getActivity().findViewById(R.id.mude_id_app_layout_3);
                if (mpf != null) {
                    mpf.setOnClickListener(this);
                    ifc = (LinearLayout) getActivity().findViewById(R.id.mude_id_app_layout_4);
                    if(ifc!=null){
                        ifc.setOnClickListener(this);
                        materialDrawer = (LinearLayout) getActivity().findViewById(R.id.mude_id_app_layout_6);
                        if(materialDrawer!=null) {
                            materialDrawer.setOnClickListener(this);
                            nucleus = (LinearLayout) getActivity().findViewById(R.id.mude_id_app_layout_5);
                            if(nucleus!=null)
                                nucleus.setOnClickListener(this);
                        }
                    }
                }
            }
        }
    }

    private void set_title(){
        MainActivity.myToolbar.setTitle("Sobre");
    }

    private void set_menu_button(){
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = true;
        return inflater.inflate(R.layout.fragment_about,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        set_title();
        set_menu_button();
        listen_clickeds();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_know_more,menu);
    }

    @Override
    public void onClick(View v) {

        String url = "";

        switch (v.getId()){
            case R.id.mude_id_app_layout:
                url = "http://www.combateacorrupcao.mpf.mp.br/10-medidas";
                break;
            case R.id.mude_id_app_layout_2:
                url = "https://www.facebook.com/10medidaseuapoio/?fref=ts";
                break;
            case R.id.mude_id_app_layout_3:
                url = "http://www.mpf.mp.br/";
                break;
            case R.id.mude_id_app_layout_4:
                url = "http://www.ifce.edu.br/";
                break;
            case R.id.mude_id_app_layout_5:
                url = "http://nucleus.eti.br";
                break;
            case R.id.mude_id_app_layout_6:
               url = "http://mikepenz.github.io/MaterialDrawer/";
                break;
        }

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}
