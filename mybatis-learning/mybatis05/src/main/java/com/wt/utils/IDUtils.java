package com.wt.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class IDUtils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.print(getID());
    }

}
