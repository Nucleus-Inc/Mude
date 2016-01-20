package br.eti.nucleus.mude.fragments;

import android.content.Context;
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

public class CorruptionTypes extends Fragment implements View.OnClickListener{

    private LinearLayout traficoInfluencia;
    private LinearLayout advocaciaAdm;
    private LinearLayout crimeLicitacao;
    private LinearLayout corrupcaoEleitoral;
    private LinearLayout concussao;
    private LinearLayout corAtivaTranComeExterior;
    private LinearLayout modfSistemaInformacao;
    private LinearLayout condCriminosa;
    private LinearLayout dadosFalsos;
    private LinearLayout peculato;
    private LinearLayout crimesParlamentares;
    private LinearLayout empregoIrregular;
    private LinearLayout ativa;
    private LinearLayout improbAdm;
    private LinearLayout contrabando;
    private LinearLayout passiva;
    private LinearLayout violacaoSigilo;
    private LinearLayout prevaricacao;

    private void listen_clickeds(){
        traficoInfluencia = (LinearLayout) getActivity().findViewById(R.id.layout_corTraficoInfluencia);
        if(traficoInfluencia!=null){
            traficoInfluencia.setOnClickListener(this);
            advocaciaAdm = (LinearLayout) getActivity().findViewById(R.id.layout_corAdvocaciaAdm);
            if(advocaciaAdm!=null){
                advocaciaAdm.setOnClickListener(this);
                crimeLicitacao = (LinearLayout) getActivity().findViewById(R.id.layout_corLeiDeLicitacao);
                if(crimeLicitacao!=null){
                    crimeLicitacao.setOnClickListener(this);
                    corrupcaoEleitoral = (LinearLayout) getActivity().findViewById(R.id.layout_corEleitoral);
                    if(corrupcaoEleitoral!=null){
                        corrupcaoEleitoral.setOnClickListener(this);
                        concussao = (LinearLayout) getActivity().findViewById(R.id.layout_corConcussao);
                        if(concussao!=null){
                            concussao.setOnClickListener(this);
                            corAtivaTranComeExterior = (LinearLayout) getActivity().findViewById(R.id.layout_corAtiva);
                            if(corAtivaTranComeExterior!=null){
                                corAtivaTranComeExterior.setOnClickListener(this);
                                modfSistemaInformacao = (LinearLayout) getActivity().findViewById(R.id.layout_corSistemaInformacao);
                                if(modfSistemaInformacao!=null){
                                    modfSistemaInformacao.setOnClickListener(this);
                                    condCriminosa = (LinearLayout) getActivity().findViewById(R.id.layout_corCondescencia);
                                    if(condCriminosa!=null){
                                        condCriminosa.setOnClickListener(this);
                                        dadosFalsos = (LinearLayout) getActivity().findViewById(R.id.layout_corDadosFalsos);
                                        if(dadosFalsos!=null){
                                            dadosFalsos.setOnClickListener(this);
                                            peculato = (LinearLayout) getActivity().findViewById(R.id.layout_corPeculato);
                                            if(peculato!=null){
                                                peculato.setOnClickListener(this);
                                                crimesParlamentares = (LinearLayout) getActivity().findViewById(R.id.layout_corPrefeitoVereador);
                                                if(crimesParlamentares!=null){
                                                    crimesParlamentares.setOnClickListener(this);
                                                    empregoIrregular = (LinearLayout) getActivity().findViewById(R.id.layout_corEmpregoIrregular);
                                                    if(empregoIrregular!=null){
                                                        empregoIrregular.setOnClickListener(this);
                                                        ativa = (LinearLayout) getActivity().findViewById(R.id.layout_corCorrupção_ativa);
                                                        if(ativa!=null){
                                                            ativa.setOnClickListener(this);
                                                            improbAdm = (LinearLayout) getActivity().findViewById(R.id.layout_corImproAdm);
                                                            if(improbAdm!=null){
                                                                improbAdm.setOnClickListener(this);
                                                                contrabando = (LinearLayout) getActivity().findViewById(R.id.layout_corContrabando);
                                                                if(contrabando!=null){
                                                                    contrabando.setOnClickListener(this);
                                                                    passiva = (LinearLayout) getActivity().findViewById(R.id.layout_corPassiva);
                                                                    if(passiva!=null){
                                                                        passiva.setOnClickListener(this);
                                                                        violacaoSigilo = (LinearLayout) getActivity().findViewById(R.id.layout_corViolacaoSigilo);
                                                                        if(violacaoSigilo!=null){
                                                                            violacaoSigilo.setOnClickListener(this);
                                                                            prevaricacao = (LinearLayout) getActivity().findViewById(R.id.layout_corPrevaricacao);
                                                                            if(prevaricacao!=null){
                                                                                prevaricacao.setOnClickListener(this);
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
        listen_clickeds();
        set_menu_button();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = false;
        return inflater.inflate(R.layout.fragment_corruption_types,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_corruption_types,menu);
    }

    @Override
    public void onClick(View v) {
        Fragment f = null;

        switch (v.getId()){
            case R.id.layout_corAdvocaciaAdm:
                f = new AdvocaciaAdm();
                break;
            case R.id.layout_corAtiva:
                f = new CorrupcaoAtivaExterior();
                break;
            case R.id.layout_corConcussao:
                f = new Concussao();
                break;
            case R.id.layout_corCondescencia:
                f = new Condescencia();
                break;
            case R.id.layout_corContrabando:
                f = new Contrabando();
                break;
            case R.id.layout_corCorrupção_ativa:
                f = new CorrupcaoAtiva();
                break;
            case R.id.layout_corDadosFalsos:
                f = new DadosFalsos();
                break;
            case R.id.layout_corEleitoral:
                f = new CrimeEleitoral();
                break;
            case R.id.layout_corEmpregoIrregular:
                f = new EmpregoIrregularVerbas();
                break;
            case R.id.layout_corImproAdm:
                f = new ImprobabilidadeAdm();
                break;
            case R.id.layout_corLeiDeLicitacao:
                f = new LeiDeLicitacao();
                break;
            case R.id.layout_corPassiva:
                f = new CorrupcaoPassiva();
                break;
            case R.id.layout_corPeculato:
                f = new Peculato();
                break;
            case R.id.layout_corPrefeitoVereador:
                f = new CorrupcaoParlamentar();
                break;
            case R.id.layout_corPrevaricacao:
                f = new Prevaricacao();
                break;
            case R.id.layout_corSistemaInformacao:
                f = new SistemaInformacao();
                break;
            case R.id.layout_corTraficoInfluencia:
                f = new TraficoInfluencia();
                break;
            case R.id.layout_corViolacaoSigilo:
                f = new ViolacaoSigilo();
                break;
        }

        if(f!=null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).addToBackStack(null).commit();
    }
}
