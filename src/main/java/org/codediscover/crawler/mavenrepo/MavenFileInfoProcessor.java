package org.codediscover.crawler.mavenrepo;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Maven文件信息页面处理器
 *
 * @author ZhangShuai　at 2018-01-10 22:33
 * @version 1.0
 */
public class MavenFileInfoProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        Element contentElement = page.getHtml().getDocument().select("#contents").first();
        if (contentElement == null) {
            return;
        }
        List<TextNode> textNodes = contentElement.textNodes();
        Elements aElements = contentElement.select("a");
        if (aElements == null || aElements.isEmpty()) {
            return;
        }
        Map<String, String> hrefMap = new HashMap<>();
        boolean isPackageDir = false;
        for (int i = 1; i < aElements.size(); i++) {
            //第0个元素为../，不应计入
            Element aElement = aElements.get(i);
            String href = aElement.attr("href");
            if (StringUtils.isNoneEmpty(href)) {
                if (href.endsWith(".pom")) {
                    //如果该目录下包含pom文件，说明该目录是jar包所在的目录
                    isPackageDir = true;
                }
            }
            hrefMap.put(href, textNodes.get(i + 1).text().trim());
        }
        for (Map.Entry<String, String> hrefEntry : hrefMap.entrySet()) {
            System.out.println(hrefEntry);
        }
        for (String href : hrefMap.keySet()) {
            if(href.endsWith("/")){
                //目录，加入爬虫
                String url = page.getUrl().get() + href;
                page.addTargetRequest(url);
            }
        }
    }

    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(3);
    }

    public static void main(String[] args) {
        Spider.create(new MavenFileInfoProcessor())
                .addUrl("http://central.maven.org/maven2/").thread(5).run();

    }

}
