package com.es.segurosinseguros.util;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class SeguroValidator {

    public void checkFieldsNotNull(SeguroDTO sDto) {
        if(sDto.getNif() == null || sDto.getNif().isBlank()) {
            throw new BadRequestException("El campo nif no puede estar vacío");
        }
        if(sDto.getNombre() == null || sDto.getNombre().isBlank()) {
            throw new BadRequestException("El campo nombre no puede estar vacío");
        }
        if(sDto.getApe1() == null || sDto.getApe1().isBlank()) {
            throw new BadRequestException("El campo ape1 no puede estar vacío");
        }
        if(sDto.getSexo() == null || sDto.getSexo().isBlank()) {
            throw new BadRequestException("El campo sexo no puede estar vacío");
        }
    }

    public void checkEmbarazada(SeguroDTO sDto) {
        if(sDto.isEmbarazada() && sDto.getSexo().equalsIgnoreCase("hombre")) {
            throw new BadRequestException("El campo embarazada no puede ser true si el asegurado es hombre.");
        }
    }

    public void checkMenorEdad(SeguroDTO sDto) {
        if(sDto.getEdad() < 0) {
            throw new BadRequestException("El campo edad no puede ser negativo");
        }
        if(sDto.getEdad() >= 0 && sDto.getEdad() < 18) {
            throw new BadRequestException("No es posible ser menor de edad para hacer un seguro.");
        }
    }

    public void checkNumHijos(SeguroDTO sDto) {
        if(sDto.isCasado() && sDto.getNumHijos() > 0) {
            throw new BadRequestException("Un seguro no puede registrar hijos si no está casado.");
        }
    }

}
