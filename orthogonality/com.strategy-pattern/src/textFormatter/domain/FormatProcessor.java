package textFormatter.domain;

import textFormatter.Interfaces.FormatStrategy;

public class FormatProcessor {
    private FormatStrategy formatStrategy;

    public void setFormatStrategy(FormatStrategy formatStrategy){
        this.formatStrategy = formatStrategy;
    }

    public String format(FormatContext formatContext) throws Exception{
        return formatStrategy.format(formatContext);
    }
    
}
