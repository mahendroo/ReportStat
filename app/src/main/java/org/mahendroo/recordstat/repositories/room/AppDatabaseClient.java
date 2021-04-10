package org.mahendroo.recordstat.repositories.room;


import android.content.Context;

import androidx.room.Room;

public class AppDatabaseClient {

    private static final AppDatabaseClient ourInstance = new AppDatabaseClient();
    private static AppDatabase appDatabase = null;

    private AppDatabaseClient() {

    }

    public static AppDatabaseClient getInstance() {
        return ourInstance;
    }

    public AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, RoomConstants.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return appDatabase;
    }


}

