package io.github.juniorcorzo.ui;

import io.github.juniorcorzo.service.SendService;

import javax.swing.*;
import java.awt.*;

public class AppEscritorio extends JFrame {
    private JButton uploadButton;

    public AppEscritorio() {
        setTitle("App Resultados");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        uploadButton = new JButton("Cargar Archivo");
        uploadButton.setSize(100, 50);
        uploadButton.addActionListener(new ButtonEventListener(new SendService()));

        setLayout(new BorderLayout());
        add(uploadButton, BorderLayout.CENTER);
    }

}

