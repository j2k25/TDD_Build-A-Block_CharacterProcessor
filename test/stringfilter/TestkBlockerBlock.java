package stringfilter;

import org.junit.jupiter.api.Test;
import stringfilter.block.kBlockerBlock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestkBlockerBlock {
  kBlockerBlock kBlockerBlock;

	@Test
	void kBlockerConversion() {
  kBlockerBlock = new kBlockerBlock();

		assertAll(
			() -> assertEquals("ZZz12df", kBlockerBlock.convertText("ZZz12kdf")),
			() -> assertEquals("", kBlockerBlock.convertText("kkkkkkkk")),
			() -> assertEquals("1234134", kBlockerBlock.convertText("1234134"))
		);
	}

}
