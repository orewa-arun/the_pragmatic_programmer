package textFormatter.domain;

import textFormatter.Interfaces.FormatStrategy;

public class FormatToLower implements FormatStrategy{

    @Override
    public String format(FormatContext ctx) throws Exception {
        if(ctx.getFormatType().equals("toLower")){
            return ctx.getText().toLowerCase();
        } else {
            throw new Exception("format type and format method doesn't match!");
        }
    }
    
}
