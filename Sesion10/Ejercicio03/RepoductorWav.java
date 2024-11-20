package Ejercicio03;

import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RepoductorWav extends JFrame {
    // Botones para la interfaz gráfica
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public RepoductorWav() {
        setTitle("Repoductor Sonidos wav"); // Titulo de la ventana
        // Cierra el app al salir
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        // Distribución de los Botones en una fila
        setLayout(new GridLayout(1,3));

        // Inicializa los botones con etiquetas descriptivas
        button1 = new JButton("Aplausos");
        button2 = new JButton("Campana");
        button3 = new JButton("Explosión");

        // Configuración de las acciones de los botones
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSonido("sonidos/aplausos.wav");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSonido("sonidos/campana.wav");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSonido("sonidos/explosion.wav");
            }
        });

        // Añadimos los botones al frame
        add(button1);
        add(button2);
        add(button3);

        setVisible(true);
    }
    // Método privado para reproducir un sonido
    private void playSonido(String rutaSonido){
        try {
            // Se carga el archivo de sonido
            File file = new File(rutaSonido);
            // Se verifica si el archivo no existe
            if(!file.exists()){
                JOptionPane.showMessageDialog(this,"Archivo no encontrado. ","Error: ",JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Se crea el flujo de entrada para el archivo de audio
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            // Crea un objeto de la clase Clip para reproducir el audio
            Clip clip = AudioSystem.getClip();
            clip.open(audio);// se abre el auido en el clip
            clip.start(); // inicia la reproducción
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException  e){
            // se muestra un mensaje de error si ocurre algún problema
            JOptionPane.showMessageDialog(this,"Error al reproducir sonido: +" + e.getMessage(),"Error: ",JOptionPane.ERROR_MESSAGE);
        }

    }
}
