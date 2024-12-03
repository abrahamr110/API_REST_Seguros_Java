package com.es.segurosinseguros.util;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.Seguro;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

@Component
public class Mapper {

    public SeguroDTO entityToDTO(Seguro s) {
        SeguroDTO sDto = new SeguroDTO();
        sDto.setNif(s.getNif());
        sDto.setNombre(s.getNombre());
        sDto.setApe1(s.getApe1());
        sDto.setApe2(s.getApe2());
        sDto.setEdad(s.getEdad());
        sDto.setNumHijos(s.getNumHijos());
        sDto.setSexo(s.getSexo());
        sDto.setCasado(s.isCasado());
        sDto.setEmbarazada(s.isEmbarazada());
        return sDto;
    }

    public Seguro dtoToEntity(SeguroDTO sDto) {
        Seguro s = new Seguro();
        s.setNif(        sDto.getNif());
        s.setNombre(     sDto.getNombre());
        s.setApe1(       sDto.getApe1());
        s.setApe2(       sDto.getApe2());
        s.setEdad(       sDto.getEdad());
        s.setNumHijos(   sDto.getNumHijos());
        s.setSexo(       sDto.getSexo());
        s.setCasado(     sDto.isCasado());
        s.setEmbarazada( sDto.isEmbarazada());
        s.setFechaCreacion(Date.from(Instant.now()));
        return s;
    }

}
