package com.feghas.biodata;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.feghas.biodata.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLoginActivity extends AppCompatActivity {

    ImageButton camera_button;
    private final int CAMERA_REQUEST = 007;
    public Uri imageToUploadUri;

    private final int CAMERA_DATA_REQUEST = 027;
    Button button;
    private String imagePath;
    private String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        camera_button = (ImageButton) findViewById(R.id.camera_button);

        button = (Button) findViewById(R.id.userImage);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.signup_actionbar);

        camera_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
//                Intent goToCamera = new Intent (UserLoginActivity.this , CameraActivity.class);
//                startActivity(goToCamera);
//                startActivityForResult(goToCamera,CAMERA_DATA_REQUEST);
//            }
//        });
//    }

//                imagePath = Environment.getExternalStorageState() + "/images/myimage.jpg";
//                File file = new File( imagePath );
//                Uri outputFileUri = Uri.fromFile( file );



                    Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                    // Ensure that there's a camera activity to handle the intent

                        // Create the File where the photo should go
                        File photoFile = null;

                        photoFile = createImageFile();

                        // Error occurred while creating the File




                        // Continue only if the File was successfully created
                        if (photoFile != null) {
                            Uri photoURI = Uri.fromFile(createImageFile());
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                            startActivityForResult(takePictureIntent, CAMERA_REQUEST);


                        }

                        else{
                            Toast.makeText(UserLoginActivity.this, "Error", Toast.LENGTH_SHORT).show();


                        }
                    }

        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CAMERA_REQUEST) {

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

//            // Show the thumbnail on ImageView
//            Uri imageUri = Uri.parse(mCurrentPhotoPath);
//            File file = new File(imageUri.getPath());

            // Show the thumbnail on ImageView
            Uri imageUri = Uri.parse(mCurrentPhotoPath);
            File file = new File(imageUri.getPath());


            try {
                InputStream ims = new FileInputStream(file);

                BitmapDrawable ob = new BitmapDrawable(getResources(), BitmapFactory.decodeStream(ims));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                    button.setBackground(ob);}
            } catch (FileNotFoundException e) {
                return;
            }

//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//
//            BitmapDrawable ob = new BitmapDrawable(getResources(), BitmapFactory.decodeStream(ims));
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//
//                button.setBackground(ob);
//
            }

    }


//            File image = new File(imagePath);
//                image.delete();
//            setImageBitmap(photo);

//        }



    private File createImageFile()  {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), "Camera");
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    //Opens the next activty on clicking next steps
    public void nextStep(View view) {

        Intent nextStep = new Intent(UserLoginActivity.this, UserSignUpActivity2.class);
        startActivity(nextStep);
    }



}
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode==CAMERA_DATA_REQUEST){
//            if(resultCode==RESULT_OK){
//
//                Bitmap photo = (Bitmap) data.getExtras().get("data");
//                BitmapDrawable ob = new BitmapDrawable(getResources(), photo);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                button.setBackground(ob);
//            }
//            }
//        }
//    }
//}
