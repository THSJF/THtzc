package runner.layer;

import java.util.*;
import runner.layer.*;

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
		this.index = idx;
	}

	public Event Clone() {
		try {
			return clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	protected Event clone() throws CloneNotSupportedException {
		Event e = (Event) super.clone();
		e.events = (ArrayList<String>) events.clone();
		e.results = new ArrayList<>();
		for (EventRead er:results) {
			e.results.add(er.clone());
		}
		return e;
	}
}
