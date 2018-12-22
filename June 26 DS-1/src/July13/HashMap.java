package July13;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import july11.GenericLinkedList;

public class HashMap<K, V> {

	private class HMNode {
		K key;
		V value;

		HMNode() {
			this.key = key;
			this.value = value;
		}
	}

	private GenericLinkedList<HMNode>[] bucketArray;
	private int size;

	public HashMap() {
		this(5);
	}

	public HashMap(int cap) {

		this.bucketArray = (GenericLinkedList<HMNode>[]) new GenericLinkedList[cap];
		for (int i = 0; i < bucketArray.length; i++) {
			this.bucketArray[i] = new GenericLinkedList<HMNode>();
		}

	}

	public void put(K key, V value) throws Exception {
		// hashcode
		int bi = this.hashFunction(key); // O(1)
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];
		// find in bucket
		int foundAt = this.findInBucket(bucket, key);

		if (foundAt == -1) { // node to be added
			HMNode ntba = new HMNode();
			ntba.key = key;
			ntba.value = value;
			bucket.addLast(ntba);
			this.size++;
		} else {

			HMNode ntbu = bucket.getAt(foundAt);
			ntbu.value = value;
		}

		// reshaing

		double lambda = (1.0 * this.size()) / bucketArray.length;
		if (lambda > 2.0) {

			reshashing();
		}
	}

	public boolean containsKey(K key) throws Exception {
		// hashcode
		int bi = this.hashFunction(key); // O(1)
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];

		// find in bucket
		int foundAt = this.findInBucket(bucket, key);

		if (foundAt == -1) { // node to be added
			return false;
		} else {

			return true;
		}

	}

	public V remove(K key, V value) throws Exception {
		// hash-code
		int bi = this.hashFunction(key); // O(1)
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];

		// find in bucket
		int foundAt = this.findInBucket(bucket, key);

		if (foundAt == -1) { // node to be added
			return null;

		} else {
			HMNode k = bucket.removeAt(foundAt);
			return k.value;
		}

	}

	private int hashFunction(K key) {
		// hashcode
		int hc = key.hashCode();

		// compress // bi = bucket index

		int bi = Math.abs(hc) % bucketArray.length;
		return bi;

	}

	private int findInBucket(GenericLinkedList<HMNode> bucket, K key) throws Exception {
		for (int i = 0; i < bucket.size(); i++) {
			HMNode temp = bucket.getAt(i);
			if (temp.key.equals(key)) {
				return i;
			}

		}
		return -1;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public V get(K key) throws Exception {

		int bi = this.hashFunction(key); // O(1)
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];

		// find in bucket
		int foundAt = this.findInBucket(bucket, key);

		if (foundAt == -1) { // node to be added
			return null;
		} else {

			HMNode ntbu = bucket.getAt(foundAt);
			return ntbu.value;
		}

	}

	public void dispaly() throws Exception {

		System.out.println("----------------------------");

		for (int i = 0; i < bucketArray.length; i++) {
			System.out.println("Bucket" + i + "= :");
			for (int j = 0; j < bucketArray[i].size(); j++) {
				System.out.println(bucketArray[i].getAt(j).key + "@" + bucketArray[i].getAt(j).value);
			}
			System.out.println(".");
		}
		System.out.println("--------------------------------");
	}

	public ArrayList<K> keySet() throws Exception {

		ArrayList<K> keys = new ArrayList<>();
		for (int i = 0; i < bucketArray.length; i++) {
			for (int j = 0; j < bucketArray[i].size(); j++) {
				keys.add(bucketArray[i].getAt(j).key);
			}
		}
		return keys;

	}

	private void reshashing() throws Exception {

		GenericLinkedList<HMNode>[] oa = this.bucketArray;

		this.bucketArray = (GenericLinkedList<HMNode>[]) new GenericLinkedList[2 * oa.length];

		for (int i = 0; i < bucketArray.length; i++) {
			this.bucketArray[i] = new GenericLinkedList<HMNode>();
		}
		this.size = 0;
		for (int i = 0; i < oa.length; i++) {
			for (int j = 0; j < oa[i].size(); j++) {
				HMNode k = oa[i].getAt(j);
				this.put(k.key, k.value);
			}
		}

	}

}
