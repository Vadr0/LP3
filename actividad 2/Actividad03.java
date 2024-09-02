package Actividad03;

import java.util.Scanner;

public class Actividad03 {
    public static void main(String[] args) {
        Motor motor1 = new Motor(01,300);
        Automovil coche1 = new Automovil("021",4,"Mazda","Rx7");
        coche1.setMotor(motor1);
        System.out.println(coche1);
    }

    public static class Motor {
        private int numMotor;
        private int revPorMin;
        public Motor(int numMotor, int revPorMin) {
            this.numMotor = numMotor;
            this.revPorMin = revPorMin;
        }
        //setter y getter
        public int getNumMotor() {
            return numMotor;
        }
        public void setNumMotor(int numMotor) {
            this.numMotor = numMotor;
        }
        public int getRevPorMin() {
            return revPorMin;
        }
        public void setRevPorMin(int revPorMin) {
            this.revPorMin = revPorMin;
        }
        @Override
        public String toString() {
            return "Motor: " +
                    "Numero:"+ numMotor+
                    "\n         Rev:"+ revPorMin;
        }
    }
    public static class Automovil {
        private String placa;
        private int numPuertas;
        private String marca;
        private String modelo;
        private Motor motor;

        public Automovil(String placa, int numPuertas, String marca, String modelo) {
            this.placa = placa;
            this.numPuertas = numPuertas;
            this.marca = marca;
            this.modelo = modelo;
        }
        public String getPlaca() {
            return placa;
        }
        public void setPlaca(String placa) {
            this.placa = placa;
        }
        public int getNumPuertas() {
            return numPuertas;
        }
        public void setNumPuertas(int numPuertas) {
            this.numPuertas = numPuertas;
        }
        public String getMarca() {
            return marca;
        }
        public void setMarca(String marca) {
            this.marca = marca;
        }
        public String getModelo() {
            return modelo;
        }
        public void setModelo(String modelo) {
            this.modelo = modelo;
        }
        public Motor getMotor() {
            return motor;
        }
        public void setMotor(Motor motor) {
            this.motor = motor;
        }
        @Override
        public String toString() {
            return "Automovil:\n"+
                    "   Placa: "+placa+
                    "\n   num Puertas :"+numPuertas+
                    "\n   marca: "+marca+
                    "\n   modelo: "+modelo+
                    "\n   "+motor;
        }
    }
}
