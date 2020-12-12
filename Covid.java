package kartheek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Covid {

	public static void main(String[] args) {
		covidSeating();
	}

	public static void covidSeating() {
		int N = 15;
		String model = "2-1";
		String backseats = "no";

		if (model.equals("2-1")) {
			if (backseats.equalsIgnoreCase("yes"))
				N = N - 2;
			List<Integer> availableseats = new ArrayList<>();
			List<Integer> list1 = new ArrayList<>();
			List<Integer> orderedseats = new ArrayList<>();
			List<Integer> listofones = new ArrayList<>();
			for (int i = 1; i < N + 1; i++) {
				if (i % 2 != 0) {
					availableseats.add(i);
					list1.add(0);
				}
			}
			orderedseats.add(availableseats.get(0));
			list1.set(0, 1);
			listofones.add(1);
			int l = availableseats.size();
			orderedseats.add(availableseats.get(l - 1));
			list1.set(l - 1, 1);
			listofones.add(l);
			l = l - 2;
			while (l > 0) {
				int maxdiff = 0;
				int diffindex = 0;
				for (int i = 0; i < listofones.size() - 1; i++) {
					if (maxdiff < listofones.get(i + 1) - listofones.get(i)) {
						diffindex = listofones.get(i);
						maxdiff = listofones.get(i + 1) - listofones.get(i);
					}
				}
				int x = (int) (diffindex + Math.floor(maxdiff / 2));
				orderedseats.add(availableseats.get(x - 1));
				list1.set(x - 1, 1);
				listofones.add(x);
				Collections.sort(listofones);
				l -= 1;
			}
			System.out.println(orderedseats);
		}
	}

}
