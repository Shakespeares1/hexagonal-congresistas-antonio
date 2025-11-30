package com.congreso.main;

import com.congreso.adapters.db.MySQLCongresistaRepository;
import com.congreso.adapters.gui.CongresistaFrame;
import com.congreso.application.CongresistaService;
import javax.swing.SwingUtilities;

public class MainApp {

    public static void main(String[] args) {

        // Adaptador de base de datos (secundario)
        MySQLCongresistaRepository repo = new MySQLCongresistaRepository();

        // Servicio (capa de aplicación)
        CongresistaService service = new CongresistaService(repo);

        // GUI (adaptador primario)
        SwingUtilities.invokeLater(() -> {
            CongresistaFrame frame = new CongresistaFrame(service);
            frame.setVisible(true);
        });
    }
}
