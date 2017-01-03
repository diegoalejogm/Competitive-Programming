package structures;

public class IntegerPair implements Comparable
{
	public int _x, _y;
	
	public IntegerPair(int x, int y) {
		_x = x;
		_y = y;
	}
	
	@Override
	public int compareTo(Object o) {
		return this._y - ((IntegerPair)o)._y;
	}
}