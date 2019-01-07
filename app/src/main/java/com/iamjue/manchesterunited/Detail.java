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

        PlayerItem playerItem = getIntent().getParcelableExtra( "manUtd" );

        Glide.with( this ).load( playerItem.getStrThumb() ).into( imageView );
        tvName.setText( playerItem.getStrPlayer() );
        tvNational.setText( playerItem.getStrNationality() );
        tvDesc.setText( playerItem.strDescriptionEN );
        tvHeight.setText( playerItem.getStrHeight() + " m" );
        tvWeight.setText( playerItem.getStrWeight() + " kg" );
        tvBorn.setText( playerItem.getStrBirthLocation() + ", " + playerItem.getDateBorn() );
        tvIg.setText( playerItem.getStrInstagram() );
        tvTw.setText( playerItem.getStrTwitter() );


    }


}
