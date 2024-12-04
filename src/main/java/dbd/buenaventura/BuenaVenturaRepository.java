package dbd.buenaventura;

import dbd.buenaventura.models.Empleado;
import dbd.buenaventura.models.Informe;
import dbd.buenaventura.models.ListadoIPERC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuenaVenturaRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    List<ListadoIPERC> getListadoIPERC(){
        String SQL="SELECT\n" +
                "    i.id_proceso,\n" +
                "    TRIM(p.descripcion_proceso) AS \"proceso\",\n" +
                "    TO_CHAR(i.fecha_act_sup, 'DD/MM/YYYY') AS \"ult_fecha_act\"\n" +
                "FROM\n" +
                "    informe_iperc i\n" +
                "        JOIN\n" +
                "    proceso p ON i.id_proceso = p.id_proceso\n" +
                "ORDER BY\n" +
                "    i.fecha_act_sup DESC\n";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(ListadoIPERC.class));
    }

    List<Empleado> getEmpleados(Integer id_proceso){
        String SQL="SELECT e.id_empleado, e.nombre\n" +
                "FROM empleado e\n";

        if(id_proceso!=null) {
            SQL += "INNER JOIN equipoevaluadorxempleado eee ON e.id_empleado = eee.id_empleado\n" +
                    "INNER JOIN equipo_evaluador ee ON ee.id_equipo_evaluador = eee.id_equipo_evaluador\n" +
                    "INNER JOIN proceso p ON p.id_equipo_evaluador = ee.id_equipo_evaluador\n" +
                    "WHERE p.id_proceso = "+id_proceso;
        }
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Empleado.class));
    }

    Informe getInforme(int id_proceso){
        String SQL="SELECT TO_CHAR(ii.fecha_registro, 'DD/MM/YYYY') as \"fechaRegistro\",\n" +
                "       ii.unidad_minera as \"unidadMinera\",\n" +
                "       ii.area,TRIM(p.descripcion_proceso) as \"proceso\"\n" +
                "FROM informe_iperc ii\n" +
                "INNER JOIN proceso p on ii.id_proceso = p.id_proceso\n" +
                "WHERE p.id_proceso=?";
        Informe i=jdbcTemplate.queryForObject(SQL, new Object[]{id_proceso}, new BeanPropertyRowMapper<>(Informe.class));
        List<Empleado> equipoEvaluador=this.getEmpleados(id_proceso);
        i.setEquipoEvaluador(equipoEvaluador);
        return i;
    }
}
