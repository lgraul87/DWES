package modelo.laboral;

public interface IEmpleado {

	public byte getbCategoria();

	public boolean setbCategoria(byte bCategoria);

	public byte getbAnyosTrabajados();

	public void setbAnyosTrabajados(byte bAnyosTrabajados);

	public boolean incrAnyo();

	public String imprimeEmpleado(Empleado oEmpleado);

	public boolean validaEmpleado(Empleado oEmpleado);

}
