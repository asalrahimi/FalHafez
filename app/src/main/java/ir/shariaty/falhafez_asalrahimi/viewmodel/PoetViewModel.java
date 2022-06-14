package ir.shariaty.falhafez_asalrahimi.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ir.shariaty.falhafez_asalrahimi.model.Poet;
import ir.shariaty.falhafez_asalrahimi.network.Api;
import ir.shariaty.falhafez_asalrahimi.network.PoetPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoetViewModel extends ViewModel {

    // ** properties
    private final MutableLiveData<List<Poet>> poetList;

    // ** constructor
    public PoetViewModel() {
        poetList = new MutableLiveData<>();
    }

    // ** response list getter
    public MutableLiveData<List<Poet>> getPoetList() {
        return poetList;
    }

    // ** function for fetch data and set response in poetList
    public void makeApiCall(){
        PoetPlaceHolderApi poetPlaceHolderApi = Api.getRetrofit().create(PoetPlaceHolderApi.class);
        Call<List<Poet>> call = poetPlaceHolderApi.getPoets();
        call.enqueue(new Callback<List<Poet>>() {
            @Override
            public void onResponse(Call<List<Poet>> call, Response<List<Poet>> response) {
                poetList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Poet>> call, Throwable t) {

                poetList.postValue(null);
            }
        });
    }
}
