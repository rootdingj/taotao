package com.dj.taotao.tool;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @ClassName: GeneratorSqlmap
 * @Description: MyBatis逆向生成工具
 * @author Steven
 * @date 2019年2月23日  
 */
public class GeneratorSqlUtil {

	public void generator() throws Exception {
		// 指定逆向工程配置文件
		File configFile = new File("generatorConfig.xml");
		List<String> list = new ArrayList<>(16);
		ConfigurationParser cp = new ConfigurationParser(list);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, list);
		myBatisGenerator.generate(null);

	}

	public static void main(String[] args) throws Exception {
		try {
			GeneratorSqlUtil generatorSqlmap = new GeneratorSqlUtil();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
