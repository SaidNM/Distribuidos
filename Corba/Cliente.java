import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class Cliente {
  public static void main(String args[]) {
    try{
        ORB orb = ORB.init(args,null);
        // obtener una referencia a NameService
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        // las siguientes lineas nos permiten obtener una ref a un objeto remoto
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        // nombre del obj remoto
        String nombre = "ClienteRemoto";
        ClienteRemoto.ClienteRem impl = ClienteRemoto.ClienteRemHelper.narrow(ncRef.resolve_str(nombre));
        System.out.println(impl.Saludar("Jose"));
        int x = 2, y = 4;
        System.out.println("X:"+x+" Y:"+y);
        System.out.println("Suma: "+impl.Suma(x, y));
        System.out.println("Resta: "+impl.Resta(x, y));
        System.out.println("Multiplicacion: "+impl.Multiplicacion(x, y));
        System.out.println("Division: "+impl.Division(x, y));
      }catch (Exception e) {
        System.out.println("ERROR : " + e);
        e.printStackTrace(System.out);
      }
  }
}