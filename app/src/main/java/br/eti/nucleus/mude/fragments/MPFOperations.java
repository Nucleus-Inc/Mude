package br.eti.nucleus.mude.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.eti.nucleus.mude.R;
import br.eti.nucleus.mude.activitys.MainActivity;

public class MPFOperations extends Fragment implements View.OnClickListener{

    private ImageView zelotes;
    private ImageView lavaJato;
    private ImageView bancoSantos;
    private ImageView sanguessuga;
    private ImageView sudam;
    private ImageView mensalao;
    private ImageView carlinhosCachoeira;
    private ImageView banestado;
    private ImageView anaconda;
    private ImageView luizEstevao;
    private ImageView scuderie;
    private ImageView jorginaFreitas;

    private void listen_clickeds() {
        zelotes = (ImageView) getActivity().findViewById(R.id.mpf_zelotes);
        if(zelotes!=null){
            zelotes.setOnClickListener(this);
            lavaJato = (ImageView) getActivity().findViewById(R.id.mpf_lavaJato);
            if(lavaJato!=null){
                lavaJato.setOnClickListener(this);
                bancoSantos = (ImageView) getActivity().findViewById(R.id.mpf_bancoSantos);
                if(bancoSantos!=null) {
                    bancoSantos.setOnClickListener(this);
                    sanguessuga = (ImageView) getActivity().findViewById(R.id.mpf_sanguessuga);
                    if (sanguessuga != null) {
                        sanguessuga.setOnClickListener(this);
                        sudam = (ImageView) getActivity().findViewById(R.id.mpf_sudam);
                        if (sudam != null) {
                            sudam.setOnClickListener(this);
                            mensalao = (ImageView) getActivity().findViewById(R.id.mpf_mensalao);
                            if (mensalao != null) {
                                mensalao.setOnClickListener(this);
                                carlinhosCachoeira = (ImageView) getActivity().findViewById(R.id.mpf_carlinhosCachoeira);
                                if (carlinhosCachoeira != null) {
                                    carlinhosCachoeira.setOnClickListener(this);
                                    banestado = (ImageView) getActivity().findViewById(R.id.mpf_banestado);
                                    if (banestado != null) {
                                        banestado.setOnClickListener(this);
                                        anaconda = (ImageView) getActivity().findViewById(R.id.mpf_operacaoAnaconda);
                                        if (anaconda != null) {
                                            anaconda.setOnClickListener(this);
                                            luizEstevao = (ImageView) getActivity().findViewById(R.id.mpf_luizEstevao);
                                            if (luizEstevao != null) {
                                                luizEstevao.setOnClickListener(this);
                                                scuderie = (ImageView) getActivity().findViewById(R.id.mpf_scuderie);
                                                if (scuderie != null) {
                                                    scuderie.setOnClickListener(this);
                                                    jorginaFreitas = (ImageView) getActivity().findViewById(R.id.mpf_jorgina);
                                                    if (jorginaFreitas != null) {
                                                        jorginaFreitas.setOnClickListener(this);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void set_title(){
        MainActivity.myToolbar.setTitle("Corrupção");
    }

    private void set_menu_button(){
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
    }

    @Override
    public void onResume() {
        super.onResume();
        set_title();
        set_menu_button();
        listen_clickeds();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = false;
        return inflater.inflate(R.layout.fragment_corruption_mpf_operation,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_mpf_operations,menu);
    }

    @Override
    public void onClick(View v) {
        Fragment f = null;

        switch (v.getId()){
            case R.id.mpf_bancoSantos:
                f = new BancoSantos();
                break;
            case R.id.mpf_banestado:
                f = new Banestado();
                break;
            case R.id.mpf_zelotes:
                f = new Zelotes();
                break;
            case R.id.mpf_carlinhosCachoeira:
                f = new CarlinhosCachoeira();
                break;
            case R.id.mpf_jorgina:
                f = new Jorgina();
                break;
            case R.id.mpf_lavaJato:
                f = new LavaJato();
                break;
            case R.id.mpf_luizEstevao:
                f = new LuizEstevao();
                break;
            case R.id.mpf_mensalao:
                f = new Mensalao();
                break;
            case R.id.mpf_operacaoAnaconda:
                f = new OperacaoAnaconda();
                break;
            case R.id.mpf_sanguessuga:
                f = new Sanguessuga();
                break;
            case R.id.mpf_scuderie:
                f = new Scuderie();
                break;
            case R.id.mpf_sudam:
                f = new Sudam();
                break;
        }

        if(f!=null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).addToBackStack(null).commit();
    }
}
