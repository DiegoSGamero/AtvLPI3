package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Carro;
import org.example.atvlpi3.models.Feline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {
    public void salvarCarro(Carro carro) {
        String sql = "INSERT INTO carro (marca, modelo, cor) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.executeUpdate();

            System.out.println("Carro salvo com sucesso!");

        } catch (
                SQLException e) {
            System.err.println("Erro ao salvar o Carro: " + e.getMessage());
        }
    }

    // Mét para buscar todos os Felines no banco
    public List<Carro> findAll() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";

        try (Connection conn = ConexaoDao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");

                Carro carro = new Carro(marca, modelo, cor);
                carros.add(carro);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar Carros: " + e.getMessage());
        }
        return carros;
    }

}
