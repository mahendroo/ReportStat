package org.mahendroo.recordstat.repositories.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.mahendroo.recordstat.models.CommentsModel;
import org.mahendroo.recordstat.models.PhotosModel;
import org.mahendroo.recordstat.models.PostsModel;
import org.mahendroo.recordstat.models.TodosModel;
import org.mahendroo.recordstat.repositories.room.daos.CommentsDao;
import org.mahendroo.recordstat.repositories.room.daos.PhotosDao;
import org.mahendroo.recordstat.repositories.room.daos.PostsDao;
import org.mahendroo.recordstat.repositories.room.daos.TodosDao;

@Database(entities = {CommentsModel.class, PhotosModel.class, PostsModel.class, TodosModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CommentsDao commentsDao();

    public abstract PhotosDao photosDao();

    public abstract PostsDao postsDao();

    public abstract TodosDao todosDao();
}