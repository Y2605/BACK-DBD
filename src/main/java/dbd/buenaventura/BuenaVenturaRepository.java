package dbd.buenaventura;

import dbd.buenaventura.models.ListadoIPERC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
