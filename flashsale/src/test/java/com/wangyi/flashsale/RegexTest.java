package com.wangyi.flashsale;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:wangyi
 * @Date:2019/12/11
 */
public class RegexTest {

    @Test
    public void test(){
        Pattern pattern = Pattern.compile("/v[1-9][\\d]*");
        String urlDemo = "/api/v1/shop";
        Matcher matcher = pattern.matcher(urlDemo);
        if(matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
