package org.medidor;

public class AnalisadorDeAlertas {

    // Limites para os alertas.
    private float limiteTemperaturaAlta = 30.0f;
    private float limiteUmidadeBaixa = 40.0f;

    public String avaliarCondicoes(DadosAmbiente dados) {
        if (dados.getTemperatura() > limiteTemperaturaAlta) {
            return "ALERTA CRÍTICO: Temperatura acima de " + limiteTemperaturaAlta + "°C!";
        }
        if (dados.getUmidade() < limiteUmidadeBaixa) {
            return "AVISO: Umidade do ar muito baixa!";
        }

        // Se estiver tudo bem, não retorna alerta nenhum
        return null;
    }
}