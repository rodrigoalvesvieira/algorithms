package math;

/**
 * Bits / Lógica para Computação
 * @author Leo Schettini (ljsa) / Rodrigo Alves (rav2)
 *
 * Defina o conjunto base e o conjunto de funções geradoras para o seguinte conjunto: Todas as
 * sequências binárias pares cujos bits em posiçõs opostas são diferentes (e.g. "00101011" pertence
 * a esse conjunto, pois o primeiro e o último bit são diferentes, assim como o segundo e o penúltimo, etc.).
 *
 */
public class Bits {
	private String value;

	public Bits(String value) {
		this.value = value;
	}

	/**
	 * Returns the size of the bit sequence
	 * @return the size of the bit sequence
	 */
	public int size() {
		return this.value.length();
	}

	/**
	 * Returns the char in the sequence in the given key (position)
	 * @param j, the key (position) integer
	 * @return the char at the given position (j)
	 */
	public char charAt(int j) {
		return this.value.charAt(j);
	}

	/**
	 * Concatenates "1" to the beginning and "0" to the ending of the given Bits object
	 * @return {@link Bits} a new Bits object with the newly concatenated string
	 */
	public Bits g() {
		return new Bits("1" + this.value + "0");
	}

	/**
	 * Concatenates "0" to the beginning and "1" to the ending of the given Bits object
	 * @return {@link Bits} a new Bits object with the newly concatenated string
	 */
	public Bits f() {
		return new Bits("0" + this.value + "1");
	}

	/**
	 * Returns the string representation of the Bits object, that is, its value
	 * @return a {@link String} the value of the Bits object
	 */
	public String toString() {
		return this.value;
	}

	/**
	 * Determines whether the Bits object (bit sequence) is valid or not.
	 * @return Returns true if the bits sequence is valid. Returns false otherwise.
	 */
	public boolean isValid() {
		for (int i = 0, j = this.size() - 1; i < j; i++, j--) {
			if (this.charAt(i) == this.charAt(j)) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Bits base = new Bits("");

		Bits a = new Bits("0101010001100110101");
		Bits b = base.g().f().g().f();
		Bits c = new Bits("001010101011");

		System.out.println(a);
		System.out.println(a.isValid());

		System.out.println(b);
		System.out.println(b.isValid());

		System.out.println(c);
		System.out.println(c.isValid());
	}
}