package textFormatter.domain;

import textFormatter.Interfaces.FormatStrategy;

public class FormatToUpper implements FormatStrategy{

    @Override
    public String format(FormatContext ctx) throws Exception {
        if(ctx.getFormatType().equals("toUpper")){
            return ctx.getText().toUpperCase();
        } else {
            throw new Exception("format type and format method doesn't match!");
        }
    }
    
}
