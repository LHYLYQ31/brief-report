package com.lypz.briefreport.modules.attachment.dao;

import java.util.List;

import com.lypz.briefreport.modules.attachment.model.Attachment;

public interface AttachmentMapper {

	int insert(Attachment record);

	Attachment selectById(Integer id);

	List<Attachment> select(Attachment record);

	int update(Attachment record);
}