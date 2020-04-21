package com.example.house.Alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
    /**
     * 应用号
     */
    public static String APP_ID = "2016102200735651";
    /**
     * 商户的私钥
     */
    public static String APP_PRIVATE_KEY = "你的私钥";
    /**
     * 编码
     */
    public static String CHARSET = "UTF-8";
    /**
     * 支付宝公钥
     */
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqjcjTm72acYdNRHIYAvRLWUhdLb0Uu1UmS/alCkfDJxO17yMW2zMZubESBQEinYqvIR3RenhtrZSjhY1ODMHe+5QjGvvsnK8PJnEq8KFYrbrsJDRvlxL94vuW1rpLbGcMeHXA/VgMWlD9ZE9v8AN8Yn/PzoAky3y6yCXiMVaqPm0Mp1E2fzF4DOM8CMHyugZ8/Ml+CCzo8SkpOQLDBmUam0t8LbkvF0gq5M0cFvg67PlgqQHCdNQJc3UW7FJYIIwDGxmY5B4+78ZcdpJGQ24WxS8GnklgNGvZSptI+gKvqj6EAi7vq9AGYpmMc7pQpfMlTreRDgmxJApkgRDj1o5iwIDAQAB";
    /**
     * 支付宝网关地址
     */
    private static String GATEWAY = "https://openapi.alipay.com/gateway.do";
    /**
     * 成功付款回调
     */
    public static String PAY_NOTIFY = "你的回调地址";
    /**
     * 支付成功回调
     */
    public static String REFUND_NOTIFY = "你的回调地址";
    /**
     * 前台通知地址
     */
    public static String RETURN_URL = "你的回调地址";
    /**
     * 参数类型
     */
    public static String PARAM_TYPE = "json";
    /**
     * 成功标识
     */
    public static final String SUCCESS_REQUEST = "TRADE_SUCCESS";
    /**
     * 交易关闭回调(当该笔订单全部退款完毕,则交易关闭)
     */
    public static final String TRADE_CLOSED = "TRADE_CLOSED";
    /**
     * 收款方账号
     */
    public static final String SELLER_ID = "1138438579@qq.com";
    /**
     * 支付宝请求客户端入口
     */
    private volatile static AlipayClient alipayClient = null;

    /**
     * 不可实例化
     */
    private AlipayConfig(){};

    /**
     * 双重锁单例
     * @return 支付宝请求客户端实例
     */
    public static AlipayClient getInstance(){
        if (alipayClient == null){
            synchronized (AlipayConfig.class){
                if (alipayClient == null){
                    alipayClient = new DefaultAlipayClient(GATEWAY,APP_ID,APP_PRIVATE_KEY,PARAM_TYPE,CHARSET,ALIPAY_PUBLIC_KEY);
                }
            }
        }
        return alipayClient;
    }

}