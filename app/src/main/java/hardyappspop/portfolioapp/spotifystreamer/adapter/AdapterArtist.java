package hardyappspop.portfolioapp.spotifystreamer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import hardyappspop.portfolioapp.R;
import hardyappspop.portfolioapp.spotifystreamer.callback.CallBackListenerArtist;
import hardyappspop.portfolioapp.spotifystreamer.dto.DtoArtist;
import hardyappspop.portfolioapp.spotifystreamer.viewholder.VHArtist;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public class AdapterArtist extends RecyclerView.Adapter<VHArtist> {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private List<DtoArtist> items;
    private Context context;
    private CallBackListenerArtist callBackListenerArtist;

    // ===========================================================
    // Constructors
    // ===========================================================
    public AdapterArtist(Context context, List<DtoArtist> items,
                         CallBackListenerArtist callBackListenerArtist) {
        this.context = context;
        this.items = items;
        this.callBackListenerArtist = callBackListenerArtist;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    /**
     * get an item depending of the position
     *
     * @param position
     * @return {@link DtoArtist}
     */
    public DtoArtist getItemByPosition(int position) {
        return items.get(position);
    }
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public VHArtist onCreateViewHolder(ViewGroup viewGroup, int position) {
        View item = LayoutInflater.from(context).inflate(R.layout.row_spotify_streamer_item, viewGroup, false);
        return new VHArtist(item, callBackListenerArtist);
    }

    @Override
    public void onBindViewHolder(VHArtist holder, int position) {
        if (items.get(position).getThumbnail() != null) {
            Picasso.with(context).load(items.get(position).getThumbnail()).into(holder.image);
        }
        holder.artist.setText(items.get(position).getName());
        holder.album.setVisibility(View.GONE);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
