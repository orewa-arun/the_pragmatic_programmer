package textFormatter.domain;

import textFormatter.Interfaces.FormatStrategy;

public class FormatFirstCharacterToUpper implements FormatStrategy{

    @Override
    public String format(FormatContext ctx) throws Exception {
        if(ctx.getFormatType().equals("firstCharacterToUpper")){
            return convertFirstCharacterToUpper(ctx.getText());
        } else {
            throw new Exception("format type and format method doesn't match!");
        }
    }
            
    private String convertFirstCharacterToUpper(String text) {
        return  text.substring(0, 1).toUpperCase() + text.substring(1, text.length()); 
    }
    
}
