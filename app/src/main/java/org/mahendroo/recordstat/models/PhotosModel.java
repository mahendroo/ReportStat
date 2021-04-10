package org.mahendroo.recordstat.models;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.mahendroo.recordstat.network.NetworkConstants;
import org.mahendroo.recordstat.repositories.room.RoomConstants;

@Entity(tableName = RoomConstants.TABLE_PHOTOS)
public class PhotosModel extends BaseModel {

    @SerializedName(NetworkConstants.ALBUM_ID)
    @Expose(serialize = false)
    private String albumId;

    @SerializedName(NetworkConstants.TITLE)
    @Expose(serialize = false)
    private String title;

    @SerializedName(NetworkConstants.URL)
    @Expose(serialize = false)
    private String url;

    @SerializedName(NetworkConstants.THUMBNAIL_URL)
    @Expose(serialize = false)
    private String thumbnailUrl;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
