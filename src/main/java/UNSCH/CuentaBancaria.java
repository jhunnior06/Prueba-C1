package UNSCH;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }

    public void transferir(double monto, CuentaBancaria destino) {
        if (monto > 0 && monto <= saldo) {
            this.retirar(monto);
            destino.depositar(monto);
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }
}