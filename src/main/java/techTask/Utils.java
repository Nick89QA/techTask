package techTask;

import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;


public class Utils {
    public static void main(String[] args) {
        String result1 = getShortString("В первичных научных статьях авторами излагается существенная информация");
        System.out.println(result1);
        getArticles().stream().forEach(x -> System.out.println(getShortString(x)));

    }

    public static List<String> getArticles() {
        List<String> articles = new ArrayList<>();
        articles.add("Научная статья — законченное авторское произведение, описывающее резул");
        articles.add("В первичных научных статьях авторами излагается существенная информация");
        articles.add("Проект «КиберЛенинка» призван исправить ситуацию в этой области. Мы предоставляем");
        articles.add("Рассмотрены лингвометодические и психолингвистические основы моделирования научного текста. Они касаются единиц текста, внутритекстовых связей");
        articles.add("функции двунаправленного");
        return articles;
    }

    private List<String> getHeaders() {
        return Lists.newArrayList("статья — законченное авторское произведение",
                "«КиберЛенинка» призван исправить ситуацию в этой области",
                "статья — законченное авторское произведение,",
                " психолингвистические основы");
    }

    public static String getShortString(String article) {

        StringBuilder sb = new StringBuilder();
        String[] words = article.split(" ");
        String exitResult = ""; //заготовка для результата
        for (String word : words) {
            String tempResult = sb.append(word).toString();
            if (tempResult.length() >= 25) {
                if (tempResult.length() == 25) {
                    exitResult = tempResult;
                }
                break;
            }
            sb.append(" ");
            exitResult = tempResult;

        }

        if (exitResult.endsWith(" ")) { //проверка на пробел
            exitResult = exitResult.replaceFirst(".$", "");//убирает значение под регулярку
            if (exitResult.endsWith(",") || exitResult.endsWith(".")) {
                exitResult = exitResult.replaceFirst(".$", "");
            }
        }

        return article.equals(exitResult) ? article : exitResult + "...";

    }

}
