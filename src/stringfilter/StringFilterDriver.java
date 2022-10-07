package stringfilter;

import stringfilter.block.Block;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;
import static stringfilter.BlockClassLoader.*;

public class StringFilterDriver {
	private static final int _exitSelect = 0;
	static Scanner keyboardScanner;
	static Processor processor;
	static BlockFactory blockFactory;

	public static void main(String[] args) {
		keyboardScanner = new Scanner(System.in);
		blockFactory = new BlockFactory();

		blockFactory.showAvailableBlocks();
		displayMenu();
		int menuSelect = parseInt(keyboardScanner.nextLine());

		while (menuSelect != _exitSelect) {
			switch (menuSelect) {
				case 1 -> showInstructions();
				case 2 -> runProcessor();
				default -> System.out.println("Invalid option!");
			}

			displayMenu();
			menuSelect = parseInt(keyboardScanner.nextLine());
		}

		keyboardScanner.close();
	}

	private static void runProcessor() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                        Before you run the processor");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Make sure you have these 2 files in the _processor_config/ folder under the project root directory:\n");
		System.out.println("1. sequence.txt: is where you list the blocks for the processor in the order they will be applied.");
		System.out.println("Please make sure that the block names match the available blocks and add one block per line as follow:\n");
		System.out.println("(sequence.txt demo)");
		System.out.println("MultiplyBlock");
		System.out.println("UpperCaseBlock\n");
		System.out.println("2. input.txt: this is where you write the string to be converted.");
		System.out.println("Press Enter to continue...");
		keyboardScanner.nextLine();
		startProcessor();
	}

	private static void startProcessor() {
		String config_path = "_processor_config/";
		List<String> listOfSequence = getStringsFromFile(config_path, "sequence.txt");
		List<String> listOfInput = getStringsFromFile(config_path, "input.txt");

		if (listOfSequence.size() > 0 && listOfInput.size() > 0) {
			processor = new Processor();
			addBlockSequenceToProcessor(listOfSequence);

			System.out.println("\nInput:");
			listOfInput.forEach(System.out::println);

			System.out.println("\nOutput");
			listOfInput.forEach(currentLine ->
				Arrays.stream(currentLine.split(" "))
					.forEach(text ->
						System.out.println(processor.process(text) + " ")
					)
			);
		}
	}

	private static List<String> getStringsFromFile(String filePath, String fileName) {
		Scanner fileScanner;
		List<String> scannerList = new ArrayList<>();

		try {
			fileScanner = new Scanner(new File(filePath + fileName));
			while (fileScanner.hasNextLine()) {
				scannerList.add(fileScanner.nextLine());
			}
			fileScanner.close();
		} catch (Exception e) {
			System.out.println(fileName + " does not exist");
			System.out.println("Please check in your " + filePath + " folder in the root directory");
		}

		return scannerList;
	}

	private static void addBlockSequenceToProcessor(List<String> listOfSequence) {
		System.out.println("This is the current sequence:");
		AtomicInteger sequenceIndex = new AtomicInteger(1);

		listOfSequence.forEach(blockName -> {
			try {
				Block newBlock;
				String predefinedPackageName = "stringfilter.block.";

				if (getClassesFromPackage(predefinedPackageName).contains(blockName)) {
					newBlock = blockFactory.createBlock(predefinedPackageName + blockName);
				} else {
					newBlock = blockFactory.createBlock(blockName);
				}

				processor.addBlock(newBlock);
				System.out.println(sequenceIndex.getAndIncrement() + ". " + blockName + ": applied");
			} catch (Exception e) {
				System.out.print(sequenceIndex.getAndIncrement() + ". " + blockName + ": not a valid block ");
				System.out.println("*Please see instruction from the main menu*");
			}
		});
	}

	private static void showInstructions() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                              Instructions");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("You can write your own block and add it to the processor.\n");
		System.out.println("For your block to be compatible with the program:");
		System.out.println("1. Your block MUST import our Block interface and implements it.");
		System.out.println("2. Your block needs to define ONLY one method called \"convertText\" which takes a String as an input and return the converted text as another String.");
		System.out.println("A simple block would be as follow:\n");
		System.out.println("(SimpleBlock.java demo)");
		System.out.println("import stringfilter.block.Block;\n");
		System.out.println("public class SimpleBlock implements Block {\n	   public String convertText(String text) {\n			return text;\n	   }\n	}\n");
		System.out.println("After writing your code, put the .java files in the _user_defined_blocks/ folder under the project root directory.");
		System.out.println("You need to run the \"gradle run\" again before you can start using it.");
	}

	private static void displayMenu() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1. Show instruction on writing your own block");
		System.out.println("2. Ready to run the processor");
		System.out.println("0. Exit\n");
		System.out.println("Please make a selection (1 / 2 / 0): ");
	}
}
