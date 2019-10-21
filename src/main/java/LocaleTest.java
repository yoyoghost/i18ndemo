import java.util.Locale;

/**
 * @author : sihk
 * @version :
 * @date : Created in 下午5:49 2019/10/21
 */
public class LocaleTest {

    public static void main(String[] args) {
        String lang = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        System.out.println(lang+"_"+country);
    }
}
