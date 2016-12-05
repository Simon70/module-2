package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class Util {

	/**
	 * Zip two lists together.
	 * 
	 * @param list1
	 *            The first list.
	 * @param list2
	 *            the second list.
	 * @return
	 */
	public static <Element> List<Element> zip(List<Element> list1, List<Element> list2) {
		ArrayList<Element> result = new ArrayList<Element>();
		for (int i = 0; i < list1.size(); i++) {
			result.add(list1.get(i));
			result.add(list2.get(i));
		}
		return result;
	}

	/**
	 * signum function
	 *
	 * @param i
	 *            the function argument
	 * @return -1, 0 or 1 if the argument is negative, 0 or positive
	 */
	public static int signum(int i) {
		if (i < 0) {
			return -1;
		} else if (i > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
