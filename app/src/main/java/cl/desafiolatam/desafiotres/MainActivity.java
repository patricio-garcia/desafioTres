package cl.desafiolatam.desafiotres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import cl.desafiolatam.desafiotres.api.Api;
import cl.desafiolatam.desafiotres.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarApi();
    }

    private void cargarApi() {
        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
    }
}