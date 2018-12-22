package July13;

public class TP {

	public static void main(String[] args) {

		int k =searchPattern("asdkalskuhdasjdgakakldkl", "asdl");
		System.out.println(k);
	}

	public static int searchPattern(String src, String pat) {

		int i = 0;
		int j = 0;

		while (i <= src.length() - pat.length()) {

			while (j < pat.length()) {
				if (src.charAt(i + j) != pat.charAt(j)) {
					break;
				}
				j++;
			}
			if (j == pat.length()) {
				return i;
			}
			i++;
		}

		return -1;

	}
}
