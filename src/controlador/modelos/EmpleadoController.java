package controlador.modelos;

import controlador.database.ConexionDB;
import laboral.Empleado;

public class EmpleadoController {

	public void addEmployeeE(Empleado oEmpleado1) {

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
		}

	}

	public void addEmployeeNE(Empleado oEmpleado) {
		// TODO Auto-generated method stub

	}

	public void showAll() {
		// TODO Auto-generated method stub

	}

	public void showEmployee(Empleado oEmpleado) {
		// TODO Auto-generated method stub

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
