package stringfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringfilter.block.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestProcessor {
	Processor processor;
	BlockFactory blockFactory;

	@BeforeEach
	void setup() {
		processor = new Processor();
		blockFactory = new BlockFactory();
	}

	@Test
	void processorWithNoBlock() {
		String phrase = "Hello";
		String expected = "Hello";

		assertEquals(expected, processor.process(phrase));
	}

	@Test
	void processorWithUppercaseBlock() {
		processor.addBlock(new UpperCaseBlock());
		String phrase = "Hello";
		String expected = "HELLO";

		assertEquals(expected, processor.process(phrase));
	}

	@Test
	void processorWithLowercaseBlock() {
		processor.addBlock(new LowerCaseBlock());
		String phrase = "Hello";
		String expected = "hello";

		assertEquals(expected, processor.process(phrase));
	}

	@Test
	void processorWithTwoBlock() {
		processor.addBlock(new UpperCaseBlock());
		processor.addBlock(new MultiplyBlock());
		String phrase = "Hello";
		String expected = "HHEELLLLOO";

		assertEquals(expected, processor.process(phrase));
	}

	@Test
	void processorWithThreeBlock() {
		processor.addBlock(new kBlockerBlock());
		processor.addBlock(new UpperCaseBlock());
		processor.addBlock(new MultiplyBlock());
		String phrase = "kello";
		String expected = "EELLLLOO";

		assertEquals(expected, processor.process(phrase));
	}

}
