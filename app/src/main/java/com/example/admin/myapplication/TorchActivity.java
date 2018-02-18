package com.example.admin.myapplication;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

public class TorchActivity extends AppCompatActivity {

    Switch switchView;
    Camera camera;
    Camera.Parameters parameters;

    CameraManager cameraManager;
    Thread thread;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        switchView = findViewById(R.id.switch1);
        try {
            camera = Camera.open();
            parameters = camera.getParameters();
        } catch (Exception e) {

        }


        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
//                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//                    //sleep
//                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//                    //sleep
//

                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 10; i++) {
                                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            }
                        }
                    });
                    thread.start();


                } else {
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    // TODO: 14.02.2018 kill runnable
                }
                if (camera != null) {
                    camera.setParameters(parameters);
                    camera.startPreview();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.stopPreview();
            camera.release();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
