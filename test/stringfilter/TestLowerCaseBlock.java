package stringfilter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import stringfilter.block.LowerCaseBlock;

public class TestLowerCaseBlock {
	LowerCaseBlock lowerCaseBLock;

	@Test
	void lowerCaseConversions() {
		lowerCaseBLock = new LowerCaseBlock();

		assertAll(
			() -> assertEquals("abc", lowerCaseBLock.convertText("ABC")),
			() -> assertEquals("abc", lowerCaseBLock.convertText("abc")),
			() -> assertEquals("abc", lowerCaseBLock.convertText("aBC")),
			() -> assertEquals("a1c", lowerCaseBLock.convertText("a1C")),
			() -> assertEquals("a&a", lowerCaseBLock.convertText("A&a")),
			() -> assertEquals("", lowerCaseBLock.convertText(""))
		);
	}

}
