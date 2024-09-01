package com.shaqima.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @Description :
 * @Author : wang.yanqi
 * @Date: 2024/8/31 2:36
 */
public class DruidEncryptUtil {
    // 定义公钥和私钥
    private static String publicKey;

    private static String privateKey;

    // 静态代码块，用于生成公钥和私钥
    static {
        try {
            // 生成512位的公钥和私钥
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey:" + privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey:" + publicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    // 加密方法
    public static String encrypt(String plainText) throws Exception {
        // 使用私钥对明文进行加密
        String encrypt = ConfigTools.encrypt(privateKey, plainText);
        System.out.println("encrypt:" + encrypt);
        return encrypt;
    }

    // 解密方法
    public static String decrypt(String encryptText) throws Exception {
        // 使用公钥对密文进行解密
        String decrypt = ConfigTools.decrypt(publicKey, encryptText);
        System.out.println("decrypt:" + decrypt);
        return decrypt;
    }

    // 主方法，用于测试加密和解密方法
    public static void main(String[] args) throws Exception {
        // 加密
        String encrypt = encrypt("Wing1Q2W#E");
        System.out.println("encrypt:" + encrypt);
        // 解密
        String decrypt = decrypt(encrypt);
        System.out.println("decrypt = " + decrypt);
    }


}