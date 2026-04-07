package org.medidor;

public class Main {
    public static void main(String[] args) {

        // Porta do Arduino no PC.
        String portaDoArduino = "COM3";

        // Instancia o serviço de monitoramento.
        ServicoDeMonitoramento monitoramento = new ServicoDeMonitoramento(portaDoArduino);

        // Chama o loop.
        monitoramento.iniciarEmSegundoPlano();

    }
}