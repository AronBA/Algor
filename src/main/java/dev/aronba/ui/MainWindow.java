package dev.aronba.ui;

import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import dev.aronba.ui.controller.AlgorithmController;
import dev.aronba.ui.view.ConfigView;
import dev.aronba.ui.view.SortAlgorithmView;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final ConfigView configView;
    private AlgorithmController algorithmController;

    public MainWindow() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Algor");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(100,100);

        this.algorithmController = new AlgorithmController(new SortAlgorithmView());

        configView = new ConfigView();
        configView.getButtonRun().addActionListener(_ -> algorithmController.startVisualization(configView.getConfig()));


        add(algorithmController.getView(),BorderLayout.CENTER);
        add(configView,BorderLayout.WEST);
        setVisible(true);
    }

    public static void start(){
        FlatVuesionIJTheme.setup();
        SwingUtilities.invokeLater(MainWindow::new);
    };

}
