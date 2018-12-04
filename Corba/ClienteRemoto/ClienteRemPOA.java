package ClienteRemoto;



public abstract class ClienteRemPOA extends org.omg.PortableServer.Servant
 implements ClienteRemoto.ClienteRemOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("Saludar", new java.lang.Integer (0));
    _methods.put ("Suma", new java.lang.Integer (1));
    _methods.put ("Resta", new java.lang.Integer (2));
    _methods.put ("Division", new java.lang.Integer (3));
    _methods.put ("Multiplicacion", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ClienteRemoto/ClienteRem/Saludar
       {
         String nombre = in.read_string ();
         String $result = null;
         $result = this.Saludar (nombre);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // ClienteRemoto/ClienteRem/Suma
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.Suma (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // ClienteRemoto/ClienteRem/Resta
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.Resta (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // ClienteRemoto/ClienteRem/Division
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.Division (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 4:  // ClienteRemoto/ClienteRem/Multiplicacion
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.Multiplicacion (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ClienteRemoto/ClienteRem:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ClienteRem _this() 
  {
    return ClienteRemHelper.narrow(
    super._this_object());
  }

  public ClienteRem _this(org.omg.CORBA.ORB orb) 
  {
    return ClienteRemHelper.narrow(
    super._this_object(orb));
  }


} // class ClienteRemPOA
