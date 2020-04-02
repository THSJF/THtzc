package runner.Layer;

public class EventRead implements Cloneable {
	public float rand;
	public int special;
	public int special2;
	public String condition;
	public String result;
	public String condition2;
	public int contype;
	public int contype2;
	public String opreator;
	public String opreator2;
	public String collector;
	public int change;
	public int changetype;
	public int changevalue;
	public int changename;
	public float res;
	public int times;
	public int time;
	public boolean noloop;

	@Override
	protected EventRead clone() throws CloneNotSupportedException {
		return (EventRead)super.clone();
	}   
}
