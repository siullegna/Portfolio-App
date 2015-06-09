package hardyappspop.portfolioapp.spotifystreamer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import hardyappspop.portfolioapp.R;

/**
 * Created by luisangelgarcia on 6/9/15.
 */
public class SpotifySplash extends AppCompatActivity {
    // ===========================================================
    // Constants
    // ===========================================================
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_spotify_streamer);
        startAction();
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void startAction() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void start() {
        Intent mainIntent = new Intent(this, SpotifyStreamer.class);
        startActivity(mainIntent);
        finish();
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
