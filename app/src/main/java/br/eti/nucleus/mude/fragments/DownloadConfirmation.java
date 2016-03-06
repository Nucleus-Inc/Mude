package br.eti.nucleus.mude.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import br.eti.nucleus.mude.R;

public class DownloadConfirmation extends DialogFragment{

    private String message;
    private int id;

    public static DownloadConfirmation newInstance(int id,String message) {
        DownloadConfirmation downloadConfirmation = new DownloadConfirmation();
        Bundle args = new Bundle();
        args.putString("message",message);
        args.putInt("id", id);
        downloadConfirmation.setArguments(args);
        return downloadConfirmation;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        this.id = getArguments().getInt("id");
        this.message = getArguments().getString("message");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Download")
                .setIcon(R.drawable.alert_dialog_icon)
                .setMessage(message)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String url = "";

                        switch (id) {
                            case R.id.download_id_app_layout:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/modelo_carta_apoio.pdf";
                                break;
                            case R.id.download_id_app_layout_1:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/medidas-anticorrupcao_versao-2015-06-25.pdf";
                                break;
                            case R.id.download_id_app_layout_2:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/sumario_executivo.pdf";
                                break;
                            case R.id.download_id_app_layout_3:
                                url = "http://www.combateacorrupcao.mpf.mp.br/10-medidas/docs/lista-apoiadores-por-uf.pdf";
                                break;
                            case R.id.download_id_app_layout_4:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/Ficha-de-Assinatura_.pdf";
                                break;
                            case R.id.download_1_id_app_layout:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/resumo-medidas-frente-verso.pdf";
                                break;
                            case R.id.download_1_id_app_layout_1:
                                url = "http://www.combateacorrupcao.mpf.mp.br/10-medidas/docs/001_15_10_Medidas_Corrupcao_Banner_LONA_sem_marca_apoio.pdf";
                                break;
                            case R.id.download_1_id_app_layout_2:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/001_15_10_Medidas_Banner_Online_600x120_APOIE.png";
                                break;
                            case R.id.download_1_id_app_layout_3:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/001_15_Prisma_Mesa_10_Medidas.pdf";
                                break;
                            case R.id.download_1_id_app_layout_4:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/filipeta-de-apoio-10-medidas.pdf";
                                break;
                            case R.id.download_1_id_app_layout_5:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/001_15_10_medidas_Cartaz_Apoio_A4.pdf";
                                break;
                            case R.id.download_1_id_app_layout_6:
                                url = "http://www.combateacorrupcao.mpf.mp.br/10-medidas/docs/001_10_medidas_Outdoor.pdf";
                                break;
                            case R.id.download_1_id_app_layout_7:
                                url = "http://www.combateacorrupcao.mpf.mp.br/10-medidas/docs/Broadside-10-Medidas-Internet_new.pdf";
                                break;
                            case R.id.download_1_id_app_layout_8:
                                url = "http://www.combateacorrupcao.mpf.mp.br/10-medidas/docs/001_15_10_Medidas_Camiseta.pdf";
                                break;
                            case R.id.ten_measure_download:
                                url = "http://combateacorrupcao.mpf.mp.br/10-medidas/docs/Ficha-de-Assinatura_.pdf";
                                break;
                        }

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                })
                .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }

}
