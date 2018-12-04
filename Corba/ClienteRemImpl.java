public class ClienteRemImpl extends ClienteRemoto.ClienteRemPOA
{
	public ClienteRemImpl(){}
	public String Saludar(String nombre){
		return "Hola "+nombre;
	}
	public double Suma(double x,double y){
		return x+y;
	}
	public double Resta(double x,double y){
		return x-y;
	}
	public double Division(double x,double y){
		return x/y;
	}
	public double Multiplicacion(double x,double y){
		return x*y;
	}
}