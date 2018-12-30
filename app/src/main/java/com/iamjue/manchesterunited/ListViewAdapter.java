package com.iamjue.manchesterunited;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListViewAdapter extends ArrayAdapter<PlayerItem> {
    private List<PlayerItem> playerItemList;
    private Context context;

    public ListViewAdapter(List<PlayerItem> playerItemList, Context context) {
        super( context, R.layout.list_row, playerItemList );
        this.playerItemList = playerItemList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View listViewItem = inflater.inflate( R.layout.list_row, null, true );

        CircleImageView imgPlayer = (CircleImageView) listViewItem.findViewById( R.id.img_photo );

        TextView tvNamePlayer = (TextView) listViewItem.findViewById( R.id.tv_namePlayer );
        TextView tvBirth = (TextView) listViewItem.findViewById( R.id.tv_playerBorn );
        TextView tvSign = (TextView) listViewItem.findViewById( R.id.tv_playerSign );
        TextView tvPosition = (TextView) listViewItem.findViewById( R.id.tv_playerPosition );

        PlayerItem playerItem = playerItemList.get( position );

        Glide.with( context ).load( playerItem.getStrThumb() ).into( imgPlayer );
        tvNamePlayer.setText( "\t\t\t" + playerItem.getStrPlayer() );
        tvBirth.setText( "\t\t\t" + playerItem.getDateBorn() );
        tvSign.setText( "\t\t\t" + playerItem.getDateSigned() );
        tvPosition.setText( "\t\t\t" + playerItem.getStrPosition() );


        return listViewItem;

    }
}
