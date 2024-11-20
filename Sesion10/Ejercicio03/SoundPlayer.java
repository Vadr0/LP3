package Ejercicio03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer extends JFrame {
    public SoundPlayer() {
        setTitle("Reproductor de Efectos de Sonido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(1, 3)); // Tres botones alineados

        // Crear botones para los efectos de sonido
        JButton applauseButton = new JButton("Aplausos");
        JButton bellButton = new JButton("Campana");
        JButton explosionButton = new JButton("Explosión");

        // Añadir listeners a cada botón
        applauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("aplausos.wav");
            }
        });

        bellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("campana.wav");
            }
        });

        explosionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("explosion.wav");
            }
        });

        // Añadir botones al frame
        add(applauseButton);
        add(bellButton);
        add(explosionButton);

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    // Método para reproducir sonidos
    private void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName);
            if (!soundFile.exists()) {
                JOptionPane.showMessageDialog(this, "Archivo no encontrado: " + soundFileName, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            JOptionPane.showMessageDialog(this, "Error al reproducir el sonido: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SoundPlayer::new);
    }
}
