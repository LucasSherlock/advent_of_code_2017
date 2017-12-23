package q3;

import java.awt.Point;
import java.util.HashMap;
import java.util.function.Function;

public class MappingFunction implements Function<Point, Integer> {
	private HashMap<Point, Integer> _map;
	
	public MappingFunction(HashMap<Point, Integer> map) {
		_map = map;
	}

	@Override
	public Integer apply(Point t) {
		int x = (int) t.getX();
		int y = (int) t.getY();
		Integer value = 0;
		value += _map.getOrDefault(new Point(x+1, y-1), 0);
		value += _map.getOrDefault(new Point(x+1, y), 0);
		value += _map.getOrDefault(new Point(x+1, y+1), 0);
		value += _map.getOrDefault(new Point(x, y-1), 0);
		value += _map.getOrDefault(new Point(x, y+1), 0);
		value += _map.getOrDefault(new Point(x-1, y-1), 0);
		value += _map.getOrDefault(new Point(x-1, y), 0);
		value += _map.getOrDefault(new Point(x-1, y+1), 0);
		return value;
	}
	

}
