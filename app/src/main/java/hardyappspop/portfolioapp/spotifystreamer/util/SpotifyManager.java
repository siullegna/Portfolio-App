package hardyappspop.portfolioapp.spotifystreamer.util;

import hardyappspop.portfolioapp.spotifystreamer.callback.CallBackListenerArtist;
import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.ArtistsPager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public class SpotifyManager {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private SpotifyApi spotifyApi;
    private SpotifyService spotifyService;
    private CallBackListenerArtist callBackListenerArtist;
    // ===========================================================
    // Constructors
    // ===========================================================
    public SpotifyManager(CallBackListenerArtist callBackListenerArtist) {
        spotifyApi = new SpotifyApi();
        spotifyService = spotifyApi.getService();
        this.callBackListenerArtist = callBackListenerArtist;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    /**
     * Method to set all the Artist that contains the specify artist
     *
     * @param artist
     * @see {@link CallBackListenerArtist}
     */
    public void setAllAboutArtist(String artist) {
        spotifyService.searchArtists(artist, new Callback<ArtistsPager>() {
            @Override
            public void success(ArtistsPager artistsPager, Response response) {
                callBackListenerArtist.setAllAboutArtist(artistsPager);
            }

            @Override
            public void failure(RetrofitError error) {
                callBackListenerArtist.setAllAboutArtist(null);
            }
        });
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
