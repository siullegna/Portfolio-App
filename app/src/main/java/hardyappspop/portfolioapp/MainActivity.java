package hardyappspop.portfolioapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    // ===========================================================
    // Constants
    // ===========================================================

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
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // ===========================================================
    // Methods
    // ===========================================================
    public void onClickListenerSpotifyStreamer(View view) {
        Toast.makeText(this, getResources().getString(R.string.str_toast_spotify_streamer), Toast.LENGTH_SHORT).show();
    }

    public void onClickListenerScoresApp(View view) {
        Toast.makeText(this, getResources().getString(R.string.str_toast_scores_app), Toast.LENGTH_SHORT).show();
    }

    public void onClickListenerLibraryApp(View view) {
        Toast.makeText(this, getResources().getString(R.string.str_toast_library_app), Toast.LENGTH_SHORT).show();
    }

    public void onClickListenerBuildItBigger(View view) {
        Toast.makeText(this, getResources().getString(R.string.str_toast_build_it_bigger), Toast.LENGTH_SHORT).show();
    }

    public void onClickListenerXYZReader(View view) {
        Toast.makeText(this, getResources().getString(R.string.str_toast_xyz_reader), Toast.LENGTH_SHORT).show();
    }

    public void onClickListenerCapStone(View view) {
        Toast.makeText(this, getResources().getString(R.string.str_toast_capstone), Toast.LENGTH_SHORT).show();
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
