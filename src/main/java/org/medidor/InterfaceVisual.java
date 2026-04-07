package org.medidor;

public class InterfaceVisual {

    public void exibirDados(DadosAmbiente dados) {
        System.out.println("\n[ TELA DO APLICATIVO - TEMPO REAL ]");
        System.out.println("🌡️ Temperatura:  " + dados.getTemperatura() + " °C");
        System.out.println("💧 Umidade:      " + dados.getUmidade() + " %");
        System.out.println("☀️ Luminosidade: " + dados.getLuminosidade() + " %");
        System.out.println("---------------------------------------");
    }

    public void exibirAvisoVermelho(String mensagemDeAlerta) {
        System.out.println("🚨 " + mensagemDeAlerta.toUpperCase());
        System.out.println("---------------------------------------");
    }
}
