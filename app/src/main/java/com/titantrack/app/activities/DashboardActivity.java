package com.titantrack.app.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.titantrack.app.R;
import com.titantrack.app.adapters.EjercicioAdapter;
import com.titantrack.app.models.Ejercicio;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtContenido = findViewById(R.id.txtContenido);
        LinearLayout headerEntrenos = findViewById(R.id.headerEntrenos);
        RecyclerView rvEjercicios = findViewById(R.id.rvEjercicios);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // Mock data
        List<Ejercicio> listaEjercicios = new ArrayList<>();
        listaEjercicios.add(new Ejercicio("Press de banca", "Pecho", "4 x 10", "Intermedio"));
        listaEjercicios.add(new Ejercicio("Sentadilla", "Piernas", "4 x 8", "Intermedio"));
        listaEjercicios.add(new Ejercicio("Peso muerto", "Espalda", "3 x 6", "Avanzado"));
        listaEjercicios.add(new Ejercicio("Dominadas", "Espalda", "4 x 8", "Avanzado"));
        listaEjercicios.add(new Ejercicio("Press militar", "Hombros", "3 x 10", "Intermedio"));
        listaEjercicios.add(new Ejercicio("Curl de bíceps", "Brazos", "3 x 12", "Principiante"));
        listaEjercicios.add(new Ejercicio("Extensión de tríceps", "Brazos", "3 x 12", "Principiante"));
        listaEjercicios.add(new Ejercicio("Zancadas", "Piernas", "3 x 12", "Principiante"));
        listaEjercicios.add(new Ejercicio("Plancha", "Core", "3 x 45 s", "Principiante"));
        listaEjercicios.add(new Ejercicio("Remo con barra", "Espalda", "4 x 10", "Intermedio"));
        listaEjercicios.add(new Ejercicio("Elevaciones laterales", "Hombros", "3 x 15", "Principiante"));
        listaEjercicios.add(new Ejercicio("Hip thrust", "Glúteos", "4 x 10", "Intermedio"));

        // RecyclerView + Adapter
        rvEjercicios.setLayoutManager(new LinearLayoutManager(this));
        rvEjercicios.setAdapter(new EjercicioAdapter(listaEjercicios));

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_entrenos) {
                txtContenido.setVisibility(View.GONE);
                headerEntrenos.setVisibility(View.VISIBLE);
                rvEjercicios.setVisibility(View.VISIBLE);
                return true;
            }

            headerEntrenos.setVisibility(View.GONE);
            rvEjercicios.setVisibility(View.GONE);
            txtContenido.setVisibility(View.VISIBLE);

            if (id == R.id.nav_inicio) {
                txtContenido.setText(R.string.nav_inicio);
                return true;
            } else if (id == R.id.nav_progreso) {
                txtContenido.setText(R.string.nav_progreso);
                return true;
            } else if (id == R.id.nav_perfil) {
                txtContenido.setText(R.string.nav_perfil);
                return true;
            }

            return false;
        });
    }
}