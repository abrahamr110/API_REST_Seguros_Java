package com.es.segurosinseguros.Service;


import com.es.segurosinseguros.DTO.AsistenciaMedicaDTO;
import com.es.segurosinseguros.Entities.AsistenciaMedica;
import com.es.segurosinseguros.Repository.AsistenciaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaMedicaService {
    @Autowired
    private final AsistenciaMedicaRepository asistenciaMedicaRepository;

    public AsistenciaMedicaService(AsistenciaMedicaRepository asistenciaMedicaRepository) {
        this.asistenciaMedicaRepository = asistenciaMedicaRepository;
    }

    public AsistenciaMedicaDTO mapToDto(AsistenciaMedica asistenciaMedica){
        AsistenciaMedicaDTO asistenciaMedicaDTO = new AsistenciaMedicaDTO();
        asistenciaMedicaDTO.setBreveDescripcion(asistenciaMedica.getBreveDescripcion());
        asistenciaMedicaDTO.setLugar(asistenciaMedica.getLugar());
        asistenciaMedicaDTO.setFecha(asistenciaMedica.getFecha());
        asistenciaMedicaDTO.setHora(asistenciaMedica.getHora());
        asistenciaMedicaDTO.setImporte(asistenciaMedica.getImporte());
        asistenciaMedicaDTO.setTipoAsistencia(asistenciaMedica.getTipoAsistencia());
        asistenciaMedicaDTO.setExplicacion(asistenciaMedica.getExplicacion());
        return asistenciaMedicaDTO;
    }

    public AsistenciaMedicaDTO addAsistenciaMedica(AsistenciaMedicaDTO asistenciaMedicaDTO,Long idSeguro){ {
        AsistenciaMedica asistenciaMedica = new AsistenciaMedica();

        if(asistenciaMedica.getSeguro().getIdSeguro().equals(idSeguro)){
            asistenciaMedica.setBreveDescripcion(asistenciaMedicaDTO.getBreveDescripcion());
            asistenciaMedica.setLugar(asistenciaMedicaDTO.getLugar());
            asistenciaMedica.setFecha(asistenciaMedicaDTO.getFecha());
            asistenciaMedica.setHora(asistenciaMedicaDTO.getHora());
            asistenciaMedica.setImporte(asistenciaMedicaDTO.getImporte());
            asistenciaMedica.setTipoAsistencia(asistenciaMedicaDTO.getTipoAsistencia());
            asistenciaMedica.setExplicacion(asistenciaMedicaDTO.getExplicacion());
            asistenciaMedicaRepository.save(asistenciaMedica);
        }
        return mapToDto(asistenciaMedica);
        }
    }

    public AsistenciaMedicaDTO updateAsistenciaMedica(AsistenciaMedicaDTO asistenciaMedicaDTO, Long idAsistencia) {
        AsistenciaMedica asistenciaMedica = asistenciaMedicaRepository.findById(idAsistencia).orElse(null);
        asistenciaMedica.setBreveDescripcion(asistenciaMedicaDTO.getBreveDescripcion());
        asistenciaMedica.setLugar(asistenciaMedicaDTO.getLugar());
        asistenciaMedica.setFecha(asistenciaMedicaDTO.getFecha());
        asistenciaMedica.setHora(asistenciaMedicaDTO.getHora());
        asistenciaMedica.setImporte(asistenciaMedicaDTO.getImporte());
        asistenciaMedica.setTipoAsistencia(asistenciaMedicaDTO.getTipoAsistencia());
        asistenciaMedica.setExplicacion(asistenciaMedicaDTO.getExplicacion());

        asistenciaMedicaRepository.save(asistenciaMedica);

        return mapToDto(asistenciaMedica);
    }

    public List<AsistenciaMedicaDTO> getAll() {
        List<AsistenciaMedica> allAsistenciasMedicas = asistenciaMedicaRepository.findAll();
        List<AsistenciaMedicaDTO> allAsistenciasMedicasDto = allAsistenciasMedicas.stream().map(asistenciaMedica -> mapToDto(asistenciaMedica)).toList();
        return allAsistenciasMedicasDto;
    }

    public AsistenciaMedicaDTO deleteById(Long idAsistencia) {
        AsistenciaMedica asistenciaMedica = asistenciaMedicaRepository.findById(idAsistencia).orElse(null);
        asistenciaMedicaRepository.delete(asistenciaMedica);
        return mapToDto(asistenciaMedica);
    }

    public AsistenciaMedicaDTO putById(Long idAsistencia,AsistenciaMedicaDTO asistenciaMedicaDTO) {
        AsistenciaMedica asistenciaMedica = asistenciaMedicaRepository.findById(idAsistencia).orElse(null);
        asistenciaMedica.setBreveDescripcion(asistenciaMedicaDTO.getBreveDescripcion());
        asistenciaMedica.setLugar(asistenciaMedicaDTO.getLugar());
        asistenciaMedica.setFecha(asistenciaMedicaDTO.getFecha());
        asistenciaMedica.setHora(asistenciaMedicaDTO.getHora());
        asistenciaMedica.setImporte(asistenciaMedicaDTO.getImporte());
        asistenciaMedica.setTipoAsistencia(asistenciaMedicaDTO.getTipoAsistencia());
        asistenciaMedica.setExplicacion(asistenciaMedicaDTO.getExplicacion());
        asistenciaMedicaRepository.save(asistenciaMedica);
        return mapToDto(asistenciaMedica);
    }
}
