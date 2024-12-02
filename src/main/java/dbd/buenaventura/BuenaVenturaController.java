package dbd.buenaventura;

import dbd.buenaventura.models.ListadoIPERC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

