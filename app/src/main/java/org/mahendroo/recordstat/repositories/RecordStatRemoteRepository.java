package org.mahendroo.recordstat.repositories;

import org.mahendroo.recordstat.models.CommentsModel;
import org.mahendroo.recordstat.models.PhotosModel;
import org.mahendroo.recordstat.models.PostsModel;
import org.mahendroo.recordstat.models.TodosModel;
import org.mahendroo.recordstat.network.NetworkClient;
import org.mahendroo.recordstat.network.NetworkService;
import org.mahendroo.recordstat.repositories.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RecordStatRemoteRepository {

    public static RecordStatRemoteRepository mInstance;

    private static NetworkService mNetworkService;

    private static AppDatabase mAppDatabase;

//    private static final  commentsRequest = NetworkClient.getInstance()

    public static RecordStatRemoteRepository getInstance(AppDatabase appDatabase) {
        if (mInstance == null) {
            mInstance = new RecordStatRemoteRepository();
            mNetworkService = NetworkClient.getInstance().getNetworkService();
            mAppDatabase = appDatabase;
        }
        return mInstance;
    }

    public Single<List<CommentsModel>> fetchComments() {
        Single<List<CommentsModel>> commentsRequest =
                mNetworkService.getComments()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());

        return commentsRequest;
    }

    public Completable storeComments(List<CommentsModel> commentsModels) {
        if (commentsModels == null)
            commentsModels = new ArrayList<>();

        return mAppDatabase.commentsDao()
                .insertAll(commentsModels)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<PhotosModel>> fetchPhotos() {
        Single<List<PhotosModel>> photosRequest =
                mNetworkService.getPhotos()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());

        return photosRequest;
    }

    public Completable storePhotos(List<PhotosModel> photosModels) {
        if (photosModels == null)
            photosModels = new ArrayList<>();

        return mAppDatabase.photosDao()
                .insertAll(photosModels)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<PostsModel>> fetchPosts() {
        Single<List<PostsModel>> postsRequest =
                mNetworkService.getPosts()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());

        return postsRequest;
    }

    public Completable storePosts(List<PostsModel> postsModels) {
        if (postsModels == null)
            postsModels = new ArrayList<>();

        return mAppDatabase.postsDao()
                .insertAll(postsModels)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<TodosModel>> fetchTodos() {
        Single<List<TodosModel>> todosRequest =
                mNetworkService.getTodos()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());

        return todosRequest;
    }

    public Completable storeTodos(List<TodosModel> todosModels) {
        if (todosModels == null)
            todosModels = new ArrayList<>();

        return mAppDatabase.todosDao()
                .insertAll(todosModels)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
