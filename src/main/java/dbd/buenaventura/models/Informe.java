package dbd.buenaventura.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Informe {
    List<Empleado> equipoEvaluador;
    String proceso;
    String unidadMinera;
    String fechaRegistro;
    String area;
}
