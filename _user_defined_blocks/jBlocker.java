import stringfilter.block.Block;

public class jBlocker implements Block {
   public String convertText(String text) {
      return text.replace("j","");
   }

}
