package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Bird;
import org.example.atvlpi3.models.Feline;
import org.example.atvlpi3.models.Reptile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BirdDao {
    public void saveBird(Bird bird) {
        String sql = "INSERT INTO bird (specie, habitat, weight) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bird.getSpecies());
            stmt.setString(2, bird.getHabitat());
            stmt.setDouble(3, bird.getWeight());
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
