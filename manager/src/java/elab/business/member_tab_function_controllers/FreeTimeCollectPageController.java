package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import elab.application.BaseViewController;
import javafx.fxml.FXML;

import java.awt.*;

public class FreeTimeCollectPageController extends BaseViewController {

    @FXML
    private TextArea questionBoard;
    @FXML
    private JFXButton save;

    /**
     * 最上一排的选项
     * 其中M-Morning,A-Afternoon,N-Night
     */

    @FXML
    private JFXCheckBox MonM;
    @FXML
    private JFXCheckBox MonA;
    @FXML
    private JFXCheckBox MonN;
    @FXML
    private JFXCheckBox TueM;
    @FXML
    private JFXCheckBox TueA;
    @FXML
    private JFXCheckBox TueN;
    @FXML
    private JFXCheckBox WedM;
    @FXML
    private JFXCheckBox WedA;
    @FXML
    private JFXCheckBox WedN;
    @FXML
    private JFXCheckBox ThurM;
    @FXML
    private JFXCheckBox ThurA;
    @FXML
    private JFXCheckBox ThurN;
    @FXML
    private JFXCheckBox FriM;
    @FXML
    private JFXCheckBox FriA;
    @FXML
    private JFXCheckBox FriN;
    @FXML
    private JFXCheckBox SatM;
    @FXML
    private JFXCheckBox SatA;
    @FXML
    private JFXCheckBox SatN;
    @FXML
    private JFXCheckBox SunM;
    @FXML
    private JFXCheckBox SunA;
    @FXML
    private JFXCheckBox SunN;

    /**
     * 最左一列的选项
     */

    @FXML
    private JFXCheckBox week1M;
    @FXML
    private JFXCheckBox week1A;
    @FXML
    private JFXCheckBox week1N;
    @FXML
    private JFXCheckBox week2M;
    @FXML
    private JFXCheckBox week2A;
    @FXML
    private JFXCheckBox week2N;
    @FXML
    private JFXCheckBox week3M;
    @FXML
    private JFXCheckBox week3A;
    @FXML
    private JFXCheckBox week3N;
    @FXML
    private JFXCheckBox week4M;
    @FXML
    private JFXCheckBox week4A;
    @FXML
    private JFXCheckBox week4N;
    @FXML
    private JFXCheckBox week5M;
    @FXML
    private JFXCheckBox week5A;
    @FXML
    private JFXCheckBox week5N;
    @FXML
    private JFXCheckBox week6M;
    @FXML
    private JFXCheckBox week6A;
    @FXML
    private JFXCheckBox week6N;
    @FXML
    private JFXCheckBox week7M;
    @FXML
    private JFXCheckBox week7A;
    @FXML
    private JFXCheckBox week7N;
    @FXML
    private JFXCheckBox week8M;
    @FXML
    private JFXCheckBox week8A;
    @FXML
    private JFXCheckBox week8N;
    @FXML
    private JFXCheckBox week9M;
    @FXML
    private JFXCheckBox week9A;
    @FXML
    private JFXCheckBox week9N;
    @FXML
    private JFXCheckBox week10M;
    @FXML
    private JFXCheckBox week10A;
    @FXML
    private JFXCheckBox week10N;
    @FXML
    private JFXCheckBox week11M;
    @FXML
    private JFXCheckBox week11A;
    @FXML
    private JFXCheckBox week11N;
    @FXML
    private JFXCheckBox week12M;
    @FXML
    private JFXCheckBox week12A;
    @FXML
    private JFXCheckBox week12N;
    @FXML
    private JFXCheckBox week13M;
    @FXML
    private JFXCheckBox week13A;
    @FXML
    private JFXCheckBox week13N;
    @FXML
    private JFXCheckBox week14M;
    @FXML
    private JFXCheckBox week14A;
    @FXML
    private JFXCheckBox week14N;

    /**
     * 其他的选项_周一
     */

    @FXML
    private JFXCheckBox W1MonM;
    @FXML
    private JFXCheckBox W1MonA;
    @FXML
    private JFXCheckBox W1MonN;
    @FXML
    private JFXCheckBox W2MonM;
    @FXML
    private JFXCheckBox W2MonA;
    @FXML
    private JFXCheckBox W2MonN;
    @FXML
    private JFXCheckBox W3MonM;
    @FXML
    private JFXCheckBox W3MonA;
    @FXML
    private JFXCheckBox W3MonN;
    @FXML
    private JFXCheckBox W4MonM;
    @FXML
    private JFXCheckBox W4MonA;
    @FXML
    private JFXCheckBox W4MonN;
    @FXML
    private JFXCheckBox W5MonM;
    @FXML
    private JFXCheckBox W5MonA;
    @FXML
    private JFXCheckBox W5MonN;
    @FXML
    private JFXCheckBox W6MonM;
    @FXML
    private JFXCheckBox W6MonA;
    @FXML
    private JFXCheckBox W6MonN;
    @FXML
    private JFXCheckBox W7MonM;
    @FXML
    private JFXCheckBox W7MonA;
    @FXML
    private JFXCheckBox W7MonN;
    @FXML
    private JFXCheckBox W8MonM;
    @FXML
    private JFXCheckBox W8MonA;
    @FXML
    private JFXCheckBox W8MonN;
    @FXML
    private JFXCheckBox W9MonM;
    @FXML
    private JFXCheckBox W9MonA;
    @FXML
    private JFXCheckBox W9MonN;
    @FXML
    private JFXCheckBox W10MonM;
    @FXML
    private JFXCheckBox W10MonA;
    @FXML
    private JFXCheckBox W10MonN;
    @FXML
    private JFXCheckBox W11MonM;
    @FXML
    private JFXCheckBox W11MonA;
    @FXML
    private JFXCheckBox W11MonN;
    @FXML
    private JFXCheckBox W12MonM;
    @FXML
    private JFXCheckBox W12MonA;
    @FXML
    private JFXCheckBox W12MonN;
    @FXML
    private JFXCheckBox W13MonM;
    @FXML
    private JFXCheckBox W13MonA;
    @FXML
    private JFXCheckBox W13MonN;
    @FXML
    private JFXCheckBox W14MonM;
    @FXML
    private JFXCheckBox W14MonA;
    @FXML
    private JFXCheckBox W14MonN;

    /**
     * 其他的选项_周二
     */

    @FXML
    private JFXCheckBox W1TueM;
    @FXML
    private JFXCheckBox W1TueA;
    @FXML
    private JFXCheckBox W1TueN;
    @FXML
    private JFXCheckBox W2TueM;
    @FXML
    private JFXCheckBox W2TueA;
    @FXML
    private JFXCheckBox W2TueN;
    @FXML
    private JFXCheckBox W3TueM;
    @FXML
    private JFXCheckBox W3TueA;
    @FXML
    private JFXCheckBox W3TueN;
    @FXML
    private JFXCheckBox W4TueM;
    @FXML
    private JFXCheckBox W4TueA;
    @FXML
    private JFXCheckBox W4TueN;
    @FXML
    private JFXCheckBox W5TueM;
    @FXML
    private JFXCheckBox W5TueA;
    @FXML
    private JFXCheckBox W5TueN;
    @FXML
    private JFXCheckBox W6TueM;
    @FXML
    private JFXCheckBox W6TueA;
    @FXML
    private JFXCheckBox W6TueN;
    @FXML
    private JFXCheckBox W7TueM;
    @FXML
    private JFXCheckBox W7TueA;
    @FXML
    private JFXCheckBox W7TueN;
    @FXML
    private JFXCheckBox W8TueM;
    @FXML
    private JFXCheckBox W8TueA;
    @FXML
    private JFXCheckBox W8TueN;
    @FXML
    private JFXCheckBox W9TueM;
    @FXML
    private JFXCheckBox W9TueA;
    @FXML
    private JFXCheckBox W9TueN;
    @FXML
    private JFXCheckBox W10TueM;
    @FXML
    private JFXCheckBox W10TueA;
    @FXML
    private JFXCheckBox W10TueN;
    @FXML
    private JFXCheckBox W11TueM;
    @FXML
    private JFXCheckBox W11TueA;
    @FXML
    private JFXCheckBox W11TueN;
    @FXML
    private JFXCheckBox W12TueM;
    @FXML
    private JFXCheckBox W12TueA;
    @FXML
    private JFXCheckBox W12TueN;
    @FXML
    private JFXCheckBox W13TueM;
    @FXML
    private JFXCheckBox W13TueA;
    @FXML
    private JFXCheckBox W13TueN;
    @FXML
    private JFXCheckBox W14TueM;
    @FXML
    private JFXCheckBox W14TueA;
    @FXML
    private JFXCheckBox W14TueN;

    /**
     * 其他的选项_周三
     */

    @FXML
    private JFXCheckBox W1WedM;
    @FXML
    private JFXCheckBox W1WedA;
    @FXML
    private JFXCheckBox W1WedN;
    @FXML
    private JFXCheckBox W2WedM;
    @FXML
    private JFXCheckBox W2WedA;
    @FXML
    private JFXCheckBox W2WedN;
    @FXML
    private JFXCheckBox W3WedM;
    @FXML
    private JFXCheckBox W3WedA;
    @FXML
    private JFXCheckBox W3WedN;
    @FXML
    private JFXCheckBox W4WedM;
    @FXML
    private JFXCheckBox W4WedA;
    @FXML
    private JFXCheckBox W4WedN;
    @FXML
    private JFXCheckBox W5WedM;
    @FXML
    private JFXCheckBox W5WedA;
    @FXML
    private JFXCheckBox W5WedN;
    @FXML
    private JFXCheckBox W6WedM;
    @FXML
    private JFXCheckBox W6WedA;
    @FXML
    private JFXCheckBox W6WedN;
    @FXML
    private JFXCheckBox W7WedM;
    @FXML
    private JFXCheckBox W7WedA;
    @FXML
    private JFXCheckBox W7WedN;
    @FXML
    private JFXCheckBox W8WedM;
    @FXML
    private JFXCheckBox W8WedA;
    @FXML
    private JFXCheckBox W8WedN;
    @FXML
    private JFXCheckBox W9WedM;
    @FXML
    private JFXCheckBox W9WedA;
    @FXML
    private JFXCheckBox W9WedN;
    @FXML
    private JFXCheckBox W10WedM;
    @FXML
    private JFXCheckBox W10WedA;
    @FXML
    private JFXCheckBox W10WedN;
    @FXML
    private JFXCheckBox W11WedM;
    @FXML
    private JFXCheckBox W11WedA;
    @FXML
    private JFXCheckBox W11WedN;
    @FXML
    private JFXCheckBox W12WedM;
    @FXML
    private JFXCheckBox W12WedA;
    @FXML
    private JFXCheckBox W12WedN;
    @FXML
    private JFXCheckBox W13WedM;
    @FXML
    private JFXCheckBox W13WedA;
    @FXML
    private JFXCheckBox W13WedN;
    @FXML
    private JFXCheckBox W14WedM;
    @FXML
    private JFXCheckBox W14WedA;
    @FXML
    private JFXCheckBox W14WedN;

    /**
     * 其他的选项_周四
     */

    @FXML
    private JFXCheckBox W1ThurM;
    @FXML
    private JFXCheckBox W1ThurA;
    @FXML
    private JFXCheckBox W1ThurN;
    @FXML
    private JFXCheckBox W2ThurM;
    @FXML
    private JFXCheckBox W2ThurA;
    @FXML
    private JFXCheckBox W2ThurN;
    @FXML
    private JFXCheckBox W3ThurM;
    @FXML
    private JFXCheckBox W3ThurA;
    @FXML
    private JFXCheckBox W3ThurN;
    @FXML
    private JFXCheckBox W4ThurM;
    @FXML
    private JFXCheckBox W4ThurA;
    @FXML
    private JFXCheckBox W4ThurN;
    @FXML
    private JFXCheckBox W5ThurM;
    @FXML
    private JFXCheckBox W5ThurA;
    @FXML
    private JFXCheckBox W5ThurN;
    @FXML
    private JFXCheckBox W6ThurM;
    @FXML
    private JFXCheckBox W6ThurA;
    @FXML
    private JFXCheckBox W6ThurN;
    @FXML
    private JFXCheckBox W7ThurM;
    @FXML
    private JFXCheckBox W7ThurA;
    @FXML
    private JFXCheckBox W7ThurN;
    @FXML
    private JFXCheckBox W8ThurM;
    @FXML
    private JFXCheckBox W8ThurA;
    @FXML
    private JFXCheckBox W8ThurN;
    @FXML
    private JFXCheckBox W9ThurM;
    @FXML
    private JFXCheckBox W9ThurA;
    @FXML
    private JFXCheckBox W9ThurN;
    @FXML
    private JFXCheckBox W10ThurM;
    @FXML
    private JFXCheckBox W10ThurA;
    @FXML
    private JFXCheckBox W10ThurN;
    @FXML
    private JFXCheckBox W11ThurM;
    @FXML
    private JFXCheckBox W11ThurA;
    @FXML
    private JFXCheckBox W11ThurN;
    @FXML
    private JFXCheckBox W12ThurM;
    @FXML
    private JFXCheckBox W12ThurA;
    @FXML
    private JFXCheckBox W12ThurN;
    @FXML
    private JFXCheckBox W13ThurM;
    @FXML
    private JFXCheckBox W13ThurA;
    @FXML
    private JFXCheckBox W13ThurN;
    @FXML
    private JFXCheckBox W14ThurM;
    @FXML
    private JFXCheckBox W14ThurA;
    @FXML
    private JFXCheckBox W14ThurN;

    /**
     * 其他的选项_周五
     */

    @FXML
    private JFXCheckBox W1FriM;
    @FXML
    private JFXCheckBox W1FriA;
    @FXML
    private JFXCheckBox W1FriN;
    @FXML
    private JFXCheckBox W2FriM;
    @FXML
    private JFXCheckBox W2FriA;
    @FXML
    private JFXCheckBox W2FriN;
    @FXML
    private JFXCheckBox W3FriM;
    @FXML
    private JFXCheckBox W3FriA;
    @FXML
    private JFXCheckBox W3FriN;
    @FXML
    private JFXCheckBox W4FriM;
    @FXML
    private JFXCheckBox W4FriA;
    @FXML
    private JFXCheckBox W4FriN;
    @FXML
    private JFXCheckBox W5FriM;
    @FXML
    private JFXCheckBox W5FriA;
    @FXML
    private JFXCheckBox W5FriN;
    @FXML
    private JFXCheckBox W6FriM;
    @FXML
    private JFXCheckBox W6FriA;
    @FXML
    private JFXCheckBox W6FriN;
    @FXML
    private JFXCheckBox W7FriM;
    @FXML
    private JFXCheckBox W7FriA;
    @FXML
    private JFXCheckBox W7FriN;
    @FXML
    private JFXCheckBox W8FriM;
    @FXML
    private JFXCheckBox W8FriA;
    @FXML
    private JFXCheckBox W8FriN;
    @FXML
    private JFXCheckBox W9FriM;
    @FXML
    private JFXCheckBox W9FriA;
    @FXML
    private JFXCheckBox W9FriN;
    @FXML
    private JFXCheckBox W10FriM;
    @FXML
    private JFXCheckBox W10FriA;
    @FXML
    private JFXCheckBox W10FriN;
    @FXML
    private JFXCheckBox W11FriM;
    @FXML
    private JFXCheckBox W11FriA;
    @FXML
    private JFXCheckBox W11FriN;
    @FXML
    private JFXCheckBox W12FriM;
    @FXML
    private JFXCheckBox W12FriA;
    @FXML
    private JFXCheckBox W12FriN;
    @FXML
    private JFXCheckBox W13FriM;
    @FXML
    private JFXCheckBox W13FriA;
    @FXML
    private JFXCheckBox W13FriN;
    @FXML
    private JFXCheckBox W14FriM;
    @FXML
    private JFXCheckBox W14FriA;
    @FXML
    private JFXCheckBox W14FriN;

    /**
     * 其他的选项_周六
     */

    @FXML
    private JFXCheckBox W1SatM;
    @FXML
    private JFXCheckBox W1SatA;
    @FXML
    private JFXCheckBox W1SatN;
    @FXML
    private JFXCheckBox W2SatM;
    @FXML
    private JFXCheckBox W2SatA;
    @FXML
    private JFXCheckBox W2SatN;
    @FXML
    private JFXCheckBox W3SatM;
    @FXML
    private JFXCheckBox W3SatA;
    @FXML
    private JFXCheckBox W3SatN;
    @FXML
    private JFXCheckBox W4SatM;
    @FXML
    private JFXCheckBox W4SatA;
    @FXML
    private JFXCheckBox W4SatN;
    @FXML
    private JFXCheckBox W5SatM;
    @FXML
    private JFXCheckBox W5SatA;
    @FXML
    private JFXCheckBox W5SatN;
    @FXML
    private JFXCheckBox W6SatM;
    @FXML
    private JFXCheckBox W6SatA;
    @FXML
    private JFXCheckBox W6SatN;
    @FXML
    private JFXCheckBox W7SatM;
    @FXML
    private JFXCheckBox W7SatA;
    @FXML
    private JFXCheckBox W7SatN;
    @FXML
    private JFXCheckBox W8SatM;
    @FXML
    private JFXCheckBox W8SatA;
    @FXML
    private JFXCheckBox W8SatN;
    @FXML
    private JFXCheckBox W9SatM;
    @FXML
    private JFXCheckBox W9SatA;
    @FXML
    private JFXCheckBox W9SatN;
    @FXML
    private JFXCheckBox W10SatM;
    @FXML
    private JFXCheckBox W10SatA;
    @FXML
    private JFXCheckBox W10SatN;
    @FXML
    private JFXCheckBox W11SatM;
    @FXML
    private JFXCheckBox W11SatA;
    @FXML
    private JFXCheckBox W11SatN;
    @FXML
    private JFXCheckBox W12SatM;
    @FXML
    private JFXCheckBox W12SatA;
    @FXML
    private JFXCheckBox W12SatN;
    @FXML
    private JFXCheckBox W13SatM;
    @FXML
    private JFXCheckBox W13SatA;
    @FXML
    private JFXCheckBox W13SatN;
    @FXML
    private JFXCheckBox W14SatM;
    @FXML
    private JFXCheckBox W14SatA;
    @FXML
    private JFXCheckBox W14SatN;

    /**
     * 其他的选项_周日
     */

    @FXML
    private JFXCheckBox W1SunM;
    @FXML
    private JFXCheckBox W1SunA;
    @FXML
    private JFXCheckBox W1SunN;
    @FXML
    private JFXCheckBox W2SunM;
    @FXML
    private JFXCheckBox W2SunA;
    @FXML
    private JFXCheckBox W2SunN;
    @FXML
    private JFXCheckBox W3SunM;
    @FXML
    private JFXCheckBox W3SunA;
    @FXML
    private JFXCheckBox W3SunN;
    @FXML
    private JFXCheckBox W4SunM;
    @FXML
    private JFXCheckBox W4SunA;
    @FXML
    private JFXCheckBox W4SunN;
    @FXML
    private JFXCheckBox W5SunM;
    @FXML
    private JFXCheckBox W5SunA;
    @FXML
    private JFXCheckBox W5SunN;
    @FXML
    private JFXCheckBox W6SunM;
    @FXML
    private JFXCheckBox W6SunA;
    @FXML
    private JFXCheckBox W6SunN;
    @FXML
    private JFXCheckBox W7SunM;
    @FXML
    private JFXCheckBox W7SunA;
    @FXML
    private JFXCheckBox W7SunN;
    @FXML
    private JFXCheckBox W8SunM;
    @FXML
    private JFXCheckBox W8SunA;
    @FXML
    private JFXCheckBox W8SunN;
    @FXML
    private JFXCheckBox W9SunM;
    @FXML
    private JFXCheckBox W9SunA;
    @FXML
    private JFXCheckBox W9SunN;
    @FXML
    private JFXCheckBox W10SunM;
    @FXML
    private JFXCheckBox W10SunA;
    @FXML
    private JFXCheckBox W10SunN;
    @FXML
    private JFXCheckBox W11SunM;
    @FXML
    private JFXCheckBox W11SunA;
    @FXML
    private JFXCheckBox W11SunN;
    @FXML
    private JFXCheckBox W12SunM;
    @FXML
    private JFXCheckBox W12SunA;
    @FXML
    private JFXCheckBox W12SunN;
    @FXML
    private JFXCheckBox W13SunM;
    @FXML
    private JFXCheckBox W13SunA;
    @FXML
    private JFXCheckBox W13SunN;
    @FXML
    private JFXCheckBox W14SunM;
    @FXML
    private JFXCheckBox W14SunA;
    @FXML
    private JFXCheckBox W14SunN;

    @Override
    public void initializeController() {

    }
}
