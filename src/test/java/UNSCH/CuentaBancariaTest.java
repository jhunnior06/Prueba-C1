package UNSCH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    @Test
    void depositoDebeIncrementarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.depositar(50);
        assertEquals(150, cuenta.obtenerSaldo());
    }

    @Test
    void retiroDebeDisminuirSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(40);
        assertEquals(60, cuenta.obtenerSaldo());
    }

    @Test
    void transferenciaDebeModificarSaldosCorrectamente() {
        CuentaBancaria origen = new CuentaBancaria(200);
        CuentaBancaria destino = new CuentaBancaria(50);

        origen.transferir(100, destino);

        assertEquals(100, origen.obtenerSaldo());
        assertEquals(150, destino.obtenerSaldo());
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
    void depositarMontoValido() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.obtenerSaldo());
    }
}