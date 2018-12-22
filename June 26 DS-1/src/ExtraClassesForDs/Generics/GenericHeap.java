package ExtraClassesForDs.Generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class GenericHeap<T extends Comparable<T>> {
	
	private ArrayList<T> data = new ArrayList<>();
	Comparator<T> speciicComparator;
	private HashMap<T, Integer> idxmap = new HashMap<>();

	public GenericHeap(Comparator<T> speciicComparator) {
		this.speciicComparator = speciicComparator;
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public void display() {
		System.out.println(data);
	}

	public void add(T item) {
		this.data.add(item);
		this.idxmap.put(item, this.data.size() - 1);
		this.upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (this.isLarger(ci, pi)) { // ?
			swap(pi, ci);
			this.upheapify(pi);
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

	public T get() {
		return data.get(0);
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

		if (lci < data.size() && this.isLarger(lci, maxi)) {
			maxi = lci;
		}

		if (rci < data.size() && this.isLarger(rci, maxi)) {
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

		if (speciicComparator == null) {
			return ith.compareTo(jth) > 0;
		} else {
			return speciicComparator.compare(ith, jth) > 0;
		}
	}

	public void updatePriority(T item) {
		int idx = idxmap.get(item);
		upheapify(idx);
		downheapify(idx);
	}
}