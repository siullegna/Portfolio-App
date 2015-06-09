package hardyappspop.portfolioapp.spotifystreamer.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hardyappspop.portfolioapp.R;
import hardyappspop.portfolioapp.spotifystreamer.callback.CallBackListenerArtist;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public class VHArtist extends RecyclerView.ViewHolder implements View.OnClickListener {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    public ImageView image;
    public TextView artist;
    public TextView album;
    private CallBackListenerArtist callBackListenerArtist;

    // ===========================================================
    // Constructors
    // ===========================================================
    public VHArtist(View item, CallBackListenerArtist callBackListenerArtist) {
        super(item);
        this.image = (ImageView) item.findViewById(R.id.image);
        this.artist = (TextView) item.findViewById(R.id.artist);
        this.album = (TextView) item.findViewById(R.id.album);
        this.callBackListenerArtist = callBackListenerArtist;
        item.setOnClickListener(this);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void onClick(View v) {
        if (this.callBackListenerArtist != null) {
            this.callBackListenerArtist.setOnItemClickListener(v, getAdapterPosition());
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
