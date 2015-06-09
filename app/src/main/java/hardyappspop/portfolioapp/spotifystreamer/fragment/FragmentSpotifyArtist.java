package hardyappspop.portfolioapp.spotifystreamer.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hardyappspop.portfolioapp.R;
import hardyappspop.portfolioapp.spotifystreamer.adapter.AdapterArtist;
import hardyappspop.portfolioapp.spotifystreamer.callback.CallBackSpotifyArtist;
import hardyappspop.portfolioapp.spotifystreamer.callback.CallBackListenerArtist;
import hardyappspop.portfolioapp.spotifystreamer.dto.DtoArtist;
import hardyappspop.portfolioapp.spotifystreamer.util.SpotifyManager;
import kaaes.spotify.webapi.android.models.Artist;
import kaaes.spotify.webapi.android.models.ArtistsPager;
import kaaes.spotify.webapi.android.models.Image;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public class FragmentSpotifyArtist extends Fragment implements CallBackListenerArtist {
    // ===========================================================
    // Constants
    // ===========================================================
    private final String KEY_SPOTIFY = "spotify";
    // ===========================================================
    // Fields
    // ===========================================================
    private View view;
    private RecyclerView rv;
    private AdapterArtist adapter;
    private RecyclerView.LayoutManager layoutManager;
    private CallBackSpotifyArtist callBackSpotifyArtist;
    private List<DtoArtist> listArtist;
    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    private String getThumnail(List<Image> list) {
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0).url;
        }
    }
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callBackSpotifyArtist = (CallBackSpotifyArtist) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_spotify_artist, container, false);
        init();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setOnItemClickListener(View item, int position) {
        callBackSpotifyArtist.onArtistClickListener(adapter.getItemByPosition(position));
    }

    @Override
    public void setAllAboutArtist(ArtistsPager artistsPager) {
        try {
            listArtist = new ArrayList<>();
            for (Artist artist : artistsPager.artists.items) {
                String spotify = artist.external_urls.get(KEY_SPOTIFY);
                String id = artist.id;
                String name = artist.name;
                String thumbnail = getThumnail(artist.images);
                DtoArtist dtoArtist = new DtoArtist(spotify, id, name, thumbnail);
                listArtist.add(dtoArtist);
            }

            /*
            this part is to update the UI
            */
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new AdapterArtist(view.getContext(), listArtist, FragmentSpotifyArtist.this);
                    rv.setAdapter(adapter);
                }
            });
        } catch (NullPointerException e) {
            Toast.makeText(getActivity(), view.getContext().getString(R.string.str_no_artist_information),
                    Toast.LENGTH_SHORT).show();
            listArtist = new ArrayList<>();
            adapter = new AdapterArtist(view.getContext(), listArtist, this);
            rv.setAdapter(adapter);
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void init() {
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(layoutManager);

        SpotifyManager spotifyManager =
                new SpotifyManager(this);
        spotifyManager.setAllAboutArtist(view.getContext().getResources().getString(R.string.str_nach));
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
