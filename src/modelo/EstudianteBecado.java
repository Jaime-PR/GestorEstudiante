/*
 * Autor: Jaime Alfredo Perez Rivera
 * Descripción: Clase EstudianteBecado. Hereda de Estudiante y agrega el porcentaje de beca. Necesita un promedio mínimo mayor.
 */
package modelo;

public class EstudianteBecado extends Estudiante {

    private float porcentajeBeca;

    public EstudianteBecado(String nombre, String matricula, float porcentajeBeca) {
        super(nombre, matricula);
        if (porcentajeBeca >= 0 && porcentajeBeca <= 100) {
            this.porcentajeBeca = porcentajeBeca;
        } else {
            this.porcentajeBeca = 0;
        }
    }

    public float getPorcentajeBeca() {
        return porcentajeBeca;
    }

    public void setPorcentajeBeca(float porcentajeBeca) {
        if (porcentajeBeca >= 0 && porcentajeBeca <= 100) {
            this.porcentajeBeca = porcentajeBeca;
        }
    }

    @Override
    public float getPromedioMinimo() {
        return 8;
    }

    public boolean conservaBeca() {
        return estaAprobado();
    }

    public float calcularMontoBeca(float costo) {
        return costo * porcentajeBeca / 100;
    }
}
