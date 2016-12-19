package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";

        System.out.println("5.11");
        String hex = Hex.encodeHexString(input.getBytes());
        System.out.println(hex);

        System.out.println("5.12");
        System.out.println(new String(Hex.decodeHex(hex.toCharArray())));

        System.out.println("5.13");
        System.out.println("a");
        System.out.println(Base64.encodeBase64String(input.getBytes()));

        System.out.println("b");
        String hexInput = "010203040506";
        System.out.println(new String(Base64.encodeBase64(Hex.decodeHex(hexInput.toCharArray()))));

        System.out.println("c");
        String base64Input = Base64.encodeBase64String("Software Systems".getBytes());
        System.out.print(base64Input);
        System.out.print(" --> ");
        System.out.println(new String(Base64.decodeBase64(base64Input)));

        System.out.println("d");
        char charInput = 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            sb.append(charInput);
            System.out.println(Base64.encodeBase64String(sb.toString().getBytes()));
        }
    }
}
