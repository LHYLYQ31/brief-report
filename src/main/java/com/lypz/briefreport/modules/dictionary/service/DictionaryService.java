/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.dictionary.service;

import java.util.List;

import com.lypz.briefreport.modules.dictionary.model.Dictionary;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月15日
 */
public interface DictionaryService {

	/**
	 * 
	 * <B>方法名称：list</B><BR>
	 * <B>概要说明：根据字典类型查询对应的字典数据</B><BR>
	 * 
	 * @param dictionaryType
	 *            字典类型 1 信息类型 2 提交类型
	 * @return
	 */
	List<Dictionary> list(Integer dictionaryType);

}