package com.iamjue.manchesterunited;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class Detail extends AppCompatActivity {
    ImageView imageView;
    TextView tvName, tvBorn, tvNational, tvDesc, tvHeight, tvWeight, tvTw, tvIg;
    public static String EXTRA_PHOTO = "extra_photo";
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_BORN = "extra_born";
    public static String EXTRA_BIRTH = "extra_birth";
    public static String EXTRA_NATIONAL = "extra_national";
    public static String EXTRA_DESC = "extra_desc";
    public static String EXTRA_WEIGHT = "extra_weight";
    public static String EXTRA_HEIGHT = "extra_height";
    public static String EXTRA_TW = "extra_tw";
    public static String EXTRA_IG = "extra_ig";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );
        imageView = findViewById( R.id.img_photoDetail );
        tvTw = findViewById( R.id.tv_twiter );
        tvIg = findViewById( R.id.tv_Ig );
        tvName = findViewById( R.id.tv_nameDetail );
        tvBorn = findViewById( R.id.tv_dateOfBirth );
        tvNational = findViewById( R.id.tv_nationality );
        tvDesc = findViewById( R.id.tv_desc );
        tvHeight = findViewById( R.id.tv_Height );
        tvWeight = findViewById( R.id.tv_weight );


        Glide.with( this ).load( getIntent().getStringExtra( EXTRA_PHOTO ) ).into( imageView );
        tvName.setText( getIntent().getStringExtra( EXTRA_NAME ) );
        tvNational.setText( getIntent().getStringExtra( EXTRA_NATIONAL ) );
        tvDesc.setText( getIntent().getStringExtra( EXTRA_DESC ) );
        tvHeight.setText( getIntent().getStringExtra( EXTRA_HEIGHT ) + " m" );
        tvWeight.setText( getIntent().getStringExtra( EXTRA_WEIGHT ) + " kg" );
        tvBorn.setText( getIntent().getStringExtra( EXTRA_BIRTH ) + ", " + getIntent().getStringExtra( EXTRA_BORN ) );
        tvIg.setText( getIntent().getStringExtra( EXTRA_IG ) );
        tvTw.setText( getIntent().getStringExtra( EXTRA_TW ) );

    }


}
