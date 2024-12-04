package dbd.buenaventura;

import dbd.buenaventura.models.Empleado;
import dbd.buenaventura.models.Informe;
import dbd.buenaventura.models.ListadoIPERC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuenaVenturaService {
    @Autowired
    BuenaVenturaRepository buenaVenturaRepository;

    List<ListadoIPERC> getListadoIPERC(){
        return buenaVenturaRepository.getListadoIPERC();
    }

    List<Empleado> getEmpleados(Integer id_proceso){
        return buenaVenturaRepository.getEmpleados(id_proceso);
    }

    Informe getInforme(int id_proceso){
        return buenaVenturaRepository.getInforme(id_proceso);
    }
}
