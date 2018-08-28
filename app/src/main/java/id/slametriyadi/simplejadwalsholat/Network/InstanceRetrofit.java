package id.slametriyadi.simplejadwalsholat.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstanceRetrofit {
    public static final String WebUrl = "http://muslimsalat.com/";

    private static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(WebUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
