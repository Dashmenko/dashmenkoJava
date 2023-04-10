public class MD5Calculator {
	public static void main(String arguments[]) {
		for(String argument : arguments) {
			System.out.println("\"" + argument + "\" => " + HashCode.md5(argument));
		}
	}
}
