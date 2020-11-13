package cl.desafiolatam.desafiotres.api;

import cl.desafiolatam.desafiotres.pojos.PreguntaLista;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api.php?amount=10&category=98&difficulty=medium&type=boolean")
    Call<PreguntaLista> getAllQuestions();
}
