package com.iusofts.blades.job.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    public static final String UTF8 = "UTF-8";
    /**
     * Used by the hash method.
     */
    private static MessageDigest MD5_DIGEST;

    static {
        try {
            MD5_DIGEST = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            // Smack wont be able to function normally if this exception is thrown, wrap it into
            // an ISE and make the user aware of the problem.
            throw new IllegalStateException(e);
        }
    }

    public static synchronized byte[] bytes(byte[] bytes) {
        return MD5_DIGEST.digest(bytes);
    }

    public static byte[] bytes(String string) {
        return bytes(toBytes(string));
    }

    public static String hex(byte[] bytes) {
        return encodeHex(bytes(bytes));
    }

    public static String hex(String string) {
        return hex(toBytes(string));
    }

    private static byte[] toBytes(String string) {
        try {
            return string.getBytes(UTF8);
        }
        catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 encoding not supported by platform", e);
        }
    }

    private static String encodeHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_CHARS[v >>> 4];
            hexChars[j * 2 + 1] = HEX_CHARS[v & 0x0F];
        }
        return new String(hexChars);
    }
}
