package com.dj.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestFreemarker {

	@Test
	public void testFreemarker() throws Exception {
		// 1.创建一个模板文件
		// 2.创建一个configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 3.设置模板所在路径
		configuration.setDirectoryForTemplateLoading(new File("D:/resource/workspace/taotao/taotao-item-web/src/main/webapp/WEB-INF/ftl"));
		// 4.设置字符集
		configuration.setDefaultEncoding("utf-8");
		// 5.使用configuration加载一个对象
		Template template = configuration.getTemplate("hello.ftl");
		// 6.创建一个字符集
		Map data = new HashMap<>();
		data.put("hello", "hello freemarker");
		Student student = new Student(1, "哈喽", 11, "深圳");
		data.put("student", student);
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student(1, "哈喽", 11, "深圳"));
		stuList.add(new Student(2, "哈喽2", 12, "深圳"));
		stuList.add(new Student(3, "哈喽3", 13, "深圳"));
		stuList.add(new Student(4, "哈喽4", 14, "深圳"));
		stuList.add(new Student(5, "哈喽5", 15, "深圳"));
		stuList.add(new Student(6, "哈喽6", 16, "深圳"));
		stuList.add(new Student(7, "哈喽7", 17, "深圳"));
		data.put("stuList", stuList);
		//日期类型的处理
		data.put("date", new Date());
		data.put("val","123456");
		// 7.创建一个writer对象，指定输出文件名及路径
		FileWriter out = new FileWriter(new File("D:/ftlout/hello.txt"));
		//使用template对象的process()输出文件
		template.process(data, out);
		out.close();

	}

}
