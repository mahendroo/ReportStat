package org.mahendroo.recordstat.models;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.mahendroo.recordstat.network.NetworkConstants;
import org.mahendroo.recordstat.repositories.room.RoomConstants;

@Entity(tableName = RoomConstants.TABLE_POSTS)
public class PostsModel extends BaseModel {

    @SerializedName(NetworkConstants.USER_ID)
    @Expose(serialize = false)
    private int userId;

    @SerializedName(NetworkConstants.TITLE)
    @Expose(serialize = false)
    private String title;


    @SerializedName(NetworkConstants.BODY)
    @Expose(serialize = false)
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
