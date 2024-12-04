package dbd.buenaventura;

import dbd.buenaventura.models.Empleado;
import dbd.buenaventura.models.Informe;
import dbd.buenaventura.models.ListadoIPERC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${url.client}")
@RestController // Ruta base para este controlador
@RequestMapping("/buenaventura")
public class BuenaVenturaController {

    @Autowired
    private BuenaVenturaService buenaVenturaService;  // Servicio que maneja la lógica de los empleados

    // Muestra la página principal o alguna vista
    @GetMapping("/getListadoIPERC")
    public List<ListadoIPERC> getListadoIPERC() {
        return buenaVenturaService.getListadoIPERC();
    }

    @GetMapping("/getEmpleados")
    List<Empleado> getEmpleados(@RequestParam(required = false) Integer id_proceso){
        System.out.println("id_proceso: "+id_proceso);
        return buenaVenturaService.getEmpleados(id_proceso);
    }

    @GetMapping("/getInforme")
    Informe getInforme(@RequestParam int id_proceso){
        return buenaVenturaService.getInforme(id_proceso);
    }
}

