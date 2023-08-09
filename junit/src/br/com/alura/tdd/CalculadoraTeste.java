package br.com.alura.tdd;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTeste {


    @Test
    public void deveriaSomarDOisNumerosPositivos() {
        Calculadora calc = new Calculadora();
        calc.somar(3, 7);
        int soma = calc.somar(3, 7);

        Assertions.assertEquals(10, soma);
    }
}
