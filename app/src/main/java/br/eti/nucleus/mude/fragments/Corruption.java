package br.eti.nucleus.mude.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.eti.nucleus.mude.R;
import br.eti.nucleus.mude.activitys.MainActivity;

public class Corruption extends Fragment implements View.OnClickListener{

    private Button corruptionType;
    private Button mpfOperations;

    private void listen_buttons(){
        corruptionType = (Button) getActivity().findViewById(R.id.corruption_about);
        if(corruptionType!=null) {
            corruptionType.setOnClickListener(this);
            mpfOperations = (Button) getActivity().findViewById(R.id.corruption_1_about);
            if(mpfOperations!=null)
                mpfOperations.setOnClickListener(this);
        }
    }

    private void set_title(){
        MainActivity.myToolbar.setTitle("Corrupção");
    }

    private void set_menu_button(){
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = true;
        return inflater.inflate(R.layout.fragment_corruption,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_corruption, menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        set_title();
        listen_buttons();
        set_menu_button();
    }

    @Override
    public void onClick(View v) {
        Fragment f = null;

        switch (v.getId()){
            case R.id.corruption_about:
                f = new CorruptionTypes();
                break;
            case R.id.corruption_1_about:
                f = new MPFOperations();
                break;
        }

        if(f!=null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).addToBackStack(null).commit();
    }
}
