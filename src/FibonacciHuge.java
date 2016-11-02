import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FibonacciHuge {

	private static long getFibonacciHugeEfficient(long n, long m) {
		List<Integer> modulos = new ArrayList<>();
		modulos.add(0);
		modulos.add(1);
		int i = 0;
		while (!(i > 0 && modulos.get(i) == 0 && modulos.get(i + 1) == 1)) {
			modulos.add((int) ((modulos.get(i) % m + modulos.get(i + 1) % m) % m));
			i++;
		}
		return modulos.get((int) (n % i));

	}

	public static void main(String[] args) {
		FastScanner fs = new FastScanner(System.in);
		long n = fs.nextLong();
		long m = fs.nextLong();
		System.out.println("Ans new --> " + getFibonacciHugeEfficient(n, m));
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
