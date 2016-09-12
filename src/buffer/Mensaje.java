package buffer;

public class Mensaje
{
	public long msj; 
	public Mensaje(long msjn)
	{
		msj = msjn;
	}
	public synchronized void dormir()
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
	public synchronized void despertar()
	{
		notifyAll();
	}
	public long darMensaje() {
		return msj;
	}
	
}
