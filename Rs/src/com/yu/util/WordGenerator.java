package com.yu.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Map;

/**
 * 简历生成word工具类
 */
public class WordGenerator {
    private static Configuration configuration = null;
    private static String url = "e:\\resume";
    //freeMarker渲染前的设置
    static {
     configuration = new Configuration();
     //设置模版加载基础路径
        try {
            configuration.setDirectoryForTemplateLoading(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置渲染字符集
        configuration.setDefaultEncoding("utf-8");
        //设置模版异常处理
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }
    //防止实例化
    private WordGenerator() {}

    public static File createDoc(Map<?,?> dataMap,String xmlName) throws Exception {
        //渲染后的文件名
        String name = "resume" + (int)(1+ Math.random()*999) + ".doc";
        String path = "e:/resume";
        File file = new File(path,name);
        // 定义模版
        Template t = null;
        t = configuration.getTemplate(xmlName);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"utf-8");
       //渲染模版
        t.process(dataMap,writer);
        writer.close();
        return file;
    }
}
