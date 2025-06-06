package com.example.text2image.api;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://ai.elliottwen.info/";
    private static RetrofitClient instance = null;
    private final ApiService apiService;

    private RetrofitClient() {
        // Create logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // Log request/response body

        // Configure Certificate Pinning
        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add("ai.elliottwen.info", "sha256/47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=")
                .build();

        // Add to OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .certificatePinner(certificatePinner)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }
}