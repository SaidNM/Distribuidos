import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
public class Servidor{
  public static void main(String[] args){
  //inicializa orb 
  System.out.println("Server Ready");
  try {
    // crear e inicializar ORB
    ORB orb = ORB.init(args, null);
    // crear un objeto remoto
    ClienteRemImpl impl = new ClienteRemImpl();
    // obtener referencia rootpoa y activar el POAManager
    POA rootpoa = POAHelper.narrow(orb
    .resolve_initial_references("RootPOA"));
    rootpoa.the_POAManager().activate();
    // obtener una referencia al objeto remoto
    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(impl);
    ClienteRemoto.ClienteRem href = ClienteRemoto.ClienteRemHelper.narrow(ref);
    // las siguientes lineas me permiten publicar un obj remoto
    org.omg.CORBA.Object objRef = orb
    .resolve_initial_references("NameService");
    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
    // nombre con el cual voy a publicar mi objeto
    String nombre = "ClienteRemoto";
    NameComponent path[] = ncRef.to_name(nombre);
    // publicar el objeto
    ncRef.rebind(path, href);
    // ejecutar el orb
    orb.run();
  } 
    catch (Exception e) {
      System.err.println("ERROR: " + e);
    }
  }
}