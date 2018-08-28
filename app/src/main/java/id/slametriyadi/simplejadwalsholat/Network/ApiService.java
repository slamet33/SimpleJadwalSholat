package id.slametriyadi.simplejadwalsholat.Network;

import id.slametriyadi.simplejadwalsholat.Model.ResponseJadwalSholat;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("tangerang.json?key=d1aa7cdf5e8c0d2d7f1f47811497a732")
    Call<ResponseJadwalSholat> readJadwalSholat();

}
