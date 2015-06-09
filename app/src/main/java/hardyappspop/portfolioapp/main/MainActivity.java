/**
 * @author Luis Ángel García Muñoz
 * Jun 7, 2015
 * <p/>
 * References:
 * - https://docs.google.com/document/d/1v4Kv5lSd8-4cs0BW6F24ccA3c1-KDQZG3EV49CUHQys/pub?embedded=true
 * - https://github.com/kaaes/spotify-web-api-android/blob/master/README.md
 * - https://developer.spotify.com/technologies/spotify-android-sdk/tutorial/
 * Icons:
 * - http://google.github.io/material-design-icons/
 * - https://github.com/google/material-design-icons/releases/download/2.0.0/material-design-icons-2.0.0.zip
 * CardView and RecyclerView:
 * - https://developer.android.com/training/material/lists-cards.html
 * - https://developer.android.com/reference/android/support/v7/widget/CardView.html
 * - http://developer.android.com/reference/android/support/v7/widget/RecyclerView.html
 * Search Functionality
 * - https://developer.android.com/training/search/index.html
 */
package hardyappspop.portfolioapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import hardyappspop.portfolioapp.R;
import hardyappspop.portfolioapp.main.fragment.FragmentMain;
import hardyappspop.portfolioapp.spotifystreamer.SpotifySplash;

public class MainActivity extends AppCompatActivity {
    // ===========================================================
    // Constants
    // ===========================================================
    private final String TAG_FRAGMENT_MAIN = "FragmentMain";
    // ===========================================================
    // Fields
    // ===========================================================
    private Toolbar toolbar;
    private Toast toast;
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
        setContentView(R.layout.toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentMain fragmentMain = new FragmentMain();
        ft.add(R.id.frame_container, fragmentMain, TAG_FRAGMENT_MAIN).commit();
    }

    // ===========================================================
    // Methods
    // ===========================================================
    public void onClickListenerSpotifyStreamer(View view) {
        startActivity(new Intent(this, SpotifySplash.class));
    }

    public void onClickListenerScoresApp(View view) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, getResources().getString(R.string.str_toast_scores_app), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickListenerLibraryApp(View view) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, getResources().getString(R.string.str_toast_library_app), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickListenerBuildItBigger(View view) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, getResources().getString(R.string.str_toast_build_it_bigger), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickListenerXYZReader(View view) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, getResources().getString(R.string.str_toast_xyz_reader), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickListenerCapStone(View view) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, getResources().getString(R.string.str_toast_capstone), Toast.LENGTH_SHORT);
        toast.show();
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
