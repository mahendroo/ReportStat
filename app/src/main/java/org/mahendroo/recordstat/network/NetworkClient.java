package org.mahendroo.recordstat.network;

import org.mahendroo.recordstat.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Used for setting up basic properties of all the API calls
 */
public class NetworkClient {

    private static final NetworkClient ourInstance = new NetworkClient();
    private static Retrofit retrofit = null;

    public static NetworkClient getInstance() {
        return ourInstance;
    }

    /**
     * prepare api client setup for one time only.
     *
     * @return api service.
     */
    public NetworkService getNetworkService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(NetworkService.class);
    }

    /**
     * Customisation of all the API Requests
     *
     * @return OkHttpClient.
     */
    private OkHttpClient getClient() {

        OkHttpClient.Builder clientBuilder = new OkHttpClient
                .Builder()
                .addInterceptor(getInterceptor())
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                })
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS);

        return clientBuilder.build();
    }

    /**
     * A logging interceptor, used for logging Request and response by intercepting an ongoing API call
     *
     * @return Interceptor.
     */
    private Interceptor getInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

}

