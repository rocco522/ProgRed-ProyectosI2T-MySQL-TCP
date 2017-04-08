package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.Ejecutar;

public class Consultas {

	private Ejecutar ejecutar;

	public Consultas(Ejecutar e) {
		this.ejecutar = e;
	}

	public void consulta_i(Statement st) throws SQLException {
		String consultaGeneral = "";
		String consulta = "";
		//Crear tabla Proyectos
		consulta = "CREATE TABLE IF NOT EXISTS `P09728_1_1`.`Proyectos` ( "+
				"`ID` INT NOT NULL AUTO_INCREMENT, "+
				"`Nombre` VARCHAR(500) NULL, "+
				"`LineaInvestigativa` VARCHAR(45) NULL, "+
				"`DescripcionBreve` VARCHAR(500) NULL, "+
				"`Presupuesto` DOUBLE NULL, "+
				"PRIMARY KEY (`ID`))";
		st.executeUpdate(consulta);
		consultaGeneral = consulta + "\n";


		//Crear tabla Investigadores
		consulta = "CREATE TABLE IF NOT EXISTS `P09728_1_1`.`Investigadores` ( "+
				"`ID` INT NOT NULL AUTO_INCREMENT, "+
				"`Nombre` VARCHAR(45) NULL, "+
				"`Identificacion` VARCHAR(45) NULL, "+
				"`Telefono` VARCHAR(45) NULL, "+
				"`AniosExperiencia` VARCHAR(45) NULL, "+
				"`TituloAcademico` VARCHAR(45) NULL, "+
				"PRIMARY KEY (`ID`))";
		st.executeUpdate(consulta);
		consultaGeneral += consulta + "\n";

		//Crear tabla ProyectoInvestigador
		consulta = "CREATE TABLE IF NOT EXISTS `P09728_1_1`.`ProyectoInvestigador` ( "+
				"`ID` INT NOT NULL AUTO_INCREMENT, "+
				"`Proyecto` INT NULL, "+
				"`Investigador` INT NULL, "+
				"`Lider` INT NULL, "+
				"PRIMARY KEY (`ID`), "+
				"INDEX `Proyectos_idx` (`Proyecto` ASC), "+
				"INDEX `Investigadores_idx` (`Investigador` ASC), "+
				"CONSTRAINT `Proyectos` FOREIGN KEY (`Proyecto`) REFERENCES `P09728_1_1`.`Proyectos` (`ID`), "+
				"CONSTRAINT `Investigadores` FOREIGN KEY (`Investigador`) REFERENCES `P09728_1_1`.`Investigadores` (`ID`), "+
				"CONSTRAINT `Lider` FOREIGN KEY (`Lider`) REFERENCES `P09728_1_1`.`Investigadores` (`ID`))";

		st.executeUpdate(consulta);
		consultaGeneral += consulta + "\n";
		ejecutar.setConsultaGeneral(consultaGeneral);
		//Cerrar conexión
		st.close();

	}

	public void consultaCrearRegistrosAuto(Statement st) throws SQLException{
		String consultaGeneral = "";
		String consulta = "";

		//Insertar investigadores
		consulta = "INSERT INTO `P09728_1_1`.`Investigadores` (`ID`, `Nombre`, `Identificacion`, `Telefono`, `AniosExperiencia`, `TituloAcademico`) "+ 
				"VALUES "+
				"('1', 'José Sánchez', '1000', '093433578', '12', 'Profesional'), "+
				"('2', 'Javier Fernandez', '2000', '095486972', '30', 'Doctor'), "+
				"('3', 'Juan Soto', '3000', '098456792', '14', 'Magister'), "+
				"('4', 'Paul Cucalon', '4000', '094589786', '12', 'Magister'), "+ 
				"('5', 'Freddy Garces', '5000', '094589456', '10', 'Profesional'), "+ 
				"('6', 'Luisa Gomez', '6000', '09458890', '0', 'Bachiller'), "+
				"('7', 'Carlota Garcia', '7000', '094589294', '2', 'Técnico'), "+
				"('8', 'Erika Ramirez', '8000', '094589049', '1', 'Tecnólogo'), "+
				"('9', 'Henry Marquez', '9000', '094589384', '6', 'Profesional'), "+
				"('10', 'Marcela Silva', '10000', '094589832', '20', 'Doctor'), "+
				"('11', 'Margarita Espinosa', '11000', '094589283', '7', 'Magister'), "+
				"('12', 'Karina Zuleta', '12000', '094589034', '4', 'Especialización'), "+ 
				"('13', 'Ana María Rivera', '13000', '094589591', '3', 'Técnico'), "+ 
				"('14', 'Lilly Duke', '14000', '094589905', '2', 'Tecnólogo'), "+ 
				"('15', 'Francisco Ortiz', '15000', '094589203', '1', 'Estudiante'); ";
		consultaGeneral += consulta + "\n";
		st.executeUpdate(consulta);

		//Insertar registros a proyectos
		consulta = "INSERT INTO `P09728_1_1`.`Proyectos` (`ID`, `Nombre`, `LineaInvestigativa`, `DescripcionBreve`, `Presupuesto`) "+
				"VALUES "+ 
				"('1', 'Diseño de aplicación móvil para detección de enfermedades', 'Análisis de imagen', 'Diseño de aplicación móvil para detección de enfermedades', '100000000'), "+
				"('2', 'Diseño de aplicación para consultas de lugar y fecha de votación', 'Análisis de imagen', 'Diseño de aplicación para consultas de lugar y fecha de votación', '2000000'), "+ 
				"('3', 'Red Interuniversitaria Latinoamericana y del Caribe sobre Discapacidad y DH', 'Análisis de imagen', 'Red Interuniversitaria Latinoamericana y del Caribe sobre Discapacidad y DH', '200000'), "+ 
				"('4', 'Fundación Cyathea Ambiental Fundación Colombia Viva ASOPESAMM', 'Análisis de imagen', 'Fundación Cyathea Ambiental Fundación Colombia Viva ASOPESAMM', '300000000'), "+ 
				"('5', 'Comunidad Indígena Chenche - Buenavista', 'Desarrollo Software', 'Comunidad Indígena Chenche - Buenavista', '10000000'), "+ 
				"('6', 'Implementación de programas de formación y extensión en la Universidad de los Llanos para etnias de la Orinoquia colombiana', 'Desarrollo Software', 'Implementación de programas de formación y extensión en la Universidad de los Llanos para etnias de la Orinoquia colombiana', '400000000'), "+ 
				"('7', 'Fortalecimiento de T&T', 'Desarrollo Software', 'Fortalecimiento de T&T', '53000000'), "+ 
				"('8', 'Licenciatura en Pedagogía Infantil', 'Mejoramiento del aprendizaje', 'Licenciatura en Pedagogía Infantil', '6000000'), "+ 
				"('9', 'Tecnología en Mecatrónica - Discapacidad', 'Mejoramiento del aprendizaje', 'Tecnología en Mecatrónica - Discapacidad', '18000000'), "+ 
				"('10', 'Cátedra Medellín Diversa e Incluyente', 'Mejoramiento del aprendizaje', 'Cátedra Medellín Diversa e Incluyente', '290000000'); ";
		consultaGeneral += consulta + "\n";
		st.executeUpdate(consulta);

		//Insertar registros relaciones
		consulta = "INSERT INTO `P09728_1_1`.`ProyectoInvestigador` (`ID`, `Proyecto`, `Investigador`, `Lider`) "+
				"VALUES (NULL, '1', '1', '2'), "+
				"(NULL, '1', '3', '2'), "+
				"(NULL, '1', '2', '2'), "+
				"(NULL, '2', '4', '10'), "+
				"(NULL, '2', '10', '10'), "+
				"(NULL, '2', '5', '10'), "+
				"(NULL, '2', '6', '10'), "+
				"(NULL, '3', '7', '3'), "+
				"(NULL, '3', '3', '3'), "+
				"(NULL, '3', '2', '3'), "+
				"(NULL, '3', '10', '3'), "+
				"(NULL, '4', '12', '4'), "+
				"(NULL, '4', '4', '4'), "+
				"(NULL, '4', '11', '4'), "+
				"(NULL, '4', '1', '4'), "+
				"(NULL, '5', '5', '5'), "+
				"(NULL, '5', '11', '5'), "+
				"(NULL, '5', '12', '5'), "+
				"(NULL, '5', '14', '5'), "+
				"(NULL, '6', '9', '9'), "+
				"(NULL, '6', '2', '9'), "+
				"(NULL, '6', '11', '9'), "+
				"(NULL, '7', '12', '12'), "+
				"(NULL, '7', '1', '12'), "+
				"(NULL, '7', '3', '12'), "+
				"(NULL, '8', '8', '8'), "+
				"(NULL, '8', '9', '8'), "+
				"(NULL, '8', '2', '8'), "+
				"(NULL, '8', '3', '8'), "+
				"(NULL, '8', '4', '8'), "+
				"(NULL, '8', '5', '8'), "+
				"(NULL, '8', '10', '8'), "+
				"(NULL, '8', '11', '8'), "+
				"(NULL, '9', '14', '14'), "+
				"(NULL, '9', '12', '14'), "+
				"(NULL, '9', '1', '14'), "+
				"(NULL, '9', '2', '14'), "+
				"(NULL, '9', '7', '14'), "+
				"(NULL, '9', '6', '14'), "+
				"(NULL, '10', '4', '11'), "+
				"(NULL, '10', '9', '11'), "+
				"(NULL, '10', '10', '11'), "+
				"(NULL, '10', '11', '11'), "+
				"(NULL, '10', '12', '11');";
		consultaGeneral += consulta + "\n";
		st.executeUpdate(consulta);

		ejecutar.setConsultaGeneral(consultaGeneral);

		st.close();
	}

	public void consultaEliminarTablas(Statement st) throws SQLException{
		String consultaGeneral = "";
		String consulta = "";

		//Eliminar tabla relaciones
		consulta = "DROP TABLE `ProyectoInvestigador`";
		consultaGeneral += consulta + "\n";
		st.executeUpdate(consulta);

		//Eliminar tabla proyectos
		consulta = "DROP TABLE `Proyectos`";
		consultaGeneral += consulta + "\n";
		st.executeUpdate(consulta);

		//Eliminar tabla Investigadores
		consulta = "DROP TABLE `Investigadores`";
		consultaGeneral += consulta + "\n";
		st.executeUpdate(consulta);

		ejecutar.setConsultaGeneral(consultaGeneral);

		st.close();
	}
	
	public int consulta_ii(Statement st, ResultSet resultado ) throws SQLException{
		int valor = 0;

		String consultaGeneral = "";
		String consulta = "";

		consulta = "SELECT  `Presupuesto` "+
				"FROM  `Proyectos` "+
				"WHERE  `LineaInvestigativa` =  \"Análisis de imagen\" ";

		resultado = st.executeQuery(consulta); 

		while(resultado.next()){
			String res = resultado.getString(1);
			valor += Integer.parseInt(res);	
		}
		
		consultaGeneral += consulta;
		ejecutar.setConsultaGeneral(consultaGeneral);
		
		st.close();

		return valor;
	}
	
	public String consulta_iii(Statement st, ResultSet resultado ) throws SQLException{
		String datos = "";

		String consultaGeneral = "";
		String consulta = "";

		consulta = "SELECT DISTINCT i.Nombre, i.TituloAcademico "+
				"FROM Investigadores i, ProyectoInvestigador pi "+
				"WHERE pi.Lider = i.ID";

		resultado = st.executeQuery(consulta); 

		while(resultado.next()){
			String nombre = resultado.getString(1);
			String titulo = resultado.getString(2);
			datos += nombre +" ---- "+titulo+"\n";
		}
		
		consultaGeneral += consulta;
		ejecutar.setConsultaGeneral(consultaGeneral);
		
		st.close();

		return datos;
	}
	
	public String consulta_iv(Statement st, ResultSet resultado ) throws SQLException{
		String datos = "";

		String consultaGeneral = "";
		String consulta = "";

		consulta = "SELECT DISTINCT p.Nombre, p.Presupuesto "+
				"FROM Investigadores i, ProyectoInvestigador pi, Proyectos p "+
				"WHERE pi.Lider = i.ID AND i.TituloAcademico=\"Doctor\" AND pi.Investigador = pi.Lider AND pi.Proyecto = p.ID";

		resultado = st.executeQuery(consulta); 

		while(resultado.next()){
			String nombre = resultado.getString(1);
			String presupuesto = resultado.getString(2);
			datos += nombre +" ---- "+presupuesto+"\n";
		}
		
		consultaGeneral += consulta;
		ejecutar.setConsultaGeneral(consultaGeneral);
		
		st.close();

		return datos;
	}
	
	public String consulta_v(Statement st, ResultSet resultado ) throws SQLException{
		String datos = "";

		String consultaGeneral = "";
		String consulta = "";

		consulta = "SELECT DISTINCT i.Nombre "+
				"FROM Investigadores i, ProyectoInvestigador pi, Proyectos p "+
				"WHERE p.Nombre = 'Diseño de aplicación móvil para detección de enfermedades' AND pi.Proyecto=1 AND pi.Investigador = i.ID";

		resultado = st.executeQuery(consulta); 

		while(resultado.next()){
			String nombre = resultado.getString(1);
			datos += nombre +"\n";
		}
		
		consultaGeneral += consulta;
		ejecutar.setConsultaGeneral(consultaGeneral);
		
		st.close();

		return datos;
	}
}
