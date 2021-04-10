package org.mahendroo.recordstat.models;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.mahendroo.recordstat.network.NetworkConstants;
import org.mahendroo.recordstat.repositories.room.RoomConstants;

@Entity(tableName = RoomConstants.TABLE_TODOS)
public class TodosModel extends BaseModel {

    @SerializedName(NetworkConstants.USER_ID)
    @Expose(serialize = false)
    private int postId;

    @SerializedName(NetworkConstants.TITLE)
    @Expose(serialize = false)
    private String title;

    @SerializedName(NetworkConstants.COMPLETED)
    @Expose(serialize = false)
    private boolean completed;


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
