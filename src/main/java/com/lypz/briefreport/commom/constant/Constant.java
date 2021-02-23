package com.lypz.briefreport.commom.constant;

/**
 * <B>系统名称：</B>简报系统<BR>
 * <B>模块名称：</B>简报管理模块<BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 *
 * @author 余灏
 * @since 2021-02-15
 */
public class Constant {

	/**
	 * 报送管理状态------未上报
	 */
	public static final Integer NOT_REPORTED = 2;

	/**
	 * 报送管理状态------已上报
	 */
	public static final Integer REPORTED = 1;

	/**
	 * 报送管理状态------退回/暂存
	 */
	public static final Integer RETURN = 3;

	/**
	 * 报送管理删除状态------未删除
	 */
	public static final Integer NOT_DELETED = 1;

	/**
	 * 报送管理删除状态------已删除
	 */
	public static final Integer DELETED = 0;
	/**
	 * 区标题
	 */
	public static final String AREA_EXCEL_TITLE = "xxx年采用信息统计表";
	/**
	 * 县标题
	 */
	public static final String COUNTY_EXCEL_TITLE = "xxx年边境沿海市县边海防信息报送明细表";
	/**
	 * 县市 code 的长度
	 */
	public static final int COUNTY_CODE_LENGTH = 9;
	/**
	 * 区code 长度
	 */
	public static final int AREA_CODE_LENGTH = 6;

}
