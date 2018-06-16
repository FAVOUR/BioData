package com.feghas.biodata;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.feghas.biodata.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    ShowCamera showCamers;

    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

         camera = Camera.open();
        frameLayout = (FrameLayout)findViewById(R.id.cameraDisp);

        showCamers =new ShowCamera(this,camera);

        frameLayout.addView(showCamers);



    }

    Camera.PictureCallback mPictureCallBack = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] bytes, Camera camera) {

            File pictureFile= getOutputMediaFile();

            if (pictureFile==null){

                return;
            }

            else{

                try {

                    FileOutputStream fileOutputStream = new FileOutputStream(pictureFile);

                    fileOutputStream.write(bytes);

                    fileOutputStream.close();

                    camera.startPreview();

            }
//            catch (FileNotFoundException e){
//
//
//                e.printStackTrace();
//            }
            catch (IOException e){

                    e.printStackTrace();
                }
            }

        }
    };

    private File getOutputMediaFile() {

        String state = Environment.getExternalStorageState();

        if (!state.equals(Environment.MEDIA_MOUNTED))
        {
              return null;

        }
       else{
            File folder_gui= new File (Environment.getExternalStorageDirectory() + File.separator + "GUI");

            if(folder_gui.exists()){

                folder_gui.mkdirs();

            }

            File outPutFile= new File(folder_gui,"temp.jpg");

            return outPutFile;
        }



    }

    public void snap(View view) {

        if(camera != null){

            camera.takePicture(null,null,mPictureCallBack);
        }

    }

    public void back(View view) {
        Intent backToCamera = new Intent (CameraActivity.this , UserLoginActivity.class);
        startActivity(backToCamera);
    }
}
