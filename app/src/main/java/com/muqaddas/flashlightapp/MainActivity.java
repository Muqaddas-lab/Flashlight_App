package com.muqaddas.flashlightapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    Button btnFlashlight;
    boolean isFlashOn = false;
    CameraManager cameraManager;
    String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFlashlight = findViewById(R.id.btnFlashlight);

        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        // Permission check
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
        }

        btnFlashlight.setOnClickListener(v -> {
            try {
                if (!isFlashOn) {
                    cameraManager.setTorchMode(cameraId, true);
                    isFlashOn = true;
                    btnFlashlight.setText(R.string.turn_off_flashlight);  // Reference the string here
                } else {
                    cameraManager.setTorchMode(cameraId, false);
                    isFlashOn = false;
                    btnFlashlight.setText(R.string.turn_on_flashlight);  // Reference the string here
                }
            } catch (CameraAccessException e) {
                Toast.makeText(this, "Flash not available", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
