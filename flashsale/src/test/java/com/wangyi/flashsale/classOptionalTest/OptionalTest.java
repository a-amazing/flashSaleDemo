package com.wangyi.flashsale.classOptionalTest;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author wangyi
 * @date 2020/02/05
 */
public class OptionalTest {
    @Test
    public void testPackage(){
        Object obj = new Object();
        Optional optional = Optional.ofNullable(obj);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

    }
}
