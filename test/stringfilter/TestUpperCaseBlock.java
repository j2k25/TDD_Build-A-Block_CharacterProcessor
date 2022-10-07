package stringfilter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import stringfilter.block.UpperCaseBlock;

class TestUpperCaseBlock {
	UpperCaseBlock upperCaseBlock;

	@Test
	void canary() {
		assertTrue(true);
	}

	@Test
	void upperCaseConversions() {
		upperCaseBlock = new UpperCaseBlock();

		assertAll(
			() -> assertEquals("ABC", upperCaseBlock.convertText("abc")),
			() -> assertEquals("ABC", upperCaseBlock.convertText("ABC")),
			() -> assertEquals("ABC", upperCaseBlock.convertText("aBc")),
			() -> assertEquals("A1C", upperCaseBlock.convertText("a1c")),
			() -> assertEquals("A&C", upperCaseBlock.convertText("a&c")),
			() -> assertEquals("", upperCaseBlock.convertText(""))
		);
	}

}
