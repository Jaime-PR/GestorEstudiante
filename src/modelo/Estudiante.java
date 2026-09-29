/*
 * Autor: Jaime Alfredo Perez Rivera
 * Descripción: Clase Estudiante (TDA). Guarda el nombre, la matrícula y las calificaciones, y calcula el promedio y si el estudiante aprobó.
 */
package modelo;

import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String matricula;
    private final ArrayList<Float> calificaciones;

    public Estudiante(String nombre, String matricula) {
        if (nombre.equals("")) {
            this.nombre = "Sin nombre";
        } else {
            this.nombre = nombre;
        }

        if (matricula.equals("")) {
            this.matricula = "Sin matrícula";
        } else {
            this.matricula = matricula;
        }

        this.calificaciones = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.equals("")) {
            this.nombre = nombre;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (!matricula.equals("")) {
            this.matricula = matricula;
        }
    }

    public ArrayList<Float> getCalificaciones() {
        return calificaciones;
    }

    public float getPromedioMinimo() {
        return 7;
    }

    public boolean agregarCalificacion(float calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            calificaciones.add(calificacion);
            return true;
        }
        return false;
    }

    public float sumarCalificaciones(int posicion) {
        if (posicion >= calificaciones.size()) {
            return 0;
        }
        return calificaciones.get(posicion) + sumarCalificaciones(posicion + 1);
    }

    public float calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0;
        }
        return sumarCalificaciones(0) / calificaciones.size();
    }

    public boolean estaAprobado() {
        return calcularPromedio() >= getPromedioMinimo();
    }

    public float obtenerMejorNota() {
        float mejor = 0;
        for (float nota : calificaciones) {
            if (nota > mejor) {
                mejor = nota;
            }
        }
        return mejor;
    }

    public String obtenerEstado() {
        if (estaAprobado()) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }
}