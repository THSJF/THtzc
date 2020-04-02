package runner.Layer;
import java.util.*;
import runner.Layer.*;

public class Event implements Cloneable {
	public String tag = "新事件组";
	public int t = 1;
	public ArrayList<String> events = new ArrayList<String>();
	public ArrayList<EventRead> results = new ArrayList<EventRead>();
	public int index;
	public int loop;
	public int addtime;
	public int special;

	public Event(int idx) {
		index = idx;
	}

	@Override
	public Event clone() throws CloneNotSupportedException {
		Event e=(Event) super.clone();
		e.events.clear();
		e.events.addAll(events);
		e.results.clear();
		for (EventRead er:results) {
			e.results.add(er.clone());
		}
		return e;
	}
}
