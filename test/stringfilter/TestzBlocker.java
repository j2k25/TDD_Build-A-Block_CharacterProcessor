package stringfilter;

import org.junit.jupiter.api.Test;
import stringfilter.block.zBlocker;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestzBlocker {
  zBlocker zBlocker;

  @Test
  void zBlockerConversion() {
    zBlocker = new zBlocker();

    assertAll(
      () -> assertEquals("ZZ12kdf", zBlocker.convertText("ZZz12kdf")),
      () -> assertEquals("8mnZadfZ", zBlocker.convertText("8mnZadfzZ")),
      () -> assertEquals("00000", zBlocker.convertText("00000"))
    );
  }

}
