package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Caminhao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaminhaoDao {
    public void salvarCaminhao(Caminhao caminhao) {
        String sql = "INSERT INTO carro (marca, modelo, cor) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, caminhao.getMarca());
            stmt.setString(2, caminhao.getModelo());
            stmt.setString(3, caminhao.getCor());
            stmt.executeUpdate();

            System.out.println("caminhao salvo com sucesso!");

        } catch (
                SQLException e) {
            System.err.println("Erro ao salvar o caminhao: " + e.getMessage());
        }
    }

    // Mét para buscar todos os Felines no banco
    public List<Caminhao> findAll() {
        List<Caminhao> caminhoes = new ArrayList<>();
        String sql = "SELECT * FROM caminhao";

        try (Connection conn = ConexaoDao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");

                Caminhao caminhao = new Caminhao(marca, modelo, cor);
                caminhoes.add(caminhao);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar caminhao: " + e.getMessage());
        }
        return caminhoes;
    }
}
