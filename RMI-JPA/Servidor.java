public class Principal
{
	public static void main(String[] args){
		try{
			Interfaz inter;
			LocalRegistry.createRegistry(1099);
			inter = new Implementacion();
			Naming.bind("registroalum",inter);
			System.out.println("Servidor");
		}
		catch(MalformedURLException | AlreadyBoundException | RemoteException ex){
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
		}

	}


}