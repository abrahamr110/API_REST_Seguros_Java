package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    // Autowired
    @Autowired
    private SeguroService seguroService;

    /**
     * Devuelve todos los seguros almacenados en la base de datos
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<SeguroDTO>> getAll() {
        return null;
    }

    /**
     * Método para obtener un seguro dado su id
     * endpoint -> localhost:8080/seguros/{id}
     * @param id {@link String} id del seguro
     * @return {@link ResponseEntity<SeguroDTO>} con status code 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable String id) {

        // 1º Compruebo que el id no es null
        if(id == null || id.isBlank()) {
            // LANZO UNA EXCEPCION PROPIA
            /*
            a) Qué código de estado devolveríais -> BAD_REQUEST (400)
            b) Qué información daríais al cliente
            -> Un mensaje: "id no válido" "el id no puede ser null"
            -> La URI: localhost:8080/seguros/x
            c) Nombre a nuestra excepcion -> BadRequestException
             */
            throw new BadRequestException("id no válido");
        }
        SeguroDTO sDto = seguroService.getById(id);
        return new ResponseEntity<>(sDto, HttpStatus.OK);
    }

    /**
     * Inserta un seguro en la BDD
     * @param sDto
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<SeguroDTO> insert(
            @RequestBody SeguroDTO sDto
    ) {
        return null;
    }

    /**
     * Actualiza un recurso en la BDD buscando por su id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<SeguroDTO> update(
            @RequestBody SeguroDTO sDto,
            @PathVariable String id
    ) {
        return null;
    }

    /**
     * Elimina un seguro de la BDD
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable String id
    ) {

    }




}
