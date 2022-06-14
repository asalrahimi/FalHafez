package ir.shariaty.falhafez_asalrahimi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static Retrofit instance;

    public static Retrofit getRetrofit() {
            instance = new Retrofit.Builder()
                    .baseUrl("https://api.ganjoor.net/api/ganjoor/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return instance;
    }
}
