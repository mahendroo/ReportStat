package org.mahendroo.recordstat.network;

import org.mahendroo.recordstat.models.CommentsModel;
import org.mahendroo.recordstat.models.PhotosModel;
import org.mahendroo.recordstat.models.PostsModel;
import org.mahendroo.recordstat.models.TodosModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface NetworkService {

    String COMMENTS = "/comments";
    String PHOTOS = "/photos";
    String TODOS = "/todos";
    String POSTS = "/posts";

    @GET(COMMENTS)
    Single<List<CommentsModel>> getComments();

    @GET(PHOTOS)
    Single<List<PhotosModel>> getPhotos();

    @GET(TODOS)
    Single<List<TodosModel>> getTodos();

    @GET(POSTS)
    Single<List<PostsModel>> getPosts();
}
