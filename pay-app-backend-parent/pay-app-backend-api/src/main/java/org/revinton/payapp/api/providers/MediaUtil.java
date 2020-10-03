package org.revinton.payapp.api.providers;

import javax.ws.rs.core.MediaType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MediaUtil {

    public static Charset getCharset(MediaType mediaType) {
        String charset = getCharsetParameter(mediaType);
        return charset != null ? Charset.forName(charset) : StandardCharsets.UTF_8;
    }

    private static String getCharsetParameter(MediaType mediaType) {
        if (mediaType == null) {
            return null;
        }
        Map<String, String> mediaTypeParameters = mediaType.getParameters();
        return mediaTypeParameters.get(MediaType.CHARSET_PARAMETER);
    }
}
