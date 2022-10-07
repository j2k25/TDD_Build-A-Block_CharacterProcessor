package stringfilter;

import stringfilter.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Processor {
	List<Block> blocks = new ArrayList<>();

	public void addBlock(Block block) {
		blocks.add(block);
	}

	public String process(final String text) {
		var composedBlocks = blocks.stream()
			.reduce(input -> input,
				(block1, block2) -> input -> block2.convertText(block1.convertText(input)));

		return composedBlocks.convertText(text);
	}

}
