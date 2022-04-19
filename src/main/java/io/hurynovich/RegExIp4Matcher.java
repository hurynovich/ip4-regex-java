package io.hurynovich;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExIp4Matcher implements Ip4Matcher{
    private static final RegExIp4Matcher rx1 = new RegExIp4Matcher(
            "(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\." +
            "(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\." +
            "(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\." +
            "(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])"
    );
    private static final RegExIp4Matcher rx2 = new RegExIp4Matcher(
            "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$"
    );

    private final Pattern pattern;

    private RegExIp4Matcher(String regex){
        pattern = Pattern.compile(regex);
    }

    public static RegExIp4Matcher rx1() {
        return rx1;
    }

    public static RegExIp4Matcher rx2() {
        return rx2;
    }

    @Override
    public boolean isValid(String ip4) {
        return pattern.matcher(ip4).matches();
    }


    private int toInt(String ip4) {
        Matcher m = pattern.matcher(ip4);
        if (!m.matches()) throw new IllegalArgumentException(ip4 + " is not a valid IP4 address.");

        int result = 0;
        for (int i = 1; i <= 4; i++) {
            result <<= 8;
            result = result | Integer.parseInt(m.group(i));
        }

        return result;
    }
}
