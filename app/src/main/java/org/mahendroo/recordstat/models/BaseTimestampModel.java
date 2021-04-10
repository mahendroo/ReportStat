package org.mahendroo.recordstat.models;

public class BaseTimestampModel {

    private long apiRequestTime;
    private long apiResponseTime;
    private long roomSaveInitTime;
    private long roomSaveDoneTime;

    public long getApiRequestTime() {
        return apiRequestTime;
    }

    public void setApiRequestTime(long apiRequestTime) {
        this.apiRequestTime = apiRequestTime;
    }

    public long getApiResponseTime() {
        return apiResponseTime;
    }

    public void setApiResponseTime(long apiResponseTime) {
        this.apiResponseTime = apiResponseTime;
    }

    public long getRoomSaveInitTime() {
        return roomSaveInitTime;
    }

    public void setRoomSaveInitTime(long roomSaveInitTime) {
        this.roomSaveInitTime = roomSaveInitTime;
    }

    public long getRoomSaveDoneTime() {
        return roomSaveDoneTime;
    }

    public void setRoomSaveDoneTime(long roomSaveDoneTime) {
        this.roomSaveDoneTime = roomSaveDoneTime;
    }
}
