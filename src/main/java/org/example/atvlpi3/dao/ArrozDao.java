package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Arroz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArrozDao {
    public void saveArroz(Arroz arroz) {
        String sql = "INSERT INTO arroz (tipo, peso, prato) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, arroz.getTipo());
            stmt.setDouble(2, arroz.getPeso());
            stmt.setString(3, arroz.getPrato());
            stmt.executeUpdate();

            System.out.println("arroz salvo com sucesso!");

        } catch (
                SQLException e) {
            System.err.println("Erro ao salvar Arroz: " + e.getMessage());
        }
    }
}
