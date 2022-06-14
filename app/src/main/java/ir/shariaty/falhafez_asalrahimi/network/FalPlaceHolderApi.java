package ir.shariaty.falhafez_asalrahimi.network;


import ir.shariaty.falhafez_asalrahimi.model.Fal;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FalPlaceHolderApi {

    @GET("hafez/faal")
    Call<Fal> getFal();


}
