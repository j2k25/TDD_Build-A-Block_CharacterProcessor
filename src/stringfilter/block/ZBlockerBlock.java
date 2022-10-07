package stringfilter.block;

public class ZBlockerBlock implements Block{
  public String convertText(String text) {
    return text.replace("Z","");
  }

}
