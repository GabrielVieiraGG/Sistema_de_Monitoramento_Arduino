package org.medidor;

public class ProcessadorDeDados {

    public DadosAmbiente tratarDados(String dadoBruto) {
        try {
            // Separa o texto "25.5,45,75" pelas vírgulas.
            String[] partes = dadoBruto.split(",");

            if (partes.length == 3) {
                float temp = Float.parseFloat(partes[0]);
                float umi = Float.parseFloat(partes[1]);
                int lum = Integer.parseInt(partes[2].trim());

                //Retorna os dados tratados.
                return new DadosAmbiente(temp, umi, lum);
            }
        } catch (Exception e) {
            // Retorna nulo se o texto veio diferente da formatação.
        }
        return null;
    }
}
