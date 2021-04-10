package org.mahendroo.recordstat.models;

import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.mahendroo.recordstat.network.NetworkConstants;

public class BaseModel {

    @SerializedName(NetworkConstants.ID)
    @Expose(serialize = false)
    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
