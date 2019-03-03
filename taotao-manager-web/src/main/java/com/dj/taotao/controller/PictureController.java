package com.dj.taotao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dj.taotao.utils.FastDFSClient;
import com.dj.taotao.utils.JsonUtils;

/** 
 * @ClassName: PictureController 
 * @Description: 图片上传controller
 * @author Steven 
 * @date 2019年3月3日  
 */
@Controller
public class PictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String imageServerUrl;

	/** 
	* @Title: uploadPic 
	* @Description: 上传图片
	* @param uploadFile
	* @return String  返回类型  
	*/
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile) {
		Map map = new HashMap<>(16);
		try {
			// 接收上传的文件
			// 获取扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			FastDFSClient dfsClient = new FastDFSClient("classpath:resource/client.conf");
			// 上传到图片服务器
			String url = dfsClient.uploadFile(uploadFile.getBytes(), extName);
			url = imageServerUrl + url;
			// 响应上传图片的url
			map.put("error", 0);
			map.put("url", url);
		} catch (Exception e) {
			map.put("error", 1);
			map.put("message", "图片上传失败!");
			e.printStackTrace();
		}
		return JsonUtils.objectToJson(map);
	}

}
