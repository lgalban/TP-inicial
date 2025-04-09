package domain.correlativas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class InscripcionTest {

    @InjectMocks
    private Inscripcion inscripcion;

    @Mock
    private Materia am1, am2,am3, algebra ;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    public void verificarInscripcionFalse() {
        List<Materia> materias = Arrays.asList(algebra, am1);
        List<Materia> materiasCorrelativas = Arrays.asList(am2, algebra);
        Alumno alumno = mock(Alumno.class);
        List<Materia> materiaInscripcion = Collections.singletonList(am3);
        Inscripcion inscripcion = new Inscripcion(alumno, materiaInscripcion );

        when(alumno.getMaterias()).thenReturn(materias);
        when(am3.getCorrelativas()).thenReturn(materiasCorrelativas);

        assertFalse(inscripcion.aprobada());
    }
    @Test
    public void verificarInscripcionTrue() {
        List<Materia> materias = Arrays.asList(algebra, am1);
        List<Materia> materiasCorrelativas = Arrays.asList(algebra, am1);
        Alumno alumno = mock(Alumno.class);
        List<Materia> materiaInscripcion = Collections.singletonList(am2);
        Inscripcion inscripcion = new Inscripcion(alumno, materiaInscripcion );

        when(alumno.getMaterias()).thenReturn(materias);
        when(am2.puedeCursarMaterias(anyList())).thenReturn(true);

        Assertions.assertTrue(inscripcion.aprobada());
    }
}