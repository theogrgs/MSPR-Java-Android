package com.gosecuriscan;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScanActivity extends AppCompatActivity {

    ImageView imageView;
    Uri image;
    String mCameraFileName;

    //A la création on prend l'imageView pour pouvoir la modifier plus tard :
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        imageView = (ImageView) this.findViewById(R.id.imageView2);
    }

    //Mettre la photo prise dans l'image view :
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 2) {
                if (data != null) {
                    image = data.getData();
                    imageView.setImageURI(image);
                    imageView.setVisibility(View.VISIBLE);
                    System.out.println("l'image est chargée dans l'image view");
                }
            }
        }
    }

    //Lancer la camera pour prendre la photo :
    public void cameraIntent(View view) {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy--kk-mm-ss");

        String newPicFile = df.format(date) + ".jpg";
        String outPath = newPicFile;
        File outFile = new File(outPath);

        mCameraFileName = outFile.toString();
        Uri outuri = Uri.fromFile(outFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outuri);
        startActivityForResult(intent, 2);
    }


    /*public void camera (View v) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAM_REQUEST);
    }*/
}