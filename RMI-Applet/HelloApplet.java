public class HelloApplet extends Applet{
	String message = "blank";
	Saludo saludo = null;
	@Override
	public void init(){
		try {
			saludo = (Saludo) Naming.lookup("//"+getCodeBase().getHost()+"/HelloServer");
			message = saludo.saludar();
		} catch (Exception e) {
			System.out.println("HelloApplet exception: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		g.drawString(message,25,50);
	} 
}