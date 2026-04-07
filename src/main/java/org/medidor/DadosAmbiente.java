package org.medidor;

public class DadosAmbiente {
    private float temperatura;
    private float umidade;
    private int luminosidade;

    public DadosAmbiente(float temperatura, float umidade, int luminosidade) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.luminosidade = luminosidade;
    }

    public float getTemperatura() { return temperatura; }
    public float getUmidade() { return umidade; }
    public int getLuminosidade() { return luminosidade; }
}
