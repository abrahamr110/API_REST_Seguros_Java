package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SeguroRepository;
import com.es.segurosinseguros.util.Mapper;
import com.es.segurosinseguros.util.NIFValidator;
import com.es.segurosinseguros.util.SeguroValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class SeguroService {

    // Autowired
    @Autowired
    private SeguroRepository seguroRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private SeguroValidator seguroValidator;
    @Autowired
    private NIFValidator nifValidator;


    /**
     * Método que busca en la BDD todos los seguros de la BDD
     * @return
     */
    public List<SeguroDTO> getAll() {
        // Usando el método .findAll, obtengo todos los seguros de la BDD
        List<Seguro> allSeguros = seguroRepository.findAll();

        // Si la lista viene vacía, puedo lanzar una excepción con código 404
        if(allSeguros.isEmpty()) {
            throw new NotFoundException("No existen seguros en la base de datos");
        }

        // Convierto la lista de objetos Seguro a una lista de objetos SeguroDTO
        return allSeguros
                .stream()
                .map(seguro -> mapper.entityToDTO(seguro))
                .toList();
    }

    /**
     * Obtiene un seguro buscando por su id
     * @param id id del seguro a buscar
     * @return Objeto de tipo {@link SeguroDTO}
     * @exception BadRequestException
     * @exception NotFoundException
     */
    public SeguroDTO getById(String id) {

        // 1 Aplicamos la logica de negocio
        // -> El id debe ser Long
        Long idL = 0L;
        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("El formato del id: "+id+" es incorrecto");
        }

        // 2 Buscamos la entidad en la BDD
        Long finalIdL = idL;
        Seguro s = seguroRepository
                .findById(idL)
                .orElseThrow(() -> new NotFoundException("Seguro con id "+ finalIdL +" no encontrado"));

        return mapper.entityToDTO(s);
    }

    /**
     * Inserta un seguro en la BDD
     * @param sDto
     * @return
     */
    public SeguroDTO insert(SeguroDTO sDto) {

        // Validaciones de L.N.
        // 1 compruebo que los campos no sean null
        seguroValidator.checkFieldsNotNull(sDto);
        // 2 compruebo la edad del asegurado
        seguroValidator.checkMenorEdad(sDto);
        // 3 compruebo el campo embarazada
        seguroValidator.checkEmbarazada(sDto);
        // 4 compruebo el campo hijos
        seguroValidator.checkNumHijos(sDto);
        // 5 compruebo la validez del DNI
        nifValidator.checkDNI(sDto.getNif());
        // Los métodos anteriores contienen todas las comprobaciones de la entidad Seguro

        // Si t0d0 ha ido bien, puedo realizar la inserción en la BDD
        Seguro s = seguroRepository.save(mapper.dtoToEntity(sDto));

        return mapper.entityToDTO(s);
    }

    /**
     * Actualiza un recurso en la BDD buscando por su id
     * @return
     */
    public SeguroDTO update(SeguroDTO sDto, String id) {
        return null;
    }

    /**
     * Elimina un seguro de la BDD
     * @param id
     */
    public void delete(String id) {

    }
}
