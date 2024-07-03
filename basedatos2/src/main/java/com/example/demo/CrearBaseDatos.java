package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CrearBaseDatos {

    	public static void main(String[] args) {
		
            try {
				
				// hacemos connexión: 

				Class.forName("com.mysql.cj.jdbc.Driver");

				// conectamos con base datos especifica: 

				Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinilos?serverTimezone=UTC", "root","");

				System.out.println("Conexión establecida correctamente.");

				// creamos objeto: 

				Statement objeto1 = conexion1.createStatement();

				// insertamos datos CREATE:

				// String insertar = "INSERT INTO vinilos (titulo, cantanteGrupo, fechaLanzamiento) VALUES ('Iowa', 'Slipknot', 20010828)";

				// objeto1.executeUpdate(insertar);
				// System.out.println("Datos insertados.");

				// leer READ:

				ResultSet resultado = objeto1.executeQuery("SELECT * FROM vinilos");

				while(resultado.next()){
					System.out.println("Titulo: " + resultado.getString("titulo") + ", Grupo: " + resultado.getString("cantanteGrupo")+ ", Lanzamiento: " + resultado.getString("fechaLanzamiento"));
				}

				// actualizamos datos UPDATE: 

				String actualizar = "UPDATE vinilos SET titulo = 'All Hope is Gone', cantanteGrupo = 'Slipknot', fechaLanzamiento = '20080826' WHERE id = 7";
				objeto1.executeUpdate(actualizar);
				System.out.println("Datos actualizados.");

				// borramos datos DELETE:

				String eliminar = "DELETE FROM vinilos WHERE id = 8";
				objeto1.executeUpdate(eliminar);
				System.out.println("Datos eliminados.");

				String eliminar1 = "DELETE FROM vinilos WHERE id = 9";
				objeto1.executeUpdate(eliminar1);
				System.out.println("Datos eliminados.");

				String eliminar2 = "DELETE FROM vinilos WHERE id = 10";
				objeto1.executeUpdate(eliminar2);
				System.out.println("Datos eliminados.");

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
