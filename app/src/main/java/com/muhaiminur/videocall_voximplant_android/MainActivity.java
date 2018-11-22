package com.muhaiminur.videocall_voximplant_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.karan.churi.PermissionManager.PermissionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    PermissionManager permissionManager;
    @BindView(R.id.video_call)
    Button videoCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        permissionManager = new PermissionManager() {
        };
        permissionManager.checkAndRequestPermissions(MainActivity.this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        permissionManager.checkResult(requestCode, permissions, grantResults);
    }

    @OnClick(R.id.video_call)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this,Video_Call.class));
    }
}
