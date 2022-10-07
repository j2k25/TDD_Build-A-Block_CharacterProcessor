package stringfilter;

import org.junit.jupiter.api.Test;
import stringfilter.block.ZBlockerBlock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestZBlockerBlock {
	ZBlockerBlock zBlockerBlock;

	@Test
	void ZBlockerConversion() {
		zBlockerBlock = new ZBlockerBlock();

		assertAll(
			() -> assertEquals("z12kdf", zBlockerBlock.convertText("ZZz12kdf")),
			() -> assertEquals("8mnadfz", zBlockerBlock.convertText("8mnZadfzZ")),
			() -> assertEquals("00000", zBlockerBlock.convertText("00000"))
		);
	}

}
