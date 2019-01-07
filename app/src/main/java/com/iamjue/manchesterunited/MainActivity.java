package com.iamjue.manchesterunited;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private List<PlayerItem> playerItemList;

    private static String URL = "https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?t=Man%United";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        listView = (ListView) findViewById( R.id.recyclerView );
        playerItemList = new ArrayList<>();
        loadPlayer();
        playerClick();
    }

    private void playerClick() {
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                PlayerItem player = new PlayerItem();
                player.setStrPlayer( playerItemList.get( position ).getStrPlayer() );
                player.setStrThumb( playerItemList.get( position ).getStrThumb() );
                player.setStrDescriptionEN( playerItemList.get( position ).getStrDescriptionEN() );
                player.setStrNationality( playerItemList.get( position ).getStrNationality() );
                player.setDateBorn( playerItemList.get( position ).getDateBorn() );
                player.setStrBirthLocation( playerItemList.get( position ).getStrBirthLocation() );
                player.setStrHeight( playerItemList.get( position ).getStrHeight() );
                player.setStrWeight( playerItemList.get( position ).getStrWeight() );
                player.setStrTwitter( playerItemList.get( position ).getStrTwitter() );
                player.setStrInstagram( playerItemList.get( position ).getStrInstagram() );
                Intent detailIntent = new Intent( MainActivity.this, Detail.class );

                detailIntent.putExtra( "manUtd", player );
                startActivity( detailIntent );
            }
        } );
    }


    private void loadPlayer() {
        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject( response );
                    JSONArray playerArray = object.getJSONArray( "player" );
                    for (int i = 0; i < playerArray.length(); i++) {
                        JSONObject playerObject = playerArray.getJSONObject( i );
                        PlayerItem playerItem = new PlayerItem( playerObject.getString( "strPlayer" ),
                                playerObject.getString( "dateBorn" ),
                                playerObject.getString( "dateSigned" ),
                                playerObject.getString( "strPosition" ),
                                playerObject.getString( "strThumb" ),
                                playerObject.getString( "strNationality" ),
                                playerObject.getString( "strBirthLocation" ),
                                playerObject.getString( "strDescriptionEN" ),
                                playerObject.getString( "strHeight" ),
                                playerObject.getString( "strWeight" ),
                                playerObject.getString( "strTwitter" ),
                                playerObject.getString( "strInstagram" ) );

                        playerItemList.add( playerItem );
                    }
                    ListViewAdapter listViewAdapter = new ListViewAdapter( playerItemList, getApplicationContext() );
                    listView.setAdapter( listViewAdapter );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );
        RequestQueue requestQueue = Volley.newRequestQueue( this );
        requestQueue.add( stringRequest );
    }
}
