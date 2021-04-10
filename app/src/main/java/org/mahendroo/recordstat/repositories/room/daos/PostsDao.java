package org.mahendroo.recordstat.repositories.room.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import org.mahendroo.recordstat.models.PostsModel;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(List<PostsModel> postsModels);
}
