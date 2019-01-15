package com.example.openpdfsample;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uttampanchasara.pdfgenerator.CreatePdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;


public class PdfGeneratorActivity extends AppCompatActivity {

    public static final String EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private OutputStream os;
    private static final String TAG = "PdfGeneratorActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean b =  getExtStoragePermission();
        setContentView(R.layout.activity_pdf_generator);

        Button btnGenPdf = findViewById(R.id.btnGenPdf);
        btnGenPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfGeneratorStart();
            }
        });
    }

    // создание pdf файла
    private void PdfGeneratorStart() {
        final Context ctx = PdfGeneratorActivity.this;
        File extDir = Environment.getExternalStorageDirectory();
        File pdfDirPath = new File(extDir, "AisBrigade");
        Log.d(TAG, "PdfGeneratorStart: path CacheDir - " + ctx.getCacheDir());

        String pageTemplate = getResources().getString(R.string.html1);


        StringHelper helper = new StringHelper();
        String pageContent = helper.ReplaceTemplateText(pageTemplate,  new DataObjectRepo().GetData());

        // создание pdf файла - библиотека com.uttampanchasara.pdfgenerator
        new CreatePdf(ctx)
                .setPdfName("pdfExample") // сохранить файл pdfExample.pdf в папку кеша приложения
                .openPrintDialog(false)
                .setContentBaseUrl(null)
                .setContent(pageContent)
                .setCallbackListener(new CreatePdf.PdfCallbackListener() {
                    @Override
                    public void onFailure(String errorMsg) {
                        Toast.makeText(ctx, errorMsg, Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onSuccess(String filePath) {
                        Toast.makeText(ctx, "Pdf Saved at: "+filePath, Toast.LENGTH_LONG).show();
                        Log.d(TAG, "onSuccess: filePath - " + filePath);
                        CopyFile();
                    }
                })
                .create();
    }

    // скопировать файл из кеша на диск
    private void CopyFile(){
        final Context ctx = PdfGeneratorActivity.this;
        String fileName = "pdfExample.pdf";
        File pdfFile0 = new File(getCacheDir(), fileName);

        File extDir = Environment.getExternalStorageDirectory();
        File aisBrigadeDir = new File(extDir, "AisBrigade");
        File pdfFile1 = new File(aisBrigadeDir, fileName);

        try {
            copy(pdfFile0, pdfFile1);
            Toast.makeText(ctx, "Pdf Copied at: "+pdfFile1.getAbsolutePath(), Toast.LENGTH_LONG).show();
            //OpenPdfFile(pdfFile1);
        }
        catch (IOException ex){
            Log.e(TAG, "CopyFile: "+fileName,ex );
        }
    }

    /*
    копирование файла
     */
    public void copy(File src, File dst) throws IOException {
        FileInputStream inStream = new FileInputStream(src);
        FileOutputStream outStream = new FileOutputStream(dst);
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = outStream.getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inStream.close();
        outStream.close();
    }

    /*
    * Открыть файл с диска
    * */
    private void OpenPdfFile(File pdfFile){
        Uri pdfFileURI = Uri.fromFile(pdfFile);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(pdfFileURI, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    /**
     * Получение прав на хранилище данных
     */
    private boolean getExtStoragePermission(){
        // есть ли права
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // если нет, то запросить права
            ActivityCompat.requestPermissions(this, new String[]{EXTERNAL_STORAGE}, 9999);
            Log.d(TAG, "getExtStoragePermission: PERMISSION_GRANTED");
            return  true;
        }
        Log.d(TAG, "getExtStoragePermission: PERMISSION_GRANTED");
        return  false;
    }
}
