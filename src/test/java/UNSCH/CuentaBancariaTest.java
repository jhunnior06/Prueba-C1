package UNSCH;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    @Test
    void depositoValidoDebeIncrementarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);

        boolean resultado = cuenta.depositar(50);

        assertTrue(resultado);
        assertEquals(150, cuenta.obtenerSaldo());
    }

    @Test
    void retiroDebeDisminuirSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(40);
        assertEquals(60, cuenta.obtenerSaldo());
    }

    @Test
    void transferirDinero() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);

        origen.transferir(destino, 200);

        assertEquals(800, origen.obtenerSaldo());
        assertEquals(700, destino.obtenerSaldo());
    }

    @Test
    void retirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(500);
        assertEquals(100, cuenta.obtenerSaldo());
    }

    @Test
    void retirarMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(-200);
        assertEquals(1000, cuenta.obtenerSaldo());
    }

    @Test
    void depositoCeroDebeSerRechazado() {
        CuentaBancaria cuenta = new CuentaBancaria(100);

        boolean resultado = cuenta.depositar(0);

        assertFalse(resultado);
        assertEquals(100, cuenta.obtenerSaldo());
    }

    @Test
    void depositoNegativoDebeSerRechazado() {
        CuentaBancaria cuenta = new CuentaBancaria(100);

        boolean resultado = cuenta.depositar(-20);

        assertFalse(resultado);
        assertEquals(100, cuenta.obtenerSaldo());
    }
}