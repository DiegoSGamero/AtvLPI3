package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Carne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarneDao {
    public void saveCarne(Carne carne) {
        String sql = "INSERT INTO carne (tipo, peso, prato) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carne.getTipo());
            stmt.setDouble(2, carne.getPeso());
            stmt.setString(3, carne.getPrato());
            stmt.executeUpdate();

            System.out.println("carne salva com sucesso!");

        } catch (
                SQLException e) {
            System.err.println("Erro ao salvar Carne: " + e.getMessage());
        }
    }
}
