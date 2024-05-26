package com.laziobird.ai.recomand.util;

import static java.lang.System.out;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 10:12 PM
 */
public class PromptUtil {

    //调整余弦相似度推荐算法
    private static final String TEMPLATE_COSINE_SIMILARITY = "基于 Adjusted Cosine Similarity 推荐算法，我喜欢一本书 ，书名 %s ，帮我推荐其它几本书 ";
    public static  String getByBookCosineSimilarity(String bookName){
        return String.format(TEMPLATE_COSINE_SIMILARITY, bookName);
    };

    //协同过滤算法，基于相识用户内容推荐
    private static final String TEMPLATE_C_FILTERING = " 假设用户分别看了如下表格所示的电影，并且给电影有如下评分（5分最高，没看过的值空） \n " +
            " %s" +
            " \n 只能用协同过滤推荐算法，给每个用户推荐一部没看过的电影";

    public static  String getByMovieCollaborativeFiltering(String movieName){
        return String.format(TEMPLATE_C_FILTERING, movieName);
    };

    //协同过滤算法，基于相识用户内容推荐
    private static final String TEMPLATE_C_FILTERING_ORDER = " 假设用户购买了如下表格所示的商品，(数值表示购买的次数，没买过的值为空) \n " +
            " %s" +
            " \n 只能用协同过滤推荐算法，给每个用户推荐一个没买过的商品,结果输出到标签<rules>中";

    public static  String getByOrderCollaborativeFiltering(String orderName){
        return String.format(TEMPLATE_C_FILTERING_ORDER, orderName);
    };


    //关联规则推荐算法（Association Rules），基于历史订单数据挖掘
    private static final String TEMPLATE_A_RULE_ORDER = " 用户购买了如下表格所示的商品 \n " +
            " %s" +
            " \n 用关联规则算法，找出提升度>1 的关联推荐规则，结果输出到标签<rules>中";

    public static  String getByOrderAssociationRules(String orderName){
        return String.format(TEMPLATE_A_RULE_ORDER, orderName);
    };


    //Gemini 图片识别能力
    //private static final String TEMPLATE_IMAGE_TEXT = " 这是酒店价格列表图片，提取酒店相关价格信息，返回json格式 " ;
    private static final String TEMPLATE_IMAGE_TEXT = " 这是酒店价格图片，提取酒店相关信息，返回json格式 " ;
    public static  String getByChatImage(){
        return TEMPLATE_IMAGE_TEXT;
    };

    private static final String TEMPLATE_AIRBNB_IMAGE_TEXT = " 提取图片中酒店相关信息，包含每晚价格(字段名price)、入住日期(字段名checkIn，格式YYYY-MM-DD)" +
            "、退房日期(字段名，格式YYYY-MM-DD)、" +
            "入住人数(字段名personNum)、税费(字段名taxPrice)、总价(字段名totalPrice)，评分(字段名hotelScore,必须是数值)，点评数(hotelDianpin，必须是数值) 包含酒店房间ID(字段名roomId)一起，只返回 json 字符串 " ;
    public static  String getByAirbnbChatImage(String hotelId){
        return " 酒店房间的ID：" + hotelId + TEMPLATE_AIRBNB_IMAGE_TEXT;
    };

    private static final String TEMPLATE_CTRIP_IMAGE_TEXT = " 图片是携程订酒店的房间列表页面，文字包含简体中文。提取字段：" +
            "字段名orderInfo(有'领券订'，并且'在线付'下方有文字，提取文字信息。有'售完'，返回'sell'), "+
            "包含价格(字段名price，纯数字。如果orderInfo字段是'sell'，值为0)、入住日期(字段名checkIn，格式YYYY-MM-DD)、退房日期(字段名，格式YYYY-MM-DD)、" +
            "房间名称(最后一个字是'房'结尾的文本,字段名roomName)， 房间描述('查看客房信息'文本上方的文字,包含'm²'，字段名roomInfo) " +
            " 格式JSON " ;
    public static  String getByCtripChatImage(String hotelId){
        return TEMPLATE_CTRIP_IMAGE_TEXT;
    };


    public static void main(String[] args) {
        out.print(TEMPLATE_CTRIP_IMAGE_TEXT);
    }


}
