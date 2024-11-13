package com.es.segurosinseguros.Controller;

import com.es.segurosinseguros.DTO.SeguroDTO;
import com.es.segurosinseguros.Exception.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seguro")
public class SeguroController {
    @Autowired

    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable String id) {
        if(id==null){
            throw new BadRequest("El id no puede ser nulo");
        }

        return null;
    }

}
