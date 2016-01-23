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

public class Downloads extends Fragment implements View.OnClickListener{

    LinearLayout list;
    LinearLayout letter;
    LinearLayout proposal;
    LinearLayout summary;
    LinearLayout supporter;
    LinearLayout banner;
    LinearLayout fliers;
    LinearLayout prism;
    LinearLayout poster;
    LinearLayout resume;
    LinearLayout outdoor;
    LinearLayout broadside;
    LinearLayout t_shirt;
    LinearLayout bannerInternet;

    private void listen_clickeds() {
        letter = (LinearLayout) getActivity().findViewById(R.id.download_id_app_layout);
        if(letter!=null){
            letter.setOnClickListener(this);
            proposal = (LinearLayout) getActivity().findViewById(R.id.download_id_app_layout_1);
            if(proposal!=null) {
                proposal.setOnClickListener(this);
                summary = (LinearLayout) getActivity().findViewById(R.id.download_id_app_layout_2);
                if (summary != null) {
                    summary.setOnClickListener(this);
                    supporter = (LinearLayout) getActivity().findViewById(R.id.download_id_app_layout_3);
                    if(supporter!=null){
                        supporter.setOnClickListener(this);
                        list = (LinearLayout) getActivity().findViewById(R.id.download_id_app_layout_4);
                        if(list!=null) {
                            list.setOnClickListener(this);
                            resume = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout);
                            if (resume != null) {
                                resume.setOnClickListener(this);
                                banner = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_1);
                                if (banner != null) {
                                    banner.setOnClickListener(this);
                                    prism = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_3);
                                    if (prism != null) {
                                        prism.setOnClickListener(this);
                                        fliers = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_4);
                                        if (fliers != null) {
                                            fliers.setOnClickListener(this);
                                            poster = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_5);
                                            if (poster != null) {
                                                poster.setOnClickListener(this);
                                                outdoor = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_6);
                                                if (outdoor != null) {
                                                    outdoor.setOnClickListener(this);
                                                    broadside = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_7);
                                                    if (broadside != null) {
                                                        broadside.setOnClickListener(this);
                                                        t_shirt = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_8);
                                                        if (t_shirt != null) {
                                                            t_shirt.setOnClickListener(this);
                                                            bannerInternet = (LinearLayout) getActivity().findViewById(R.id.download_1_id_app_layout_2);
                                                            if (bannerInternet != null) {
                                                                bannerInternet.setOnClickListener(this);
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
        MainActivity.myToolbar.setTitle("Download");
    }

    private void set_menu_button(){
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = true;
        return inflater.inflate(R.layout.fragment_downloads,container,false);
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
        inflater.inflate(R.menu.menu_know_more, menu);
    }

    @Override
    public void onClick(View v) {

        String url = "";

        switch (v.getId()){
            case R.id.download_id_app_layout:
                url = "Deseja efetuar o download da carta de apoio?";
                break;
            case R.id.download_id_app_layout_1:
                url = "Deseja efetuar o download das 10 medidas contra a corrupção?";
                break;
            case R.id.download_id_app_layout_2:
                url = "Deseja efetuar o download do sumário executivo?";
                break;
            case R.id.download_id_app_layout_3:
                url = "Deseja efetuar o download da lista de apoiadores?";
                break;
            case R.id.download_id_app_layout_4:
                url = "Deseja efetuar o download da ficha de assinatura?";
                break;
            case R.id.download_1_id_app_layout:
                url = "Deseja efetuar o download do resumo das medidas?";
                break;
            case R.id.download_1_id_app_layout_1:
                url = "Deseja efetuar o download do banner de lona?";
                break;
            case R.id.download_1_id_app_layout_2:
                url = "Deseja efetuar o download do banner de internet?";
                break;
            case R.id.download_1_id_app_layout_3:
                url = "Deseja efetuar o download do prisma de mesa?";
                break;
            case R.id.download_1_id_app_layout_4:
                url = "Deseja efetuar o download da filipeta de apoio?";
                break;
            case R.id.download_1_id_app_layout_5:
                url = "Deseja efetuar o download do cartaz de apoio?";
                break;
            case R.id.download_1_id_app_layout_6:
                url = "Deseja efetuar o download do outdoor?";
                break;
            case R.id.download_1_id_app_layout_7:
                url = "Deseja efetuar o download do broadside?";
                break;
            case R.id.download_1_id_app_layout_8:
                url = "Deseja efetuar o download da camiseta?";
                break;
        }

        DownloadConfirmation downloadConfirmation = DownloadConfirmation.newInstance(v.getId(),url);

        downloadConfirmation.show(getFragmentManager(),url);

    }
}
