package tri.pura.ashura.mathbantai;

public class Soal {
	private int level, ongko1, ongko2, pilA, pilB, pilC, pilD, jawab;
	private Operasi mode;

	public Soal(int level) {
		super();
		this.level = level;
		ichiban();
	}

	public boolean benar(int i) {
		return jawab == i;
	}

	public int getPilA() {
		return pilA;
	}

	public int getPilB() {
		return pilB;
	}

	public int getPilC() {
		return pilC;
	}

	public int getPilD() {
		return pilD;
	}

	@Override
	public String toString() {
		String s = "" + ongko1;
		switch (mode) {
		case TAMBAH:
			s += " +";
			break;
		case KURANG:
			s += " -";
			break;
		case KALI:
			s += " *";
			break;
		case BAGI:
			s += " /";
			break;
		} return s;
	}

	private void ichiban() {
		genOp();
		genSoal();
		genPil();
	}

	private void genPil() {
		if (jawab == 1) {
			pilA = jawabe();
			pilB = genSalah();
			pilC = genSalah();
			pilD = genSalah();
		} else if (jawab == 2) {
			pilA = genSalah();
			pilB = jawabe();
			pilC = genSalah();
			pilD = genSalah();
		} else if (jawab == 3) {
			pilA = genSalah();
			pilB = genSalah();
			pilC = jawabe();
			pilD = genSalah();
		} else if (jawab == 4) {
			pilA = genSalah();
			pilB = genSalah();
			pilC = genSalah();
			pilD = jawabe();
		}
	}

	private int genSalah() {
		int j = jawabe(), min = j - 5, max = j + 5, h = acak(min, max);
		while (j == h)
			h = acak(min, max);
		return h;
	}

	private int jawabe() {
		int i = 0;
		switch (mode) {
		case TAMBAH:
			i = ongko1 + ongko2;
			break;
		case KURANG:
			i = ongko1 - ongko2;
			break;
		case KALI:
			i = ongko1 * ongko2;
			break;
		case BAGI:
			i = ongko1 / ongko2;
			break;
		} return i;
	}

	private void genSoal() {
		int min = level - 1 * 5, max = level * 5;
		if (min == 0) min += 1;
		ongko1 = acak(min, max);
		ongko2 = acak(min, max);
		jawab = acak(1, 4);
	}

	private void genOp() {
		int op = acak(1, 4);
		if (op == 1) mode = Operasi.TAMBAH;
		else if (op == 2) mode = Operasi.KURANG;
		else if (op == 3) mode = Operasi.KALI;
		else if (op == 4) mode = Operasi.BAGI;
	}

	private int acak(int min, int max) {
		java.util.Random r = new java.util.Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public enum Operasi {
		TAMBAH, KURANG, KALI, BAGI
	}
}
