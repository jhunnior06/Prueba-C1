package UNSCH;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        }
    }

    public void transferir(double monto, CuentaBancaria destino) {
        if (monto <= saldo) {
            this.retirar(monto);
            destino.depositar(monto);
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }
}