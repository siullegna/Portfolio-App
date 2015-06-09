package hardyappspop.portfolioapp.spotifystreamer;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import hardyappspop.portfolioapp.R;
import hardyappspop.portfolioapp.spotifystreamer.callback.CallBackSpotifyArtist;
import hardyappspop.portfolioapp.spotifystreamer.dto.DtoArtist;
import hardyappspop.portfolioapp.spotifystreamer.fragment.FragmentSpotifyArtist;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public class SpotifyStreamer extends AppCompatActivity implements CallBackSpotifyArtist,
        SearchView.OnQueryTextListener {
    // ===========================================================
    // Constants
    // ===========================================================
    private final String TAG_SPOTIFY_ARTIST = "FragmentSpotifyArtist";
    // ===========================================================
    // Fields
    // ===========================================================
    private Toolbar toolbar;
    private Menu menu;
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

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();
        handleIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spotify_streamer, menu);
        this.menu = menu;


        MenuItem itemSearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(itemSearch);
        if (searchView != null) {
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setOnQueryTextListener(this);

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onArtistClickListener(DtoArtist artist) {
        Toast.makeText(this, "Artista: " + artist.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
        return false;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void init() {
        addFragment(new FragmentSpotifyArtist(), TAG_SPOTIFY_ARTIST);

    }

    private void addFragment(Fragment fragment, final String TAG) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_container, fragment, TAG).commit();
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
        }
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
