package com.peterdang.domain.utils;

/**
 * Created by phuoc on 2017-10-23.
 */

public class ValidateUtils {
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
