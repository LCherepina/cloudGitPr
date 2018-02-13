import java.math.BigInteger;
import java.util.Scanner;

public class Evol {
	BigInteger node1, node2;
	static BigInteger son1, son2;
	static BigInteger val = new BigInteger("2");
	static BigInteger one1 = new BigInteger("1");

	public static void main(String args[]) {
		Evol ev;

		Scanner sc = new Scanner(System.in);

		System.out.println();

		int n = Integer.valueOf(sc.nextLine());
		if (n < 1 || n > 100)
			throw new IllegalArgumentException();
		BigInteger firSon = new BigInteger(sc.nextLine());
		if (firSon.compareTo(new BigInteger("0")) < 0)
			throw new IllegalArgumentException();
		BigInteger secSon = new BigInteger(sc.nextLine());
		if (secSon.compareTo(new BigInteger("0")) < 0)
			throw new IllegalArgumentException();

		ev = new Evol(n, firSon, secSon);

	}

	public Evol(int n, BigInteger leftSon, BigInteger rightSon) {

		BigInteger node1 = new BigInteger("0");
		BigInteger node2 = new BigInteger("0");
		BigInteger son1 = leftSon;
		BigInteger son2 = rightSon;

		int levelFir = log2(son1);
		int levelSec = log2(son2);
		// System.out.println(log2(son1) +" "+ log2(son2));
		if (levelFir == levelSec) {
			if (son1.equals(son2))
				System.out.println(son1);
			else
				System.out.println(equal(node1, node2, son1, son2));
		} else {

			if (son1.compareTo(son2) > 0) {
				while (levelFir != levelSec) {
					son1 = son1.divide(val);
					// System.out.println(son1);
					levelFir--;
				}
				if (son1.equals(son2))
					System.out.println(son1);
				else
					System.out.println(equal(node1, node2, son1, son2));

			} else {
				while (levelSec != levelFir) {
					son2 = son2.divide(val);
					levelSec--;
				}
				if (son1.equals(son2))
					System.out.println(son1);
				else
					System.out.println(equal(node1, node2, son1, son2));
			}
		}

	}

	public static BigInteger equal(BigInteger node1, BigInteger node2, BigInteger son1, BigInteger son2) {
		while (true) {

			node1 = son1.divide(val);
			// System.out.println("node 1 " + node1);
			node2 = son2.divide(val);
			// System.out.println("node 2 " + node2);

			if (node1.equals(one1) || node2.equals(one1))
				break;

			if (node1.equals(node2)) {
				break;

			} else {
				son1 = node1;
				son2 = node2;
			}

		}
		return node1;
	}

	public static int log2(BigInteger x) {
		return x.bitLength() - 1;
	}

}
