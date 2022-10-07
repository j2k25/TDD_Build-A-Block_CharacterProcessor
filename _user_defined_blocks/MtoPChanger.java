import stringfilter.block.Block;

public class MtoPChanger implements Block {
   public String convertText(String text) {
	  return text.replace("M","P");
   }

}
