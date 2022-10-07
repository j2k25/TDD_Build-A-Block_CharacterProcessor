package stringfilter.block;

public class zBlocker implements Block {
  public String convertText(String text) {
    return text.replace("z","");
  }

}
