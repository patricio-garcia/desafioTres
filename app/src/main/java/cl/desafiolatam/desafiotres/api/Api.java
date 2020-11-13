package cl.desafiolatam.desafiotres.api;

import cl.desafiolatam.desafiotres.pojos.PreguntaLista;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api.php?amount=10&category=1&difficulty=easy")
    Call<PreguntaLista> getAllQuestions();
}
