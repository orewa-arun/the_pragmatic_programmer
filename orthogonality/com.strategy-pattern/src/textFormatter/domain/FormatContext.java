package textFormatter.domain;

public class FormatContext {
    private String text;
    private String formatType;

    public FormatContext(String text, String formatType){
        this.text = text;
        this.formatType = formatType;
    }

    public String getText() {
        return text;
    }

    public String getFormatType() {
        return formatType;
    }
}
