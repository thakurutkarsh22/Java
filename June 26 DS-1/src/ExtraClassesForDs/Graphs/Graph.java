package ExtraClassesForDs.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;


public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vces = new HashMap<>();

	public int numVertices() {
		return vces.size();
	}

	public boolean constainsVerticex(String vname) {
		if (vces.containsKey(vname)) {
			return true;
		}
		return false;
	}

	public void addVertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		}

		Vertex newv = new Vertex();
		vces.put(vname, newv);
	}

	public int numEdges() {
		int rv = 0;

		Set<String> list = vces.keySet();
		for (String li : list) {
			Vertex v = vces.get(li);
			rv += v.nbrs.size();
		}
		return rv / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		Vertex v1 = vces.get(v1name);
		Vertex v2 = vces.get(v2name);
		if (v1 == null || v2 == null || !v1.nbrs.containsKey(v2name)) {
			return false;
		}
		return true;
	}

	public void addEdge(String v1name, String v2name, int weight) {
		Vertex v1 = vces.get(v1name);
		Vertex v2 = vces.get(v2name);
		if (v1 == null || v2 == null) {
			return;
		}

		v1.nbrs.put(v2name, weight);
		v2.nbrs.put(v1name, weight);
	}

	public void removeEdge(String v1name, String v2name) {
		Vertex v1 = vces.get(v1name);
		Vertex v2 = vces.get(v2name);
		if (v1 == null || v2 == null || !v1.nbrs.containsKey(v2name)) {
			return;
		}

		v1.nbrs.remove(v2name);
		v2.nbrs.remove(v1name);
	}

	public void removeVertices(String vname) {
		if (!vces.containsKey(vname)) {
			return;
		}

		else {

			Vertex vec = vces.get(vname);
			Set<String> list = vec.nbrs.keySet();
			for (String ver : list) {
				Vertex n = vces.get(ver);
				n.nbrs.remove(vname);
			}

			vces.remove(vname);
		}
	}

	public void display() {

		Set<String> vname = vces.keySet();
		for (String vnames : vname) {

			Vertex vtx = vces.get(vnames);

			Set<String> nbrname = vtx.nbrs.keySet();

			String str = vnames + "==>";
			for (String nbrnames : nbrname) {

				str += "[" + nbrnames + vtx.nbrs.get(nbrnames) + "]";

			}
			System.out.println(str);

		}

	}

	public boolean hasPath(String v1name, String v2name, HashMap<String, Boolean> hm) {
		if (hm.containsKey(v1name)) {
			return false;
		}
		hm.put(v1name, true);

		if (containsEdge(v1name, v2name)) {
			return true;
		} else {
			Vertex v = vces.get(v1name);
			Set<String> nbrnames = v.nbrs.keySet();
			for (String nbrname : nbrnames) {
				if (hasPath(nbrname, v2name, hm)) {
					return true;
				}
			}

		}
		return false;

	}

	public void Printpath(String v1name, String v2name) {
		Printpath(v1name, v2name, new HashMap<>(), v1name);
	}

	private boolean Printpath(String v1name, String v2name, HashMap<String, Boolean> hm, String str) {
		if (hm.containsKey(v1name)) {
			return false;
		}
		hm.put(v1name, true);

		if (containsEdge(v1name, v2name)) {
			System.out.println(str + v2name);
			return true;
		}
		Vertex v = vces.get(v1name);
		Set<String> nbrnames = v.nbrs.keySet();
		for (String nbrname : nbrnames) {
			if (Printpath(nbrname, v2name, hm, str + nbrname)) {
				return true;
			}
		}

		return false;

	}

	public void Printallpath(String v1name, String v2name) {
		Printallpath(v1name, v2name, new HashMap<>(), v1name);
	}

	private boolean Printallpath(String v1name, String v2name, HashMap<String, Boolean> hm, String str) {
		if (hm.containsKey(v1name)) {
			return false;
		}
		hm.put(v1name, true);

		if (containsEdge(v1name, v2name)) {
			System.out.println(str + v2name);
			hm.remove(v1name, true);
			return true;

		} else {
			Vertex v = vces.get(v1name);
			Set<String> nbrnames = v.nbrs.keySet();
			for (String nbrname : nbrnames) {
				if (Printpath(nbrname, v2name, hm, str + nbrname)) {
					return true;
				}
			}

		}
		return false;

	}

	public void printallPath(String v1name, String v2name, HashMap<String, Boolean> pro, String psf) {

		pro.put(v1name, true);

		psf += v1name + "==>";
		if (v1name.equals(v2name)) {
			System.out.println(psf);
			pro.remove(v1name, true);
			return;
		}

		Vertex vtx1 = vces.get(v1name);
		Set<String> nbrnames = vtx1.nbrs.keySet();

		for (String nbrname : nbrnames) {
			if (pro.containsKey(nbrname) == false) {
				printallPath(nbrname, v2name, pro, psf);
			}

		}

		pro.remove(v1name, true);
	}

	private class Pair {

		String vname;
		Vertex vtx;
		String psf;
		String colour;

		Pair(String vname, Vertex vtx, String psf, String colour) {
			this.vname = vname;
			this.vtx = vtx;
			this.psf = psf;
			this.colour = colour;

		}

		Pair(String vname, Vertex vtx, String psf) {

			this.vname = vname;
			this.vtx = vtx;
			this.psf = psf;

		}
	}
	
	public ArrayList<ArrayList<String>> getConnectedComponents() {

		HashMap<String, Boolean> pro = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<ArrayList<String>> list = new ArrayList<>();

		Set<String> vname = this.vces.keySet();
		for (String vnames : vname) {

			if (pro.containsKey(vnames)) {

				continue;
			}

			ArrayList<String> list2 = new ArrayList<>();

			Vertex vtx1 = vces.get(vnames);
			Pair p = new Pair(vnames, vtx1, vnames);

			queue.addLast(p);

			while (!queue.isEmpty()) {
				// 1. remove

				Pair rp = queue.removeFirst();

				// 2. process if unprocessed
				if (!pro.containsKey(rp.vname)) {

					// 2.0 mark processed
					pro.put(rp.vname, true);

					// 2.1 check nbrs

					// System.out.println(rp.psf );

					list2.add(rp.vname);
					// 2.2 put the unprocessed nbrs in

					Set<String> rpnbrnames = rp.vtx.nbrs.keySet();
					for (String rvname : rpnbrnames) {

						if (!pro.containsKey(rvname)) {
							Pair np = new Pair(rvname, this.vces.get(rvname), rp.psf + rvname);
							queue.addLast(np);
						}

					}

				}

			}
			list.add(list2);

		}

		return list;

	}
	
//	public boolean bfs (String v1name ,String v2name) {
//		LinkedList<Pair> queue = new LinkedList<>();
//		HashMap<String, Boolean> pro = new HashMap<>();
//		Vertex vtx =vces.get(v1name);
//		Pair np = new Pair(v1name, vtx, v1name);
//		
//		while ()
//		
//	}
}