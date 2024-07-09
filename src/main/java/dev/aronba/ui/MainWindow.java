package dev.aronba.ui;

import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import dev.aronba.ui.view.AlgorithmView;
import dev.aronba.ui.view.ConfigView;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final ConfigView configView;
    private AlgorithmView algorithmView;

    public MainWindow() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Algor");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(100,100);

        configView = new ConfigView();
        configView.getButtonRun().addActionListener(_ -> algorithmView.run(configView.getConfig()));

        algorithmView = new AlgorithmView();

        add(algorithmView,BorderLayout.CENTER);
        add(configView,BorderLayout.WEST);
        setVisible(true);
    }

    public static void start(){
        FlatVuesionIJTheme.setup();
        SwingUtilities.invokeLater(MainWindow::new);
    };

}
