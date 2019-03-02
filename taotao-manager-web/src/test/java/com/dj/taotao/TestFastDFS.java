package com.dj.taotao;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class TestFastDFS {

	@Test
	public void uploadFile() throws Exception {
		// 1、向工程中添加jar包
		// 2、创建一个配置文件。配置tracker服务器地址
		// 3、加载配置文件
		ClientGlobal.init("D:/resource/workspace/taotao/taotao-manager-web/src/test/resources/client.conf");
		// 4、创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 5、使用TrackerClient对象获得trackerserver对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 6、创建一个StorageServer的引用null就可以
		StorageServer storageServer = null;
		// 7、创建一个StorageClient对象。trackerserver、StorageServer两个参数
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 8、使用StorageClient对象上传文件(win10:如果路径显示不存在就手敲)
		String[] file = storageClient.upload_file("C:/Users/dj673/Pictures/1.png", "png", null);
		for (String s : file) {
			System.out.println(s);
		}
	}

}
