/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago.bscarton
 */
public class ClienteDAO {
    
    public static boolean cadastrarCliente(Cliente cliente) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "insert into cliente values (default,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ok;
    }
    
    public static List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                clientes.add(new Cliente(nome, email));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return clientes;
    }
}
