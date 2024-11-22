package io.github.juniorcorzo.ui;

import io.github.juniorcorzo.service.SendService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ButtonEventListener extends Component implements ActionListener {
    private final SendService sendService;

    public ButtonEventListener(SendService sendService) {
        this.sendService = sendService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(new AppEscritorio());

        if (result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            try {
                loadFileContent(selectedFile);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(new AppEscritorio(), "error al leer el archivo" + err.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void loadFileContent(File file) {
        StringBuilder message = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null){
                message.append(line);
            }
            this.sendService.sendRequest(message.toString());

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        JOptionPane.showMessageDialog(this, "Archivo cargado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }


}
