package ir.shariaty.falhafez_asalrahimi.network;

import java.util.List;

import ir.shariaty.falhafez_asalrahimi.model.Poet;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PoetPlaceHolderApi {

    @GET("poets")
     Call<List<Poet>> getPoets();

}
