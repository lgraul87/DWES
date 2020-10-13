package controlador.modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.database.ConexionDB;

import modelo.laboral.Empleado;
import modelo.laboral.Nomina;

public class EmpleadoController implements IEmpleadoController {

	@Override
	public boolean addEmployee(Empleado oEmpleado1) {

		boolean bExito = false;

		String sNombre = oEmpleado1.getsNombre();
		String sDni = oEmpleado1.getsDni();
		char cLetra = oEmpleado1.getcLetra();
		byte bCategoria = oEmpleado1.getbCategoria();
		byte bAnio = oEmpleado1.getbAnyosTrabajados();

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDni + "'";

		if (ConexionDB.executeCount(sql) == 0) {

			String sql2 = "INSERT INTO EMPLEADO VALUES ('" + sNombre + "'," + bCategoria + "," + bAnio + ",'" + sDni
					+ "','" + cLetra + "')";

			ConexionDB.executeUpdate(sql2);

			String sqlSalary = "INSERT INTO NOMINA VALUES (" + Nomina.setSalaryDB(bCategoria, bAnio) + ",'" + sDni + "');";
			ConexionDB.executeUpdate(sqlSalary);
			bExito = true;

		}
		return bExito;

	}

	

	@Override
	public String showAll() {

		String sResultado = "No hay Empleados";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		byte bCategoria = 0;
		byte bAnios = 0;

		String sql = "SELECT COUNT(*) FROM EMPLEADO;";
		if (ConexionDB.executeCount(sql) > 0) {

			sResultado = "";

			String sql2 = "SELECT * FROM EMPLEADO;";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql2);
				while (resultSet.next()) {

					sNombre = resultSet.getString("nombre");
					sLetra = resultSet.getString("sexo");
					sDni = resultSet.getString("dni");
					bCategoria = resultSet.getByte("categoria");
					bAnios = resultSet.getByte("anio");

					sResultado += "  --Nombre: " + sNombre + "  --Dni: '" + sDni + "'  --Sexo: " + sLetra
							+ "  --Categoria: " + bCategoria + "  --Anios: " + bAnios + ""
									+ "\n  --Sueldo: "+getSalaryDB(sDni)+"\n";

				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sResultado;

	}

	@Override
	public String showEmployee(Empleado oEmpleado) {
		String sResultado = null;

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		byte bCategoria = 0;
		byte bAnios = 0;

		sDni = oEmpleado.getsDni();

		String sql = "SELECT * FROM EMPLEADO WHERE DNI = '" + sDni + "';";

		try {
			Statement statement = ConexionDB.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				sNombre = resultSet.getString("nombre");
				sLetra = resultSet.getString("sexo");
				sDni = resultSet.getString("dni");
				bCategoria = resultSet.getByte("categoria");
				bAnios = resultSet.getByte("anio");

				sResultado = "  --Nombre: " + sNombre + "  --Dni: '" + sDni + "'  --Sexo: " + sLetra + "  --Categoria: "
						+ bCategoria + "  --Anios: " + bAnios + ""
								+ "\nSueldo: "+getSalaryDB(sDni)+"\n";

			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sResultado;
	}

	



	@Override
	public boolean editEmployee(Empleado oEmpleado, Empleado oEmpleadoModificado) {

		boolean bExito = false;

		String sDniBuscador = oEmpleado.getsDni();

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDniBuscador + "' ";

		if (ConexionDB.executeCount(sql) != 0) {

			String sNombre = oEmpleadoModificado.getsNombre();
			char cLetra = oEmpleadoModificado.getcLetra();
			String sDni = oEmpleadoModificado.getsDni();
			byte bCategoria = oEmpleadoModificado.getbCategoria();
			byte bAnios = oEmpleadoModificado.getbAnyosTrabajados();

			String sql2 = "INSERT INTO EMPLEADO VALUES ('" + sNombre + "'," + bCategoria + "," + bAnios + ",'" + sDni
					+ "','" + cLetra + "')";

			ConexionDB.executeUpdate(sql2);
			bExito = true;

		}
		return bExito;

	}

	@Override
	public void upDateSalaryAll() {

		String sql = "UPDATE empleado SET anio = (SELECT anio FROM empleado)+1;";

		ConexionDB.executeUpdate(sql);
	}

	@Override
	public Empleado bringEmployee(Empleado oEmpleado) {

		String sDni = oEmpleado.getsDni();

		Empleado oEmpleadoBuscador = null;

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDni + "'";

		if (ConexionDB.executeCount(sql) != 0) {

			String sql2 = "SELECT * FROM EMPLEADO WHERE DNI = '" + sDni + "'";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql2);

				while (resultSet.next()) {

					String sNombre = resultSet.getString("nombre");
					String sLetra = resultSet.getString("sexo");
					sDni = resultSet.getString("dni");
					byte bCategoria = resultSet.getByte("categoria");
					byte bAnios = resultSet.getByte("anio");

					char cLetra = sLetra.charAt(0);

					oEmpleadoBuscador = new Empleado(sNombre, sDni, cLetra, bAnios, bCategoria);
				}
				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return oEmpleadoBuscador;
		}
		return oEmpleadoBuscador;
	}

	@Override
	public boolean upDateSalary(Empleado oEmpleado, Empleado oEmpleadoEditado) {

		boolean bExito = false;

		String sDniBuscador = oEmpleado.getsDni();

		String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI = '" + sDniBuscador + "'";

		if (ConexionDB.executeCount(sql) != 0) {

		}
		return bExito;

	}
	public float getSalaryDB(String sDni) {
		float fResultado = 0;
		String sql = "SELECT SUELDO FROM NOMINA WHERE DNI = '"+sDni+"';";
		try {
			Statement statement = ConexionDB.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				float fSueldo = resultSet.getFloat("sueldo");
				

				 fResultado =fSueldo;

			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fResultado;
	}

}
