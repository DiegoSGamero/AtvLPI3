package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Feline;
import org.example.atvlpi3.models.Reptile;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReptileDao {
    public void saveRetile(Reptile reptile) {
        String sql = "INSERT INTO reptile (specie, habitat, weight) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, reptile.getSpecies());
            stmt.setString(2, reptile.getHabitat());
            stmt.setDouble(3, reptile.getWeight());
            stmt.executeUpdate();

            System.out.println("Reptil salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar o Reptile: " + e.getMessage());
        }
    }

    // Mét para buscar todos os Felines no banco
    public List<Feline> findAll() {
        List<Feline> felines = new ArrayList<>();
        String sql = "SELECT * FROM felines";

        try (Connection conn = ConexaoDao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String specie = rs.getString("specie");
                String habitat = rs.getString("habitat");
                double weight = rs.getDouble("weight");

                Feline feline = new Feline(specie, habitat, weight);
                felines.add(feline);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar Felines: " + e.getMessage());
        }
        return felines;
    }

}
