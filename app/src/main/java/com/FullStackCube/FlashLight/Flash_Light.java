package com.FullStackCube.FlashLight;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.ImageButton;




public class Flash_Light extends AppCompatActivity
{

    ImageButton b1;
    private Camera camera;

    Camera.Parameters parameters;
    boolean isflash=false;
    boolean ison=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_flash__light);



        b1=(ImageButton)findViewById(R.id.imageButton);


        if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
        {
            camera=Camera.open();
            parameters=camera.getParameters();
            isflash=true;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isflash)
                {
                    if(!ison)
                    {
                        b1.setImageResource(R.drawable.flashlightoff);
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();
                        ison=true;
                    }
                    else
                    {
                        b1.setImageResource(R.drawable.onicon1);
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(parameters);
                        camera.stopPreview();
                        ison=false;
                    }
                }
                else
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(Flash_Light.this);
                    builder.setTitle("Error");
                    builder.setMessage("Flash is Not Available on this device");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }




}
