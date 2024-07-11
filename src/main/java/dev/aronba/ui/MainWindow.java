package dev.aronba.ui;

import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;

import javax.swing.*;
public class MainWindow extends JFrame {

    SettingPanel settingPanel;


    public MainWindow() {


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Algor");
        setSize(400, 400);

        this.settingPanel = new SettingPanel();
        this.add(settingPanel);

        setVisible(true);
    }

    public static void start() {
        FlatVuesionIJTheme.setup();
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
