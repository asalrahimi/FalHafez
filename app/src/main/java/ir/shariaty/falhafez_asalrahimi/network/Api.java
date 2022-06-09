package ir.shariaty.falhafez_asalrahimi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static Retrofit instance;

    public static Retrofit getRetrofit() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("https://ganjgah.ir/api/ganjoor/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
