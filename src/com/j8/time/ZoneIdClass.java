package com.j8.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdClass {
    public static void main(String[] args) {
        ZoneId zone= ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId zI = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zt = ZonedDateTime.now(zI);
        System.out.println(zt);
    }
}
