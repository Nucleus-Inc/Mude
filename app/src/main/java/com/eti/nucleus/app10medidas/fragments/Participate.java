package com.eti.nucleus.app10medidas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.activity.MainActivity;
import com.eti.nucleus.app10medidas.modules.MyToolbar;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Participate extends Fragment implements View.OnClickListener{

    public Button savePDF;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity.result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
        MyToolbar.activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MyToolbar.activity.getSupportActionBar().setTitle("Participe");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ten_measures_participate,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        savePDF = (Button) getActivity().findViewById(R.id.participate_savePDF);
        savePDF.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.participate_savePDF) {
            createPDF();
        }
    }

    public void createPDF(){

        Document docPdf = new Document();

        try{

            String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/10Medidas";

            File dir = new File(path);
            if(!dir.exists())
                dir.mkdirs();

            Log.d("PDFCreator", "PDF Path: " + path);

            File file = new File(dir,"Ficha-de-Assinatura_.pdf");
            FileOutputStream fOut = new FileOutputStream(file);

            PdfWriter.getInstance(docPdf, fOut);

            docPdf.open();

            Paragraph p1 = new Paragraph("LISTA DE APOIAMENTO - PROJETO DE LEI DE INICIATIVA POPULAR: 10 MEDIDAS CONTRA CORRUPÇÃO");
            Font fontP1 = new Font(Font.TIMES_ROMAN,24);
            p1.setFont(fontP1);

            docPdf.add(p1);

            Paragraph p2 = new Paragraph("Dispõe sobre propostas legislativas para aprimorar a prevenção e o combate à corrupção e à impunidade. As medidas estão consolidadas\n" +
                    "em 20 anteprojetos de lei e buscam, entre outros resultados, evitar a ocorrência de corrupção (via prestação de contas, treinamentos e testes\n" +
                    "morais de servidores, ações de marketing/conscientização e proteção a quem denuncia a corrupção), criminalizar o enriquecimento ilícito,\n" +
                    "aumentar penas da corrupção e tornar hedionda aquela de altos valores, agilizar o processo penal e o processo civil de crimes e atos de improbidade,\n" +
                    "fechar brechas da lei por onde criminosos escapam (via reforma dos sistemas de prescrição e nulidades), criminalizar caixa dois\n" +
                    "e lavagem eleitorais, permitir punição objetiva de partidos políticos por corrupção em condutas futuras, viabilizar a prisão para evitar que\n" +
                    "o dinheiro desviado desapareça, agilizar o rastreamento do dinheiro desviado e fechar brechas da lei por onde o dinheiro desviado escapa\n" +
                    "(via ação de extinção de domínio e confisco alargado). A íntegra das medidas e suas justificativas também podem ser encontradas no site:\n" +
                    "www.10medidas.mpf.mp.br. ATENÇÃO: SE ESTIVER SEM O TÍTULO DE ELEITOR, ESTE CAMPO PODE SER DEIXADO EM BRANCO");
            Font fontP2 = new Font(Font.NORMAL,10);
            p2.setFont(fontP2);

            docPdf.add(p2);

        } catch (DocumentException de) {
            Log.e("PDFCreator", "DocumentException:" + de);
        } catch (IOException e) {
            Log.e("PDFCreator", "ioException:" + e);
        } finally {
            docPdf.close();
        }

    }
}
