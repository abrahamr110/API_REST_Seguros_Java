package com.es.segurosinseguros.Service;

import com.es.segurosinseguros.DTO.SeguroDTO;
import com.es.segurosinseguros.Entities.Seguro;
import com.es.segurosinseguros.Repository.SeguroRepository;
import org.hibernate.type.descriptor.jdbc.LocalDateTimeJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class SeguroService {
    @Autowired
    private final SeguroRepository seguroRepository;
    private final Date fechaActual;

    public SeguroService(SeguroRepository seguroRepository, Date fechaActual) {
        this.seguroRepository = seguroRepository;
        this.fechaActual = fechaActual;
    }

    public SeguroDTO mapToDto(Seguro seguro) {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNif(seguro.getNif());
        seguroDTO.setApe1(seguro.getApe1());
        seguroDTO.setApe2(seguro.getApe2());
        seguroDTO.setNombre(seguro.getNombre());
        seguroDTO.setCasado(seguro.isCasado());
        seguroDTO.setEdad(seguro.getEdad());
        seguroDTO.setNumHijos(seguro.getNumHijos());
        seguroDTO.setSexo(seguro.getSexo());
        return seguroDTO;
    }

    public List<SeguroDTO> getAll(){
        List<Seguro> allSeguros=seguroRepository.findAll();
        List<SeguroDTO> allSegurosDto= allSeguros.stream().map(seguro -> mapToDto(seguro)).toList();

        return allSegurosDto;
    }

    public SeguroDTO getById(Long id){
        Seguro seguro=seguroRepository.findById(id).orElse(null);
        return mapToDto(seguro);
    }

    public SeguroDTO addSeguro(SeguroDTO seguroDTO){
        Seguro seguro=new Seguro();
        seguro.setNombre(seguroDTO.getNombre());
        seguro.setApe1(seguroDTO.getApe1());
        seguro.setApe2(seguroDTO.getApe2());
        seguro.setNif(seguroDTO.getNif());
        seguro.setEdad(seguroDTO.getEdad());
        seguro.setSexo(seguroDTO.getSexo());
        seguro.setCasado(seguroDTO.isCasado());
        seguro.setNumHijos(seguroDTO.getNumHijos());
        seguro.setEmbarazada(seguroDTO.isEmbarazada());
        seguro.setFechaCreacion(fechaActual);
        seguro.setFechaInicio("15-11-2024");
        seguro=seguroRepository.save(seguro);

        return mapToDto(seguro);
    }
}
