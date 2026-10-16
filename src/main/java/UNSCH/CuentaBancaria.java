package UNSCH;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }

        saldo += monto;
        return true;
    }


    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }

    public void transferir(CuentaBancaria destino, double monto) {
        if (monto > 0 && monto <= saldo) {
            this.saldo -= monto;
            destino.depositar(monto);
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }
}