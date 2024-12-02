package dbd.buenaventura;

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
}
