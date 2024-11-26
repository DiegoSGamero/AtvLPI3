package org.example.atvlpi3.dao;

import org.example.atvlpi3.models.Feline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FelineDao {

    public void saveFeline(Feline feline) {
        String sql = "INSERT INTO feline (specie, habitat, weight) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, feline.getSpecies());
            stmt.setString(2, feline.getHabitat());
            stmt.setDouble(3, feline.getWeight());
            stmt.executeUpdate();

            System.out.println("Feline salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar o Feline: " + e.getMessage());
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

    // Mét para deletar um Feline pelo nome da espécie
    public void deleteBySpecie(String specie) {
        String sql = "DELETE FROM felines WHERE specie = ?";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, specie);
            stmt.executeUpdate();

            System.out.println("Feline deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar o Feline: " + e.getMessage());
        }
    }

    // Mét para atualizar os dados de um Feline
    public void update(Feline feline) {
        String sql = "UPDATE felines SET habitat = ?, weight = ? WHERE specie = ?";

        try (Connection conn = ConexaoDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, feline.getHabitat());
            stmt.setDouble(2, feline.getWeight());
            stmt.setString(3, feline.getSpecies());
            stmt.executeUpdate();

            System.out.println("Feline atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o Feline: " + e.getMessage());
        }
    }
}
