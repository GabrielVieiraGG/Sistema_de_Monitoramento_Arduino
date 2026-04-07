package org.medidor;

public class ServicoDeMonitoramento {

    private ConexaoSerial conexao;
    private ProcessadorDeDados processador;
    private AnalisadorDeAlertas analisador;
    private InterfaceVisual interfaceUI;

    public ServicoDeMonitoramento(String porta) {
        this.conexao = new ConexaoSerial(porta);
        this.processador = new ProcessadorDeDados();
        this.analisador = new AnalisadorDeAlertas();
        this.interfaceUI = new InterfaceVisual();
    }

    public void iniciarEmSegundoPlano() {
        System.out.println("Iniciando serviço... Tentando conectar ao Arduino...");

        if (conexao.conectar()) {
            System.out.println("Conexão bem-sucedida! Iniciando ciclo de leitura...\n");

            //Loop.
            while (true) {
                // 1. Pede o texto para a conexão
                String textoBruto = conexao.lerLinhaDeTexto();

                if (textoBruto != null) {
                    // 2. Manda a fábrica transformar o texto em objeto
                    DadosAmbiente dados = processador.tratarDados(textoBruto);

                    if (dados != null) {
                        // 3. Pede para o painel desenhar os dados na tela
                        interfaceUI.exibirDados(dados);

                        // 4. Pergunta ao inspetor se há algum alerta e exibe se houver
                        String alerta = analisador.avaliarCondicoes(dados);
                        if (alerta != null) {
                            interfaceUI.exibirAvisoVermelho(alerta);
                        }
                    }
                }
            }
        } else {
            System.out.println("FALHA CRÍTICA: Não foi possível conectar à porta serial.");
        }
    }
}