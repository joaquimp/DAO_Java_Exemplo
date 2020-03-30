package br.mack.ps2;

import br.mack.ps2.persistencia.AlunoDAOMySQL;

import java.sql.*;
public class App {
    public static void main(final String[] args) {
        AlunoDAOMySQL mysqlDAO = new AlunoDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();
    }
}