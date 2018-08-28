package id.slametriyadi.simplejadwalsholat.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.slametriyadi.simplejadwalsholat.Model.ItemsItem;
import id.slametriyadi.simplejadwalsholat.Model.ResponseJadwalSholat;
import id.slametriyadi.simplejadwalsholat.Network.ApiService;
import id.slametriyadi.simplejadwalsholat.Network.InstanceRetrofit;
import id.slametriyadi.simplejadwalsholat.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtCity)
    TextView txtCity;
    @BindView(R.id.txtState)
    TextView txtState;
    @BindView(R.id.txtClock)
    TextView txtClock;
    @BindView(R.id.txtJadwalSholat)
    RecyclerView txtJadwalSholat;

    List<ResponseJadwalSholat> dataLokasi;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        getData(); //2
    }

    private void getData() {
        ApiService api = InstanceRetrofit.getInstance();
        Call<ResponseJadwalSholat> call = api.readJadwalSholat();
        call.enqueue(new Callback<ResponseJadwalSholat>() {
            @Override
            public void onResponse(Call<ResponseJadwalSholat> call, Response<ResponseJadwalSholat> response) {
                if (response.body().getStatusCode() == 1){
                    txtCity.setText(response.body().getCity());
                    txtState.setText(response.body().getCountry());

                    List<ItemsItem> jadwalSholat = response.body().getItems();
                    txtClock.setText(jadwalSholat.get(0).getIsha());
//                    txtJadwalSholat.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                    txtJadwalSholat.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseJadwalSholat> call, Throwable t) {

            }
        });
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder>{
        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.)
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class MyHolder extends RecyclerView.ViewHolder {
            public MyHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
