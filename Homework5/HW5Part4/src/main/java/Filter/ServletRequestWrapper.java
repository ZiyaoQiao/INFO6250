package Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ServletRequestWrapper extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public ServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    public String [] getParameterValues (String parameter) {
        String [] values = super. getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values. length;
        String [] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = cleanXSS(values[i]);
        }
        return encodedValues;
    }
    public String getParameter (String parameter) {
        String value = super. getParameter(parameter);
        if (value == null) {
            return null;
        }
        return cleanXSS(value);
    }
    public String getHeader (String name) {
        String value = super. getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
    }
    private String cleanXSS (String value) {
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replace("script", "");
        return value;
    }
}
