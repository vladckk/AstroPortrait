package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parsing {
	public static void main(String[] args) throws IOException {
		List<String> signsText = new ArrayList<>();
		int day = 11;
		int month = 12;
		int year = 2000;
		signsText = Parsing.parsingResults("https://1001goroskop.ru/astroportret/?day=" + day + "&month=" +month+"&year=" + year);
		Parsing.toJSON(new Links(signsText.get(0), signsText.get(1), signsText.get(2)));
	}
	
	public static File toJSON(Links link) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File json = new File("starPortrait.json");
		mapper.writeValue(json, link);
		return json;
	}
	
	public static List<String> parsingResults(String mainUrl) throws IOException {
		List<String> signsText = new ArrayList<>();
		int countLinks = 3;
		Document doc = Jsoup.connect(mainUrl)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
		Elements h1Elements = doc.getElementsByClass("astroprtret");
		
		h1Elements.forEach(h1Element -> {
			for (int i = 0; i < countLinks; i++) {
				Element a1Element = h1Element.child(i).child(1).child(0);
				String url = a1Element.attr("href");
				String sign = a1Element.text();
				try {
					Document doc1 = Jsoup.connect(url)
					        .userAgent("Chrome/4.0.249.0 Safari/532.5")
					        .referrer("http://www.google.com")
					        .get();
					Elements h2Elements = doc1.getElementsByClass("maincenter");
					h2Elements.forEach(h2Element ->{
						String text = sign + "\n" + "\n";
						for (Element aa1Element : h2Elements.select("p")) {
							String conc = aa1Element.text();
							if (!conc.contains("*")) {
								text += "#" + conc;
							}
						}
						signsText.add(text);
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			String text = signsText.get(countLinks - 1);
			int index = text.lastIndexOf("#");
			text = text.substring(0, index);
			signsText.remove(countLinks - 1);
			signsText.add(text);
			for (int i = 0; i < countLinks; i++) {
				String temp = signsText.get(0);
				temp = temp.replaceAll("#", " ");
				temp = temp.replaceAll("\n ", "\n");
				signsText.remove(0);
				signsText.add(temp);
			}
			signsText.forEach(System.out::println);
		});
		return signsText;
	}
}
