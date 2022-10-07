# TDD_Build-A-Block_CharacterProcessor
Test Driven Development using Design Principles and Patterns #3


In this assignment we will design a logical characters processor. The processor will receive a series of characters as input and produce
a series of characters as output. The processor may house any number of processing blocks. Not all blocks that are available may be used
when creating a processor. Also, a block may be used more than once. The order in which the blocks are used may also vary.
                                                            

		...input... -> | block1 block2 block3 ... | -> ...output...
                           Processor

Let's discuss some examples of blocks and then revisit the processor.

1. UpperCaseConverter Block
	Given a character, this block will send out or return the character in uppercase.

2. LowerCaseConverter Block
	Given a character, this block will send out or return the character in lowercase.
	
3. Multiplier Block
  Given a character, this block will send out or return two of the same character. For example, if it received 'a', it will produce 'aa'.
  If it receives '1', it will produce '11'.

4. z-blocker Block
  Given a character, if the character is a lowercase 'z', this block will not return or produce anything. If it is any other character,
  it will produce the given character as output. For example, 'a' will result in an output of 'a'.

5. Z-blocker Block
	This block will not return or produce an output if the character given is an uppercase 'Z'.
	
6. k-blocker Block
   This block will not return or produce an output if the character given is lowercase 'k'.

The program should allow end users to create other similar blocks they like.

The end user should be able to create a processor using any series of blocks.

For example, a user may create a processor with the following series of blocks:
	UpperCaseConverter - Z-blocker - LowerCaseConverter
	
After creating this processor, if a user were to send the following series of characters as input:

	11abcdabcdabcdzzaazzabcd

it will return the following output:

	11abcdabcdabcdaaabcd

In addition to designing a few sample blocks and the processor, we will create a console based driver program.
	
Design the program in such a way that:

1. A user can specify the blocks available for use before the program starts. This should include pre-defined blocks and user created blocks.

2. The user can specify, through a file, the blocks they'd like to use and the order or sequence in which they'd like to use them.

Think through the overall design of the program first. Then start with one small, but interesting and valuable part, and evolve the 
design and code incrementally.

After completing the assignment answer these questions:

1. What did you learn in this assignment?

In the beginning, it seemed like another path exploring the intended functionality of OOP features. We were excited to continue our 
practices in TDD and writing minimum code following the YAGNI principle. However, it quickly became clear this assignment was a test of 
adhering to design principles. From the videos, we learned about the principles and the metrics available that observe them. In the 
coding, we had many painful examples of how easy it is to fail the principles while planning for pure functionality. 

As we progressed in the block creations, even though we could see our future implementation, it helped to be forced to move incrementally
so we could learn what to look before extracting a base class from similar classes. This will be helpful when reviewing future code for
refactoring potential. 

A surprising and rewarding challenge for us was learning about loading classes in runtime and dynamically creating new objects. This 
helps us unlock the secret gate to implementing polymorphism in programming. These functionalities are helpful when trying to follow
design principles.

Later, we began to realize some design patterns that prevent us from violation design principles. In the end, we began to discover the 
appropriate balance between providing proper extensibility and functionality.     


2. What design principles did you use? List each one of them, discuss what this principle is, and give example(s) of where specifically 
you used it in this assignment.

Although the LSP (Liskov Substitution Principle) usually focuses on inheritance and revolves around making sure extended classes 
functionality honors the contract of the base class functionality, we were able to use it while implementing our interface that allows
its implemented classes to use the convertText() functionality. 

SRP (Single-Responsibility Principle) was a frequent visitor for us. Making sure every file was responsible for a single purpose was 
somewhat against our coding nature. At first, the concept of expanding classes and code seemed counterproductive. However, once we 
realized it sets us up properly to be able to follow the OCP (Open-Closed Principle), its importance became clear.  At first, we 
struggled to visualize the intended functionality of our Processor. The more extensible our program became, the more Processor our was
abused. Eventually SRP and OCP led us to using the BlockFactory and ClassLoader to keep our Processor pure by having it to serve a 
single purpose while still allowing the program to be extensible through adding new blocks.


3. What design patterns did you use? List each one of them, discuss what this pattern is, and give example(s) of where specifically you
used it in this assignment.

STRUCTURAL PATTERN
a. Adapter pattern: a design pattern that lets interface of the existing class to be use as an interface for other classes. For example,
we defined an interface for all the predefined blocks. The user-defined blocks can be added to the processor when and only when they 
implement the existing Block. By providing this interface, we are making a contract to make sure that user-defined blocks will be
compatible with our program. This is a great practical practice of OCP and LSP.

b. Composite pattern: is a design pattern where a group of objects is being treated as one with the same type. When we define the
Processor::process method, we compose a list of Block objects into one super Block and uses its convertText method to process the string
to be converted.

CREATIONAL PATTERN
c. Abstract Factory pattern: a design pattern that delegates and encapsulates the responsibility of creating objects to another class. 
It provides an interface of creating objects without the need of declaring new initiation. In this project, we made a class called
BlockFactory that creates a new Block object based on the type of the block being provided. Based on the user’s input, the 
StringFilterDriver program will need to add new blocks to the processor. But that responsibility will be shifted to the BlockFactory.
By doing this, we are practicing the SRP when we only let the driver program take care of the IO instead of the logic behind.

BEHAVIOR PATTERN
d. Template method pattern: is a design pattern where a method of the super class define the skeleton of the subclasses. By making the
convertText() method abstract, different blocks that implement the Block interface can overide the behavior of convertText(). For example
the convertText() of UpperCaseBlock make the input string uppercased wheras the convertText() of k-BlockerBlock removes all the “k”s from
the input string.


Total [100]: 99
Program run and produces desires results [10]:
Program is design for extensibility to add new blocks [20]:
Test pass [10]:
Test quality [10]:
Code coverage [10]:
Design quality [20]:
Code quality [10]:
Response to questions [10]: -1
2. Need to break details into smaller paragraphs and include more principles.
