package hardyappspop.portfolioapp.spotifystreamer.callback;

import android.view.View;

import kaaes.spotify.webapi.android.models.ArtistsPager;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public interface CallBackListenerArtist {
    void setOnItemClickListener(View item, int position);
    void setAllAboutArtist(ArtistsPager artistsPager);
}
