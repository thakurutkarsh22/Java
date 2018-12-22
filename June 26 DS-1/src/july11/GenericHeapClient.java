package july11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//
//import july11.GenericHeap.Pair;
//import july11.GenericHeap.Pair.PairComparator;

//import july11.GenericClient.Car;

public class GenericHeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 GenericHeap<Car> car = new GenericHeap<>(null);
//		
//		 Car[] cars = new Car[5];
//		 cars[0] = new Car(50, 30000, "A");
//		 cars[2] = new Car(100, 60000, "B");
//		 cars[4] = new Car(150, 90000, "C");
//		 cars[1] = new Car(125, 92000, "D");
//		 cars[3] = new Car(250, 100000, "E");
//		
//		 car.add(cars[0]);
//		 car.add(cars[2]);
//		 car.add(cars[3]);
//		 car.add(cars[1]);
//		 car.add(cars[4]);
//		 car.display();
		
		// System.out.println(car.remove());
		// System.out.println(car.remove());
		// System.out.println(car.remove());
		// System.out.println(car.remove());
		// System.out.println(car.remove());

		ArrayList<Integer> zero = new ArrayList<>(Arrays.asList(10, 15, 20, 25));
		ArrayList<Integer> one = new ArrayList<>(Arrays.asList(9, 18, 24, 27));
		ArrayList<Integer> two = new ArrayList<>(Arrays.asList(5, 7, 28, 40));
		ArrayList<Integer> three = new ArrayList<>(Arrays.asList(17, 19, 21, 29));
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>(Arrays.asList(zero, one, two, three));
		int k =2 ;
		ArrayList<Integer> listss = new ArrayList<>(Arrays.asList(12,3,9,8,7,17,90,33));
		System.out.println(mergeList(lists));
		System.out.println(getKthLargestElements(listss, k));

	}

	private static class Car implements Comparable<Car> {

		int speed;
		int price;
		String name;

		Car(int speed, int price, String name) {

			this.price = price;
			this.name = name;
			this.speed = speed;

		}

		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
			return this.speed - o.speed;
		}

		@Override
		public String toString() {
			return "[S=" + this.speed + ",P =" + this.price + " ,N =" + this.name + "]";
		}

		public static class CarSpeedComparator implements Comparator<Car> {

			@Override
			public int compare(Car o, Car t) {
				// TODO Auto-generated method stub
				return o.speed - t.speed;
			}

		}

		public static class CarPriceComparator implements Comparator<Car> {

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return o2.price - o1.price;
			}

		}

		public static class CarNameComparator implements Comparator<Car> {

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}

		}

	}
	// merge list extra .. . . . .. .

	
	public static class Pair {
		int data;
		int lno;
		int ino;

		public static final PairComparator comparator = new PairComparator();
		public static final PairComparators comparator2 = new PairComparators();

		public static class PairComparator implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.data - o1.data;
			}

		}

		public static class PairComparators implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.data - o2.data;
			}

		}

	}

	public static ArrayList<Integer> mergeList(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> list = new ArrayList<>();
//		 GenericHeap<Comparable<Pair>> heap = new GenericHeap<>(Pair.comparator);
		GenericHeap<Pair> hp = new GenericHeap<>(Pair.comparator);

		// fill
		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair();
			p.lno = i;
			
			p.ino = 0;
			p.data = lists.get(i).get(0);
			hp.add(p);
		}

		// while heap is not empty
		while (hp.size() != 0) {
			Pair rp = hp.remove();
			list.add(rp.data);
			rp.ino++;
			

			if (rp.ino < lists.get(rp.lno).size()) {
				rp.data = lists.get(rp.lno).get(rp.ino);
				hp.add(rp);
			}

		}
		return list;
	}

	public static ArrayList<Integer> kthLargest(ArrayList<ArrayList<Integer>> lists, int k) {

		ArrayList<Integer> list = new ArrayList<>();
		// GenericHeap<Comparable<Pair>> heap = new GenericHeap<>(Pair.comparator);
		GenericHeap<Pair> hp = new GenericHeap<>(Pair.comparator2);

		// fill
		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair();
			p.lno = i;
			p.ino = 0;
			p.data = lists.get(i).get(0);
			hp.add(p);
		}

		// while heap is not empty
		while (hp.size() <= k) {
			Pair rp = hp.remove();
			list.add(rp.data);
			// rp.ino++;
			//
			// if (rp.ino < lists.get(rp.lno).size() ) {
			// hp.add(rp);
			// }
			//
		}
		return list;
	}

	public static ArrayList<Integer> getKthLargestElements(ArrayList<Integer> lists , int k){
		
		ArrayList<Integer> list = new ArrayList<>();
		// GenericHeap<Comparable<Pair>> heap = new GenericHeap<>(Pair.comparator);
		GenericHeap<Pair> hp = new GenericHeap<>(Pair.comparator);

		// fill
		for (int i = 0; i < k ; i++) {
			Pair p = new Pair();
			
			p.data = lists.get(i);
			hp.add(p);
		}
		
		for(int i = k ; i < lists.size() ; i++) {
			Pair gp = hp.get();
			int p =lists.get(i);
			
			if(p > gp.data) {
			
			Pair rp=hp.remove();
			
//			Pair np = new Pair();
			rp.data = p ;
			hp.add(rp);
				
			}
		}
		
		while (hp.size()!=0) {
			Pair gp = hp.remove();
			list.add(gp.data);
		}
		
		
		return list;
		
	}
}
