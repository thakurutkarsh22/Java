package ExtraClassesForDs.GenericHashMap;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;

import ExtraClassesForDs.GenericHashMap.GenericLinkedList;

public class HashMap<K, V> {

	private class HMNode {
		K key;
		V value;
	}

	private GenericLinkedList<HMNode>[] bucketArray; // N
	private int size = 0; // n

	public HashMap(int cap) {
		this.bucketArray = (GenericLinkedList<HMNode>[]) new GenericLinkedList[cap];
		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new GenericLinkedList<>();
		}
	}

	public void put(K key, V value) throws Exception {
		// hash function
		int bi = hashFunction(key);
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];
		// find
		int foundAt = findInBucket(bucket, key);
		if (foundAt == -1) {
			HMNode ntba = new HMNode();
			ntba.key = key;
			ntba.value = value;
			bucket.addLast(ntba);
			this.size++;
		} else {
			HMNode ntbu = bucket.getAt(foundAt);
			ntbu.value = value;
		}

		if (size / bucketArray.length >= 2) {
			reshashing();
		}

	}

	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];
		// find
		int foundAt = findInBucket(bucket, key);
		if (foundAt == -1) {
			return null;
		} else {
			return bucketArray[bi].getAt(foundAt).value;
		}
	}

	public V remove(K key) throws Exception {
		int bi = hashFunction(key);
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];
		// find
		int foundAt = findInBucket(bucket, key);
		if (foundAt == -1) {
			return null;
		} else {
			HMNode rm = bucketArray[bi].removeAt(foundAt);
			this.size--;
			return rm.value;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEMpty() {
		return this.size == 0;
	}

	public boolean containsKey(K key) throws Exception {
		int bi = hashFunction(key);
		GenericLinkedList<HMNode> bucket = this.bucketArray[bi];
		// find
		int foundAt = findInBucket(bucket, key);
		if (foundAt == -1) {
			return false;
		} else {
			return true;
		}
	}

	public void display() throws Exception {
		for (int i = 0; i < this.bucketArray.length; i++) {
			for (int j = 0; j < bucketArray[i].size(); j++) {
				HMNode temp = bucketArray[i].getAt(j);
				System.out.println(temp.value + " " + temp.key);
			}
		}
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
	
	public ArrayList<K> keyset() throws Exception{
		ArrayList<K> list = new ArrayList<>();
		for (int i = 0 ; i < bucketArray.length ;i++) {
			for (int j =0 ; j< bucketArray[i].size() ; j++) {
				HMNode temp = bucketArray[i].getAt(j);
				list.add(temp.key);
			}
		}
		return list;
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % bucketArray.length;
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
}
