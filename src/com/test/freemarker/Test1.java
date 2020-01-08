package com.test.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wyl.bean.Address;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test1 {
	public static void main(String[] args) throws IOException,
			TemplateException {
		// 1 创建Freemarker配置实例
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("templates"));

		// 2 创建数据模型
		Map root = new HashMap();
		root.put("user", "Suneyae");
		root.put("now",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		Address address = new Address("中国", "泰州");
		ArrayList<Address> list = new ArrayList<Address>();
		list.add(address);
		list.add(new Address("日本", "冈崎"));
		list.add(new Address("韩国", "仁川"));
		root.put("addr", list);
		root.put("html2", "<h1>abcd</h1>");
		// 3 加载模板文件
		Template t1 = cfg.getTemplate("a.ftl");

		// 4 显示生成的数据
		Writer out = new OutputStreamWriter(System.out);
		t1.process(root, out);// 会输出到控制台
		out.flush();
		out.close();
	}
}
