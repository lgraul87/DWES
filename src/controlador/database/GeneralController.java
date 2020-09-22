package controlador.database;

import controlador.modelos.EmpleadoController;

public class GeneralController {

	private ConexionDB conexionDB;
	private EmpleadoController empleadoController;

	public GeneralController(String sDatabase) {

		this.conexionDB = new ConexionDB(sDatabase);
		this.empleadoController = new EmpleadoController();

	}

	public ConexionDB getConexionDB() {
		return this.conexionDB;
	}

	public EmpleadoController getEmpleadoController() {
		return this.empleadoController;
	}

}
