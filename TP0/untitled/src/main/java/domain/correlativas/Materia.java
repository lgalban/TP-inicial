package domain.correlativas;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    @Getter
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>();
    }

    public boolean puedeCursarMaterias(List<Materia> materias) {
        return correlativas.stream().allMatch(materias::contains);
    }
}
