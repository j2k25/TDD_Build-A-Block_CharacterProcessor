package stringfilter.block;

import static java.util.stream.Collectors.joining;

public class MultiplyBlock implements Block {
	public String convertText(String text) {
		return text.chars()
			.mapToObj(Character::toString)
			.map(ch -> ch + ch)
			.collect(joining(""));
	}

}
