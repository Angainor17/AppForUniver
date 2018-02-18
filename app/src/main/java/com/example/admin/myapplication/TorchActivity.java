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
//    Thread thread;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        switchView = findViewById(R.id.switch1);

        camera = Camera.open();//получаем ресурс камеры
        parameters = camera.getParameters();//ссылка на парметры камеры

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);//ВКЛ
                } else {
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);//ВЫКЛ
                }
                camera.setParameters(parameters);//задаём параметры камеры
                camera.startPreview();//запуск работы камеры(в данном случае у нас работает только вспышка)
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.stopPreview();//останавливаем работу с камерой
            camera.release();//освобождаем ресурс, а то иначе ни система в будущем, ни мы не сможем снова без ошибки её запросить
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
