package org.mahendroo.recordstat.models;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.mahendroo.recordstat.network.NetworkConstants;
import org.mahendroo.recordstat.repositories.room.RoomConstants;

@Entity(tableName = RoomConstants.TABLE_COMMENTS)
public class CommentsModel extends BaseModel {

    @SerializedName(NetworkConstants.POST_ID)
    @Expose(serialize = false)
    private int postId;

    @SerializedName(NetworkConstants.NAME)
    @Expose(serialize = false)
    private String name;

    @SerializedName(NetworkConstants.EMAIL)
    @Expose(serialize = false)
    private String email;

    @SerializedName(NetworkConstants.BODY)
    @Expose(serialize = false)
    private String body;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
