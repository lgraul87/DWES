package controlador.modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.database.ConexionDB;
import laboral.Empleado;

public class EmpleadoController {

	public boolean addEmployee(Empleado oEmpleado1) {

		boolean bExito = false;

		String sNombre = oEmpleado1.getsNombre();
		String sDni = oEmpleado1.getsDni();
		char cLetra = oEmpleado1.getcLetra();
		byte bCategoria = oEmpleado1.getbCategoria();
		byte bAnio = oEmpleado1.getbAnyosTrabajados();

		String sql = "SELECT DNI FROM EMPLEADO WHERE DNI = '" + sDni + "'";

		if (ConexionDB.executeCount(sql) == 0) {

			String sql2 = "INSERT INTO EMPLEADO VALUES ('" + sNombre + "'," + bCategoria + "," + bAnio + ",'" + sDni
					+ "','" + cLetra + "')";

			ConexionDB.executeUpdate(sql2);
			bExito = true;

		}
		return bExito;

	}

	public String showAll() {

		String sResultado = "No hay Empleados";

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		byte bCategoria = 0;
		byte bAnios = 0;

		String sql = "SELECT COUNT(*) FROM Proveedor;";
		if (ConexionDB.executeCount(sql) > 0) {

			sResultado = "";

			String sql2 = "SELECT * FROM EMPLEADO;";

			try {
				Statement statement = ConexionDB.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(sql2);
				while (resultSet.next()) {

					sNombre = resultSet.getString("nombre");
					sLetra = resultSet.getString("sexo");
					sDni = resultSet.getString("correo");
					bCategoria = resultSet.getByte("categoria");
					bAnios = resultSet.getByte("anio");

					sResultado += "  --Nombre: " + sNombre + "  --Dni: '" + sDni + "'  --Sexo: " + sLetra
							+ "  --Categoria: " + bCategoria + "  --Anios: " + bAnios + "\n";

				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sResultado;

	}

	public String showEmployee(Empleado oEmpleado) {
		String sResultado = null;

		String sNombre = null;
		String sLetra = null;
		String sDni = null;
		byte bCategoria = 0;
		byte bAnios = 0;

		sDni = oEmpleado.getsDni();

		String sql = "SELECT * FROM Proveedor WHERE nombre_proveedor = '" + sNombre + "';";

		try {
			Statement statement = ConexionDB.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				sNombre = resultSet.getString("nombre");
				sLetra = resultSet.getString("sexo");
				sDni = resultSet.getString("correo");
				bCategoria = resultSet.getByte("categoria");
				bAnios = resultSet.getByte("anio");

				sResultado = "  --Nombre: " + sNombre + "  --Dni: '" + sDni + "'  --Sexo: " + sLetra + "  --Categoria: "
						+ bCategoria + "  --Anios: " + bAnios + "\n";

			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sResultado;
	}

	public void editEmployee(Empleado oEmpleado, Empleado oEmpleadoModificado) {
		// TODO Auto-generated method stub

	}

	public void upDateSalaryAll() {
		// TODO Auto-generated method stub

	}

	public Empleado bringEmployee(Empleado oEmpleado) {
		// TODO Auto-generated method stub
		return null;
	}

	public void upDateSalary(Empleado oEmpleado, Empleado oEmpleadoEditado) {
		// TODO Auto-generated method stub

	}

}
