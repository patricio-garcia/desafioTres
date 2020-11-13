package cl.desafiolatam.desafiotres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;

public class Fragmento extends Fragment {

    int radioButtonValue = 0;
    private TextView preguntaView, categoriaView, dificultadView;
    private RadioGroup grupoRespuestasView;
    private RadioButton respuestaUno, respuestaDos;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View inflate = inflater.inflate(R.layout.fragment_main, container,false);
        initViews(inflate);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String question = bundle.getString("PREGUNTA");
            String category = bundle.getString("CATEGORIA");
            String dificultad = bundle.getString("DIFICULTAD");
            String correctAnswer = bundle.getString("RESPUESTA_CORRECTA");
            ArrayList<String> incorrectAnswers = bundle.getStringArrayList("RESPUESTAS_INCORRECTAS");
            preguntaView.setText(question);
            categoriaView.setText(category);
            categoriaView.setText(dificultad);
            if (incorrectAnswers != null) {
                ArrayList<String> answers = new ArrayList<>(incorrectAnswers);
                answers.add(correctAnswer);
                Collections.shuffle(answers);
                for (int i = 0; i < 2; i++) {
                    switch (i) {
                        case 0:
                            respuestaUno.setText(answers.get(i));
                            break;
                        case 1:
                            respuestaDos.setText(answers.get(i));
                            break;
                    }
                }
            }
        }
        return inflate;
    }

    private void initViews(View view) {
        preguntaView = view.findViewById(R.id.pregunta);
        categoriaView = view.findViewById(R.id.categoria);
        dificultadView = view.findViewById(R.id.dificultad);
        grupoRespuestasView = view.findViewById(R.id.radioGrupoRespuestas);
        respuestaUno = view.findViewById(R.id.radioRespuestaUno);
        respuestaDos = view.findViewById(R.id.radioRespuestaDos);
    }

    public static Fragmento newInstance(String pregunta, String categoria, String dificultad, String respuestaCorrecta, ArrayList<String> respuestasIncorrectas) {
        Fragmento fragment = new Fragmento();
        Bundle arguments = new Bundle();
        arguments.putString("PREGUNTA", pregunta);
        arguments.putString("CATEGORIA", categoria);
        arguments.putString("DIFICULTAD", dificultad);
        arguments.putString("RESPUESTA_CORRECTA", respuestaCorrecta);
        arguments.putStringArrayList("RESPUESTAS_INCORRECTAS", respuestasIncorrectas);
        fragment.setArguments(arguments);
        return fragment;
    }
}
