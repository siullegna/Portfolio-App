package hardyappspop.portfolioapp.spotifystreamer.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luisangelgarcia on 6/8/15.
 */
public class DtoArtist implements Parcelable {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    /**
     * Field to save the Artist's Spotify
     */
    private String spotify;
    /**
     * Field to save the Artist's ID
     */
    private String id;
    /**
     * Field to save the Artist's Name
     */
    private String name;
    /**
     * Field to save the Artist's Thumbnail
     */
    private String thumbnail;
    // ===========================================================
    // Constructors
    // ===========================================================

    /**
     * Constructor
     * <p/>
     * Default constructor
     */
    public DtoArtist() {

    }

    /**
     * Constructor
     *
     * @param source - {@link Parcel}
     *               <p/>
     *               Constructor to read the values from the Parcel object
     */
    private DtoArtist(Parcel source) {
        this();
        spotify = source.readString();
        id = source.readString();
        name = source.readString();
        thumbnail = source.readString();
    }

    /**
     * Constructor
     * Constructor to init my object
     *
     * @param spotify
     * @param id
     * @param name
     * @param thumbnail
     */
    public DtoArtist(String spotify, String id, String name, String thumbnail) {
        this();
        this.spotify = spotify;
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

// ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(spotify);
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(thumbnail);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    public static final Creator<DtoArtist> CREATOR = new Creator<DtoArtist>() {
        @Override
        public DtoArtist createFromParcel(Parcel source) {
            return new DtoArtist(source);
        }

        @Override
        public DtoArtist[] newArray(int size) {
            return new DtoArtist[size];
        }
    };
}
