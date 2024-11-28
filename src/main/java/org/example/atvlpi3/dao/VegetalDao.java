package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Vegetal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VegetalDao {
    public void saveVegetal(Vegetal vegetal) {
        String sql = "INSERT INTO vegetal (tipo, peso, prato) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vegetal.getTipo());
            stmt.setDouble(2, vegetal.getPeso());
            stmt.setString(3, vegetal.getPrato());
            stmt.executeUpdate();

            System.out.println("vegetal salvo com sucesso!");

        } catch (
                SQLException e) {
            System.err.println("Erro ao salvar vegetal: " + e.getMessage());
        }
    }
}
