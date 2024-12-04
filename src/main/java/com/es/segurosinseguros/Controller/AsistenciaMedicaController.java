package com.es.segurosinseguros.Controller;

import com.es.segurosinseguros.DTO.AsistenciaMedicaDTO;
import com.es.segurosinseguros.Exception.BadRequest;
import com.es.segurosinseguros.Service.AsistenciaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistenciamedica")
public class AsistenciaMedicaController {
    @Autowired
    private final AsistenciaMedicaService asistenciaMedicaService;

    public AsistenciaMedicaController(AsistenciaMedicaService asistenciaMedicaService) {
        this.asistenciaMedicaService = asistenciaMedicaService;
    }

    public void ValidateAsistenciaMedica(AsistenciaMedicaDTO asistenciaMedica){
        if(asistenciaMedica.getBreveDescripcion().isEmpty()){
            throw new BadRequest("El campo breveDescripcion no puede estar vacío.",400);
        }
        if(asistenciaMedica.getLugar().isEmpty()){
            throw new BadRequest("El campo lugar no puede estar vacío.",400);
        }
        if(asistenciaMedica.getExplicacion().isEmpty()){
            throw new BadRequest("El campo explicacion no puede estar vacío.",400);
        }
        if(asistenciaMedica.getTipoAsistencia()==null){
            throw new BadRequest("El campo tipoAsistencia no puede ser nulo.",400);
        }
        if(asistenciaMedica.getFecha()==null && asistenciaMedica.getHora()==null){
            throw new BadRequest("El campo {fecha/hora} no puede ser nulo.",400);
        }
        if(asistenciaMedica.getImporte()<=0){
            throw new BadRequest("El campo importe debe ser mayor que 0.",400);
        }
    }

    @PostMapping("/")
    public ResponseEntity<AsistenciaMedicaDTO> addAsistenciaMedica(
            @RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO, Long idSeguro
    ){
        ValidateAsistenciaMedica(asistenciaMedicaDTO);

        return ResponseEntity.created(null).body(asistenciaMedicaService.addAsistenciaMedica(asistenciaMedicaDTO,idSeguro));
    }

    @PutMapping("/")
    public ResponseEntity<AsistenciaMedicaDTO> updateAsistenciaMedica(@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO, Long idAsistencia){
        ValidateAsistenciaMedica(asistenciaMedicaDTO);

        return ResponseEntity.ok(asistenciaMedicaService.updateAsistenciaMedica(asistenciaMedicaDTO,idAsistencia));
    }

    @PutMapping("/{idAsistencia}")
    public ResponseEntity<AsistenciaMedicaDTO> putById(@PathVariable Long idAsistencia,@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO){
        ValidateAsistenciaMedica(asistenciaMedicaDTO);

        return ResponseEntity.ok(asistenciaMedicaService.putById(idAsistencia,asistenciaMedicaDTO));
    }

    @DeleteMapping("/{idAsistencia}")
    public ResponseEntity<AsistenciaMedicaDTO> deleteAsistenciaMedica(@PathVariable Long idAsistencia){
        ValidateAsistenciaMedica(asistenciaMedicaService.deleteById(idAsistencia));

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<AsistenciaMedicaDTO>> getAll(){
        ValidateAsistenciaMedica(asistenciaMedicaService.getAll().get(0));

        return ResponseEntity.ok(asistenciaMedicaService.getAll());
    }
}
