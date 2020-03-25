package com.monsoon.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public Producer kaptchaProducer(){
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "100"); //单位默认是px
        properties.setProperty("kaptcha.image.height", "40");
        properties.setProperty("kaptcha.textproducer.font.size", "32"); // 字号
        properties.setProperty("kaptcha.textproducer.font.color", "0,0,0"); // 直接英文black也行
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"); // 从这里面生成
        properties.setProperty("kaptcha.textproducer.char.length", "4"); // 长度限定
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise"); // 用哪一个干扰器

        DefaultKaptcha kaptcha = new DefaultKaptcha();

        // config的设置要依赖Properties对象
        Config config = new Config(properties);

        // 把配置导入到kaptcha里
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
