package org.mahendroo.recordstat.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.mahendroo.recordstat.models.CommentsModel;
import org.mahendroo.recordstat.models.PhotosModel;
import org.mahendroo.recordstat.models.PostsModel;
import org.mahendroo.recordstat.models.RecordStatModel;
import org.mahendroo.recordstat.models.TodosModel;
import org.mahendroo.recordstat.repositories.RecordStatRemoteRepository;
import org.mahendroo.recordstat.repositories.room.AppDatabaseClient;
import org.mahendroo.recordstat.utils.Utililty;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class RecordStatViewModel extends AndroidViewModel {

    private List<Disposable> disposables = new ArrayList<>();
    private RecordStatModel recordStatModel = new RecordStatModel();
    private RecordStatRemoteRepository mRecordStatRemoteRepository;
    private MutableLiveData<RecordStatModel> recordStatModelMutableLiveData = new MutableLiveData<>();

    public RecordStatViewModel(@androidx.annotation.NonNull Application application) {
        super(application);
        mRecordStatRemoteRepository = RecordStatRemoteRepository.getInstance(
                AppDatabaseClient.getInstance().getAppDatabase(application.getApplicationContext()));
    }

    public MutableLiveData<RecordStatModel> getRecordStatModelMutableLiveData() {
        return recordStatModelMutableLiveData;
    }

    public void fetchComments() {
        mRecordStatRemoteRepository.fetchComments().subscribe(new SingleObserver<List<CommentsModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposables.add(d);
                recordStatModel.getCommentsTimestamp().setApiRequestTime(Utililty.INSTANCE.getCurrentTimestamp());
            }

            @Override
            public void onSuccess(@NonNull List<CommentsModel> commentsModels) {
                recordStatModel.getCommentsTimestamp().setApiResponseTime(Utililty.INSTANCE.getCurrentTimestamp());

                mRecordStatRemoteRepository.storeComments(commentsModels)
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                recordStatModel.getCommentsTimestamp().setRoomSaveInitTime(Utililty.INSTANCE.getCurrentTimestamp());
                            }

                            @Override
                            public void onComplete() {
                                recordStatModel.getCommentsTimestamp().setRoomSaveDoneTime(Utililty.INSTANCE.getCurrentTimestamp());
                                recordStatModelMutableLiveData.setValue(recordStatModel);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });

    }

    public void fetchPhotos() {
        mRecordStatRemoteRepository.fetchPhotos().subscribe(new SingleObserver<List<PhotosModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposables.add(d);
                recordStatModel.getPhotosTimestamp().setApiRequestTime(Utililty.INSTANCE.getCurrentTimestamp());
            }

            @Override
            public void onSuccess(@NonNull List<PhotosModel> photosModels) {
                recordStatModel.getPhotosTimestamp().setApiResponseTime(Utililty.INSTANCE.getCurrentTimestamp());

                mRecordStatRemoteRepository.storePhotos(photosModels)
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                recordStatModel.getPhotosTimestamp().setRoomSaveInitTime(Utililty.INSTANCE.getCurrentTimestamp());
                            }

                            @Override
                            public void onComplete() {
                                recordStatModel.getPhotosTimestamp().setRoomSaveDoneTime(Utililty.INSTANCE.getCurrentTimestamp());
                                recordStatModelMutableLiveData.setValue(recordStatModel);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });

    }

    public void fetchTodos() {
        mRecordStatRemoteRepository.fetchTodos().subscribe(new SingleObserver<List<TodosModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposables.add(d);
                recordStatModel.getTodosTimestamp().setApiRequestTime(Utililty.INSTANCE.getCurrentTimestamp());
            }

            @Override
            public void onSuccess(@NonNull List<TodosModel> todosModels) {
                recordStatModel.getTodosTimestamp().setApiResponseTime(Utililty.INSTANCE.getCurrentTimestamp());

                mRecordStatRemoteRepository.storeTodos(todosModels)
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                recordStatModel.getTodosTimestamp().setRoomSaveInitTime(Utililty.INSTANCE.getCurrentTimestamp());
                            }

                            @Override
                            public void onComplete() {
                                recordStatModel.getTodosTimestamp().setRoomSaveDoneTime(Utililty.INSTANCE.getCurrentTimestamp());
                                recordStatModelMutableLiveData.setValue(recordStatModel);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });

    }

    public void fetchPosts() {
        mRecordStatRemoteRepository.fetchPosts().subscribe(new SingleObserver<List<PostsModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposables.add(d);
                recordStatModel.getPostsTimestamp().setApiRequestTime(Utililty.INSTANCE.getCurrentTimestamp());
            }

            @Override
            public void onSuccess(@NonNull List<PostsModel> postsModels) {
                recordStatModel.getPostsTimestamp().setApiResponseTime(Utililty.INSTANCE.getCurrentTimestamp());

                mRecordStatRemoteRepository.storePosts(postsModels)
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                recordStatModel.getPostsTimestamp().setRoomSaveInitTime(Utililty.INSTANCE.getCurrentTimestamp());
                            }

                            @Override
                            public void onComplete() {
                                recordStatModel.getPostsTimestamp().setRoomSaveDoneTime(Utililty.INSTANCE.getCurrentTimestamp());
                                recordStatModelMutableLiveData.setValue(recordStatModel);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });

    }

    @Override
    protected void onCleared() {
        for (Disposable d :
                disposables) {
            if (d != null && !d.isDisposed())
                d.dispose();
        }
        disposables.clear();
        super.onCleared();
    }
}
