package com.eti.nucleus.app10medidas.fragments;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.eti.nucleus.app10medidas.R;
import com.eti.nucleus.app10medidas.activity.MainActivity;
import com.eti.nucleus.app10medidas.modules.MyToolbar;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Participate extends Fragment implements View.OnClickListener{

    public Button savePDF;

    @Override
    public void onAttach(Context context) {
        MainActivity.myToolbar.setTitle("Participe");
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = false;
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

            String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/10 Medidas";

            File dir = new File(path);
            if(!dir.exists())
                dir.mkdirs();

            File file = new File(dir,"Ficha-de-Assinatura_.pdf");
            FileOutputStream fOut = new FileOutputStream(file);

            PdfWriter.getInstance(docPdf, fOut);

            docPdf.open();

            Paragraph title = new Paragraph();
            title.add(new Phrase("LISTA DE APOIAMENTO - PROJETO DE LEI DE INICIATIVA"+" POPULAR: “10 MEDIDAS CONTRA CORRUPÇÃO”"+"\n",new Font(Font.FontFamily.TIMES_ROMAN,9,Font.BOLD)));
            title.setAlignment(Element.ALIGN_JUSTIFIED);
            docPdf.add(title);

            String paragraph =
                    "Dispõe sobre propostas legislativas para aprimorar a prevenção e o combate à corrupção e à impunidade. As medidas estão consolidadas"+
            " em 20 anteprojetos de lei e buscam, entre outros resultados, evitar a ocorrência de corrupção (via prestação de contas, treinamentos e testes"+
            " morais de servidores, ações de marketing/conscientização e proteção a quem denuncia a corrupção), criminalizar o enriquecimento ilícito,"+
            " aumentar penas da corrupção e tornar hedionda aquela de altos valores, agilizar o processo penal e o processo civil de crimes e atos de improbidade,"+
                    " fechar brechas da lei por onde criminosos escapam (via reforma dos sistemas de prescrição e nulidades), criminalizar caixa dois"+
            " e lavagem eleitorais, permitir punição objetiva de partidos políticos por corrupção em condutas futuras, viabilizar a prisão para evitar que"+
            " o dinheiro desviado desapareça, agilizar o rastreamento do dinheiro desviado e fechar brechas da lei por onde o dinheiro desviado escapa"+
                    " (via ação de extinção de domínio e confisco alargado). A íntegra das medidas e suas justificativas também podem ser encontradas no site:";

            Paragraph text = new Paragraph(paragraph,new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL));
            text.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            docPdf.add(text);

            Anchor anchor = new Anchor("www.10medidas.mpf.mp.br");
            anchor.setReference("www.10medidas.mpf.mp.br");

            Phrase text_2 = new Phrase();
            text_2.add(anchor);
            docPdf.add(text_2);

            String paragraph_3 = " ATENÇÃO: SE ESTIVER SEM O TÍTULO DE ELEITOR, ESTE CAMPO PODE SER DEIXADO EM BRANCO\n\n";
            Phrase text_3 = new Phrase(paragraph_3,new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL));
            docPdf.add(text_3);

            PdfPTable table = new PdfPTable(3);

            PdfPCell cell1 = new PdfPCell(new Paragraph("NOME\n"+"(Por extenso e sem abreviar)",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            PdfPCell cell2 = new PdfPCell(new Paragraph(""));
            PdfPCell cell3 = new PdfPCell(new Paragraph("CPF",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));

            PdfPCell cell4 = new PdfPCell(new Paragraph("NOME DA MÃE\n"+"(Por extenso e sem abreviar)",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            PdfPCell cell5 = new PdfPCell(new Paragraph(""));

            PdfPCell cell6 = new PdfPCell(new Paragraph("ASSINATURA OU IMPRESSÃO DIGITAL",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            cell6.setRowspan(3);

            PdfPCell cell7 = new PdfPCell(new Paragraph("ENDEREÇO\n\n",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            cell7.setColspan(2);

            PdfPTable newTable = new PdfPTable(5);

            PdfPCell ntCell1 = new PdfPCell(new Paragraph("Nº TÍTULO DE ELEITOR\n\n\n",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            PdfPCell ntCell2 = new PdfPCell(new Paragraph("ZONA",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            PdfPCell ntCell3 = new PdfPCell(new Paragraph("SEÇÃO",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            PdfPCell ntCell4 = new PdfPCell(new Paragraph("MUNICÍPIO/UF ONDE VOTA",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
            PdfPCell ntCell5 = new PdfPCell(new Paragraph("DATA DE NASCIMENTO",new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL)));

            newTable.addCell(ntCell1);
            newTable.addCell(ntCell2);
            newTable.addCell(ntCell3);
            newTable.addCell(ntCell4);
            newTable.addCell(ntCell5);

            int[] columnWidths_2 = {90,30,30,100,90};
            newTable.setWidths(columnWidths_2);
            newTable.setWidthPercentage(100);

            PdfPCell cell8 = new PdfPCell(newTable);
            cell8.setColspan(2);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);

            int[] columnWidths = {35,100,55};
            table.setWidths(columnWidths);
            table.setWidthPercentage(100);

            docPdf.add(table);

            Toast.makeText(getActivity(),"PDF SALVO",Toast.LENGTH_SHORT).show();

        }catch (DocumentException de){
            Log.e("PDFCreator", "DocumentException:" + de);
        }catch (IOException ioe){
            Log.e("PDFCreator", "ioException:" + ioe);
        }finally {
            docPdf.close();
        }

    }
}
