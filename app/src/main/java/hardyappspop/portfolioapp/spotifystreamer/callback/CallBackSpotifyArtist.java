package hardyappspop.portfolioapp.spotifystreamer.callback;

import hardyappspop.portfolioapp.spotifystreamer.dto.DtoArtist;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public interface CallBackSpotifyArtist {
    void onArtistClickListener(DtoArtist artist);
}
