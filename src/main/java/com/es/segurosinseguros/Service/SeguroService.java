package com.es.segurosinseguros.Service;

import com.es.segurosinseguros.DTO.SeguroDTO;
import com.es.segurosinseguros.Entities.Seguro;
import com.es.segurosinseguros.Repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroService {
    @Autowired
    private final SeguroRepository seguroRepository;

    public SeguroService(SeguroRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
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
}
