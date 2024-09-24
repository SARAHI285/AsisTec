package com.hesarahi.asistec;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import android.content.Intent;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frgSplash#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frgSplash extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frgSplash() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frgSplash.
     */
    // TODO: Rename and change types and number of parameters
    public static frgSplash newInstance(String param1, String param2) {
        frgSplash fragment = new frgSplash();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_splash, container, false);

        // Configurar el temporizador para el splash (2 segundos)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Navegar a la siguiente pantalla (puede ser otra actividad o fragmento)
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.flip_in, R.anim.flip_out);
                getActivity().finish(); // Finaliza la actividad actual si es necesario
            }
        }, 3000); // Duración de 2 segundos

        return view;
    }
}