package io.github.juniorcorzo;

import io.github.juniorcorzo.ui.AppEscritorio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppEscritorio app = new AppEscritorio();
            app.setVisible(true);
        });
    }
}