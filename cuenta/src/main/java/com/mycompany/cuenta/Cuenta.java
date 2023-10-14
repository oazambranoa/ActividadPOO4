/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuenta;

/**
 *
 * @author omarz
 */
public class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float cantidad) {
        saldo = saldo + cantidad;
        numeroConsignaciones = numeroConsignaciones + 1;
    }

    public void retirar(float cantidad) {
        float nuevoSaldo = saldo - cantidad;
        if (nuevoSaldo >= 0) {
            saldo -= cantidad;
            numeroRetiros = numeroRetiros + 1;
        } else {
            System.out.println("La cantidad a retirar excede el saldo actual.");
        }
    }

    public void calcularInteres() {
        float tasaMensual = tasaAnual / 12;
        float interesMensual = saldo * tasaMensual;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
    }

    public static void main(String[] args) {
        // Código para probar la clase Cuenta como una aplicación
        Cuenta cuenta = new Cuenta(1000.0f, 0.05f);
        cuenta.consignar(500.0f);
        cuenta.retirar(200.0f);
        cuenta.extractoMensual();
        System.out.println("Saldo después del extracto mensual: $" + cuenta.saldo);
    }
}
