package domain.correlativas;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre;
    @Getter
    private List<Materia> materias;

    public Alumno(String nombre, String carrera) {
        this.nombre = nombre;
    }

    public void setMaterias(Materia ... materia) {
        Collections.addAll(materias, materia);
    }
}
