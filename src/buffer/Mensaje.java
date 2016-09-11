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
		wait();
	}
	public void actualizarInfo(int info)
	{
		msj = info;
	}
	public void despertar()
	{
		notify();
	}
	
}
