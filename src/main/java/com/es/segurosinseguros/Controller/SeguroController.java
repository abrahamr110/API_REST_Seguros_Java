package com.es.segurosinseguros.Controller;

import com.es.segurosinseguros.DTO.SeguroDTO;
import com.es.segurosinseguros.Exception.BadRequest;
import com.es.segurosinseguros.Service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.es.segurosinseguros.Entities.Seguro;
import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {
    @Autowired
    private final SeguroService seguroService;

    private String NIF_REGEX =
            "^(\\d{8}[A-Z])|([XYZ]\\d{7}[A-Z])|([ABCDEFGHJKLMNPQRSUVW]\\d{7}[0-9A-J])$";

    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }
    /*@GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable String id) {
        if(id==null){
            throw new BadRequest("El id no puede ser nulo");
        }

        return null;
    }*/

    public void ValidateSeguro(SeguroDTO seguro) {
        if(!seguro.getNif().matches(NIF_REGEX)){
            throw new BadRequest("El campo NIF no tiene un formato válido.",400);
        }
        if(seguro.getNombre().isEmpty()&&seguro.getApe1().isEmpty()){
            throw new BadRequest("El campo {nombre/ape1} no puede estar vacío.",400);
        }
        if(seguro.getEdad()<18 && seguro.getEdad()<0) {
            throw new BadRequest("No es posible ser menor de edad para hacer un seguro.", 400);
        }
        if(!seguro.isCasado() && seguro.getNumHijos()>=0){
            throw new BadRequest("Un seguro no puede registrar hijos si no está casado.",400);
        }
        if(seguro.getSexo().equalsIgnoreCase("hombre")&& seguro.isEmbarazada()){
            throw new BadRequest("El campo embarazada no puede ser true si el asegurado es hombre.",400);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<SeguroDTO>> getAll(){
        ValidateSeguro(seguroService.getAll().get(0));

        return ResponseEntity.ok(seguroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable Long id){
        ValidateSeguro(seguroService.getById(id));

        return ResponseEntity.ok(seguroService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<SeguroDTO> addSeguro(@RequestBody SeguroDTO seguroDTO){
        ValidateSeguro(seguroDTO);

        return ResponseEntity.created(null).body(seguroService.addSeguro(seguroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguroDTO> updateSeguro(@RequestBody SeguroDTO seguroDTO, @PathVariable Long id){
        ValidateSeguro(seguroDTO);

        return ResponseEntity.ok(seguroService.updateSeguro(id, seguroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SeguroDTO> deleteSeguro(@PathVariable Long id){
        ValidateSeguro(seguroService.getById(id));

        return ResponseEntity.noContent().build();
    }
}

