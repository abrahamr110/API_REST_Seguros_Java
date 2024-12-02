package com.es.segurosinseguros.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
public class NIFValidator {


    private static final String REGEX_FORMAT_DNI = "^\\d{8}(-|\\s)?[A-Za-z]$";
    private static final Map<Character, Integer> TABLA_VALIDEZ_DNI = Map.ofEntries(
            Map.entry('T', 0),
            Map.entry('R', 1),
            Map.entry('W', 2),
            Map.entry('A', 3),
            Map.entry('G', 4),
            Map.entry('M', 5),
            Map.entry('Y', 6),
            Map.entry('F', 7),
            Map.entry('P', 8),
            Map.entry('D', 9),
            Map.entry('X', 10),
            Map.entry('B', 11),
            Map.entry('N', 12),
            Map.entry('J', 13),
            Map.entry('Z', 14),
            Map.entry('S', 15),
            Map.entry('Q', 16),
            Map.entry('V', 17),
            Map.entry('H', 18),
            Map.entry('L', 19),
            Map.entry('C', 20),
            Map.entry('K', 21),
            Map.entry('E', 22)
    );

    /**
     * Método público de acceso al validador de DNI
     * @param dni
     * @return
     */
    public boolean checkDNI(String dni) {
        return checkDniFormat(dni) && checkCorrectLetterDni(dni);
    }

    /**
     * Comprueba el formato del dni en modo (NNNNNNNNNL)
     * @param dni
     * @return true si el dni sigue el formato correcto
     */
    private boolean checkDniFormat(String dni) {
        Pattern pattern = Pattern.compile(REGEX_FORMAT_DNI, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dni.trim());
        return matcher.find();
    }

    /**
     * Comprueba si el dni es válido
     * @param dni
     * @return
     */
    private boolean checkCorrectLetterDni(String dni) {
        String dniTemp = dni.trim();
        int nums = 0;
        try {
            nums = Integer.parseInt(dniTemp.substring(0,8));
        } catch (NumberFormatException e) {
            return false;
        }

        char letra = dniTemp.toCharArray()[dniTemp.length()-1];

        return TABLA_VALIDEZ_DNI.get(letra) == nums%23;
    }



}
