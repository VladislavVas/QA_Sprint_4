package scooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.scooter.pageObject.HomePage;

import java.util.List;

@RunWith(Parameterized.class)
public class QuestionsListTest extends BaseTest {

    private final int questionLocator;
    private final int answerLocator;
    private final String expectedText;

    private final static List<String> expectedAnswers = List.of(
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    );

    public QuestionsListTest(int questionLocator, int answerLocator, String expectedText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] expectedParams() {
        return new Object[][]{
                {0, 0, expectedAnswers.get(0)},
                {1, 1, expectedAnswers.get(1)},
                {2, 2, expectedAnswers.get(2)},
                {3, 3, expectedAnswers.get(3)},
                {4, 4, expectedAnswers.get(4)},
                {5, 5, expectedAnswers.get(5)},
                {6, 6, expectedAnswers.get(6)},
                {7, 7, expectedAnswers.get(7)},
        };
    }

    @Test
    public void testQuestions() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.clickQuestionButton(questionLocator);
        String actualText = homePage.getActualAnswerText(answerLocator);
        Assert.assertEquals("The answer text does not match the question!", expectedText, actualText);
    }
}
