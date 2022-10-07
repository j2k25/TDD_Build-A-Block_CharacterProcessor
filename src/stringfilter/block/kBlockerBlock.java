package stringfilter.block;

public class kBlockerBlock implements Block{
  public String convertText(String text) {
    return text.replace("k","");
  }

}
