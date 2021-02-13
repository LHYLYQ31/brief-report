/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.handle;

/**
 * <B>系统名称：mobile-im</B><BR>
 * <B>模块名称：异常枚举</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 */
public enum LMWebExceptionEnum {
	// 10008：凭证失效
	// 10019 账号异常,请联系管理员
	// 10020, "登录失败,未知原因"
	// 10021, "手机号格式不正确"
	// 10023, "密码输入错误次数超过5次"
	// 10024, "验证码不正确"
	// 10025, "账号密码错误"
	// 10026, "微信授权登录失败，有账号则绑定到已有账号，没有账号请注册"
	// 10027, "手机号不存在"
	// 10030, "上传图片的流没有值"
	// 10031, "会员级别不够"
	// 10032当前约会已结束
	// 10033 无法报名自己发布的约会
	// 10034 取消报名约会
	BUSINESS_ERROR(10001, 10001, "网络繁忙，请稍后再试"), //
	PARAM_EMPTY(10000, 10002, "参数为空"), //
	WRONGFUL_ERROR(10000, 10003, "参数不合法"), //
	DB_EMPTY(10000, 10004, "数据库中的字段值为空"), //
	JSON_FORM_ERROR(10000, 10005, "json数据格式不符合标准"), //
	FILE_NO_EXIST(10000, 10006, "文件不存在"), //
	AUTHORIZED_ERROR(10000, 10007, "您没有权限，请联系您的管家"), //
	LOGIN_NO_EFFECTIVE_ERROR(10000, 10008, "登录失效"), //
	UNKNOWN_ERROR(10000, 10010, "未知错误"), //
	USERCODE_ERROR(10000, 10019, "账号异常,请联系你的专属客服"), //
	LOGIN_ERROR(10000, 10020, "登录失败"), //
	PHONE_FORM_ERROR(10000, 10021, "手机号格式不正确"), //
	PASSWORD_MORE_FIVE_ERROR(10000, 10023, "密码输入错误次数超过5次, 请使用验证码登录"), //
	CODE_ERROR(10000, 10024, "验证码不正确"), //
	PASSWORD_AND_USERNAME_ERROR(10000, 10025, "账号或密码错误"), //
	PHONE_EXISTENCE_ERROR(10000, 10029, "手机号已经存在"), //
	LEVEL_ERROR(10000, 10031, "当前级别不够，无法报名，请联系客服管家约ta"), //
	DATING_END_ERROR(10000, 10032, "当前约会已结束"), //
	ENROLL_SELF_DATING_ERROR(10000, 10033, "无法报名自己发布的约会"), //
	CANSEL_DATING_ERROR(10000, 10034, " 取消报名约会 失败"), //
	DATING_SAME_SEX_ERROR(10000, 10035, "无法报名同性别约会"), //
	IOS_LOGIN_ERROR(10000, 10061, "ios授权登录失败"), //
	FLASHMOBILE_ERROR(10000, 10060, "一键登录失败"), //
	ACTIVITY_DELETE_ERROR(10000, 10101, "回复的动态或评论已经被删除或审核未过"), //
	SHARE_DATA_ERROR(10000, 10102, "分享数据不存在，请核对清楚"), //
	CHAT_PARAM_ERROR(10000, 10103, "请求核对添加好友参数"), //
	CHAT_EQUALS_ERROR(10000, 10104, "不能对自己操作"), //
	ACTIVITY_NO_EXISTENCE_ERROR(10000, 10105, "该动态已被删除"), //
	CHATTOKEN_RESET_ERROR(10000, 10106, "融云重置失败"), //
	PARAM_TOO_LONG_ERROR(10000, 10107, "参数太长"), //
	CHAT_ADD_FRIEND_ERROR(10000, 10108, "该用户在您的黑名单中"), //
	OSS_STS_ERROR(10000, 10109, "获取 OSS 签名授权失败！"), //
	PRODUCT_NO_EXIST_ERROR(10000, 10120, "产品不存在！"), //
	ORDER_NO_EXIST_ERROR(10000, 10121, "订单不存在！"), //
	RECEIPT_NO_EXIST_ERROR(10000, 10122, "票据无效"), //
	REPEAT_CREATE_ORDER_ERROR(10000, 10123, "该订单已经创建完成,不能重复创建"), //
	CREATE_ORDER_ERROR(10000, 10124, "该订单创建失败"), //
	ADD_FRIEND_NUM_TOO_MORE_ERROR(10000, 10125, "今日私信次数XX次已用完，明天再来试试吧！"), //
	BUNDLEID_NO_SAME_ERROR(10000, 10126, "bundleID不一样，请核对"), //
	PRODUCTID_NO_SAME_ERROR(10000, 10127, "产品id不一样，请核对"), //
	TRANSACTIONID_NO_EXIST_ERROR(10000, 10128, "交易id存在，请核对"), //
	HASHTAG_NO_EXIST_ERROR(10000, 10129, "交易id存在，请核对"), //
	USER_NO_EXIST_ERROR(10000, 10130, "用户不存，请核对"), //
	NO_FOLLOW_OWN_ERROR(10000, 10131, "不能关注自己"), //
	DATING_GPS_ERROR(10000, 10132, "约会定位失败，请手动选择地区"), //
	CHECK_ERROR(10000, 10133, "内容有违规"), //
	DATING_NO_EXISTENCE_ERROR(10000, 10134, "内容不存在"), //
	CANDY_ERROR(10000, 10135, "余额不足，无法消费"), //
	GIFT_NO_EXIST_ERROR(10000, 10136, "礼物不存在"), //
	GIFT_RECEIVEDID_NO_EXIST_ERROR(10000, 10137, "礼物接收人不存在"), //
	EXCHANGERULE_NO_EXIST_ERROR(10000, 10138, "兑换规则不存在"), //
	GIFT_RECEIVEDID_ERROR(10000, 10139, "礼物接收人不对"), //
	GIFT_NO_EFFECTIVE_ERROR(10000, 10140, "礼物失效"), //
	GIFT_RECEIVED_ERROR(10000, 10141, "该礼物您已经"), //
	GIFT_RECEIVED_OBJECT_ERROR(10000, 10142, "消费的对象不存在"), //
	RECOMMED_USED_ERROR(10000, 10142, "推送已使用完了"), //
	HEAD_IMAGE_CONTRABAND_ERROR(10000, 10143, "上传照片违禁，请上传正确的照片，多次违规将被系统冻结账户"), //
	POWER_ERROR(10000, 10144, "权限异常请联系管家"), //
	ORDER_TRADE_TYPE_ERROR(10000, 10145, "该订单支付方式不对"), //
	CHECKCONTENT_ERROR(10000, 20001, "审核不通过"), //
	HEAD_AUTHENTICATION_ERROR(10000, 20002, "未检测到你本人，请确保自拍照片面部清晰"), //
	GESTURE_AUTHENTICATION_ERROR(10000, 20002, "未检测到符合示例的手势，请核对照片重新上传");
	private Integer code;
	private Integer status;
	private String msg;

	/**
	 * <B>构造方法</B><BR>
	 * 
	 * @param code
	 * @param msg
	 */
	private LMWebExceptionEnum(Integer code, Integer status, String msg) {
		this.code = code;
		this.msg = msg;
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getStatus() {
		return status;
	}

}
