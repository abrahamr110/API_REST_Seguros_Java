package com.es.segurosinseguros.Controller;

import com.es.segurosinseguros.DTO.SeguroDTO;
import com.es.segurosinseguros.Exception.BadRequest;
import com.es.segurosinseguros.Service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {
    private final SeguroService seguroService;

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

    @GetMapping("/")
    public ResponseEntity<List<SeguroDTO>> getAll(){
        return ResponseEntity.ok(seguroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(seguroService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<SeguroDTO> addSeguro(@RequestBody SeguroDTO seguroDTO){
        return ResponseEntity.created(null).body(seguroService.addSeguro(seguroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguroDTO> updateSeguro(@RequestBody SeguroDTO seguroDTO, @PathVariable Long id){
        return ResponseEntity.ok(seguroService.updateSeguro(id, seguroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SeguroDTO> deleteSeguro(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
