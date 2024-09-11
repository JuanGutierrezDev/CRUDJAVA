/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudjavamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gutie
 */
public class CRUDJAVAMYSQL {

    public static void main(String[] args) {
       String usuario="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/bdik_propuestas";
        Connection conexion;   
        Statement statement;
        ResultSet rs;
        
        try {
            conexion=DriverManager.getConnection(url, usuario, password);
            statement= conexion.createStatement();
            rs = statement.executeQuery(" SELECT * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre_usuario"));
            }
            
            //INSERCIÓN DE DATOS
           statement.execute("INSERT INTO `usuarios` (`nombre_usuario`, `pass_usuario`, `rol_usuario`, `cedula_usuario`, `dependencia_usuario`, `correo_usuario`, `telefono_usuario`) VALUES ('David Mera 2', '12345Juan', 'Administrador', '39158', 'Comunicación', 'gutierrezjuandavid22@gmail.com', '311560152');");
           System.out.println("");
           rs = statement.executeQuery(" SELECT * FROM usuarios");
           
           while(rs.next()) {
                System.out.println(rs.getString("nombre_usuario"));
             }
            
           //ACTUALIZACIÓN DE DATOS
           statement.execute("UPDATE `usuarios` SET `nombre_usuario` = 'Sara Gutierrez Silva' WHERE `usuarios`.`id_usuario` = 2;");
           System.out.println("");
           rs = statement.executeQuery(" SELECT * FROM usuarios");
           
           while(rs.next()) {
                System.out.println(rs.getString("nombre_usuario"));
             }
           
            //ELIMINACIÓN DE DATOS
           statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id_usuario` = 4;");
           System.out.println("");
           rs = statement.executeQuery(" SELECT * FROM usuarios");
           
           while(rs.next()) {
                System.out.println(rs.getString("nombre_usuario"));
             }

           
        } catch (SQLException ex) {
            Logger.getLogger(CRUDJAVAMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
