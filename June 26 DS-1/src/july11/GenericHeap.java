package july11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class GenericHeap<T> {

	private ArrayList<T> data = new ArrayList<>();
	Comparator<T> specificcomparator;
	private HashMap<T, Integer> idxmap = new HashMap<>();

	public GenericHeap(Comparator<T> specificcomparator) {
		this.specificcomparator = specificcomparator;
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public T get() {
		return data.get(0);
	}

	public void add(T item) {

		this.data.add(item);
		idxmap.put(item, data.size() - 1);
		upheapify(this.size() - 1);

	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (isLarger(ci, pi)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

		idxmap.put(ith, j);
		idxmap.put(jth, i);
	}

	public T remove() {
		swap(0, data.size() - 1);

		T rv = data.remove(data.size() - 1);

		idxmap.remove(rv);
		downheapify(0);

		return rv;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int maxi = pi;

		if (lci < data.size() && isLarger(lci, maxi)) {
			maxi = lci;
		}
		if (rci < data.size() && isLarger(rci, maxi)) {
			maxi = rci;
		}

		if (maxi != pi) {
			swap(maxi, pi);
			downheapify(maxi);
		}

	}

	private boolean isLarger(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);
		return specificcomparator.compare(ith, jth) > 0;
	}

	public void updatePriority(T item) {
		int i = idxmap.get(item);
		upheapify(i);
		downheapify(i);
	}

}
