package domain.correlativas;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private String numero;
    private Alumno alumno;
    @Getter
    private List<Materia> materias;
    @Getter
    private boolean estado;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public void addMaterias(Materia ... materia) {
        Collections.addAll(materias, materia);
    }

    public boolean aprobada() {
        List<Boolean> puedeCursarTodo= new ArrayList<>();
        verificarTodasLasMaterias(puedeCursarTodo);
        //this.materias.stream().allMatch(materia -> materia.puedeCursarMaterias(alumno.getMaterias()));
        estado= puedeCursarTodo.stream().allMatch(v1 -> v1==Boolean.TRUE);
        return estado;
    }


    private void verificarTodasLasMaterias(List<Boolean> puedeCursarTodo) {
        for (Materia materia : materias) {
            boolean puedeCursarla= materia.puedeCursarMaterias(alumno.getMaterias());
            puedeCursarTodo.add(puedeCursarla);
        }
    }
}
