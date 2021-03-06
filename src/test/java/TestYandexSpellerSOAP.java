import core.YandexSpellerSOAP;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static core.YandexSpellerConstants.*;

/**
 * Created by yulia_atlasova@epam.com on 22/06/2017.
 * try to test SOAP via RestAssured
 */
public class TestYandexSpellerSOAP {

    @Test
    public void simpleCall(){
                YandexSpellerSOAP
                        .with().text(wrongWordEn)
                        .callSOAP()
                        .then()
                        .body(Matchers.stringContainsInOrder(Arrays.asList(wrongWordEn, rightWordEn)));
    }

    @Test
    public void useRequestBuilderToChangeParams(){
        YandexSpellerSOAP.with()
                .language(Languages.EN)
                .text(wrongWordEn)
                .options("6")
                .callSOAP()
                .then()
                .body(Matchers.stringContainsInOrder(Arrays.asList(wrongWordEn, rightWordEn)));
    }
}
