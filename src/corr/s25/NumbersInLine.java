package corr.s25;

/**
 * NumbersInLine implements a special formatter for integer lists. The purpose of this
 * class is to produce a multi-lines string with a list of integers in brackets.
 * Each lines must not be shorter or equal to a length given during the
 * construction of the object.
 * 
 * @author Jacques Supcik / HEIA-FR
 * @version 1.0 / 2016-08-24
 */
public class NumbersInLine {

	private final int lineLength;

	/**
	 * Constructor with a given line length
	 * 
	 * @param lineLength
	 *            Line length
	 */
	public NumbersInLine(int lineLength) {
		if (lineLength <= 2) {
			throw new RuntimeException("LineLength must be greater than 2");
		}
		this.lineLength = lineLength;
	}

	/**
	 * Returns a multi-lines string with the formated list of integers between
	 * <b>from</b> and <b>to</b>. <b>From</b> must be smaller or equal than
	 * <b>to</b>, otherwise a RuntimeException is raised.
	 * 
	 * @param from
	 *            lower limit of the list
	 * @param to
	 *            upper limit of the list
	 * @return formated multi-lines string. The last line always ends with a
	 *         new-line.
	 */
	public String format(int from, int to) {
		if (from > to) {
			throw new RuntimeException("from must be smaller or equal than to");
		}
		String result = "";
		String line = "";
		for (int i = from; i <= to; i++) {
			String item = "[" + i + "]";
			if (line.length() + item.length() > this.lineLength) {
				result += line + "\n";
				line = item;
			} else {
				line += item;
			}
			if (line.length() > this.lineLength) {
				throw new RuntimeException("LineLength is too small for this range.");
			}
		}
		if (line.length() > 0) {
			result += line + "\n";
		}
		return result;
	}

	/**
	 * Example program
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		NumbersInLine x = new NumbersInLine(13);
		String s = x.format(7, 15);
		System.out.println(s);
	}

}
