package textFormatter.Interfaces;

import textFormatter.domain.FormatContext;

public interface FormatStrategy {
    public String format(FormatContext ctx) throws Exception;
}
