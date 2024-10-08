import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExploradoresDelMundo extends JFrame {
    private JPanel mapaPanel;
    private JLabel puntuacionLabel;
    private int puntuacion;
    private int nivel;

    public ExploradoresDelMundo() {
        setTitle("Exploradores del Mundo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        puntuacion = 0;
        nivel = 1;

        // Mapa interactivo
        mapaPanel = new JPanel();
        mapaPanel.setBackground(Color.CYAN);
        mapaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarPais(evt);
            }
        });
        add(mapaPanel, BorderLayout.CENTER);

        // Panel de puntuación
        JPanel puntuacionPanel = new JPanel();
        puntuacionLabel = new JLabel("Puntuación: " + puntuacion);
        puntuacionPanel.add(puntuacionLabel);
        add(puntuacionPanel, BorderLayout.NORTH);

        // Preguntas de opción múltiple
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setLayout(new GridLayout(2, 2));
        JButton opcion1 = new JButton("Opción 1");
        JButton opcion2 = new JButton("Opción 2");
        JButton opcion3 = new JButton("Opción 3");
        JButton opcion4 = new JButton("Opción 4");

        opcion1.addActionListener(new OpcionListener());
        opcion2.addActionListener(new OpcionListener());
        opcion3.addActionListener(new OpcionListener());
        opcion4.addActionListener(new OpcionListener());

        opcionesPanel.add(opcion1);
        opcionesPanel.add(opcion2);
        opcionesPanel.add(opcion3);
        opcionesPanel.add(opcion4);
        add(opcionesPanel, BorderLayout.SOUTH);

        // Inicializar el juego
        mostrarPregunta();
    }

    private void seleccionarPais(java.awt.event.MouseEvent evt) {
        // Lógica para manejar la selección de un país en el mapa
        JOptionPane.showMessageDialog(this, "País seleccionado");
    }

    private void mostrarPregunta() {
        // Lógica para mostrar una nueva pregunta
        // Actualizar las opciones de respuesta y mostrar en pantalla
    }

    private void actualizarPuntuacion(int puntos) {
        puntuacion += puntos;
        puntuacionLabel.setText("Puntuación: " + puntuacion);
    }

    private class OpcionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para manejar la respuesta seleccionada
            JButton botonSeleccionado = (JButton) e.getSource();
            if (esRespuestaCorrecta(botonSeleccionado.getText())) {
                actualizarPuntuacion(10);
                JOptionPane.showMessageDialog(null, "¡Correcto!");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto. Intenta de nuevo.");
            }
            mostrarPregunta();
        }

        private boolean esRespuestaCorrecta(String respuesta) {
            // Lógica para verificar si la respuesta es correcta
            return true; // Esto es solo un marcador de posición
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExploradoresDelMundo juego = new ExploradoresDelMundo();
            juego.setVisible(true);
        });
    }
}