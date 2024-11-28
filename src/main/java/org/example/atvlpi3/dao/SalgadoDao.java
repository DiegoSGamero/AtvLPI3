package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Salgado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalgadoDao {
    public void saveSalgado(Salgado salgado) {
        String sql = "INSERT INTO salgado (tipo, peso, sabor) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, salgado.getTipo());
            stmt.setDouble(2, salgado.getPeso());
            stmt.setString(3, salgado.getSabor());
            stmt.executeUpdate();

            System.out.println("Salgado salvo com sucesso!");

        } catch (
                SQLException e) {
            System.err.println("Erro ao salvar Salgado: " + e.getMessage());
        }
    }
}
