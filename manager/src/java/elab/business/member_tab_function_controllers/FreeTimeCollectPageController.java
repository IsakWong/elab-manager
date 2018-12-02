package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import sun.security.provider.Sun;


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
     * 其他的选项
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
     * 其中W-Week
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

    /**
     * 最终信息收集
     */

    public void collectInformation() {

        //留言板信息收集

        String question = questionBoard.getText();
        System.out.println(question);

        //最上一行及对应列的选项信息收集

        if(MonM.isSelected())
            System.out.println("Monday mornings are selected");
        else {

        }
        if(TueM.isSelected())
            System.out.println("Tuesday mornings are selected");
        else {

        }
        if(WedM.isSelected())
            System.out.println("Wednesday mornings are selected");
        else {

        }
        if(ThurM.isSelected())
            System.out.println("Thursday mornings are selected");
        else {

        }
        if(FriM.isSelected())
            System.out.println("Friday mornings are selected");
        else {

        }
        if(SatM.isSelected())
            System.out.println("Saturday mornings are selected");
        else {

        }
        if(SunM.isSelected())
            System.out.println("Sunday mornings are selected");
        else {

        }

        if(MonA.isSelected())
            System.out.println("Monday afternoons are selected");
        else {

        }
        if(TueA.isSelected())
            System.out.println("Tuesday afternoons are selected");
        else {

        }
        if(WedA.isSelected())
            System.out.println("Wednesday afternoons are selected");
        else {

        }
        if(ThurA.isSelected())
            System.out.println("Thursday afternoons are selected");
        else {

        }
        if(FriA.isSelected())
            System.out.println("Friday afternoons are selected");
        else {

        }
        if(SatA.isSelected())
            System.out.println("Saturday afternoons are selected");
        else {

        }
        if(SunA.isSelected())
            System.out.println("Sunday afternoons are selected");
        else {

        }

        if(MonN.isSelected())
            System.out.println("Monday nights are selected");
        else {

        }
        if(TueN.isSelected())
            System.out.println("Tuesday nights are selected");
        else {

        }
        if(WedN.isSelected())
            System.out.println("Wednesday nights are selected");
        else {

        }
        if(ThurN.isSelected())
            System.out.println("Thursday nights are selected");
        else {

        }
        if(FriN.isSelected())
            System.out.println("Friday nights are selected");
        else {

        }
        if(SatN.isSelected())
            System.out.println("Saturday nights are selected");
        else {

        }
        if(SunN.isSelected())
            System.out.println("Sunday nights are selected");
        else {

        }

        //最左一列及对应行的选项信息收集

        if(week1M.isSelected())
            System.out.println("Week1 mornings are selected");
        else {
            if(W1MonM.isSelected())
                System.out.println("Week1 Monday morning is selected");
            if(W1TueM.isSelected())
                System.out.println("Week1 Tuesday morning is selected");
            if(W1WedM.isSelected())
                System.out.println("Week1 Wednesday morning is selected");
            if(W1ThurM.isSelected())
                System.out.println("Week1 Thursday morning is selected");
            if(W1FriM.isSelected())
                System.out.println("Week1 Friday morning is selected");
            if(W1SatM.isSelected())
                System.out.println("Week1 Saturday morning is selected");
            if(W1SunM.isSelected())
                System.out.println("Week1 Sunday morning is selected");
        }
        if(week1A.isSelected())
            System.out.println("Week1 afternoons are selected");
        else {
            if(W1MonA.isSelected())
                System.out.println("Week1 Monday afternoon is selected");
            if(W1TueA.isSelected())
                System.out.println("Week1 Tuesday afternoon is selected");
            if(W1WedA.isSelected())
                System.out.println("Week1 Wednesday afternoon is selected");
            if(W1ThurA.isSelected())
                System.out.println("Week1 Thursday afternoon is selected");
            if(W1FriA.isSelected())
                System.out.println("Week1 Friday afternoon is selected");
            if(W1SatA.isSelected())
                System.out.println("Week1 Saturday afternoon is selected");
            if(W1SunA.isSelected())
                System.out.println("Week1 Sunday afternoon is selected");
        }
        if(week1N.isSelected())
            System.out.println("Week1 nights are selected");
        else {
            if(W1MonN.isSelected())
                System.out.println("Week1 Monday night is selected");
            if(W1TueN.isSelected())
                System.out.println("Week1 Tuesday night is selected");
            if(W1WedN.isSelected())
                System.out.println("Week1 Wednesday night is selected");
            if(W1ThurN.isSelected())
                System.out.println("Week1 Thursday night is selected");
            if(W1FriN.isSelected())
                System.out.println("Week1 Friday night is selected");
            if(W1SatN.isSelected())
                System.out.println("Week1 Saturday night is selected");
            if(W1SunN.isSelected())
                System.out.println("Week1 Sunday night is selected");
        }

        if(week2M.isSelected())
            System.out.println("Week2 mornings are selected");
        else {
            if(W2MonM.isSelected())
                System.out.println("Week2 Monday morning is selected");
            if(W2TueM.isSelected())
                System.out.println("Week2 Tuesday morning is selected");
            if(W2WedM.isSelected())
                System.out.println("Week2 Wednesday morning is selected");
            if(W2ThurM.isSelected())
                System.out.println("Week2 Thursday morning is selected");
            if(W2FriM.isSelected())
                System.out.println("Week2 Friday morning is selected");
            if(W2SatM.isSelected())
                System.out.println("Week2 Saturday morning is selected");
            if(W2SunM.isSelected())
                System.out.println("Week2 Sunday morning is selected");
        }
        if(week2A.isSelected())
            System.out.println("Week2 afternoons are selected");
        else {
            if(W2MonA.isSelected())
                System.out.println("Week2 Monday afternoon is selected");
            if(W2TueA.isSelected())
                System.out.println("Week2 Tuesday afternoon is selected");
            if(W2WedA.isSelected())
                System.out.println("Week2 Wednesday afternoon is selected");
            if(W2ThurA.isSelected())
                System.out.println("Week2 Thursday afternoon is selected");
            if(W2FriA.isSelected())
                System.out.println("Week2 Friday afternoon is selected");
            if(W2SatA.isSelected())
                System.out.println("Week2 Saturday afternoon is selected");
            if(W2SunA.isSelected())
                System.out.println("Week2 Sunday afternoon is selected");
        }
        if(week2N.isSelected())
            System.out.println("Week2 nights are selected");
        else {
            if(W2MonN.isSelected())
                System.out.println("Week2 Monday night is selected");
            if(W2TueN.isSelected())
                System.out.println("Week2 Tuesday night is selected");
            if(W2WedN.isSelected())
                System.out.println("Week2 Wednesday night is selected");
            if(W2ThurN.isSelected())
                System.out.println("Week2 Thursday night is selected");
            if(W2FriN.isSelected())
                System.out.println("Week2 Friday night is selected");
            if(W2SatN.isSelected())
                System.out.println("Week2 Saturday night is selected");
            if(W2SunN.isSelected())
                System.out.println("Week2 Sunday night is selected");
        }

        if(week3M.isSelected())
            System.out.println("Week3 mornings are selected");
        else {
            if(W3MonM.isSelected())
                System.out.println("Week3 Monday morning is selected");
            if(W3TueM.isSelected())
                System.out.println("Week3 Tuesday morning is selected");
            if(W3WedM.isSelected())
                System.out.println("Week3 Wednesday morning is selected");
            if(W3ThurM.isSelected())
                System.out.println("Week3 Thursday morning is selected");
            if(W3FriM.isSelected())
                System.out.println("Week3 Friday morning is selected");
            if(W3SatM.isSelected())
                System.out.println("Week3 Saturday morning is selected");
            if(W3SunM.isSelected())
                System.out.println("Week3 Sunday morning is selected");
        }
        if(week3A.isSelected())
            System.out.println("Week3 afternoons are selected");
        else {
            if(W3MonA.isSelected())
                System.out.println("Week3 Monday afternoon is selected");
            if(W3TueA.isSelected())
                System.out.println("Week3 Tuesday afternoon is selected");
            if(W3WedA.isSelected())
                System.out.println("Week3 Wednesday afternoon is selected");
            if(W3ThurA.isSelected())
                System.out.println("Week3 Thursday afternoon is selected");
            if(W3FriA.isSelected())
                System.out.println("Week3 Friday afternoon is selected");
            if(W3SatA.isSelected())
                System.out.println("Week3 Saturday afternoon is selected");
            if(W3SunA.isSelected())
                System.out.println("Week3 Sunday afternoon is selected");
        }
        if(week3N.isSelected())
            System.out.println("Week3 nights are selected");
        else {
            if(W3MonN.isSelected())
                System.out.println("Week3 Monday night is selected");
            if(W3TueN.isSelected())
                System.out.println("Week3 Tuesday night is selected");
            if(W3WedN.isSelected())
                System.out.println("Week3 Wednesday night is selected");
            if(W3ThurN.isSelected())
                System.out.println("Week3 Thursday night is selected");
            if(W3FriN.isSelected())
                System.out.println("Week3 Friday night is selected");
            if(W3SatN.isSelected())
                System.out.println("Week3 Saturday night is selected");
            if(W3SunN.isSelected())
                System.out.println("Week3 Sunday night is selected");
        }

        if(week4M.isSelected())
            System.out.println("Week4 mornings are selected");
        else {
            if(W4MonM.isSelected())
                System.out.println("Week4 Monday morning is selected");
            if(W4TueM.isSelected())
                System.out.println("Week4 Tuesday morning is selected");
            if(W4WedM.isSelected())
                System.out.println("Week4 Wednesday morning is selected");
            if(W4ThurM.isSelected())
                System.out.println("Week4 Thursday morning is selected");
            if(W4FriM.isSelected())
                System.out.println("Week4 Friday morning is selected");
            if(W4SatM.isSelected())
                System.out.println("Week4 Saturday morning is selected");
            if(W4SunM.isSelected())
                System.out.println("Week4 Sunday morning is selected");
        }
        if(week4A.isSelected())
            System.out.println("Week4 afternoons are selected");
        else {
            if(W4MonA.isSelected())
                System.out.println("Week4 Monday afternoon is selected");
            if(W4TueA.isSelected())
                System.out.println("Week4 Tuesday afternoon is selected");
            if(W4WedA.isSelected())
                System.out.println("Week4 Wednesday afternoon is selected");
            if(W4ThurA.isSelected())
                System.out.println("Week4 Thursday afternoon is selected");
            if(W4FriA.isSelected())
                System.out.println("Week4 Friday afternoon is selected");
            if(W4SatA.isSelected())
                System.out.println("Week4 Saturday afternoon is selected");
            if(W4SunA.isSelected())
                System.out.println("Week4 Sunday afternoon is selected");
        }
        if(week4N.isSelected())
            System.out.println("Week4 nights are selected");
        else {
            if(W4MonN.isSelected())
                System.out.println("Week4 Monday night is selected");
            if(W4TueN.isSelected())
                System.out.println("Week4 Tuesday night is selected");
            if(W4WedN.isSelected())
                System.out.println("Week4 Wednesday night is selected");
            if(W4ThurN.isSelected())
                System.out.println("Week4 Thursday night is selected");
            if(W4FriN.isSelected())
                System.out.println("Week4 Friday night is selected");
            if(W4SatN.isSelected())
                System.out.println("Week4 Saturday night is selected");
            if(W4SunN.isSelected())
                System.out.println("Week4 Sunday night is selected");
        }

        if(week5M.isSelected())
            System.out.println("Week5 mornings are selected");
        else {
            if(W5MonM.isSelected())
                System.out.println("Week5 Monday morning is selected");
            if(W5TueM.isSelected())
                System.out.println("Week5 Tuesday morning is selected");
            if(W5WedM.isSelected())
                System.out.println("Week5 Wednesday morning is selected");
            if(W5ThurM.isSelected())
                System.out.println("Week5 Thursday morning is selected");
            if(W5FriM.isSelected())
                System.out.println("Week5 Friday morning is selected");
            if(W5SatM.isSelected())
                System.out.println("Week5 Saturday morning is selected");
            if(W5SunM.isSelected())
                System.out.println("Week5 Sunday morning is selected");
        }
        if(week5A.isSelected())
            System.out.println("Week5 afternoons are selected");
        else {
            if(W5MonA.isSelected())
                System.out.println("Week5 Monday afternoon is selected");
            if(W5TueA.isSelected())
                System.out.println("Week5 Tuesday afternoon is selected");
            if(W5WedA.isSelected())
                System.out.println("Week5 Wednesday afternoon is selected");
            if(W5ThurA.isSelected())
                System.out.println("Week5 Thursday afternoon is selected");
            if(W5FriA.isSelected())
                System.out.println("Week5 Friday afternoon is selected");
            if(W5SatA.isSelected())
                System.out.println("Week5 Saturday afternoon is selected");
            if(W5SunA.isSelected())
                System.out.println("Week5 Sunday afternoon is selected");
        }
        if(week5N.isSelected())
            System.out.println("Week5 nights are selected");
        else {
            if(W5MonN.isSelected())
                System.out.println("Week5 Monday night is selected");
            if(W5TueN.isSelected())
                System.out.println("Week5 Tuesday night is selected");
            if(W5WedN.isSelected())
                System.out.println("Week5 Wednesday night is selected");
            if(W5ThurN.isSelected())
                System.out.println("Week5 Thursday night is selected");
            if(W5FriN.isSelected())
                System.out.println("Week Friday night is selected");
            if(W5SatN.isSelected())
                System.out.println("Week5 Saturday night is selected");
            if(W5SunN.isSelected())
                System.out.println("Week5 Sunday night is selected");
        }

        if(week6M.isSelected())
            System.out.println("Week6 mornings are selected");
        else {
            if(W6MonM.isSelected())
                System.out.println("Week6 Monday morning is selected");
            if(W6TueM.isSelected())
                System.out.println("Week6 Tuesday morning is selected");
            if(W6WedM.isSelected())
                System.out.println("Week6 Wednesday morning is selected");
            if(W6ThurM.isSelected())
                System.out.println("Week6 Thursday morning is selected");
            if(W6FriM.isSelected())
                System.out.println("Week6 Friday morning is selected");
            if(W6SatM.isSelected())
                System.out.println("Week6 Saturday morning is selected");
            if(W6SunM.isSelected())
                System.out.println("Week6 Sunday morning is selected");
        }
        if(week6A.isSelected())
            System.out.println("Week6 afternoons are selected");
        else {
            if(W6MonA.isSelected())
                System.out.println("Week6 Monday afternoon is selected");
            if(W6TueA.isSelected())
                System.out.println("Week6 Tuesday afternoon is selected");
            if(W6WedA.isSelected())
                System.out.println("Week6 Wednesday afternoon is selected");
            if(W6ThurA.isSelected())
                System.out.println("Week6 Thursday afternoon is selected");
            if(W6FriA.isSelected())
                System.out.println("Week6 Friday afternoon is selected");
            if(W6SatA.isSelected())
                System.out.println("Week6 Saturday afternoon is selected");
            if(W6SunA.isSelected())
                System.out.println("Week6 Sunday afternoon is selected");
        }
        if(week6N.isSelected())
            System.out.println("Week6 nights are selected");
        else {
            if(W6MonN.isSelected())
                System.out.println("Week6 Monday night is selected");
            if(W6TueN.isSelected())
                System.out.println("Week6 Tuesday night is selected");
            if(W6WedN.isSelected())
                System.out.println("Week6 Wednesday night is selected");
            if(W6ThurN.isSelected())
                System.out.println("Week6 Thursday night is selected");
            if(W6FriN.isSelected())
                System.out.println("Week6 Friday night is selected");
            if(W6SatN.isSelected())
                System.out.println("Week6 Saturday night is selected");
            if(W6SunN.isSelected())
                System.out.println("Week6 Sunday night is selected");
        }

        if(week7M.isSelected())
            System.out.println("Week7 mornings are selected");
        else {
            if(W7MonM.isSelected())
                System.out.println("Week7 Monday morning is selected");
            if(W7TueM.isSelected())
                System.out.println("Week7 Tuesday morning is selected");
            if(W7WedM.isSelected())
                System.out.println("Week7 Wednesday morning is selected");
            if(W7ThurM.isSelected())
                System.out.println("Week7 Thursday morning is selected");
            if(W7FriM.isSelected())
                System.out.println("Week7 Friday morning is selected");
            if(W7SatM.isSelected())
                System.out.println("Week7 Saturday morning is selected");
            if(W7SunM.isSelected())
                System.out.println("Week7 Sunday morning is selected");
        }
        if(week7A.isSelected())
            System.out.println("Week7 afternoons are selected");
        else {
            if(W7MonA.isSelected())
                System.out.println("Week7 Monday afternoon is selected");
            if(W7TueA.isSelected())
                System.out.println("Week7 Tuesday afternoon is selected");
            if(W7WedA.isSelected())
                System.out.println("Week7 Wednesday afternoon is selected");
            if(W7ThurA.isSelected())
                System.out.println("Week7 Thursday afternoon is selected");
            if(W7FriA.isSelected())
                System.out.println("Week7 Friday afternoon is selected");
            if(W7SatA.isSelected())
                System.out.println("Week7 Saturday afternoon is selected");
            if(W7SunA.isSelected())
                System.out.println("Week7 Sunday afternoon is selected");
        }
        if(week7N.isSelected())
            System.out.println("Week7 nights are selected");
        else {
            if(W7MonN.isSelected())
                System.out.println("Week7 Monday night is selected");
            if(W7TueN.isSelected())
                System.out.println("Week7 Tuesday night is selected");
            if(W7WedN.isSelected())
                System.out.println("Week7 Wednesday night is selected");
            if(W7ThurN.isSelected())
                System.out.println("Week7 Thursday night is selected");
            if(W7FriN.isSelected())
                System.out.println("Week7 Friday night is selected");
            if(W7SatN.isSelected())
                System.out.println("Week7 Saturday night is selected");
            if(W7SunN.isSelected())
                System.out.println("Week7 Sunday night is selected");
        }

        if(week8M.isSelected())
            System.out.println("Week8 mornings are selected");
        else {
            if(W8MonM.isSelected())
                System.out.println("Week8 Monday morning is selected");
            if(W8TueM.isSelected())
                System.out.println("Week8 Tuesday morning is selected");
            if(W8WedM.isSelected())
                System.out.println("Week8 Wednesday morning is selected");
            if(W8ThurM.isSelected())
                System.out.println("Week8 Thursday morning is selected");
            if(W8FriM.isSelected())
                System.out.println("Week8 Friday morning is selected");
            if(W8SatM.isSelected())
                System.out.println("Week8 Saturday morning is selected");
            if(W8SunM.isSelected())
                System.out.println("Week8 Sunday morning is selected");
        }
        if(week8A.isSelected())
            System.out.println("Week8 afternoons are selected");
        else {
            if(W8MonA.isSelected())
                System.out.println("Week8 Monday afternoon is selected");
            if(W8TueA.isSelected())
                System.out.println("Week8 Tuesday afternoon is selected");
            if(W8WedA.isSelected())
                System.out.println("Week8 Wednesday afternoon is selected");
            if(W8ThurA.isSelected())
                System.out.println("Week8 Thursday afternoon is selected");
            if(W8FriA.isSelected())
                System.out.println("Week8 Friday afternoon is selected");
            if(W8SatA.isSelected())
                System.out.println("Week8 Saturday afternoon is selected");
            if(W8SunA.isSelected())
                System.out.println("Week8 Sunday afternoon is selected");
        }
        if(week8N.isSelected())
            System.out.println("Week8 nights are selected");
        else {
            if(W8MonN.isSelected())
                System.out.println("Week8 Monday night is selected");
            if(W8TueN.isSelected())
                System.out.println("Week8 Tuesday night is selected");
            if(W8WedN.isSelected())
                System.out.println("Week8 Wednesday night is selected");
            if(W8ThurN.isSelected())
                System.out.println("Week8 Thursday night is selected");
            if(W8FriN.isSelected())
                System.out.println("Week8 Friday night is selected");
            if(W8SatN.isSelected())
                System.out.println("Week8 Saturday night is selected");
            if(W8SunN.isSelected())
                System.out.println("Week8 Sunday night is selected");
        }

        if(week9M.isSelected())
            System.out.println("Week9 mornings are selected");
        else {
            if(W9MonM.isSelected())
                System.out.println("Week9 Monday morning is selected");
            if(W9TueM.isSelected())
                System.out.println("Week9 Tuesday morning is selected");
            if(W9WedM.isSelected())
                System.out.println("Week9 Wednesday morning is selected");
            if(W9ThurM.isSelected())
                System.out.println("Week9 Thursday morning is selected");
            if(W9FriM.isSelected())
                System.out.println("Week9 Friday morning is selected");
            if(W9SatM.isSelected())
                System.out.println("Week9 Saturday morning is selected");
            if(W9SunM.isSelected())
                System.out.println("Week9 Sunday morning is selected");
        }
        if(week9A.isSelected())
            System.out.println("Week9 afternoons are selected");
        else {
            if(W9MonA.isSelected())
                System.out.println("Week9 Monday afternoon is selected");
            if(W9TueA.isSelected())
                System.out.println("Week9 Tuesday afternoon is selected");
            if(W9WedA.isSelected())
                System.out.println("Week9 Wednesday afternoon is selected");
            if(W9ThurA.isSelected())
                System.out.println("Week9 Thursday afternoon is selected");
            if(W9FriA.isSelected())
                System.out.println("Week9 Friday afternoon is selected");
            if(W9SatA.isSelected())
                System.out.println("Week9 Saturday afternoon is selected");
            if(W9SunA.isSelected())
                System.out.println("Week9 Sunday afternoon is selected");
        }
        if(week9N.isSelected())
            System.out.println("Week9 nights are selected");
        else {
            if(W9MonN.isSelected())
                System.out.println("Week9 Monday night is selected");
            if(W9TueN.isSelected())
                System.out.println("Week9 Tuesday night is selected");
            if(W9WedN.isSelected())
                System.out.println("Week9 Wednesday night is selected");
            if(W9ThurN.isSelected())
                System.out.println("Week9 Thursday night is selected");
            if(W9FriN.isSelected())
                System.out.println("Week9 Friday night is selected");
            if(W9SatN.isSelected())
                System.out.println("Week9 Saturday night is selected");
            if(W9SunN.isSelected())
                System.out.println("Week9 Sunday night is selected");
        }

        if(week10M.isSelected())
            System.out.println("Week10 mornings are selected");
        else {
            if(W10MonM.isSelected())
                System.out.println("Week10 Monday morning is selected");
            if(W10TueM.isSelected())
                System.out.println("Week10 Tuesday morning is selected");
            if(W10WedM.isSelected())
                System.out.println("Week10 Wednesday morning is selected");
            if(W10ThurM.isSelected())
                System.out.println("Week10 Thursday morning is selected");
            if(W10FriM.isSelected())
                System.out.println("Week10 Friday morning is selected");
            if(W10SatM.isSelected())
                System.out.println("Week10 Saturday morning is selected");
            if(W10SunM.isSelected())
                System.out.println("Week10 Sunday morning is selected");
        }
        if(week10A.isSelected())
            System.out.println("Week10 afternoons are selected");
        else {
            if(W10MonA.isSelected())
                System.out.println("Week10 Monday afternoon is selected");
            if(W10TueA.isSelected())
                System.out.println("Week10 Tuesday afternoon is selected");
            if(W10WedA.isSelected())
                System.out.println("Week10 Wednesday afternoon is selected");
            if(W10ThurA.isSelected())
                System.out.println("Week10 Thursday afternoon is selected");
            if(W10FriA.isSelected())
                System.out.println("Week10 Friday afternoon is selected");
            if(W10SatA.isSelected())
                System.out.println("Week10 Saturday afternoon is selected");
            if(W10SunA.isSelected())
                System.out.println("Week10 Sunday afternoon is selected");
        }
        if(week10N.isSelected())
            System.out.println("Week10 nights are selected");
        else {
            if(W10MonN.isSelected())
                System.out.println("Week10 Monday night is selected");
            if(W10TueN.isSelected())
                System.out.println("Week10 Tuesday night is selected");
            if(W10WedN.isSelected())
                System.out.println("Week10 Wednesday night is selected");
            if(W10ThurN.isSelected())
                System.out.println("Week10 Thursday night is selected");
            if(W10FriN.isSelected())
                System.out.println("Week10 Friday night is selected");
            if(W10SatN.isSelected())
                System.out.println("Week10 Saturday night is selected");
            if(W10SunN.isSelected())
                System.out.println("Week10 Sunday night is selected");
        }

        if(week11M.isSelected())
            System.out.println("Week11 mornings are selected");
        else {
            if(W11MonM.isSelected())
                System.out.println("Week11 Monday morning is selected");
            if(W11TueM.isSelected())
                System.out.println("Week11 Tuesday morning is selected");
            if(W11WedM.isSelected())
                System.out.println("Week11 Wednesday morning is selected");
            if(W11ThurM.isSelected())
                System.out.println("Week11 Thursday morning is selected");
            if(W11FriM.isSelected())
                System.out.println("Week11 Friday morning is selected");
            if(W11SatM.isSelected())
                System.out.println("Week11 Saturday morning is selected");
            if(W11SunM.isSelected())
                System.out.println("Week11 Sunday morning is selected");
        }
        if(week11A.isSelected())
            System.out.println("Week11 afternoons are selected");
        else {
            if(W11MonA.isSelected())
                System.out.println("Week11 Monday afternoon is selected");
            if(W11TueA.isSelected())
                System.out.println("Week11 Tuesday afternoon is selected");
            if(W11WedA.isSelected())
                System.out.println("Week11 Wednesday afternoon is selected");
            if(W11ThurA.isSelected())
                System.out.println("Week11 Thursday afternoon is selected");
            if(W11FriA.isSelected())
                System.out.println("Week11 Friday afternoon is selected");
            if(W11SatA.isSelected())
                System.out.println("Week11 Saturday afternoon is selected");
            if(W11SunA.isSelected())
                System.out.println("Week11 Sunday afternoon is selected");
        }
        if(week11N.isSelected())
            System.out.println("Week11 nights are selected");
        else {
            if(W11MonN.isSelected())
                System.out.println("Week11 Monday night is selected");
            if(W11TueN.isSelected())
                System.out.println("Week11 Tuesday night is selected");
            if(W11WedN.isSelected())
                System.out.println("Week11 Wednesday night is selected");
            if(W11ThurN.isSelected())
                System.out.println("Week11 Thursday night is selected");
            if(W11FriN.isSelected())
                System.out.println("Week11 Friday night is selected");
            if(W11SatN.isSelected())
                System.out.println("Week11 Saturday night is selected");
            if(W11SunN.isSelected())
                System.out.println("Week11 Sunday night is selected");
        }

        if(week12M.isSelected())
            System.out.println("Week12 mornings are selected");
        else {
            if(W12MonM.isSelected())
                System.out.println("Week12 Monday morning is selected");
            if(W12TueM.isSelected())
                System.out.println("Week12 Tuesday morning is selected");
            if(W12WedM.isSelected())
                System.out.println("Week12 Wednesday morning is selected");
            if(W12ThurM.isSelected())
                System.out.println("Week12 Thursday morning is selected");
            if(W12FriM.isSelected())
                System.out.println("Week12 Friday morning is selected");
            if(W12SatM.isSelected())
                System.out.println("Week12 Saturday morning is selected");
            if(W12SunM.isSelected())
                System.out.println("Week12 Sunday morning is selected");
        }
        if(week12A.isSelected())
            System.out.println("Week12 afternoons are selected");
        else {
            if(W12MonA.isSelected())
                System.out.println("Week12 Monday afternoon is selected");
            if(W12TueA.isSelected())
                System.out.println("Week12 Tuesday afternoon is selected");
            if(W12WedA.isSelected())
                System.out.println("Week12 Wednesday afternoon is selected");
            if(W12ThurA.isSelected())
                System.out.println("Week12 Thursday afternoon is selected");
            if(W12FriA.isSelected())
                System.out.println("Week12 Friday afternoon is selected");
            if(W12SatA.isSelected())
                System.out.println("Week12 Saturday afternoon is selected");
            if(W12SunA.isSelected())
                System.out.println("Week12 Sunday afternoon is selected");
        }
        if(week12N.isSelected())
            System.out.println("Week12 nights are selected");
        else {
            if(W12MonN.isSelected())
                System.out.println("Week12 Monday night is selected");
            if(W12TueN.isSelected())
                System.out.println("Week12 Tuesday night is selected");
            if(W12WedN.isSelected())
                System.out.println("Week12 Wednesday night is selected");
            if(W12ThurN.isSelected())
                System.out.println("Week12 Thursday night is selected");
            if(W12FriN.isSelected())
                System.out.println("Week12 Friday night is selected");
            if(W12SatN.isSelected())
                System.out.println("Week12 Saturday night is selected");
            if(W12SunN.isSelected())
                System.out.println("Week12 Sunday night is selected");
        }

        if(week13M.isSelected())
            System.out.println("Week13 mornings are selected");
        else {
            if(W13MonM.isSelected())
                System.out.println("Week13 Monday morning is selected");
            if(W13TueM.isSelected())
                System.out.println("Week13 Tuesday morning is selected");
            if(W13WedM.isSelected())
                System.out.println("Week13 Wednesday morning is selected");
            if(W13ThurM.isSelected())
                System.out.println("Week13 Thursday morning is selected");
            if(W13FriM.isSelected())
                System.out.println("Week13 Friday morning is selected");
            if(W13SatM.isSelected())
                System.out.println("Week13 Saturday morning is selected");
            if(W13SunM.isSelected())
                System.out.println("Week13 Sunday morning is selected");
        }
        if(week13A.isSelected())
            System.out.println("Week13 afternoons are selected");
        else {
            if(W13MonA.isSelected())
                System.out.println("Week13 Monday afternoon is selected");
            if(W13TueA.isSelected())
                System.out.println("Week13 Tuesday afternoon is selected");
            if(W13WedA.isSelected())
                System.out.println("Week13 Wednesday afternoon is selected");
            if(W13ThurA.isSelected())
                System.out.println("Week13 Thursday afternoon is selected");
            if(W13FriA.isSelected())
                System.out.println("Week13 Friday afternoon is selected");
            if(W13SatA.isSelected())
                System.out.println("Week13 Saturday afternoon is selected");
            if(W13SunA.isSelected())
                System.out.println("Week13 Sunday afternoon is selected");
        }
        if(week13N.isSelected())
            System.out.println("Week13 nights are selected");
        else {
            if(W13MonN.isSelected())
                System.out.println("Week13 Monday night is selected");
            if(W13TueN.isSelected())
                System.out.println("Week13 Tuesday night is selected");
            if(W13WedN.isSelected())
                System.out.println("Week13 Wednesday night is selected");
            if(W13ThurN.isSelected())
                System.out.println("Week13 Thursday night is selected");
            if(W13FriN.isSelected())
                System.out.println("Week13 Friday night is selected");
            if(W13SatN.isSelected())
                System.out.println("Week13 Saturday night is selected");
            if(W13SunN.isSelected())
                System.out.println("Week13 Sunday night is selected");
        }

        if(week14M.isSelected())
            System.out.println("Week14 mornings are selected");
        else {
            if(W14MonM.isSelected())
                System.out.println("Week14 Monday morning is selected");
            if(W14TueM.isSelected())
                System.out.println("Week14 Tuesday morning is selected");
            if(W14WedM.isSelected())
                System.out.println("Week14 Wednesday morning is selected");
            if(W14ThurM.isSelected())
                System.out.println("Week14 Thursday morning is selected");
            if(W14FriM.isSelected())
                System.out.println("Week14 Friday morning is selected");
            if(W14SatM.isSelected())
                System.out.println("Week14 Saturday morning is selected");
            if(W14SunM.isSelected())
                System.out.println("Week14 Sunday morning is selected");
        }
        if(week14A.isSelected())
            System.out.println("Week14 afternoons are selected");
        else {
            if(W14MonA.isSelected())
                System.out.println("Week14 Monday afternoon is selected");
            if(W14TueA.isSelected())
                System.out.println("Week14 Tuesday afternoon is selected");
            if(W14WedA.isSelected())
                System.out.println("Week14 Wednesday afternoon is selected");
            if(W14ThurA.isSelected())
                System.out.println("Week14 Thursday afternoon is selected");
            if(W14FriA.isSelected())
                System.out.println("Week14 Friday afternoon is selected");
            if(W14SatA.isSelected())
                System.out.println("Week14 Saturday afternoon is selected");
            if(W14SunA.isSelected())
                System.out.println("Week14 Sunday afternoon is selected");
        }
        if(week14N.isSelected())
            System.out.println("Week14 nights are selected");
        else {
            if(W14MonN.isSelected())
                System.out.println("Week14 Monday night is selected");
            if(W14TueN.isSelected())
                System.out.println("Week14 Tuesday night is selected");
            if(W14WedN.isSelected())
                System.out.println("Week14 Wednesday night is selected");
            if(W14ThurN.isSelected())
                System.out.println("Week14 Thursday night is selected");
            if(W14FriN.isSelected())
                System.out.println("Week14 Friday night is selected");
            if(W14SatN.isSelected())
                System.out.println("Week14 Saturday night is selected");
            if(W14SunN.isSelected())
                System.out.println("Week14 Sunday night is selected");
        }
    }

    @Override
    public void initializeController() {

        save.setOnMouseReleased(event -> {
            collectInformation();
        });

        /**
         *最上一行选项的点击事件
         */

        MonM.setOnMouseReleased(event -> {
            if(MonM.isSelected()) {
                W1MonM.setSelected(true);
                W2MonM.setSelected(true);
                W3MonM.setSelected(true);
                W4MonM.setSelected(true);
                W5MonM.setSelected(true);
                W6MonM.setSelected(true);
                W7MonM.setSelected(true);
                W8MonM.setSelected(true);
                W9MonM.setSelected(true);
                W10MonM.setSelected(true);
                W11MonM.setSelected(true);
                W12MonM.setSelected(true);
                W13MonM.setSelected(true);
                W14MonM.setSelected(true);
            }
            else {
                W1MonM.setSelected(false);
                W2MonM.setSelected(false);
                W3MonM.setSelected(false);
                W4MonM.setSelected(false);
                W5MonM.setSelected(false);
                W6MonM.setSelected(false);
                W7MonM.setSelected(false);
                W8MonM.setSelected(false);
                W9MonM.setSelected(false);
                W10MonM.setSelected(false);
                W11MonM.setSelected(false);
                W12MonM.setSelected(false);
                W13MonM.setSelected(false);
                W14MonM.setSelected(false);
            }
        });

        MonA.setOnMouseReleased(event -> {
            if(MonA.isSelected()) {
                W1MonA.setSelected(true);
                W2MonA.setSelected(true);
                W3MonA.setSelected(true);
                W4MonA.setSelected(true);
                W5MonA.setSelected(true);
                W6MonA.setSelected(true);
                W7MonA.setSelected(true);
                W8MonA.setSelected(true);
                W9MonA.setSelected(true);
                W10MonA.setSelected(true);
                W11MonA.setSelected(true);
                W12MonA.setSelected(true);
                W13MonA.setSelected(true);
                W14MonA.setSelected(true);
            }
            else {
                W1MonA.setSelected(false);
                W2MonA.setSelected(false);
                W3MonA.setSelected(false);
                W4MonA.setSelected(false);
                W5MonA.setSelected(false);
                W6MonA.setSelected(false);
                W7MonA.setSelected(false);
                W8MonA.setSelected(false);
                W9MonA.setSelected(false);
                W10MonA.setSelected(false);
                W11MonA.setSelected(false);
                W12MonA.setSelected(false);
                W13MonA.setSelected(false);
                W14MonA.setSelected(false);
            }
        });

        MonN.setOnMouseReleased(event -> {
            if(MonN.isSelected()) {
                W1MonN.setSelected(true);
                W2MonN.setSelected(true);
                W3MonN.setSelected(true);
                W4MonN.setSelected(true);
                W5MonN.setSelected(true);
                W6MonN.setSelected(true);
                W7MonN.setSelected(true);
                W8MonN.setSelected(true);
                W9MonN.setSelected(true);
                W10MonN.setSelected(true);
                W11MonN.setSelected(true);
                W12MonN.setSelected(true);
                W13MonN.setSelected(true);
                W14MonN.setSelected(true);
            }
            else {
                W1MonN.setSelected(false);
                W2MonN.setSelected(false);
                W3MonN.setSelected(false);
                W4MonN.setSelected(false);
                W5MonN.setSelected(false);
                W6MonN.setSelected(false);
                W7MonN.setSelected(false);
                W8MonN.setSelected(false);
                W9MonN.setSelected(false);
                W10MonN.setSelected(false);
                W11MonN.setSelected(false);
                W12MonN.setSelected(false);
                W13MonN.setSelected(false);
                W14MonN.setSelected(false);
            }
        });

        TueM.setOnMouseReleased(event -> {
            if(TueM.isSelected()) {
                W1TueM.setSelected(true);
                W2TueM.setSelected(true);
                W3TueM.setSelected(true);
                W4TueM.setSelected(true);
                W5TueM.setSelected(true);
                W6TueM.setSelected(true);
                W7TueM.setSelected(true);
                W8TueM.setSelected(true);
                W9TueM.setSelected(true);
                W10TueM.setSelected(true);
                W11TueM.setSelected(true);
                W12TueM.setSelected(true);
                W13TueM.setSelected(true);
                W14TueM.setSelected(true);
            }
            else {
                W1TueM.setSelected(false);
                W2TueM.setSelected(false);
                W3TueM.setSelected(false);
                W4TueM.setSelected(false);
                W5TueM.setSelected(false);
                W6TueM.setSelected(false);
                W7TueM.setSelected(false);
                W8TueM.setSelected(false);
                W9TueM.setSelected(false);
                W10TueM.setSelected(false);
                W11TueM.setSelected(false);
                W12TueM.setSelected(false);
                W13TueM.setSelected(false);
                W14TueM.setSelected(false);
            }
        });

        TueA.setOnMouseReleased(event -> {
            if(TueA.isSelected()) {
                W1TueA.setSelected(true);
                W2TueA.setSelected(true);
                W3TueA.setSelected(true);
                W4TueA.setSelected(true);
                W5TueA.setSelected(true);
                W6TueA.setSelected(true);
                W7TueA.setSelected(true);
                W8TueA.setSelected(true);
                W9TueA.setSelected(true);
                W10TueA.setSelected(true);
                W11TueA.setSelected(true);
                W12TueA.setSelected(true);
                W13TueA.setSelected(true);
                W14TueA.setSelected(true);
            }
            else {
                W1TueA.setSelected(false);
                W2TueA.setSelected(false);
                W3TueA.setSelected(false);
                W4TueA.setSelected(false);
                W5TueA.setSelected(false);
                W6TueA.setSelected(false);
                W7TueA.setSelected(false);
                W8TueA.setSelected(false);
                W9TueA.setSelected(false);
                W10TueA.setSelected(false);
                W11TueA.setSelected(false);
                W12TueA.setSelected(false);
                W13TueA.setSelected(false);
                W14TueA.setSelected(false);
            }
        });

        TueN.setOnMouseReleased(event -> {
            if(TueN.isSelected()) {
                W1TueN.setSelected(true);
                W2TueN.setSelected(true);
                W3TueN.setSelected(true);
                W4TueN.setSelected(true);
                W5TueN.setSelected(true);
                W6TueN.setSelected(true);
                W7TueN.setSelected(true);
                W8TueN.setSelected(true);
                W9TueN.setSelected(true);
                W10TueN.setSelected(true);
                W11TueN.setSelected(true);
                W12TueN.setSelected(true);
                W13TueN.setSelected(true);
                W14TueN.setSelected(true);
            }
            else {
                W1TueN.setSelected(false);
                W2TueN.setSelected(false);
                W3TueN.setSelected(false);
                W4TueN.setSelected(false);
                W5TueN.setSelected(false);
                W6TueN.setSelected(false);
                W7TueN.setSelected(false);
                W8TueN.setSelected(false);
                W9TueN.setSelected(false);
                W10TueN.setSelected(false);
                W11TueN.setSelected(false);
                W12TueN.setSelected(false);
                W13TueN.setSelected(false);
                W14TueN.setSelected(false);
            }
        });

        WedM.setOnMouseReleased(event -> {
            if(WedM.isSelected()) {
                W1WedM.setSelected(true);
                W2WedM.setSelected(true);
                W3WedM.setSelected(true);
                W4WedM.setSelected(true);
                W5WedM.setSelected(true);
                W6WedM.setSelected(true);
                W7WedM.setSelected(true);
                W8WedM.setSelected(true);
                W9WedM.setSelected(true);
                W10WedM.setSelected(true);
                W11WedM.setSelected(true);
                W12WedM.setSelected(true);
                W13WedM.setSelected(true);
                W14WedM.setSelected(true);
            }
            else {
                W1WedM.setSelected(false);
                W2WedM.setSelected(false);
                W3WedM.setSelected(false);
                W4WedM.setSelected(false);
                W5WedM.setSelected(false);
                W6WedM.setSelected(false);
                W7WedM.setSelected(false);
                W8WedM.setSelected(false);
                W9WedM.setSelected(false);
                W10WedM.setSelected(false);
                W11WedM.setSelected(false);
                W12WedM.setSelected(false);
                W13WedM.setSelected(false);
                W14WedM.setSelected(false);
            }
        });

        WedA.setOnMouseReleased(event -> {
            if(WedA.isSelected()) {
                W1WedA.setSelected(true);
                W2WedA.setSelected(true);
                W3WedA.setSelected(true);
                W4WedA.setSelected(true);
                W5WedA.setSelected(true);
                W6WedA.setSelected(true);
                W7WedA.setSelected(true);
                W8WedA.setSelected(true);
                W9WedA.setSelected(true);
                W10WedA.setSelected(true);
                W11WedA.setSelected(true);
                W12WedA.setSelected(true);
                W13WedA.setSelected(true);
                W14WedA.setSelected(true);
            }
            else {
                W1WedA.setSelected(false);
                W2WedA.setSelected(false);
                W3WedA.setSelected(false);
                W4WedA.setSelected(false);
                W5WedA.setSelected(false);
                W6WedA.setSelected(false);
                W7WedA.setSelected(false);
                W8WedA.setSelected(false);
                W9WedA.setSelected(false);
                W10WedA.setSelected(false);
                W11WedA.setSelected(false);
                W12WedA.setSelected(false);
                W13WedA.setSelected(false);
                W14WedA.setSelected(false);
            }
        });

        WedN.setOnMouseReleased(event -> {
            if(WedN.isSelected()) {
                W1WedN.setSelected(true);
                W2WedN.setSelected(true);
                W3WedN.setSelected(true);
                W4WedN.setSelected(true);
                W5WedN.setSelected(true);
                W6WedN.setSelected(true);
                W7WedN.setSelected(true);
                W8WedN.setSelected(true);
                W9WedN.setSelected(true);
                W10WedN.setSelected(true);
                W11WedN.setSelected(true);
                W12WedN.setSelected(true);
                W13WedN.setSelected(true);
                W14WedN.setSelected(true);
            }
            else {
                W1WedN.setSelected(false);
                W2WedN.setSelected(false);
                W3WedN.setSelected(false);
                W4WedN.setSelected(false);
                W5WedN.setSelected(false);
                W6WedN.setSelected(false);
                W7WedN.setSelected(false);
                W8WedN.setSelected(false);
                W9WedN.setSelected(false);
                W10WedN.setSelected(false);
                W11WedN.setSelected(false);
                W12WedN.setSelected(false);
                W13WedN.setSelected(false);
                W14WedN.setSelected(false);
            }
        });

        ThurM.setOnMouseReleased(event -> {
            if(ThurM.isSelected()) {
                W1ThurM.setSelected(true);
                W2ThurM.setSelected(true);
                W3ThurM.setSelected(true);
                W4ThurM.setSelected(true);
                W5ThurM.setSelected(true);
                W6ThurM.setSelected(true);
                W7ThurM.setSelected(true);
                W8ThurM.setSelected(true);
                W9ThurM.setSelected(true);
                W10ThurM.setSelected(true);
                W11ThurM.setSelected(true);
                W12ThurM.setSelected(true);
                W13ThurM.setSelected(true);
                W14ThurM.setSelected(true);}
            else {
                W1ThurM.setSelected(false);
                W2ThurM.setSelected(false);
                W3ThurM.setSelected(false);
                W4ThurM.setSelected(false);
                W5ThurM.setSelected(false);
                W6ThurM.setSelected(false);
                W7ThurM.setSelected(false);
                W8ThurM.setSelected(false);
                W9ThurM.setSelected(false);
                W10ThurM.setSelected(false);
                W11ThurM.setSelected(false);
                W12ThurM.setSelected(false);
                W13ThurM.setSelected(false);
                W14ThurM.setSelected(false);
            }
        });

        ThurA.setOnMouseReleased(event -> {
            if(ThurA.isSelected()) {
                W1ThurA.setSelected(true);
                W2ThurA.setSelected(true);
                W3ThurA.setSelected(true);
                W4ThurA.setSelected(true);
                W5ThurA.setSelected(true);
                W6ThurA.setSelected(true);
                W7ThurA.setSelected(true);
                W8ThurA.setSelected(true);
                W9ThurA.setSelected(true);
                W10ThurA.setSelected(true);
                W11ThurA.setSelected(true);
                W12ThurA.setSelected(true);
                W13ThurA.setSelected(true);
                W14ThurA.setSelected(true);}
            else {
                W1ThurA.setSelected(false);
                W2ThurA.setSelected(false);
                W3ThurA.setSelected(false);
                W4ThurA.setSelected(false);
                W5ThurA.setSelected(false);
                W6ThurA.setSelected(false);
                W7ThurA.setSelected(false);
                W8ThurA.setSelected(false);
                W9ThurA.setSelected(false);
                W10ThurA.setSelected(false);
                W11ThurA.setSelected(false);
                W12ThurA.setSelected(false);
                W13ThurA.setSelected(false);
                W14ThurA.setSelected(false);
            }
        });

        ThurN.setOnMouseReleased(event -> {
            if(ThurN.isSelected()) {
                W1ThurN.setSelected(true);
                W2ThurN.setSelected(true);
                W3ThurN.setSelected(true);
                W4ThurN.setSelected(true);
                W5ThurN.setSelected(true);
                W6ThurN.setSelected(true);
                W7ThurN.setSelected(true);
                W8ThurN.setSelected(true);
                W9ThurN.setSelected(true);
                W10ThurN.setSelected(true);
                W11ThurN.setSelected(true);
                W12ThurN.setSelected(true);
                W13ThurN.setSelected(true);
                W14ThurN.setSelected(true);}
            else {
                W1ThurN.setSelected(false);
                W2ThurN.setSelected(false);
                W3ThurN.setSelected(false);
                W4ThurN.setSelected(false);
                W5ThurN.setSelected(false);
                W6ThurN.setSelected(false);
                W7ThurN.setSelected(false);
                W8ThurN.setSelected(false);
                W9ThurN.setSelected(false);
                W10ThurN.setSelected(false);
                W11ThurN.setSelected(false);
                W12ThurN.setSelected(false);
                W13ThurN.setSelected(false);
                W14ThurN.setSelected(false);
            }
        });

        FriM.setOnMouseReleased(event -> {
            if(FriM.isSelected()) {
                W1FriM.setSelected(true);
                W2FriM.setSelected(true);
                W3FriM.setSelected(true);
                W4FriM.setSelected(true);
                W5FriM.setSelected(true);
                W6FriM.setSelected(true);
                W7FriM.setSelected(true);
                W8FriM.setSelected(true);
                W9FriM.setSelected(true);
                W10FriM.setSelected(true);
                W11FriM.setSelected(true);
                W12FriM.setSelected(true);
                W13FriM.setSelected(true);
                W14FriM.setSelected(true);
            }
            else {
                W1FriM.setSelected(false);
                W2FriM.setSelected(false);
                W3FriM.setSelected(false);
                W4FriM.setSelected(false);
                W5FriM.setSelected(false);
                W6FriM.setSelected(false);
                W7FriM.setSelected(false);
                W8FriM.setSelected(false);
                W9FriM.setSelected(false);
                W10FriM.setSelected(false);
                W11FriM.setSelected(false);
                W12FriM.setSelected(false);
                W13FriM.setSelected(false);
                W14FriM.setSelected(false);
            }
        });

        FriA.setOnMouseReleased(event -> {
            if(FriA.isSelected()) {
                W1FriA.setSelected(true);
                W2FriA.setSelected(true);
                W3FriA.setSelected(true);
                W4FriA.setSelected(true);
                W5FriA.setSelected(true);
                W6FriA.setSelected(true);
                W7FriA.setSelected(true);
                W8FriA.setSelected(true);
                W9FriA.setSelected(true);
                W10FriA.setSelected(true);
                W11FriA.setSelected(true);
                W12FriA.setSelected(true);
                W13FriA.setSelected(true);
                W14FriA.setSelected(true);
            }
            else {
                W1FriA.setSelected(false);
                W2FriA.setSelected(false);
                W3FriA.setSelected(false);
                W4FriA.setSelected(false);
                W5FriA.setSelected(false);
                W6FriA.setSelected(false);
                W7FriA.setSelected(false);
                W8FriA.setSelected(false);
                W9FriA.setSelected(false);
                W10FriA.setSelected(false);
                W11FriA.setSelected(false);
                W12FriA.setSelected(false);
                W13FriA.setSelected(false);
                W14FriA.setSelected(false);
            }
        });

        FriN.setOnMouseReleased(event -> {
            if(FriN.isSelected()) {
                W1FriN.setSelected(true);
                W2FriN.setSelected(true);
                W3FriN.setSelected(true);
                W4FriN.setSelected(true);
                W5FriN.setSelected(true);
                W6FriN.setSelected(true);
                W7FriN.setSelected(true);
                W8FriN.setSelected(true);
                W9FriN.setSelected(true);
                W10FriN.setSelected(true);
                W11FriN.setSelected(true);
                W12FriN.setSelected(true);
                W13FriN.setSelected(true);
                W14FriN.setSelected(true);
            }
            else {
                W1FriN.setSelected(false);
                W2FriN.setSelected(false);
                W3FriN.setSelected(false);
                W4FriN.setSelected(false);
                W5FriN.setSelected(false);
                W6FriN.setSelected(false);
                W7FriN.setSelected(false);
                W8FriN.setSelected(false);
                W9FriN.setSelected(false);
                W10FriN.setSelected(false);
                W11FriN.setSelected(false);
                W12FriN.setSelected(false);
                W13FriN.setSelected(false);
                W14FriN.setSelected(false);
            }
        });

        SatM.setOnMouseReleased(event -> {
            if(SatM.isSelected()) {
                W1SatM.setSelected(true);
                W2SatM.setSelected(true);
                W3SatM.setSelected(true);
                W4SatM.setSelected(true);
                W5SatM.setSelected(true);
                W6SatM.setSelected(true);
                W7SatM.setSelected(true);
                W8SatM.setSelected(true);
                W9SatM.setSelected(true);
                W10SatM.setSelected(true);
                W11SatM.setSelected(true);
                W12SatM.setSelected(true);
                W13SatM.setSelected(true);
                W14SatM.setSelected(true);
            }
            else {
                W1SatM.setSelected(false);
                W2SatM.setSelected(false);
                W3SatM.setSelected(false);
                W4SatM.setSelected(false);
                W5SatM.setSelected(false);
                W6SatM.setSelected(false);
                W7SatM.setSelected(false);
                W8SatM.setSelected(false);
                W9SatM.setSelected(false);
                W10SatM.setSelected(false);
                W11SatM.setSelected(false);
                W12SatM.setSelected(false);
                W13SatM.setSelected(false);
                W14SatM.setSelected(false);
            }
        });

        SatA.setOnMouseReleased(event -> {
            if(SatA.isSelected()) {
                W1SatA.setSelected(true);
                W2SatA.setSelected(true);
                W3SatA.setSelected(true);
                W4SatA.setSelected(true);
                W5SatA.setSelected(true);
                W6SatA.setSelected(true);
                W7SatA.setSelected(true);
                W8SatA.setSelected(true);
                W9SatA.setSelected(true);
                W10SatA.setSelected(true);
                W11SatA.setSelected(true);
                W12SatA.setSelected(true);
                W13SatA.setSelected(true);
                W14SatA.setSelected(true);
            }
            else {
                W1SatA.setSelected(false);
                W2SatA.setSelected(false);
                W3SatA.setSelected(false);
                W4SatA.setSelected(false);
                W5SatA.setSelected(false);
                W6SatA.setSelected(false);
                W7SatA.setSelected(false);
                W8SatA.setSelected(false);
                W9SatA.setSelected(false);
                W10SatA.setSelected(false);
                W11SatA.setSelected(false);
                W12SatA.setSelected(false);
                W13SatA.setSelected(false);
                W14SatA.setSelected(false);
            }
        });

        SatN.setOnMouseReleased(event -> {
            if(SatN.isSelected()) {
                W1SatN.setSelected(true);
                W2SatN.setSelected(true);
                W3SatN.setSelected(true);
                W4SatN.setSelected(true);
                W5SatN.setSelected(true);
                W6SatN.setSelected(true);
                W7SatN.setSelected(true);
                W8SatN.setSelected(true);
                W9SatN.setSelected(true);
                W10SatN.setSelected(true);
                W11SatN.setSelected(true);
                W12SatN.setSelected(true);
                W13SatN.setSelected(true);
                W14SatN.setSelected(true);
            }
            else {
                W1SatN.setSelected(false);
                W2SatN.setSelected(false);
                W3SatN.setSelected(false);
                W4SatN.setSelected(false);
                W5SatN.setSelected(false);
                W6SatN.setSelected(false);
                W7SatN.setSelected(false);
                W8SatN.setSelected(false);
                W9SatN.setSelected(false);
                W10SatN.setSelected(false);
                W11SatN.setSelected(false);
                W12SatN.setSelected(false);
                W13SatN.setSelected(false);
                W14SatN.setSelected(false);
            }
        });

        SunM.setOnMouseReleased(event -> {
            if(SunM.isSelected()) {
                W1SunM.setSelected(true);
                W2SunM.setSelected(true);
                W3SunM.setSelected(true);
                W4SunM.setSelected(true);
                W5SunM.setSelected(true);
                W6SunM.setSelected(true);
                W7SunM.setSelected(true);
                W8SunM.setSelected(true);
                W9SunM.setSelected(true);
                W10SunM.setSelected(true);
                W11SunM.setSelected(true);
                W12SunM.setSelected(true);
                W13SunM.setSelected(true);
                W14SunM.setSelected(true);
            }
            else {
                W1SunM.setSelected(false);
                W2SunM.setSelected(false);
                W3SunM.setSelected(false);
                W4SunM.setSelected(false);
                W5SunM.setSelected(false);
                W6SunM.setSelected(false);
                W7SunM.setSelected(false);
                W8SunM.setSelected(false);
                W9SunM.setSelected(false);
                W10SunM.setSelected(false);
                W11SunM.setSelected(false);
                W12SunM.setSelected(false);
                W13SunM.setSelected(false);
                W14SunM.setSelected(false);
            }
        });

        SunA.setOnMouseReleased(event -> {
            if(SunA.isSelected()) {
                W1SunA.setSelected(true);
                W2SunA.setSelected(true);
                W3SunA.setSelected(true);
                W4SunA.setSelected(true);
                W5SunA.setSelected(true);
                W6SunA.setSelected(true);
                W7SunA.setSelected(true);
                W8SunA.setSelected(true);
                W9SunA.setSelected(true);
                W10SunA.setSelected(true);
                W11SunA.setSelected(true);
                W12SunA.setSelected(true);
                W13SunA.setSelected(true);
                W14SunA.setSelected(true);
            }
            else {
                W1SunA.setSelected(false);
                W2SunA.setSelected(false);
                W3SunA.setSelected(false);
                W4SunA.setSelected(false);
                W5SunA.setSelected(false);
                W6SunA.setSelected(false);
                W7SunA.setSelected(false);
                W8SunA.setSelected(false);
                W9SunA.setSelected(false);
                W10SunA.setSelected(false);
                W11SunA.setSelected(false);
                W12SunA.setSelected(false);
                W13SunA.setSelected(false);
                W14SunA.setSelected(false);
            }
        });

        SunN.setOnMouseReleased(event -> {
            if(SunN.isSelected()) {
                W1SunN.setSelected(true);
                W2SunN.setSelected(true);
                W3SunN.setSelected(true);
                W4SunN.setSelected(true);
                W5SunN.setSelected(true);
                W6SunN.setSelected(true);
                W7SunN.setSelected(true);
                W8SunN.setSelected(true);
                W9SunN.setSelected(true);
                W10SunN.setSelected(true);
                W11SunN.setSelected(true);
                W12SunN.setSelected(true);
                W13SunN.setSelected(true);
                W14SunN.setSelected(true);
            }
            else {
                W1SunN.setSelected(false);
                W2SunN.setSelected(false);
                W3SunN.setSelected(false);
                W4SunN.setSelected(false);
                W5SunN.setSelected(false);
                W6SunN.setSelected(false);
                W7SunN.setSelected(false);
                W8SunN.setSelected(false);
                W9SunN.setSelected(false);
                W10SunN.setSelected(false);
                W11SunN.setSelected(false);
                W12SunN.setSelected(false);
                W13SunN.setSelected(false);
                W14SunN.setSelected(false);
            }
        });

        /**
         * 最左一列选项的点击事件
         */

        week1M.setOnMouseReleased(event -> {
            if(week1M.isSelected()) {
                W1MonM.setSelected(true);
                W1TueM.setSelected(true);
                W1WedM.setSelected(true);
                W1ThurM.setSelected(true);
                W1FriM.setSelected(true);
                W1SatM.setSelected(true);
                W1SunM.setSelected(true);
            }
            else {
                W1MonM.setSelected(false);
                W1TueM.setSelected(false);
                W1WedM.setSelected(false);
                W1ThurM.setSelected(false);
                W1FriM.setSelected(false);
                W1SatM.setSelected(false);
                W1SunM.setSelected(false);
            }
        });

        week1A.setOnMouseReleased(event -> {
            if(week1A.isSelected()) {
                W1MonA.setSelected(true);
                W1TueA.setSelected(true);
                W1WedA.setSelected(true);
                W1ThurA.setSelected(true);
                W1FriA.setSelected(true);
                W1SatA.setSelected(true);
                W1SunA.setSelected(true);
            }
            else {
                W1MonA.setSelected(false);
                W1TueA.setSelected(false);
                W1WedA.setSelected(false);
                W1ThurA.setSelected(false);
                W1FriA.setSelected(false);
                W1SatA.setSelected(false);
                W1SunA.setSelected(false);
            }
        });

        week1N.setOnMouseReleased(event -> {
            if(week1N.isSelected()) {
                W1MonN.setSelected(true);
                W1TueN.setSelected(true);
                W1WedN.setSelected(true);
                W1ThurN.setSelected(true);
                W1FriN.setSelected(true);
                W1SatN.setSelected(true);
                W1SunN.setSelected(true);
            }
            else {
                W1MonN.setSelected(false);
                W1TueN.setSelected(false);
                W1WedN.setSelected(false);
                W1ThurN.setSelected(false);
                W1FriN.setSelected(false);
                W1SatN.setSelected(false);
                W1SunN.setSelected(false);
            }
        });

        week2M.setOnMouseReleased(event -> {
            if(week2M.isSelected()) {
                W2MonM.setSelected(true);
                W2TueM.setSelected(true);
                W2WedM.setSelected(true);
                W2ThurM.setSelected(true);
                W2FriM.setSelected(true);
                W2SatM.setSelected(true);
                W2SunM.setSelected(true);
            }
            else {
                W2MonM.setSelected(false);
                W2TueM.setSelected(false);
                W2WedM.setSelected(false);
                W2ThurM.setSelected(false);
                W2FriM.setSelected(false);
                W2SatM.setSelected(false);
                W2SunM.setSelected(false);
            }
        });

        week2A.setOnMouseReleased(event -> {
            if(week2A.isSelected()) {
                W2MonA.setSelected(true);
                W2TueA.setSelected(true);
                W2WedA.setSelected(true);
                W2ThurA.setSelected(true);
                W2FriA.setSelected(true);
                W2SatA.setSelected(true);
                W2SunA.setSelected(true);
            }
            else {
                W2MonA.setSelected(false);
                W2TueA.setSelected(false);
                W2WedA.setSelected(false);
                W2ThurA.setSelected(false);
                W2FriA.setSelected(false);
                W2SatA.setSelected(false);
                W2SunA.setSelected(false);
            }
        });

        week2N.setOnMouseReleased(event -> {
            if(week2N.isSelected()) {
                W2MonN.setSelected(true);
                W2TueN.setSelected(true);
                W2WedN.setSelected(true);
                W2ThurN.setSelected(true);
                W2FriN.setSelected(true);
                W2SatN.setSelected(true);
                W2SunN.setSelected(true);
            }
            else {
                W2MonN.setSelected(false);
                W2TueN.setSelected(false);
                W2WedN.setSelected(false);
                W2ThurN.setSelected(false);
                W2FriN.setSelected(false);
                W2SatN.setSelected(false);
                W2SunN.setSelected(false);
            }
        });

        week3M.setOnMouseReleased(event -> {
            if(week3M.isSelected()) {
                W3MonM.setSelected(true);
                W3TueM.setSelected(true);
                W3WedM.setSelected(true);
                W3ThurM.setSelected(true);
                W3FriM.setSelected(true);
                W3SatM.setSelected(true);
                W3SunM.setSelected(true);
            }
            else {
                W3MonM.setSelected(false);
                W3TueM.setSelected(false);
                W3WedM.setSelected(false);
                W3ThurM.setSelected(false);
                W3FriM.setSelected(false);
                W3SatM.setSelected(false);
                W3SunM.setSelected(false);
            }
        });

        week3A.setOnMouseReleased(event -> {
            if(week3A.isSelected()) {
                W3MonA.setSelected(true);
                W3TueA.setSelected(true);
                W3WedA.setSelected(true);
                W3ThurA.setSelected(true);
                W3FriA.setSelected(true);
                W3SatA.setSelected(true);
                W3SunA.setSelected(true);
            }
            else {
                W3MonA.setSelected(false);
                W3TueA.setSelected(false);
                W3WedA.setSelected(false);
                W3ThurA.setSelected(false);
                W3FriA.setSelected(false);
                W3SatA.setSelected(false);
                W3SunA.setSelected(false);
            }
        });

        week3N.setOnMouseReleased(event -> {
            if(week3N.isSelected()) {
                W3MonN.setSelected(true);
                W3TueN.setSelected(true);
                W3WedN.setSelected(true);
                W3ThurN.setSelected(true);
                W3FriN.setSelected(true);
                W3SatN.setSelected(true);
                W3SunN.setSelected(true);
            }
            else {
                W3MonN.setSelected(false);
                W3TueN.setSelected(false);
                W3WedN.setSelected(false);
                W3ThurN.setSelected(false);
                W3FriN.setSelected(false);
                W3SatN.setSelected(false);
                W3SunN.setSelected(false);
            }
        });

        week4M.setOnMouseReleased(event -> {
            if(week4M.isSelected()) {
                W4MonM.setSelected(true);
                W4TueM.setSelected(true);
                W4WedM.setSelected(true);
                W4ThurM.setSelected(true);
                W4FriM.setSelected(true);
                W4SatM.setSelected(true);
                W4SunM.setSelected(true);
            }
            else {
                W4MonM.setSelected(false);
                W4TueM.setSelected(false);
                W4WedM.setSelected(false);
                W4ThurM.setSelected(false);
                W4FriM.setSelected(false);
                W4SatM.setSelected(false);
                W4SunM.setSelected(false);
            }
        });

        week4A.setOnMouseReleased(event -> {
            if(week4A.isSelected()) {
                W4MonA.setSelected(true);
                W4TueA.setSelected(true);
                W4WedA.setSelected(true);
                W4ThurA.setSelected(true);
                W4FriA.setSelected(true);
                W4SatA.setSelected(true);
                W4SunA.setSelected(true);
            }
            else {
                W4MonA.setSelected(false);
                W4TueA.setSelected(false);
                W4WedA.setSelected(false);
                W4ThurA.setSelected(false);
                W4FriA.setSelected(false);
                W4SatA.setSelected(false);
                W4SunA.setSelected(false);
            }
        });

        week4N.setOnMouseReleased(event -> {
            if(week4N.isSelected()) {
                W4MonN.setSelected(true);
                W4TueN.setSelected(true);
                W4WedN.setSelected(true);
                W4ThurN.setSelected(true);
                W4FriN.setSelected(true);
                W4SatN.setSelected(true);
                W4SunN.setSelected(true);
            }
            else {
                W4MonN.setSelected(false);
                W4TueN.setSelected(false);
                W4WedN.setSelected(false);
                W4ThurN.setSelected(false);
                W4FriN.setSelected(false);
                W4SatN.setSelected(false);
                W4SunN.setSelected(false);
            }
        });

        week5M.setOnMouseReleased(event -> {
            if(week5M.isSelected()) {
                W5MonM.setSelected(true);
                W5TueM.setSelected(true);
                W5WedM.setSelected(true);
                W5ThurM.setSelected(true);
                W5FriM.setSelected(true);
                W5SatM.setSelected(true);
                W5SunM.setSelected(true);
            }
            else {
                W5MonM.setSelected(false);
                W5TueM.setSelected(false);
                W5WedM.setSelected(false);
                W5ThurM.setSelected(false);
                W5FriM.setSelected(false);
                W5SatM.setSelected(false);
                W5SunM.setSelected(false);
            }
        });

        week5A.setOnMouseReleased(event -> {
            if(week5A.isSelected()) {
                W5MonA.setSelected(true);
                W5TueA.setSelected(true);
                W5WedA.setSelected(true);
                W5ThurA.setSelected(true);
                W5FriA.setSelected(true);
                W5SatA.setSelected(true);
                W5SunA.setSelected(true);
            }
            else {
                W5MonA.setSelected(false);
                W5TueA.setSelected(false);
                W5WedA.setSelected(false);
                W5ThurA.setSelected(false);
                W5FriA.setSelected(false);
                W5SatA.setSelected(false);
                W5SunA.setSelected(false);
            }
        });

        week5N.setOnMouseReleased(event -> {
            if(week5N.isSelected()) {
                W5MonN.setSelected(true);
                W5TueN.setSelected(true);
                W5WedN.setSelected(true);
                W5ThurN.setSelected(true);
                W5FriN.setSelected(true);
                W5SatN.setSelected(true);
                W5SunN.setSelected(true);
            }
            else {
                W5MonN.setSelected(false);
                W5TueN.setSelected(false);
                W5WedN.setSelected(false);
                W5ThurN.setSelected(false);
                W5FriN.setSelected(false);
                W5SatN.setSelected(false);
                W5SunN.setSelected(false);
            }
        });

        week6M.setOnMouseReleased(event -> {
            if(week6M.isSelected()) {
                W6MonM.setSelected(true);
                W6TueM.setSelected(true);
                W6WedM.setSelected(true);
                W6ThurM.setSelected(true);
                W6FriM.setSelected(true);
                W6SatM.setSelected(true);
                W6SunM.setSelected(true);
            }
            else {
                W6MonM.setSelected(false);
                W6TueM.setSelected(false);
                W6WedM.setSelected(false);
                W6ThurM.setSelected(false);
                W6FriM.setSelected(false);
                W6SatM.setSelected(false);
                W6SunM.setSelected(false);
            }
        });

        week6A.setOnMouseReleased(event -> {
            if(week6A.isSelected()) {
                W6MonA.setSelected(true);
                W6TueA.setSelected(true);
                W6WedA.setSelected(true);
                W6ThurA.setSelected(true);
                W6FriA.setSelected(true);
                W6SatA.setSelected(true);
                W6SunA.setSelected(true);
            }
            else {
                W6MonA.setSelected(false);
                W6TueA.setSelected(false);
                W6WedA.setSelected(false);
                W6ThurA.setSelected(false);
                W6FriA.setSelected(false);
                W6SatA.setSelected(false);
                W6SunA.setSelected(false);
            }
        });

        week6N.setOnMouseReleased(event -> {
            if(week6N.isSelected()) {
                W6MonN.setSelected(true);
                W6TueN.setSelected(true);
                W6WedN.setSelected(true);
                W6ThurN.setSelected(true);
                W6FriN.setSelected(true);
                W6SatN.setSelected(true);
                W6SunN.setSelected(true);
            }
            else {
                W6MonN.setSelected(false);
                W6TueN.setSelected(false);
                W6WedN.setSelected(false);
                W6ThurN.setSelected(false);
                W6FriN.setSelected(false);
                W6SatN.setSelected(false);
                W6SunN.setSelected(false);
            }
        });

        week7M.setOnMouseReleased(event -> {
            if(week7M.isSelected()) {
                W7MonM.setSelected(true);
                W7TueM.setSelected(true);
                W7WedM.setSelected(true);
                W7ThurM.setSelected(true);
                W7FriM.setSelected(true);
                W7SatM.setSelected(true);
                W7SunM.setSelected(true);
            }
            else {
                W7MonM.setSelected(false);
                W7TueM.setSelected(false);
                W7WedM.setSelected(false);
                W7ThurM.setSelected(false);
                W7FriM.setSelected(false);
                W7SatM.setSelected(false);
                W7SunM.setSelected(false);
            }
        });

        week7A.setOnMouseReleased(event -> {
            if(week7A.isSelected()) {
                W7MonA.setSelected(true);
                W7TueA.setSelected(true);
                W7WedA.setSelected(true);
                W7ThurA.setSelected(true);
                W7FriA.setSelected(true);
                W7SatA.setSelected(true);
                W7SunA.setSelected(true);
            }
            else {
                W7MonA.setSelected(false);
                W7TueA.setSelected(false);
                W7WedA.setSelected(false);
                W7ThurA.setSelected(false);
                W7FriA.setSelected(false);
                W7SatA.setSelected(false);
                W7SunA.setSelected(false);
            }
        });

        week7N.setOnMouseReleased(event -> {
            if(week7N.isSelected()) {
                W7MonN.setSelected(true);
                W7TueN.setSelected(true);
                W7WedN.setSelected(true);
                W7ThurN.setSelected(true);
                W7FriN.setSelected(true);
                W7SatN.setSelected(true);
                W7SunN.setSelected(true);
            }
            else {
                W7MonN.setSelected(false);
                W7TueN.setSelected(false);
                W7WedN.setSelected(false);
                W7ThurN.setSelected(false);
                W7FriN.setSelected(false);
                W7SatN.setSelected(false);
                W7SunN.setSelected(false);
            }
        });

        week8M.setOnMouseReleased(event -> {
            if(week8M.isSelected()) {
                W8MonM.setSelected(true);
                W8TueM.setSelected(true);
                W8WedM.setSelected(true);
                W8ThurM.setSelected(true);
                W8FriM.setSelected(true);
                W8SatM.setSelected(true);
                W8SunM.setSelected(true);
            }
            else {
                W8MonM.setSelected(false);
                W8TueM.setSelected(false);
                W8WedM.setSelected(false);
                W8ThurM.setSelected(false);
                W8FriM.setSelected(false);
                W8SatM.setSelected(false);
                W8SunM.setSelected(false);
            }
        });

        week8A.setOnMouseReleased(event -> {
            if(week8A.isSelected()) {
                W8MonA.setSelected(true);
                W8TueA.setSelected(true);
                W8WedA.setSelected(true);
                W8ThurA.setSelected(true);
                W8FriA.setSelected(true);
                W8SatA.setSelected(true);
                W8SunA.setSelected(true);
            }
            else {
                W8MonA.setSelected(false);
                W8TueA.setSelected(false);
                W8WedA.setSelected(false);
                W8ThurA.setSelected(false);
                W8FriA.setSelected(false);
                W8SatA.setSelected(false);
                W8SunA.setSelected(false);
            }
        });

        week8N.setOnMouseReleased(event -> {
            if(week8N.isSelected()) {
                W8MonN.setSelected(true);
                W8TueN.setSelected(true);
                W8WedN.setSelected(true);
                W8ThurN.setSelected(true);
                W8FriN.setSelected(true);
                W8SatN.setSelected(true);
                W8SunN.setSelected(true);
            }
            else {
                W8MonN.setSelected(false);
                W8TueN.setSelected(false);
                W8WedN.setSelected(false);
                W8ThurN.setSelected(false);
                W8FriN.setSelected(false);
                W8SatN.setSelected(false);
                W8SunN.setSelected(false);
            }
        });

        week9M.setOnMouseReleased(event -> {
            if(week9M.isSelected()) {
                W9MonM.setSelected(true);
                W9TueM.setSelected(true);
                W9WedM.setSelected(true);
                W9ThurM.setSelected(true);
                W9FriM.setSelected(true);
                W9SatM.setSelected(true);
                W9SunM.setSelected(true);
            }
            else {
                W9MonM.setSelected(false);
                W9TueM.setSelected(false);
                W9WedM.setSelected(false);
                W9ThurM.setSelected(false);
                W9FriM.setSelected(false);
                W9SatM.setSelected(false);
                W9SunM.setSelected(false);
            }
        });

        week9A.setOnMouseReleased(event -> {
            if(week9A.isSelected()) {
                W9MonA.setSelected(true);
                W9TueA.setSelected(true);
                W9WedA.setSelected(true);
                W9ThurA.setSelected(true);
                W9FriA.setSelected(true);
                W9SatA.setSelected(true);
                W9SunA.setSelected(true);
            }
            else {
                W9MonA.setSelected(false);
                W9TueA.setSelected(false);
                W9WedA.setSelected(false);
                W9ThurA.setSelected(false);
                W9FriA.setSelected(false);
                W9SatA.setSelected(false);
                W9SunA.setSelected(false);
            }
        });

        week9N.setOnMouseReleased(event -> {
            if(week9N.isSelected()) {
                W9MonN.setSelected(true);
                W9TueN.setSelected(true);
                W9WedN.setSelected(true);
                W9ThurN.setSelected(true);
                W9FriN.setSelected(true);
                W9SatN.setSelected(true);
                W9SunN.setSelected(true);
            }
            else {
                W9MonN.setSelected(false);
                W9TueN.setSelected(false);
                W9WedN.setSelected(false);
                W9ThurN.setSelected(false);
                W9FriN.setSelected(false);
                W9SatN.setSelected(false);
                W9SunN.setSelected(false);
            }
        });

        week10M.setOnMouseReleased(event -> {
            if(week10M.isSelected()) {
                W10MonM.setSelected(true);
                W10TueM.setSelected(true);
                W10WedM.setSelected(true);
                W10ThurM.setSelected(true);
                W10FriM.setSelected(true);
                W10SatM.setSelected(true);
                W10SunM.setSelected(true);
            }
            else {
                W10MonM.setSelected(false);
                W10TueM.setSelected(false);
                W10WedM.setSelected(false);
                W10ThurM.setSelected(false);
                W10FriM.setSelected(false);
                W10SatM.setSelected(false);
                W10SunM.setSelected(false);
            }
        });

        week10A.setOnMouseReleased(event -> {
            if(week10A.isSelected()) {
                W10MonA.setSelected(true);
                W10TueA.setSelected(true);
                W10WedA.setSelected(true);
                W10ThurA.setSelected(true);
                W10FriA.setSelected(true);
                W10SatA.setSelected(true);
                W10SunA.setSelected(true);
            }
            else {
                W10MonA.setSelected(false);
                W10TueA.setSelected(false);
                W10WedA.setSelected(false);
                W10ThurA.setSelected(false);
                W10FriA.setSelected(false);
                W10SatA.setSelected(false);
                W10SunA.setSelected(false);
            }
        });

        week10N.setOnMouseReleased(event -> {
            if(week10N.isSelected()) {
                W10MonN.setSelected(true);
                W10TueN.setSelected(true);
                W10WedN.setSelected(true);
                W10ThurN.setSelected(true);
                W10FriN.setSelected(true);
                W10SatN.setSelected(true);
                W10SunN.setSelected(true);
            }
            else {
                W10MonN.setSelected(false);
                W10TueN.setSelected(false);
                W10WedN.setSelected(false);
                W10ThurN.setSelected(false);
                W10FriN.setSelected(false);
                W10SatN.setSelected(false);
                W10SunN.setSelected(false);
            }
        });

        week11M.setOnMouseReleased(event -> {
            if(week11M.isSelected()) {
                W11MonM.setSelected(true);
                W11TueM.setSelected(true);
                W11WedM.setSelected(true);
                W11ThurM.setSelected(true);
                W11FriM.setSelected(true);
                W11SatM.setSelected(true);
                W11SunM.setSelected(true);
            }
            else {
                W11MonM.setSelected(false);
                W11TueM.setSelected(false);
                W11WedM.setSelected(false);
                W11ThurM.setSelected(false);
                W11FriM.setSelected(false);
                W11SatM.setSelected(false);
                W11SunM.setSelected(false);
            }
        });

        week11A.setOnMouseReleased(event -> {
            if(week11A.isSelected()) {
                W11MonA.setSelected(true);
                W11TueA.setSelected(true);
                W11WedA.setSelected(true);
                W11ThurA.setSelected(true);
                W11FriA.setSelected(true);
                W11SatA.setSelected(true);
                W11SunA.setSelected(true);
            }
            else {
                W11MonA.setSelected(false);
                W11TueA.setSelected(false);
                W11WedA.setSelected(false);
                W11ThurA.setSelected(false);
                W11FriA.setSelected(false);
                W11SatA.setSelected(false);
                W11SunA.setSelected(false);
            }
        });

        week11N.setOnMouseReleased(event -> {
            if(week11N.isSelected()) {
                W11MonN.setSelected(true);
                W11TueN.setSelected(true);
                W11WedN.setSelected(true);
                W11ThurN.setSelected(true);
                W11FriN.setSelected(true);
                W11SatN.setSelected(true);
                W11SunN.setSelected(true);
            }
            else {
                W11MonN.setSelected(false);
                W11TueN.setSelected(false);
                W11WedN.setSelected(false);
                W11ThurN.setSelected(false);
                W11FriN.setSelected(false);
                W11SatN.setSelected(false);
                W11SunN.setSelected(false);
            }
        });

        week12M.setOnMouseReleased(event -> {
            if(week12M.isSelected()) {
                W12MonM.setSelected(true);
                W12TueM.setSelected(true);
                W12WedM.setSelected(true);
                W12ThurM.setSelected(true);
                W12FriM.setSelected(true);
                W12SatM.setSelected(true);
                W12SunM.setSelected(true);
            }
            else {
                W12MonM.setSelected(false);
                W12TueM.setSelected(false);
                W12WedM.setSelected(false);
                W12ThurM.setSelected(false);
                W12FriM.setSelected(false);
                W12SatM.setSelected(false);
                W12SunM.setSelected(false);
            }
        });

        week12A.setOnMouseReleased(event -> {
            if(week12A.isSelected()) {
                W12MonA.setSelected(true);
                W12TueA.setSelected(true);
                W12WedA.setSelected(true);
                W12ThurA.setSelected(true);
                W12FriA.setSelected(true);
                W12SatA.setSelected(true);
                W12SunA.setSelected(true);
            }
            else {
                W12MonA.setSelected(false);
                W12TueA.setSelected(false);
                W12WedA.setSelected(false);
                W12ThurA.setSelected(false);
                W12FriA.setSelected(false);
                W12SatA.setSelected(false);
                W12SunA.setSelected(false);
            }
        });

        week12N.setOnMouseReleased(event -> {
            if(week12N.isSelected()) {
                W12MonN.setSelected(true);
                W12TueN.setSelected(true);
                W12WedN.setSelected(true);
                W12ThurN.setSelected(true);
                W12FriN.setSelected(true);
                W12SatN.setSelected(true);
                W12SunN.setSelected(true);
            }
            else {
                W12MonN.setSelected(false);
                W12TueN.setSelected(false);
                W12WedN.setSelected(false);
                W12ThurN.setSelected(false);
                W12FriN.setSelected(false);
                W12SatN.setSelected(false);
                W12SunN.setSelected(false);
            }
        });

        week13M.setOnMouseReleased(event -> {
            if(week13M.isSelected()) {
                W13MonM.setSelected(true);
                W13TueM.setSelected(true);
                W13WedM.setSelected(true);
                W13ThurM.setSelected(true);
                W13FriM.setSelected(true);
                W13SatM.setSelected(true);
                W13SunM.setSelected(true);
            }
            else {
                W13MonM.setSelected(false);
                W13TueM.setSelected(false);
                W13WedM.setSelected(false);
                W13ThurM.setSelected(false);
                W13FriM.setSelected(false);
                W13SatM.setSelected(false);
                W13SunM.setSelected(false);
            }
        });

        week13A.setOnMouseReleased(event -> {
            if(week13A.isSelected()) {
                W13MonA.setSelected(true);
                W13TueA.setSelected(true);
                W13WedA.setSelected(true);
                W13ThurA.setSelected(true);
                W13FriA.setSelected(true);
                W13SatA.setSelected(true);
                W13SunA.setSelected(true);
            }
            else {
                W13MonA.setSelected(false);
                W13TueA.setSelected(false);
                W13WedA.setSelected(false);
                W13ThurA.setSelected(false);
                W13FriA.setSelected(false);
                W13SatA.setSelected(false);
                W13SunA.setSelected(false);
            }
        });

        week13N.setOnMouseReleased(event -> {
            if(week13N.isSelected()) {
                W13MonN.setSelected(true);
                W13TueN.setSelected(true);
                W13WedN.setSelected(true);
                W13ThurN.setSelected(true);
                W13FriN.setSelected(true);
                W13SatN.setSelected(true);
                W13SunN.setSelected(true);
            }
            else {
                W13MonN.setSelected(false);
                W13TueN.setSelected(false);
                W13WedN.setSelected(false);
                W13ThurN.setSelected(false);
                W13FriN.setSelected(false);
                W13SatN.setSelected(false);
                W13SunN.setSelected(false);
            }
        });

        week14M.setOnMouseReleased(event -> {
            if(week14M.isSelected()) {
                W14MonM.setSelected(true);
                W14TueM.setSelected(true);
                W14WedM.setSelected(true);
                W14ThurM.setSelected(true);
                W14FriM.setSelected(true);
                W14SatM.setSelected(true);
                W14SunM.setSelected(true);
            }
            else {
                W14MonM.setSelected(false);
                W14TueM.setSelected(false);
                W14WedM.setSelected(false);
                W14ThurM.setSelected(false);
                W14FriM.setSelected(false);
                W14SatM.setSelected(false);
                W14SunM.setSelected(false);
            }
        });

        week14A.setOnMouseReleased(event -> {
            if(week14A.isSelected()) {
                W14MonA.setSelected(true);
                W14TueA.setSelected(true);
                W14WedA.setSelected(true);
                W14ThurA.setSelected(true);
                W14FriA.setSelected(true);
                W14SatA.setSelected(true);
                W14SunA.setSelected(true);
            }
            else {
                W14MonA.setSelected(false);
                W14TueA.setSelected(false);
                W14WedA.setSelected(false);
                W14ThurA.setSelected(false);
                W14FriA.setSelected(false);
                W14SatA.setSelected(false);
                W14SunA.setSelected(false);
            }
        });

        week14N.setOnMouseReleased(event -> {
            if(week14N.isSelected()) {
                W14MonN.setSelected(true);
                W14TueN.setSelected(true);
                W14WedN.setSelected(true);
                W14ThurN.setSelected(true);
                W14FriN.setSelected(true);
                W14SatN.setSelected(true);
                W14SunN.setSelected(true);
            }
            else {
                W14MonN.setSelected(false);
                W14TueN.setSelected(false);
                W14WedN.setSelected(false);
                W14ThurN.setSelected(false);
                W14FriN.setSelected(false);
                W14SatN.setSelected(false);
                W14SunN.setSelected(false);
            }
        });

    }
}
