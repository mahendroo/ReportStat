package org.mahendroo.recordstat.models;

public class RecordStatModel {

    private BaseTimestampModel commentsTimestamp = new BaseTimestampModel();
    private BaseTimestampModel photosTimestamp = new BaseTimestampModel();
    private BaseTimestampModel todosTimestamp = new BaseTimestampModel();
    private BaseTimestampModel postsTimestamp = new BaseTimestampModel();

    public BaseTimestampModel getCommentsTimestamp() {
        return commentsTimestamp;
    }

    public void setCommentsTimestamp(BaseTimestampModel commentsTimestamp) {
        this.commentsTimestamp = commentsTimestamp;
    }

    public BaseTimestampModel getPhotosTimestamp() {
        return photosTimestamp;
    }

    public void setPhotosTimestamp(BaseTimestampModel photosTimestamp) {
        this.photosTimestamp = photosTimestamp;
    }

    public BaseTimestampModel getTodosTimestamp() {
        return todosTimestamp;
    }

    public void setTodosTimestamp(BaseTimestampModel todosTimestamp) {
        this.todosTimestamp = todosTimestamp;
    }

    public BaseTimestampModel getPostsTimestamp() {
        return postsTimestamp;
    }

    public void setPostsTimestamp(BaseTimestampModel postsTimestamp) {
        this.postsTimestamp = postsTimestamp;
    }
}
