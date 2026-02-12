package com.example.sistemavendas.dao;

import com.example.sistemavendas.model.Cliente;
import com.example.sistemavendas.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.execute();
        }
    }

    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                lista.add(c);
            }
        }
        return lista;
    }

    public void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome=?, telefone=?, email=?, endereco=? WHERE cpf=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCpf());
            stmt.execute();
        }
    }
    

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}