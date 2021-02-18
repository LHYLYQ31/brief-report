/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.attachment;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.lypz.briefreport.modules.attachment.service.AttachmentService;
import com.lypz.briefreport.modules.comment.BaseTest;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月18日
 */
public class AttachmentTest extends BaseTest {
	@Autowired
	AttachmentService attachmentService;

	/**
	 * 
	 * <B>方法名称：delete</B><BR>
	 * <B>概要说明：根据id删除附件</B><BR>
	 * 
	 * @param id
	 * @return
	 */
	// @Test
	public void deleteTest() {
		attachmentService.delete(1, 1);
	}

	/**
	 * 
	 * <B>方法名称：上传文件</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param files
	 *            文件
	 * @param request
	 * @return
	 * @throws Exception
	 */
	// @Test
	public void upload() {
		try {
			File file = new File(
					"D:\\briefreport\\2021-02-16\\0a55ec0c-2716-406e-98c7-62ec3dcb4d24.png");
			FileInputStream input = new FileInputStream(file);
			MultipartFile multipartFile = new MockMultipartFile("file",
					file.getName(), "text/plain", IOUtils.toByteArray(input));
			MultipartFile[] files = new MultipartFile[] { multipartFile };
			attachmentService.upload(files, 1, "1");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
