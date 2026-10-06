package com.titantrack.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.titantrack.app.R;
import com.titantrack.app.models.Ejercicio;

import java.util.List;

public class EjercicioAdapter extends RecyclerView.Adapter<EjercicioAdapter.EjercicioViewHolder> {

    private final List<Ejercicio> listaEjercicios;

    public EjercicioAdapter(List<Ejercicio> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }

    @NonNull
    @Override
    public EjercicioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ejercicio, parent, false);
        return new EjercicioViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull EjercicioViewHolder holder, int position) {
        Ejercicio ejercicio = listaEjercicios.get(position);
        holder.txtNombre.setText(ejercicio.getNombre());
        holder.txtGrupoMuscular.setText(ejercicio.getGrupoMuscular());
        holder.txtSeries.setText(ejercicio.getSeries());
        holder.txtNivel.setText(ejercicio.getNivel());
    }

    @Override
    public int getItemCount() {
        return listaEjercicios.size();
    }

    static class EjercicioViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre, txtGrupoMuscular, txtSeries, txtNivel;

        EjercicioViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtGrupoMuscular = itemView.findViewById(R.id.txtGrupoMuscular);
            txtSeries = itemView.findViewById(R.id.txtSeries);
            txtNivel = itemView.findViewById(R.id.txtNivel);
        }
    }
}