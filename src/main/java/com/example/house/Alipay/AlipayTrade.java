package com.example.house.Alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.example.house.Util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
//import com.alibaba.fastjson.JSON;
public class AlipayTrade {
    private Logger logger = LoggerFactory.getLogger(AlipayTrade.class);

    /**
     * web支付下单并支付(web支付在安卓中是可以直接唤醒支付宝APP的)
     * url https://doc.open.alipay.com/doc2/detail.htm?treeId=203&articleId=105463&docType=1#s1
     * @return web支付的表单
     */
    public String TradeWapPayRequest(Map<String, String> sParaTemp){
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
        alipayRequest.setNotifyUrl(AlipayConfig.PAY_NOTIFY);
        // 待请求参数数组
        sParaTemp.put("seller_id",AlipayConfig.SELLER_ID);
//        alipayRequest.setBizContent(JSON.toJSONString(sParaTemp));
        String form = "";
        try {
            form = AlipayConfig.getInstance().pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            logger.error("支付宝构造表单失败",e);
        }
        logger.debug("支付宝支付表单构造:"+form);
        return form;
    }

    /**
     * 申请退款
     * @param sParaTemp 退款参数
     * @return true成功,回调中处理
     * 备注:https://doc.open.alipay.com/docs/api.htm?spm=a219a.7629065.0.0.3RjsEZ&apiId=759&docType=4
     */
    public boolean tradeRefundRequest(Map<String, ?> sParaTemp) throws AlipayApiException {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setReturnUrl(AlipayConfig.RETURN_URL);
        request.setNotifyUrl(AlipayConfig.REFUND_NOTIFY);
        // 待请求参数数组
//        request.setBizContent(JSON.toJSONString(sParaTemp));
        AlipayTradeRefundResponse response = AlipayConfig.getInstance().execute(request);
        logger.debug("支付宝退货结果:"+response.isSuccess());
        return response.isSuccess();
    }

    /**
     * 支付宝回调验签
     * @param request 回调请求
     * @return true成功
     * 备注:验签成功后，按照支付结果异步通知中的描述(二次验签接口,貌似称为历史接口了)
     */
//    public boolean verifyNotify(HttpServletRequest request) throws AlipayApiException {
//        Map<String,String> paranMap = SignUtil.request2Map(request);
//        logger.debug("支付宝回调参数:"+paranMap.toString());
//        boolean isVerify = false;
//        if (AlipayConfig.SUCCESS_REQUEST.equals(paranMap.get("trade_status")) || AlipayConfig.TRADE_CLOSED.equals(paranMap.get("trade_status"))) {
//            isVerify = AlipaySignature.rsaCheckV1(paranMap, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET); //调用SDK验证签名
//        }
//        logger.debug("支付宝验签结果"+isVerify);
//        return isVerify;
//    }
}