package stringfilter;

import org.junit.jupiter.api.Test;
import stringfilter.block.MultiplyBlock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMultiplyBlock {

	@Test
	void multiPlyBy2Conversion() {
		MultiplyBlock x2Block = new MultiplyBlock();

		assertAll(
			() -> assertEquals("aa", x2Block.convertText("a")),
			() -> assertEquals("BB11cc", x2Block.convertText("B1c")),
			() -> assertEquals("112233", x2Block.convertText("123")),
			() -> assertEquals("", x2Block.convertText(""))
		);
	}

}
