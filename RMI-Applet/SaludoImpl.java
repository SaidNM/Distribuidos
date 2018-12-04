import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SaludoImpl extends UnicastRemoteObject implements Saludo{
	public SaludoImpl() throws RemoteException{
		super();
	}
	@Override
	public String Saludar(){
		return "Hello World!";
	}

	public static void main(String[] args) {
		if(System.getSecurityManager()==null){
			System.setSecurityManager(new RMISecurityManager());
		}
		try{
			SaludoImpl saludar = new SaludoImpl();
			Naming.rebind("HelloServer",saludar);
			System.out.println("HelloServer bond in registry");
		} catch(Exception e) {
			System.out.println("HelloImp err: "+ e.getMessage());
			e.printStackTrace();
		}
	}
}