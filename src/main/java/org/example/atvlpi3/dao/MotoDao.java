package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDao {
    public void salvarMoto(Moto moto) {
        String sql = "INSERT INTO moto (marca, modelo, cor) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, moto.getMarca());
            stmt.setString(2, moto.getModelo());
            stmt.setString(3, moto.getCor());
            stmt.executeUpdate();

            System.out.println("moto salva com sucesso!");

        } catch (
                SQLException e) {
            System.err.println("Erro ao salvar moto: " + e.getMessage());
        }
    }

    // Mét para buscar todos os Felines no banco
    public List<Moto> findAll() {
        List<Moto> motos = new ArrayList<>();
        String sql = "SELECT * FROM moto";

        try (Connection conn = ConexaoDao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");

                Moto moto = new Moto(marca, modelo, cor);
                motos.add(moto);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar caminhao: " + e.getMessage());
        }
        return motos;
    }
}
