package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class BD2DAY3 {

    	public static void main(String[] args) {
		
            try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinilos?serverTimezone=UTC", "root","");

				System.out.println("Conexión establecida correctamente.");

				Scanner sc = new Scanner(System.in);

				System.out.print("Introduce el título del vinilo: ");
				String titulo = sc.nextLine();

				System.out.print("Introduce el grupo o cantante: ");
				String cantanteGrupo = sc.nextLine();

				System.out.print("Introduce la fecha de lanzamiento: ");
            	String fechaLanzamiento = sc.nextLine();

				String insertar = "INSERT INTO vinilos (titulo, cantanteGrupo, fechaLanzamiento) VALUES (?, ?, ?)";
            	PreparedStatement prep = conexion1.prepareStatement(insertar);
            	prep.setString(1, titulo);
            	prep.setString(2, cantanteGrupo);
            	prep.setString(3, fechaLanzamiento);

				prep.execute();

				System.out.println("Datos insertados.");

				Statement objeto1 = conexion1.createStatement();
				ResultSet resultado = objeto1.executeQuery("SELECT * FROM vinilos");

				while(resultado.next()){
					System.out.println("Titulo: " + resultado.getString("titulo") + ", Grupo: " + resultado.getString("cantanteGrupo")+ ", Lanzamiento: " + resultado.getString("fechaLanzamiento"));
				}
				
				conexion1.close();

			} catch (Exception e) {

				System.out.println("No funciona.");
				e.printStackTrace();
			}
            

	}

}
