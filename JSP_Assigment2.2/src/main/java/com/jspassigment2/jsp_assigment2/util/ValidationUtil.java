package com.jspassigment2.jsp_assigment2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    //khuôn cho link
    private static Pattern patternUrl = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", Pattern.CASE_INSENSITIVE);

    //khuôn cho email

    public static boolean checkUrl(String url){
        Matcher matcher = patternUrl.matcher(url);
        return matcher.find();
    }

}
