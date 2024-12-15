import textFormatter.domain.FormatContext;
import textFormatter.domain.FormatFirstCharacterToUpper;
import textFormatter.domain.FormatProcessor;

public class TextFormatterMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Text Formatter");
        FormatProcessor formatProcessor = new FormatProcessor();

        String text = "the pragmatic programmer";
        String formatType = "firstCharacterToUpper";

        System.out.println("text to be formatted : " + text);
        System.out.println("format type chosen : " + formatType);

        formatProcessor.setFormatStrategy(new FormatFirstCharacterToUpper());
        System.out.println("Text after formatting : " + formatProcessor.format(new FormatContext(text, formatType)));
    }
}
