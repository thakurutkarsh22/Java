package ExtraClassesForDs.Generics;

import java.util.Comparator;

public class car implements Comparable<car>{
	
	private String name ;
	private int speed;
	private int price;
	public static final CarSpeedComparator speedctor = new CarSpeedComparator();
	public static final CarPriceComparator pricector = new CarPriceComparator();
	public static final CarNameComparator namector = new CarNameComparator();
	
	car(String name, int speed , int price){
		this.name = name ;
		this.speed = speed;
		this.price = price;
		
		
	}

	@Override
	public int compareTo(car o) {
//		return this.speed - o.speed;
//		return o.price - this.price;
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString(){
		return "[" + this.name + "_s :" + this.speed + "_v : "+ this.price + "]";
	}

	private static class CarSpeedComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o1.speed - o2.speed;
		}
		
	}
	
	private static class CarPriceComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o1.price - o2.price;
		}
		
	}
	private static class CarNameComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o1.name.compareTo(o2.name);
		}
		
	}


		
	
}
