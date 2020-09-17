import java.util.Comparator;

public class KeyComparator<E extends Comparable<E>> implements Comparator<E> {

	public String state = "Min";

	

	public void toggle() {

		if (state.equals("Min")) {
			state = "Max";
		} else {
			state = "Min";
		}
	}

	public String getState() {
		return state;
	}
	
	public int compare(E first, E second) {
		if (state.equals("Max")) {
			return (first.compareTo(first));
		} else {
			return (-first.compareTo(first));
		}
	}

}