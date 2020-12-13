package kartheek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Covid {

	public static void main(String[] args) {
		covidSeating();
	}

	public static void covidSeating() {
		int N = 20;
		String model = "2-2";
		String backseats = "no";
		String frontseats = "single";
		List<Integer> availableseats = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		if (model.equals("2-1")) {
			if (backseats.equalsIgnoreCase("yes"))
				N = N - 2;
			for (int i = 1; i < N + 1; i++) {
				if (i % 2 != 0) {
					availableseats.add(i);
					list1.add(0);
				}
			}
			orderSeats(availableseats, list1);
		} else if (model.equals("2-2")) {
			if (frontseats.equalsIgnoreCase("double")) {
				List<Integer> initiallist = new ArrayList<>();
				int i = 1;
				while (i <= N - 5) {
					initiallist.add(i);
					initiallist.add(i + 1);
					initiallist.add(i + 2);
					initiallist.add(i + 3);
					i = i + 7;
					if (i <= N - 5) {
						initiallist.add(i);
						initiallist.add(i - 1);
						initiallist.add(i - 2);
						initiallist.add(i - 3);
					}
					i += 1;
				}
				int k = (N - 5);
				int count = 0;
				if ((k / 4) % 2 != 0) {
					k = N;
					while (count != 5) {
						initiallist.add(k);
						k = k - 1;
						count += 1;
					}
				} else {
					while (count != 5) {
						k = k + 1;
						initiallist.add(k);
						count += 1;
					}
				}
				for (int j = 0; j < initiallist.size(); j++) {
					if (j % 2 == 0) {
						availableseats.add(initiallist.get(j));
						list1.add(0);
					}
				}
				orderSeats(availableseats, list1);
			} else if (frontseats.equalsIgnoreCase("single")) {
				List<Integer> initiallist = new ArrayList<>();
				initiallist.add(1);
				initiallist.add(2);
				initiallist.add(3);
				initiallist.add(7);
				initiallist.add(6);
				initiallist.add(5);
				initiallist.add(4);
				int i = 8;
				while (i <= N - 5) {
					initiallist.add(i);
					initiallist.add(i + 1);
					initiallist.add(i + 2);
					initiallist.add(i + 3);
					i = i + 7;
					if (i <= N - 5) {
						initiallist.add(i);
						initiallist.add(i - 1);
						initiallist.add(i - 2);
						initiallist.add(i - 3);
					}
					i += 1;
				}
				int k = (N - 5);
				int count = 0;
				if ((k / 4) % 2 != 0) {
					k = N;
					while (count != 5) {
						initiallist.add(k);
						k = k - 1;
						count += 1;
					}
				} else {
					while (count != 5) {
						k = k + 1;
						initiallist.add(k);
						count += 1;
					}
				}
				availableseats.add(1);
				availableseats.add(2);
				list1.add(1);
				list1.add(1);
				for (int m = 3; m < initiallist.size(); m++) {
					if (m % 2 != 0) {
						availableseats.add(initiallist.get(m));
						list1.add(0);
					}
				}
				orderSeats(availableseats, list1);
			}
		}
	}

	private static void orderSeats(List<Integer> availableseats, List<Integer> list1) {
		List<Integer> orderedseats = new ArrayList<>();
		List<Integer> listofones = new ArrayList<>();
		Collections.sort(availableseats);
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
