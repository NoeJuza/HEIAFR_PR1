package corr.s25;

/**
 * BasedNumber implements a class for handling numbers in different bases.
 * 
 * @author Jacques Supcik / HEIA-FR
 * @version 1.0 / 2016-08-24
 */
public class BasedNumber {

	protected long number;

	private static int digitToInt(char c) {
		if (c >= '0' && c <= '9') {
			return c - '0';
		} else if (c >= 'a' && c <= 'z') {
			return c - 'a' + 10;
		} else if (c >= 'A' && c <= 'Z') {
			return c - 'A' + 10;
		} else {
			throw new RuntimeException("Invalid character in number");
		}
	}

	private static char intToDigit(long x) {
		if (x < 10) {
			return (char) ('0' + x);
		} else {
			return (char) ('A' + x - 10);
		}
	}

	/**
	 * Constructor for a number given as a string in base <b>base</b>
	 * 
	 * @param s
	 *            the number as string
	 * @param base
	 *            the base
	 */
	public BasedNumber(String s, int base) {
		if (base < 2 || base > 36) {
			throw new RuntimeException("base must be between 2 and 36");
		}
		long result = 0;
		for (char c : s.toCharArray()) {
			int digit = digitToInt(c);
			if (digit >= base) {
				throw new RuntimeException("Invalid digit");
			}
			result = result * base + digit;
		}
		this.number = result;
	}

	/**
	 * asLong returns the number as a long value.
	 * 
	 * @return the number
	 */
	public long asLong() {
		return this.number;
	}

	/**
	 * inBase returns a representation of the number in base <b>base</b>
	 * 
	 * @param base
	 *            the base used for the conversion
	 * @return the result as a string
	 */
	public String inBase(int base) {
		if (base < 2 || base > 36) {
			throw new RuntimeException("base must be between 2 and 36");
		}
		if (this.number == 0)
			return "0";
		long n = this.number;
		String result = "";
		while (n > 0) {
			result = intToDigit(n % base) + result;
			n = n / base;
		}
		return result;
	}
}