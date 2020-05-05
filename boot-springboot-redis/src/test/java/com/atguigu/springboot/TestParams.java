package com.atguigu.springboot;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.json.JSONUtil;
import com.atguigu.springboot.domain.UserInfoDo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author sunbaojin
 * @date 2020/5/4 0:38
 */
@Slf4j
public class TestParams {

    public void testParams(Object... params) {
        log.info(params.toString());
        log.info(JSONUtil.toJsonStr(params));
        log.info(SecureUtil.md5(JSONUtil.toJsonStr(params)));
    }

    @Test
    public void testMain() {
        UserInfoDo userInfoDo = new UserInfoDo();
        userInfoDo.setUserName("张三");
        testParams("1", "2", "3",userInfoDo);
    }

    @Test
    public void testSecureUtil() throws UnsupportedEncodingException {
        String content = "test中文";

        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        // 构建
        AES aes = SecureUtil.aes(key);

        // 加密
        byte[] encrypt = aes.encrypt(content);
        // 解密
        byte[] decrypt = aes.decrypt(encrypt);

        // 加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

        log.info(encryptHex);
        log.info(decryptStr);
    }
    @Test
    public void testSecureUti2() throws UnsupportedEncodingException {
        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        log.info(key.toString());

//        String s = SecureUtil.aes("sdsadsdsadsadasdsadsadsdas".getBytes()).encryptBase64("12222");
//        log.info(s);
    }

}
