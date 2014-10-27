package search;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class StringUtils {

   static CharsetEncoder asciiEncoder = 
      Charset.forName("US-ASCII").newEncoder(); 
   public static boolean isPureAscii(String v) {
    return asciiEncoder.canEncode(v);
  }
}

