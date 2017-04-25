package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

public class Init extends JFrame {

    public JFrame frame;

    public Init() {
        frame = new JFrame();

        Font font = new Font(Font.SANS_SERIF, 3, 18);
        SpinnerModel widthModel = new SpinnerNumberModel(20, 2, 200, 1);
        SpinnerModel heightModel = new SpinnerNumberModel(20, 2, 200, 1);

        frame.setTitle("Wirtualny main.Swiat -- Jacek Ardanowski 165178");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = frame.getContentPane();

        content.setLayout(null);

        JTextArea Message = new JTextArea("Ustawienia rozmiaru planszy: ");
        JTextArea widthTextInput = new JTextArea("Podaj szerokosc: ");
        JTextArea heightTextInput = new JTextArea("Podaj wysokosc: ");
        Message.setBounds(15, 10, 260, 30);
        widthTextInput.setBounds(15, 80, 150, 30);
        heightTextInput.setBounds(15, 130, 150, 30);
        Message.setFont(font);
        widthTextInput.setFont(font);
        heightTextInput.setFont(font);

        content.add(Message);
        content.add(widthTextInput);
        content.add(heightTextInput);

        JSpinner widthSpinner = new JSpinner(widthModel);
        JSpinner heightSpinner = new JSpinner(heightModel);
        widthSpinner.setBounds(170, 80, 60, 30);
        heightSpinner.setBounds(170, 130, 60, 30);
        content.add(widthSpinner);
        content.add(heightSpinner);

        JButton start_button = new JButton("Start!");
        start_button.setBounds(150, 200, 80, 30);
        content.add(start_button);

        frame.setVisible(true);

        start_button.addActionListener(e -> {
            frame.setVisible(false);

            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new MyFrame((Integer)widthSpinner.getValue(), (Integer)heightSpinner.getValue());
                }
            });
        });
    }
}


//    public void windowApplication(int WIDTH, int HEIGHT) {
//        final int PLANSZA_WIDTH = 400;
//        final int PLANSZA_HEIGHT = 400;
//        final int POLE_WIDTH = 30;
//        final int POLE_HEIGHT = 30;
//        final int button_width = 80;
//        final int button_height = 30;
//        final int offset = 10;
//
//        JFrame frame = new JFrame();
//
//        frame.setTitle("Wirtualny Swiat -- Jacek Ardanowski 165178");
//        frame.setSize(800, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //frame.getContentPane().add(plansza);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(null);
//        frame.add(panel);
//
//        //Inicjalizuj swiat!
//        Swiat swiat = new Swiat(WIDTH, HEIGHT);
//
//        JButton save_button = new JButton("save");
//        save_button.setBounds(offset, PLANSZA_HEIGHT + button_height, button_width, button_height);
//        panel.add(save_button);
//        JButton load_button = new JButton("load");
//        load_button.setBounds(2 * offset + button_width, PLANSZA_HEIGHT + button_height, button_width, button_height);
//        panel.add(load_button);
//        JButton next_turn = new JButton("nowa tura");
//        next_turn.setBounds(3 * offset + 2 * button_width, PLANSZA_HEIGHT + button_height, 2 * offset + button_width, button_height);
//        panel.add(next_turn);
//
//
//        repaint();
//
//        next_turn.addActionListener(e -> {
//            swiat.wykonajTure();
//            System.out.println(swiat.lista.size());
//        });
//
//        frame.setVisible(true);
//    }
