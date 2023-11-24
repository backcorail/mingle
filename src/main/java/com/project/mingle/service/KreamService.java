/*
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;

@Service
public class KreamService {
    private static String News_URL = "크롤링 할 URL";

    @PostConstruct
    public List<KreamVO> getNewsDatas() throws IOException {
        List<News> newsList = new ArrayList<>();
        Document document = Jsoup.connect(News_URL).get();

        Elements contents = document.select("section ul.type2 li");

        for (Element content : contents) {
            News news = News.builder()
                    .image(content.select("a img").attr("abs:src")) // 이미지
                    .subject(content.select("h4 a").text())		// 제목
                    .url(content.select("a").attr("abs:href"))		// 링크
                    .build();
            newsList.add(news);
        }

        return newsList;
    }
}
*/