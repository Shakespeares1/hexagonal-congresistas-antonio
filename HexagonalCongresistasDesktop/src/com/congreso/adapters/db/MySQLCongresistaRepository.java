package com.congreso.adapters.db;

import com.congreso.domain.Congresista;
import com.congreso.ports.CongresistaRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCongresistaRepository implements CongresistaRepository {

    private final String url = "jdbc:mysql://localhost:3306/congresodb";
    private final String user = "root";
    private final String pass = "Tupapazzxx123"; // cámbiala si tu MySQL tiene clave

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public void crear(Congresista c) {
        String sql = "INSERT INTO congresistas(nombre, apellido, email, pais) VALUES(?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPais());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Congresista c) {
        String sql = "UPDATE congresistas SET nombre=?, apellido=?, email=?, pais=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPais());
            ps.setInt(5, c.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM congresistas WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Congresista buscarPorId(int id) {
        String sql = "SELECT id, nombre, apellido, email, pais FROM congresistas WHERE id=?";
        Congresista c = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Congresista(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("pais")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Congresista> listar() {
        String sql = "SELECT id, nombre, apellido, email, pais FROM congresistas";
        List<Congresista> lista = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Congresista(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("pais")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
