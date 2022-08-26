package techTask;
import org.testng.collections.Lists;
import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        String result1 = getShortString("В первичных научных статьях авторами излагается существенная информация");
        System.out.println(result1);
        getArticles().stream().forEach(x -> System.out.println(getShortString(x)));

    }

    public static List<String> getArticles() {
        List<String> articles = new ArrayList<>();
        articles.add("Научная статья — законченное авторское произведение, описывающее резул");
        articles.add("В первичных научных статьях авторами излагается существенная информация ");
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

    private static String getShortString(String article) {

        String[] words = article.split(" ");
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            String temp = stringBuilder.append(word).append(" ").toString();
            if (stringBuilder.toString().length() >= 25) {
                result = temp;
                break;
            }
            result = temp;
        }
        if (result.endsWith(" ")) {
            result = result.replaceFirst(".$", "");
            if (result.endsWith(".") || result.endsWith(",")) {

                result = result.replaceFirst(".$", "");

            }

        }
        return result.length() > 25 ? result + "..." : result; //тернарный оператор
    }


}
