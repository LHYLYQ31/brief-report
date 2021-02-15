/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.dictionary.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lypz.briefreport.modules.dictionary.dao.DictionaryMapper;
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
@Service
public class DictionaryServiceImpl implements DictionaryService {
	@Resource
	DictionaryMapper dictionaryMapper;

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.dictionary.service.DictionaryService#list(java.lang.Integer)
	 */
	@Override
	public List<Dictionary> list(Integer dictionaryType) {
		if (dictionaryType == null || dictionaryType == 0) {
			return new ArrayList<Dictionary>();
		}
		Dictionary d = new Dictionary();
		d.setDictionaryType(dictionaryType);
		return dictionaryMapper.select(d);
	}
}
