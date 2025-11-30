package com.congreso.adapters.gui;

import com.congreso.application.CongresistaService;
import com.congreso.domain.Congresista;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CongresistaFrame extends JFrame {

    private final CongresistaService service;
    private JTextField txtId, txtNombre, txtApellido, txtEmail, txtPais;
    private JTable table;
    private DefaultTableModel tableModel;

    public CongresistaFrame(CongresistaService service) {
        this.service = service;
        initComponents();
        cargarTabla();
    }

    private void initComponents() {
        setTitle("Gestión de Congresistas - Arquitectura Hexagonal");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblId = new JLabel("ID:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblApellido = new JLabel("Apellido:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPais = new JLabel("País:");

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtEmail = new JTextField();
        txtPais = new JTextField();

        JButton btnCrear = new JButton("Crear");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnListar = new JButton("Listar");

        lblId.setBounds(20, 20, 100, 25); txtId.setBounds(120, 20, 150, 25);
        lblNombre.setBounds(20, 55, 100, 25); txtNombre.setBounds(120, 55, 150, 25);
        lblApellido.setBounds(20, 90, 100, 25); txtApellido.setBounds(120, 90, 150, 25);
        lblEmail.setBounds(20, 125, 100, 25); txtEmail.setBounds(120, 125, 150, 25);
        lblPais.setBounds(20, 160, 100, 25); txtPais.setBounds(120, 160, 150, 25);

        btnCrear.setBounds(300, 20, 100, 25);
        btnActualizar.setBounds(300, 55, 100, 25);
        btnEliminar.setBounds(300, 90, 100, 25);
        btnBuscar.setBounds(300, 125, 100, 25);
        btnListar.setBounds(300, 160, 100, 25);

        add(lblId); add(txtId);
        add(lblNombre); add(txtNombre);
        add(lblApellido); add(txtApellido);
        add(lblEmail); add(txtEmail);
        add(lblPais); add(txtPais);

        add(btnCrear); add(btnActualizar); add(btnEliminar); add(btnBuscar); add(btnListar);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido", "Email", "País"}, 0);
        table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 230, 780, 300);
        add(scroll);

        btnCrear.addActionListener(e -> crear());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());
        btnBuscar.addActionListener(e -> buscar());
        btnListar.addActionListener(e -> cargarTabla());
    }

    private void crear() {
        Congresista c = new Congresista(
                0,
                txtNombre.getText(),
                txtApellido.getText(),
                txtEmail.getText(),
                txtPais.getText()
        );
        service.crear(c);
        cargarTabla();
        limpiarCampos();
    }

    private void actualizar() {
        int id = Integer.parseInt(txtId.getText());
        Congresista c = new Congresista(
                id,
                txtNombre.getText(),
                txtApellido.getText(),
                txtEmail.getText(),
                txtPais.getText()
        );
        service.actualizar(c);
        cargarTabla();
        limpiarCampos();
    }

    private void eliminar() {
        int id = Integer.parseInt(txtId.getText());
        service.eliminar(id);
        cargarTabla();
        limpiarCampos();
    }

    private void buscar() {
        int id = Integer.parseInt(txtId.getText());
        Congresista c = service.buscarPorId(id);
        if (c != null) {
            txtNombre.setText(c.getNombre());
            txtApellido.setText(c.getApellido());
            txtEmail.setText(c.getEmail());
            txtPais.setText(c.getPais());
        } else {
            JOptionPane.showMessageDialog(this, "No encontrado");
        }
    }

    private void cargarTabla() {
        tableModel.setRowCount(0);
        List<Congresista> lista = service.listar();
        for (Congresista c : lista) {
            tableModel.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getApellido(),
                    c.getEmail(),
                    c.getPais()
            });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtPais.setText("");
    }
}
