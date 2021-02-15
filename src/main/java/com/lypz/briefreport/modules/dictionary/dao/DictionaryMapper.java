package com.lypz.briefreport.modules.dictionary.dao;

import java.util.List;

import com.lypz.briefreport.modules.dictionary.model.Dictionary;

public interface DictionaryMapper {

	int insert(Dictionary record);

	Dictionary selectById(Integer id);

	List<Dictionary> select(Dictionary record);

	int update(Dictionary record);

}