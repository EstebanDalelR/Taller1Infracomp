package buffer;

public class Mensaje
{
	public long msj; 
	public Mensaje(long msjn)
	{
		msj = msjn;
	}
	public void dormir()
	{
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void actualizarInfo(long info)
	{
		msj = info;
	}
	public void despertar()
	{
		notify();
	}
	public long darMensaje() {
		return msj;
	}
	
}
