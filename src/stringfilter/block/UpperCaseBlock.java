package stringfilter.block;

public class UpperCaseBlock implements Block {
	public String convertText(String text) {
		return text.toUpperCase();
	}

}
