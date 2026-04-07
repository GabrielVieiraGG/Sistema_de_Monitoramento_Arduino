package org.medidor;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ConexaoSerial {
    private String portaConfigurada;
    private SerialPort portaSerial;
    private Scanner scanner;

    public ConexaoSerial(String portaConfigurada) {
        this.portaConfigurada = portaConfigurada;
    }

    public boolean conectar() {
        portaSerial = SerialPort.getCommPort(portaConfigurada);
        portaSerial.setComPortParameters(9600, 8, 1, 0);
        portaSerial.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);

        if (portaSerial.openPort()) {
            scanner = new Scanner(portaSerial.getInputStream());
            return true;
        }
        return false;
    }

    public String lerLinhaDeTexto() {
        // Bloqueia e espera até o Arduino enviar uma nova linha ("Enter")
        if (scanner != null && scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }
}