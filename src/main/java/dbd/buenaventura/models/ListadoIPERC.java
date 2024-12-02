package dbd.buenaventura.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListadoIPERC {
    int id_proceso;
    String proceso;
    String ult_fecha_act;
}
