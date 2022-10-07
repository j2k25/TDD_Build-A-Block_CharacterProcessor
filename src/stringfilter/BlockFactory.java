package stringfilter;

import stringfilter.block.Block;

import static stringfilter.BlockClassLoader.getClassesFromPackage;

public class BlockFactory {
	public void showAvailableBlocks() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                              Available Blocks");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Predefined blocks:");
		getClassesFromPackage("stringfilter.block.").forEach(System.out::println);
		System.out.println();
		System.out.println("User-defined blocks:");
		getClassesFromPackage("").forEach(System.out::println);
		System.out.println();
	}

	public Block createBlock(String blockName) throws Exception {
		return (Block) Class.forName(blockName)
			.getDeclaredConstructor()
			.newInstance();
	}
}
