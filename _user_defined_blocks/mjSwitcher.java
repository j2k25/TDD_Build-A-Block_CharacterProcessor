import stringfilter.block.Block;

public class mjSwitcher implements Block {
   public String convertText(String text) {
      return text.replace("m","j");
   }

}
