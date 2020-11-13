package cl.desafiolatam.desafiotres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import cl.desafiolatam.desafiotres.api.Api;
import cl.desafiolatam.desafiotres.api.RetrofitClient;
import cl.desafiolatam.desafiotres.pojos.Pregunta;
import cl.desafiolatam.desafiotres.pojos.PreguntaLista;
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
        Call<PreguntaLista> call = service.getAllQuestions();

        call.enqueue(new Callback<PreguntaLista>()
        {
            @Override
            public void onResponse(Call<PreguntaLista> call, Response<PreguntaLista> response) {
                if (response != null) {
                    Pregunta pregunta = response.body().getResults().get(0);
                    crearFragmentPregunta(pregunta);
                }
            }

            @Override
            public void onFailure(Call<PreguntaLista> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: no pudimos recuperar los datos de opentdb", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void crearFragmentPregunta(Pregunta pregunta) {

        Fragmento fragmento = Fragmento.newInstance(
                pregunta.getPregunta(),
                pregunta.getCategoria(),
                pregunta.getDificultad(),
                pregunta.getCorrecta(),
                pregunta.getIncorrectas()
        );
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragmento,
                        "FRAGMENTO").commit();
    }
}