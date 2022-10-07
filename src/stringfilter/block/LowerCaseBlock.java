package stringfilter.block;

public class LowerCaseBlock implements Block {
	public String convertText(String text) {
		return text.toLowerCase();
	}

}
