package br.eti.nucleus.mude.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import br.eti.nucleus.mude.activitys.MainActivity;
import br.eti.nucleus.mude.R;

public class TenMeasures extends Fragment implements View.OnClickListener{

    public Button participate;
    public Button know_more;
    public Button download;
   /* private Bundle saved;
    private LayoutInflater layoutInflater;
    private ViewGroup viewGroup;*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = true;
        /*saved = savedInstanceState;
        layoutInflater = inflater;
        viewGroup = container;*/
        return inflater.inflate(R.layout.fragment_ten_measures,container,false);
    }

    private void listen_buttons(){
        participate = (Button) getActivity().findViewById(R.id.ten_measure_participate);
        if(participate!=null) {
            participate.setOnClickListener(this);
            know_more = (Button) getActivity().findViewById(R.id.ten_measure_know_more);
            if(know_more!=null) {
                know_more.setOnClickListener(this);
                download = (Button) getActivity().findViewById(R.id.ten_measure_download);
                if(download!=null){
                    download.setOnClickListener(this);
                }
            }
        }
    }

    private void set_title(){
        MainActivity.myToolbar.setTitle("Mude");
    }

    private void set_menu_button(){
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
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
        String url;

        switch (v.getId()){
            case R.id.ten_measure_know_more:
                f = new KnowMore();
                break;
            case R.id.ten_measure_download:
                url = "Deseja efetuar o download da ficha de assinatura?";
                DownloadConfirmation downloadConfirmation = DownloadConfirmation.newInstance(v.getId(),url);
                downloadConfirmation.show(getFragmentManager(),url);
                break;
        }

        if(f!=null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).addToBackStack(null).commit();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        populateViewForOrientation(inflater, (ViewGroup) getView());
    }

    private void populateViewForOrientation(LayoutInflater inflater, ViewGroup viewGroup) {
        viewGroup.removeAllViewsInLayout();
        View subview = inflater.inflate(R.layout.fragment_ten_measures, viewGroup);
        listen_buttons();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_ten_measures, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String url = "";
        switch (item.getItemId()){
            case R.id.menu_consulta_titulo:
                url = "http://www.tse.jus.br/eleitor/servicos/titulo-e-local-de-votacao/consulta-por-nome";
                break;
            case R.id.menu_unidades_mpf:
                url = "http://www.pgr.mpf.mp.br//conheca-o-mpf/procuradores-e-procuradorias/prs/";
                break;
            case R.id.menu_pontos_coleta:
                url = "http://www.combateacorrupcao.mpf.mp.br/10-medidas/docs/outros_pontos_coleta.pdf";
                break;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}