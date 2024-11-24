package com.es.segurosinseguros.Controller;

import com.es.segurosinseguros.DTO.AsistenciaMedicaDTO;
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

    @PostMapping("/")
    public ResponseEntity<AsistenciaMedicaDTO> addAsistenciaMedica(
            @RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO, Long idSeguro
    ){
        return ResponseEntity.created(null).body(asistenciaMedicaService.addAsistenciaMedica(asistenciaMedicaDTO,idSeguro));
    }

    @PutMapping("/")
    public ResponseEntity<AsistenciaMedicaDTO> updateAsistenciaMedica(@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO, Long idAsistencia){
        return ResponseEntity.ok(asistenciaMedicaService.updateAsistenciaMedica(asistenciaMedicaDTO,idAsistencia));
    }

    @PutMapping("/{idAsistencia}")
    public ResponseEntity<AsistenciaMedicaDTO> putById(@PathVariable Long idAsistencia,@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO){
        return ResponseEntity.ok(asistenciaMedicaService.putById(idAsistencia,asistenciaMedicaDTO));
    }

    @DeleteMapping("/{idAsistencia}")
    public ResponseEntity<AsistenciaMedicaDTO> deleteAsistenciaMedica(@PathVariable Long idAsistencia){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<AsistenciaMedicaDTO>> getAll(){
        return ResponseEntity.ok(asistenciaMedicaService.getAll());
    }
}