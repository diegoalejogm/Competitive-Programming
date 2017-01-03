package structures;

public class IntegerThree implements Comparable<IntegerThree>
{
	public int _x, _y, _z;
	
	public IntegerThree(int x, int y, int z) {
		_x = x;
		_y = y;
		_z = z;
	}
	
	@Override
	public int compareTo(IntegerThree o) {
		return this._z - (o)._z;
	}
}