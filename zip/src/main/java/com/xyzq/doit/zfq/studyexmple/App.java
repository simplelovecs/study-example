package com.xyzq.doit.zfq.studyexmple;

import com.alibaba.fastjson.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ZipUtil.zipDirectory("/Users/zhengfq/git/elasticsearch", "/Users/zhengfq/git/elasticsearch.zip");
//        ZipUtil.zipDirectory("/Users/zhengfq/git/ums", "/Users/zhengfq/git/mytest/ums.zip");
//        ZipUtil.zip("/Users/zhengfq/WorkDocment/AFA", "/Users/zhengfq/WorkDocment/mytest/AFA.zip");
//        TarUtil.tar("/Users/zhengfq/WorkDocment/AFA", "/Users/zhengfq/WorkDocment/AFA.tar");

//        GZUtil.gz("/Users/zhengfq/WorkDocment/AFA", "/Users/zhengfq/WorkDocment/mytest/AFA.tar.gz");
//        List<Object> objectList = new ArrayList<>();
//        objectList.add(null);
//
//        System.out.println( objectList.size());
//        System.out.println( objectList.get(0));

        Student student = new Student();
        student.setFirst("first");
        student.setKeyword1("{\"keyword1\":\"keyword1\"天天向上；}");
        student.setKeyword2("keyword2哈哈哈");
        student.setKeyword3("keyword3中文内容\"");
        student.setRemark("remark");

        String str = JSONObject.toJSONString(student);
        System.out.println(str);
        String url = "www.newsmth.net";

        Content con = new Content();

        con.content=str;
        con.url = url;

        String constr = JSONObject.toJSONString(con);
        System.out.println(constr);


        String content = String.format("{\"content\":\"%s\",\"linkurl\":\"%s\"}", str, url);
        System.out.println(content);

        content = "{\"content\":\"" + str + "}";
        System.out.println(content);

        content = String.format("{\"content\":\"%s\"}", str);
        System.out.println(content);
//
        System.out.println();
    }

    static class Content {
        String content;
        String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
