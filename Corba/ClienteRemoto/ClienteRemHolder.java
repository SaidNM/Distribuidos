package ClienteRemoto;


public final class ClienteRemHolder implements org.omg.CORBA.portable.Streamable
{
  public ClienteRemoto.ClienteRem value = null;

  public ClienteRemHolder ()
  {
  }

  public ClienteRemHolder (ClienteRemoto.ClienteRem initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ClienteRemoto.ClienteRemHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ClienteRemoto.ClienteRemHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ClienteRemoto.ClienteRemHelper.type ();
  }

}
