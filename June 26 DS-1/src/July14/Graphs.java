package July14;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import july11.GenericHeap;

public class Graphs {

	private class Vertex {
		// String name;
		HashMap<String, Integer> nbrs = new HashMap<>();

	}

	HashMap<String, Vertex> vces = new HashMap<>();

	public int numVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		}

		Vertex vtx = new Vertex();
		vces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		if (!vces.containsKey(vname)) {
			return;
		}

		Vertex vtx = vces.get(vname);
		Set<String> nbrnames = vtx.nbrs.keySet();
		for (String nbrname : nbrnames) {
			Vertex nbrvtx = vces.get(nbrname);
			nbrvtx.nbrs.remove(vname);
		}
		vces.remove(vname);

	}

	public int numEdges() {

		int rv = 0;

		Set<String> vnames = vces.keySet();

		for (String vname : vnames) {

			Vertex vtx = vces.get(vname);
			rv += vtx.nbrs.size();
		}

		return rv / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {

		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(v2name)) {
			return false;

		}
		return true;
	}

	public void addEdge(String v1name, String v2name, int weight) {

		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(v2name)) {
			return;

		}

		vtx1.nbrs.put(v2name, weight);
		vtx2.nbrs.put(v1name, weight);

	}

	public void removeEdge(String v1name, String v2name) {

		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(v2name)) {
			return;

		}

		vtx1.nbrs.remove(v2name);
		vtx1.nbrs.remove(v1name);

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

	public boolean hasPath(String v1name, String v2name, HashMap<String, Boolean> pro) {

		if (pro.containsKey(v1name)) {
			return false;
		}
		boolean rv = false;
		pro.put(v1name, true);

		if (containsEdge(v1name, v2name) == true) {
			return true;
		} else {
			Vertex vtx1 = vces.get(v1name);
			Set<String> nbrnames = vtx1.nbrs.keySet();

			for (String nbrname : nbrnames) {
				if (this.hasPath(nbrname, v2name, pro) == true) {
					return true;
				}

			}

		}

		return rv;

	}

	public void printPath(String v1name, String v2name, HashMap<String, Boolean> pro, String psf) {

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
			if (!pro.containsKey(nbrname)) {
				printPath(nbrname, v2name, pro, psf);
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

	public boolean bsf(String v1name, String v2name) {//level order

		HashMap<String, Boolean> pro = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		Vertex vtx1 = vces.get(v1name);
		Pair p = new Pair(v1name, vtx1, v1name);

		queue.addLast(p);

		while (!queue.isEmpty()) {
			// 1. remove

			Pair rp = queue.removeFirst();

			// 2. process if unprocessed
			if (!pro.containsKey(rp.vname)) {

				// 2.0 mark processed
				pro.put(rp.vname, true);

				// 2.1 check nbrs
				if (containsEdge(rp.vname, v2name)) {
					System.out.println(rp.psf + v2name);
					return true;
				}

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
		return false;

	}

	public void bft() {

		HashMap<String, Boolean> pro = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		Set<String> vname = this.vces.keySet();
		for (String vnames : vname) {

			if (pro.containsKey(vnames)) {
				continue;
			}

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

					System.out.println(rp.psf);

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

		}

	}

	public void dft() {

		HashMap<String, Boolean> pro = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		Set<String> vname = this.vces.keySet();
		for (String vnames : vname) {

			if (pro.containsKey(vnames)) {
				continue;
			}

			Vertex vtx1 = vces.get(vnames);
			Pair p = new Pair(vnames, vtx1, vnames);

			stack.addFirst(p);

			while (!stack.isEmpty()) {
				// 1. remove

				Pair rp = stack.removeFirst();

				// 2. process if unprocessed
				if (!pro.containsKey(rp.vname)) {

					// 2.0 mark processed
					pro.put(rp.vname, true);

					// 2.1 check nbrs

					System.out.println(rp.vname + " via " + rp.psf);

					// 2.2 put the unprocessed nbrs in

					Set<String> rpnbrnames = rp.vtx.nbrs.keySet();
					for (String rvname : rpnbrnames) {

						if (!pro.containsKey(rvname)) {
							Pair np = new Pair(rvname, this.vces.get(rvname), rp.psf + rvname);
							stack.addFirst(np);
						}

					}

				}

			}

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

	public boolean isConnected() {

		HashMap<String, Boolean> pro = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		int count = 0;
		Set<String> vname = this.vces.keySet();
		for (String vnames : vname) {

			if (pro.containsKey(vnames)) {
				continue;
			}
			count++;
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

					// System.out.println(rp.psf);

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

		}
		if (count > 1) {
			return false;
		}
		return true;

	}

	public boolean isCyclic() {
		HashMap<String, Boolean> pro = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		Set<String> vname = this.vces.keySet();
		for (String vnames : vname) {

			if (pro.containsKey(vnames)) {
				continue;
			}

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

					// System.out.println(rp.psf);

					// 2.2 put the unprocessed nbrs in

					Set<String> rpnbrnames = rp.vtx.nbrs.keySet();
					for (String rvname : rpnbrnames) {

						if (!pro.containsKey(rvname)) {
							Pair np = new Pair(rvname, this.vces.get(rvname), rp.psf + rvname);
							queue.addLast(np);
						}

					}

				} else {
					return true;
				}

			}

		}
		return false;

	}

	public boolean isTree() {
		return (!isCyclic() && isConnected());
	}

	public boolean isBipartite() {

		HashMap<String, String> pro = new HashMap<>();

		Set<String> vname = this.vces.keySet();
		for (String vnames : vname) {

			if (pro.containsKey(vnames)) {
				continue;
			}

			LinkedList<Pair> queue = new LinkedList<>();

			Vertex vtx1 = vces.get(vnames);
			Pair p = new Pair(vnames, vtx1, vnames, "r");

			queue.addLast(p);

			while (!queue.isEmpty()) {
				// 1. remove

				Pair rp = queue.removeFirst();

				// 2. process if unprocessed
				if (!pro.containsKey(rp.vname)) {

					// 2.0 mark processed
					pro.put(rp.vname, rp.colour);

					// 2.1 check nbrs

					// System.out.println(rp.psf);

					// 2.2 put the unprocessed nbrs in

					Set<String> rpnbrnames = rp.vtx.nbrs.keySet();
					for (String rvname : rpnbrnames) {
						String colorToApply = rp.colour.equals("r") ? "g" : "r";
						if (!pro.containsKey(rvname)) {
							Pair np = new Pair(rvname, this.vces.get(rvname), rp.psf + rp.vname, colorToApply);
							queue.addLast(np);
						}

					}

				} else {
					String prevcol = pro.get(rp.vname);
					String currcolor = rp.colour;

					if (!prevcol.equals(currcolor)) {
						return false;
					}
				}

			}

		}
		return true;

	}

	private class DjikstraPair implements Comparable<DjikstraPair> {
		Vertex vtx;
		String vname;
		String psf;
		int csf;

		DjikstraPair(Vertex vtx, String vname, String psf, int csf) {

			this.vtx = vtx;
			this.vname = vname;
			this.psf = psf;
			this.csf = csf;
		}

		@Override
		public int compareTo(DjikstraPair o) {
			// TODO Auto-generated method stub
			return o.csf - this.csf;
		}

		@Override
		public String toString() {

			return this.vname + " " + this.psf + " " + this.csf;
		}
	}

	public HashMap<String, DjikstraPair> Dist(String src) {
		HashMap<String, DjikstraPair> map = new HashMap<>();
		GenericHeap<DjikstraPair> heap = new GenericHeap<>(null);
		Set<String> vnames = vces.keySet();
		for (String vname : vnames) {
			Vertex vtx = vces.get(vname);
			DjikstraPair p = new DjikstraPair(vtx, vname, "", Integer.MAX_VALUE);

			if (src.equals(vname)) {
				p.psf = vname;
				p.csf = 0;
			}
			heap.add(p);
			map.put(vname, p);

		}

		while (!heap.isEmpty()) {

			DjikstraPair rp = heap.remove();
			Set<String> nbrnames = rp.vtx.nbrs.keySet();
			for (String nbrname : nbrnames) {
				DjikstraPair np = map.get(nbrname);

				int nc = rp.csf + rp.vtx.nbrs.get(nbrname);
				int oc = np.csf;

				if (nc < oc) {
					np.csf = nc;
					np.psf = rp.psf + nbrname;
					heap.updatePriority(np);

				}
			}

		}
		return map;
	}
}
