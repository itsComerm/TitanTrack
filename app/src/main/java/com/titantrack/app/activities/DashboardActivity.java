package com.titantrack.app.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.titantrack.app.R;

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
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_inicio) {
                txtContenido.setText(R.string.nav_inicio);
                return true;
            } else if (id == R.id.nav_entrenos) {
                txtContenido.setText(R.string.nav_entrenos);
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