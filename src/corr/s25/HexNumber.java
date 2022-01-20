package corr.s25;

/**
 * HexNumber is a specialization of BaseNumber where base is 16.
 * This class extends BaseNumber (inheritance).
 * 
 * @author Jacques Supcik / HEIA-FR
 * @version 1.0 / 2016-08-24
 */
public class HexNumber extends BasedNumber {

	/**
	 * Constructor for a number given as a string in base 16
	 * 
	 * @param s
	 *            the number as hexadecimal string
	 */
	public HexNumber(String s) {
		super(s, 16);
	}

	/**
	 * add adds the hexadecimal number <b>n</b> to the number
	 * 
	 * @param n
	 *            the number to add
	 */
	public void add(HexNumber n) {
		this.number += n.number;
	}

	/**
	 * substract substracts the hexadecimal number <b>n</b> from the number
	 * 
	 * @param n
	 *            the number to substract
	 */
	public void subtract(HexNumber n) {
		this.number -= n.number;
	}

	/**
	 * multiply multiplies the hexadecimal number <b>n</b> with the number
	 * 
	 * @param n
	 *            the number to multiply with
	 */
	public void multiply(HexNumber n) {
		this.number *= n.number;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.inBase(16);
	}

	/**
	 * Example program
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		HexNumber a = new HexNumber("1F4B");
		a.add(new HexNumber("A8C7"));
		System.out.println(a);
	}

}
