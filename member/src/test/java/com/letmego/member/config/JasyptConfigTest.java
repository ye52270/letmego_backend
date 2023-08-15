package com.letmego.member.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = JasyptConfig.class)
@Slf4j
class JasyptConfigTest {

    final BeanFactory beanFactory = new AnnotationConfigApplicationContext(JasyptConfig.class);
    final StringEncryptor stringEncryptor = beanFactory.getBean("jasyptEncryptor", StringEncryptor.class);


    @Test
    @DisplayName("암복호화테스트")
    void stringEncryptor() {

        String keyword = "admin";
        String enc = stringEncryptor.encrypt(keyword);
        String des = stringEncryptor.decrypt(enc);
        assertThat(keyword).isEqualTo(des);

        log.info("enc : " + enc);
        log.info("des : " + des);


//        String url = "jdbc:mysql://mysql.cj07fndkeuan.ap-northeast-2.rds.amazonaws.com:3306/member";
//        String username = "admin";
//        String password = "!garak2446810";
//
//        System.out.println(jasyptEncoding(url));
//        System.out.println(jasyptEncoding(username));
//        System.out.println(jasyptEncoding(password));
    }
//
//    public String jasyptEncoding(String value) {
//
//        String key = "password";
//        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
//        pbeEnc.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
//        pbeEnc.setPassword(key);
//        pbeEnc.setIvGenerator(new RandomIvGenerator());
//        return pbeEnc.encrypt(value);
//    }
}