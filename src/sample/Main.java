package sample;

/**
 * 10/23/2016
 * JavaFX Fire Emblem Support Coder
 * v1.0
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.application.*;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
//import org.apache.commons.lang3.StringUtils;
import javafx.stage.*;
import javafx.scene.image.*;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Fire Emblem: Fates Support Coder");
        primaryStage.setWidth(568);
        primaryStage.setHeight(1000);
        primaryStage.setResizable(false);
        final GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);
        pane.setPadding(new Insets(15, 0, 15, 15));
        final Scene scene = new Scene(pane, 562, 960);
        Font.loadFont(Main.class.getResource("/fonts/Chiaro.otf").toExternalForm(), 14);
        scene.getStylesheets().add(this.getClass().getResource("font.css").toExternalForm());
        Image icon = new Image(this.getClass().getResourceAsStream("/icon.png"));
        primaryStage.getIcons().add(icon);


        /*
         *Choice Box that shows all the characters the user can choose
         *for the first character that appears in the support
         */
        final Label character1 = new Label("    1st Character:");
        pane.add(character1, 0, 0);
        character1.setTranslateX(20);

        //final TextField characters1 = new TextField();
        String characters[] = {"Avatar [F] \t(マイユニ女)", "Avatar [M] \t(マイユニ男)", "Anna \t\t(アンナ)", "Arthur \t\t(ハロルド)", "Azama \t\t(アサマ)",
                "Azura \t\t(アクア)", "Benny \t\t(ブノワ)", "Beruka \t\t(ベルカ)", "Camilla \t\t(カミラ)", "Charlotte \t\t(シャーロッテ)",
                "Effie \t\t\t(エルフィ)", "Elise \t\t(エリーゼ)", "Felicia \t\t(フェリシア)", "Flora \t\t(フローラ)", "Fuga \t\t(フウガ)",
                "Gunter \t\t(ギュンター)", "Hana \t\t(カザハナ)", "Hayato \t\t(ツクヨミ)", "Hinata \t\t(ヒナタ)", "Hinoka \t\t(ヒノカ)",
                "Izana \t\t(イザナ)", "Jakob \t\t(ジョーカー)", "Kaden \t\t(ニシキ)", "Kagero \t\t(カゲロウ)", "Kaze \t\t(スズカゼ)",
                "Keaton \t\t(フランネル)", "Laslow \t\t(ラズワルド)", "Leo \t\t\t(レオン)", "Mozu \t\t(モズメ)", "Niles \t\t(ゼロ)",
                "Nyx \t\t\t(ニュクス)", "Oboro \t\t(オボロ)", "Odin \t\t(オーディン)", "Orochi \t\t(オロチ)", "Peri \t\t\t(ピエリ)",
                "Reina \t\t(ユウギリ)", "Rinkah \t\t(リンカ)", "Ryoma \t\t(リョウマ)", "Saizo \t\t(サイゾウ)", "Sakura \t\t(サクラ)",
                "Scarlet \t\t(クリムゾン)", "Selena \t\t(ルーナ)", "Setsuna \t\t(セツナ)", "Shura \t\t(アシュラ)", "Silas \t\t(サイラス)",
                "Subaki \t\t(ツバキ)", "Takumi \t\t(タクミ)", "Xander \t\t(マークス)", "Yukimura \t(ユキムラ)",
                "----------------------------------",
                "Kana [F] \t\t(カンナ女)", "Kana [M] \t\t(カンナ男)", "Asugi \t\t(グレイ)", "Caeldori \t\t(マトイ)", "Dwyer \t\t(ディーア)",
                "Forrest \t\t(フォレオ)", "Hisame \t\t(ヒサメ)", "Ignatius \t\t(イグニス)", "Kiragi \t\t(キサラギ)", "Midori \t\t(ミドリコ)",
                "Mitama \t\t(ミタマ)", "Nina \t\t(エポニーヌ)", "Ophelia \t\t(オフェリア)", "Percy \t\t(ルッツ)", "Rhajat \t\t(シャラ)",
                "Selkie \t\t(キヌ)", "Shigure \t\t(シグレ)", "Shiro \t\t(シノノメ)", "Siegbert \t\t(ジークベルト)", "Soleil \t\t(ソレイユ)",
                "Sophie \t\t(ゾフィー)", "Velouria \t\t(べロア)",
                "---------------------------------",
                "Marth \t\t(マルス)", "Ike \t\t\t(アイク)", "Lucina \t\t(ルキナ)", "Robin \t\t(ルフレ)",
                "_________________________________",
                "Faceless \t\t(ノスフェラトゥ)", "Kitsune \t\t(妖狐男)", "Wolfskin \t\t(ガルー男)", "Ninja \t\t(忍男)", "Merchant \t(大商人男)",
                "Apothecary \t(薬商人男)", "Pegasus Knight(天馬武者女)", "Archer \t\t(弓使い男)", "Oni Savage \t(鬼人男)", "Kinshi Knight \t(金鵄武者女)",
                "Lancer \t\t(槍術士男)", "Priestess \t\t(戦巫女)", "Shrine Maiden (巫女)", "Mage \t\t(呪い師男)", "Dark Mage \t(ダークマージ男)",
                "Troubadour \t(ロッドナイト女)", "Soldier \t\t(ランサー男)", "Myrmidon \t(侍男)", "Maid \t\t(メイド女)", "Paladin \t\t(パラディン男)",
                "Cavalier \t\t(ソシアルナイト男)", "Fighter \t\t(アクスファイター男)", "Knight \t\t(アーマーナイト男)",
                "-----------------------------------",
                "Old Man \t\t(村人おじいさん白)", "Old Woman \t(村人おばさん白)", "Girl \t\t\t(村人お姉さん白)", "Boy \t\t\t(村人お兄さん白)",
                "Child \t\t(村人子供白)", "Old Man \t\t(村人おじいさん黒)", "Old Woman \t(村人おばさん黒)", "Girl \t\t\t(村人お姉さん黒)",
                "Boy \t\t\t(村人お兄さん黒)", "Child \t\t(村人子供黒)", "Villager [F] \t(村人女)", "Villager [M] \t(村人男)",
                "------------------------------------",
                "Hans \t\t(ガンズ)", "Iago \t\t(マクベス)", "Garon \t\t(ガロン)", "Kotaro \t\t(コタロウ)", "Zola \t\t\t(ゾーラ)",
                "Sumeragi \t(スメラギ)", "Arete \t\t(シェンメイ)", "Mikoto \t\t(ミコト)", "Anankos \t\t(善ハイドラ)", "Omozu \t\t(モズ)",
                "Daniela \t\t(ダニエラ)", "Haitaka \t\t(ハイタカ)", "Kumagera \t(クマゲラ)", "Lloyd \t\t(ウィリアム)", "Llewelyn \t\t(ホルモン)",
                "Gazak \t\t(カザック)", "Tarba \t\t(バンバ)", "Funke \t\t(ファンク)", "Daichi \t\t(ダイチ)", "Senno \t\t(セノウ)",
                "Zhara \t\t(ヴァスハラ)", "Kilma \t\t(クーリア)", "Nichol \t\t(ナハト)", "Candace \t\t(ドラジェ)", "Lilith \t\t(リリス)",
                "Lilith \t\t(リリス竜)", "Layla \t\t(ララ)", "Anthony \t\t(ロンタオ)", "Sage \t\t(虹の賢者)", "Cassita \t\t(カシータ)", "??? \t\t\t(フードマン)"};
        final ComboBox characters1 = new ComboBox();
        characters1.setItems(FXCollections.observableArrayList(characters));
        pane.add(characters1, 1, 0, 3, 1);
        characters1.setPrefWidth(145);
        new AutoCompleteComboBox(characters1);
        characters1.setValue("");

        /*
         *Choice Box that shows all the characters the user can choose
         *for the second character that appears in the support
         */
        final Label character2 = new Label("    2nd Character:");
        pane.add(character2, 0, 1);
        character2.setTranslateX(15);

        final ComboBox characters2 = new ComboBox();
        characters2.setItems(FXCollections.observableArrayList(characters));
        pane.add(characters2, 1, 1, 3, 1);
        characters2.setPrefWidth(145);
        new AutoCompleteComboBox(characters2);
        characters2.setValue("");

        final ComboBox newCharaField = new ComboBox();
        newCharaField.setItems(FXCollections.observableArrayList(characters));
        pane.add(newCharaField, 2, 0);
        newCharaField.setPrefWidth(145);
        new AutoCompleteComboBox(newCharaField);
        newCharaField.setVisible(false);
        newCharaField.setValue("");

        final ComboBox newCharaField2 = new ComboBox();
        newCharaField2.setItems(FXCollections.observableArrayList(characters));
        pane.add(newCharaField2, 2, 1);
        newCharaField2.setPrefWidth(145);
        new AutoCompleteComboBox(newCharaField2);
        newCharaField2.setVisible(false);
        newCharaField2.setValue("");


        /*
         *Text Area where user inputs the dialogue line of the support
         */
        Label dialogueLabel = new Label("    Dialogue Line:");
        pane.add(dialogueLabel, 0, 3);
        dialogueLabel.setTranslateX(15);
        dialogueLabel.setTranslateY(-35);

        final TextArea dialogueArea = new TextArea("");
        pane.add(dialogueArea, 1, 3, 3, 1);
        dialogueArea.setWrapText(true);
        dialogueArea.setPrefRowCount(2);
        dialogueArea.setMaxSize(309, 240);
        dialogueArea.setPromptText("\tPaste One Line of Dialogue Here\r\t     (add \"\\n\" if the text wraps)");
        dialogueArea.setFocusTraversable(false);
        dialogueArea.getStyleClass().add("textArea");


        /*
         *First line button which if pressed indicates that the
         *line of dialogue will be coded as necessary, and also asks
         *user for what song they would like to use for the support
         ****IF NOT PRESSED & (Effects != "None") APPEARS ALONE & CHOOSE SONG SHOULD BE OFF****
         */
        final RadioButton firstLine = new RadioButton("First Line");
        pane.add(firstLine, 0, 4, 2, 1);
        firstLine.setTranslateX(30);
        firstLine.setTranslateY(-79);

/*
         *A radio button to ask user whether the first character appears alone
         *in the first line or not
         *****disabled when first line isn't pressed or fade to black isn't selected in effect options*****
         */
        final RadioButton aloneBtn = new RadioButton("Appears Alone");
        pane.add(aloneBtn, 0, 7, 2, 1);
        aloneBtn.setDisable(true);
        aloneBtn.setTranslateX(225);
        //aloneBtn.setTranslateY(45);

        final Label aloneBtnReminder = new Label("Select \"Character 1 Appears\"");
        pane.add(aloneBtnReminder, 2, 0, 1, 2);
        aloneBtnReminder.setVisible(false);
        aloneBtnReminder.setTranslateX(-185);
        aloneBtnReminder.setTranslateY(450);
        aloneBtnReminder.setStyle("-fx-font-size: 10pt;" +
                "-fx-text-fill: FF5C59;");

        Label chooseSong = new Label("Songs:");
        pane.add(chooseSong, 0, 4);
        chooseSong.setTranslateY(10);
        chooseSong.setTranslateX(82);

        final ComboBox songComboBox = new ComboBox();
        songComboBox.setItems(FXCollections.observableArrayList(
                "None", "Amb A1", "Amb A2", "Amb B1", "Amb B2", "Amb C1", "Amb C2",
                "Amusia E1", "Daily A1", "Daily B1", "Daily E1", "Daily E2",
                "Daily E3", "Emergency E1", "Fool E1", "Gag E1", "Gag E2", "Kindly E1", "Kindly E2",
                "Love E1", "Serious A1", "Serious B1", "Serious E1", "Strain E1",
                "Strain E2", "Uncanny E1", "Uneasy E1"
                )
        );
        pane.add(songComboBox, 1, 4);
        songComboBox.setTranslateY(10);
        songComboBox.setValue("None");
        songComboBox.setDisable(true);
        songComboBox.setPrefWidth(135);



        /*
         *Two Radio Buttons that will determine which character
         *is being coded in the support line
         */
        Label speaker = new Label("Character Speaking:");
        speaker.setTranslateX(-5);
        pane.add(speaker, 0, 6, 2, 1);

        final ToggleGroup charaBtns = new ToggleGroup();

        final RadioButton chara1Btn = new RadioButton("1st Character");
        chara1Btn.setToggleGroup(charaBtns);
        pane.add(chara1Btn, 1, 6);

        final RadioButton chara2Btn = new RadioButton("2nd Character");
        chara2Btn.setToggleGroup(charaBtns);
        pane.add(chara2Btn, 2, 6);

        final RadioButton sameChara = new RadioButton("Same as Previous\nCharacter");
        sameChara.setToggleGroup(charaBtns);
        //pane.add(sameChara, 2, 6);



        /*
         *Ask user for which emotion the character that is
         *speaking is displaying. If user chooses "same" then
         *the character does not change their emotion and instead
         *of $k$pE| displaying, $k$p displays
         */
        final Label emotionLabel = new Label("Displayed Emotion:");
        pane.add(emotionLabel, 0, 9, 1, 2);

        final ComboBox emotComboBox = new ComboBox();
        emotComboBox.setItems(FXCollections.observableArrayList(
                "Neutral (通常)", "Smile (笑)", "Distress (苦)", "Cocky (キメ)", "Angry (怒)", "Same as previous\nemotion"
        ));
        pane.add(emotComboBox, 1, 9, 1, 2);
        emotComboBox.setValue("Neutral (通常)");
        emotComboBox.setPrefWidth(148);

        final RadioButton blushingBtn = new RadioButton("Blushing");
        pane.add(blushingBtn, 2, 9, 2, 1);

        final RadioButton sweatBtn = new RadioButton("Sweat");
        pane.add(sweatBtn, 2, 10, 2, 1);

        /*
         *Ask the user if the support line needs any effects like
         *sound additions, or if the screen will fade to black,
         *or if the characters will fall, or if one character will
         *fall
         ****IF USER CHOOSES "SOUND ADDITION" THEN THE NEXT CHOICE BOX WILL BE INTERACTABLE****
         */
        Label effectLabel = new Label("Effects:");
        effectLabel.setWrapText(true);
        effectLabel.setTranslateX(78);
        pane.add(effectLabel, 0, 12);

        final ComboBox effectComboBox1 = new ComboBox();
        effectComboBox1.setItems(FXCollections.observableArrayList(
                "None (Default)", "Screen Fades to Black", "Character 1 Appears",
                "Character 2 Appears", "Character 1 Left", "Character 2 Left",
                "Chara 1 Replaced\nBy New Chara", "Chara 2 Replaced\nBy New Chara",
                "Charas 1 & 2 Replaced\nBy New Charas", "Chara 1 Appears &\nNew Chara Appears",
                "Chara 2 Appears &\nNew Chara Appears")
        );
        pane.add(effectComboBox1, 1, 12, 3, 1);
        effectComboBox1.setValue("None (Default)");
        effectComboBox1.setPrefWidth(152);

        /*final ComboBox effectComboBox2 = new ComboBox();
        effectComboBox2.setItems(FXCollections.observableArrayList(
                "No Other\nEffect", "New Character\nAppears", "Add Sound\nEffect")//, "Sound Effect")
        );
        pane.add(effectComboBox2, 2, 12, 3, 1);
        effectComboBox2.setValue("No Other\nEffect");
        effectComboBox2.setDisable(true);

        /*
         *Ask the user which sound they'd like if they chose "sound
         *addition" in the previous choice box
         */
        Label soundLabel = new Label("        Sound Effects:");
        pane.add(soundLabel, 0, 13);

        final ComboBox soundComboBox = new ComboBox();
        soundComboBox.setItems(FXCollections.observableArrayList(
                "None (Default)", "Body Fall", "Damage", "Dish Break")
        );
        pane.add(soundComboBox, 1, 13, 2, 1);
        soundComboBox.setValue("None (Default)");
        soundComboBox.setPrefWidth(152);

        final RadioButton before = new RadioButton("Sound Plays Before Effect");
        pane.add(before, 2, 13, 2, 1);
        before.setDisable(true);
        before.setStyle("-fx-font-size: 10pt;");
        before.setTranslateY(-15);

        final RadioButton after = new RadioButton("Sound Plays After Effect");
        pane.add(after, 2, 13, 2, 1);
        after.setDisable(true);
        after.setStyle("-fx-font-size: 10pt;");
        after.setTranslateY(15);

        //button that takes all the information given and codes dialogue
        Button supportButton = new Button("  Add Line  ");

        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.getChildren().add(supportButton);
        pane.add(hbox, 1, 15);

        Button supportViewerBtn = new Button("View Support");
        supportViewerBtn.getStyleClass().add("button1");

        HBox hbox2 = new HBox(0);
        hbox2.setAlignment(Pos.BOTTOM_RIGHT);
        hbox2.getChildren().add(supportViewerBtn);
        pane.add(hbox2, 2, 15);
        hbox2.setTranslateY(10);
        supportViewerBtn.setVisible(false);
        hbox2.setVisible(false);

        /*
         *Text area that displays all of the added lines
         *as a full support
         */
        final TextArea supportArea = new TextArea();
        pane.add(supportArea, 0, 16, 4, 1);
        supportArea.setWrapText(true);
        supportArea.setFocusTraversable(false);

        //play and stop buttons
        final Button playButton = new Button();
        final Image playButtonImage = new Image(this.getClass().getResourceAsStream("/play.png"));
        playButton.setGraphic(new ImageView(playButtonImage));
        playButton.setStyle("-fx-background-radius: 16.4, 15;" + "-fx-border-radius: 15;"
                + "-fx-border-width: 2;" + "-fx-padding: 0;" + "-fx-background-insets: -1.4, 0;");

        final Button stopButton = new Button();
        Image pauseButtonImage = new Image(this.getClass().getResourceAsStream("/pause.png"));
        stopButton.setGraphic(new ImageView(pauseButtonImage));
        stopButton.setStyle("-fx-background-radius: 16.4, 15;" + "-fx-border-radius: 15;"
                + "-fx-border-width: 2;" + "-fx-padding: 0;" + "-fx-background-insets: -1.4, 0;");

        HBox hbox3 = new HBox(15);
        hbox3.setAlignment(Pos.BOTTOM_LEFT);
        hbox3.getChildren().addAll(playButton, stopButton);
        pane.add(hbox3, 2, 4);
        hbox3.setTranslateX(-25);
        hbox3.setTranslateY(7);

        after.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (after.isSelected()) {
                    before.setSelected(false);
                }
            }
        });

        before.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (before.isSelected()) {
                    after.setSelected(false);
                }
            }
        });

        //action handler for effectComboBox1 that turns on/off aloneBtn & effectComboBox2 & newCharaField
        effectComboBox1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Text t = new Text(effectComboBox1.getValue().toString());
                int length = (int)t.getBoundsInLocal().getWidth();
                if (effectComboBox1.getValue() == "Screen Fades to Black" || effectComboBox1.getValue() == "Character 2 Appears"
                        || effectComboBox1.getValue() == "Character 1 Appears" || effectComboBox1.getValue() == "Chara 1 Appears &\nNew Chara Appears"
                        || effectComboBox1.getValue() == "Chara 2 Appears &\nNew Chara Appears") {
                    effectComboBox1.setPrefWidth(length*1.60-23);
                }
                else if (effectComboBox1.getValue() == "Charas 1 & 2 Replaced\nBy New Charas") {
                    effectComboBox1.setPrefWidth(length*1.60-35);
                }
                else if (effectComboBox1.getValue() == "None (Default)") {
                    effectComboBox1.setPrefWidth(152);
                }
                else {
                    effectComboBox1.setPrefWidth(length*1.60-8);
                }

                if (effectComboBox1.getValue() == "Screen Fades\nto Black" || firstLine.isSelected()) {
                    aloneBtn.setDisable(false);
                }
                if (effectComboBox1.getValue() != "Screen Fades\nto Black" && !firstLine.isSelected()) {
                    aloneBtn.setDisable(true);
                }
                if (effectComboBox1.getValue() != "None (Default)") {
                    before.setDisable(false);
                    after.setDisable(false);
                    //effectComboBox2.setDisable(false);
                }
                if (effectComboBox1.getValue() == "None (Default)") {
                    before.setDisable(true);
                    after.setDisable(true);
                }
                if (effectComboBox1.getValue() == "Chara 1 Replaced\nBy New Chara" || effectComboBox1.getValue() == "Chara 2 Replaced\nBy New Chara" ||
                        effectComboBox1.getValue() == "Chara 1 Appears &\nNew Chara Appears" || effectComboBox1.getValue() == "Chara 2 Appears &\nNew Chara Appears") {
                    newCharaField.setVisible(true);
                }
                if (effectComboBox1.getValue() == "Charas 1 & 2 Replaced\nBy New Charas") {
                    newCharaField.setVisible(true);
                    newCharaField2.setVisible(true);
                }
                if (effectComboBox1.getValue() != "Charas 1 & 2 Replaced\nBy New Charas" && effectComboBox1.getValue() != "Chara 1 Replaced\nBy New Chara"
                        && effectComboBox1.getValue() != "Chara 2 Replaced\nBy New Chara" && effectComboBox1.getValue() != "Chara 1 Appears &\nNew Chara Appears"
                        && effectComboBox1.getValue() != "Chara 2 Appears &\nNew Chara Appears") {
                    newCharaField.setVisible(false);
                }
                if (effectComboBox1.getValue() != "Charas 1 & 2 Replaced\nBy New Charas") {
                    newCharaField2.setVisible(false);
                    soundComboBox.getItems().remove("Damage &\nBody Fall");
                }
                if (effectComboBox1.getValue() == "Charas 1 & 2 Replaced\nBy New Charas")
                    soundComboBox.getItems().add(4, "Damage &\nBody Fall");
            }
        });

        //action handler for effectComboBox1 that turns on/off aloneBtn & effectComboBox2 & newCharaField
        /*effectComboBox2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (effectComboBox2.getValue() == "New Character\nAppears") {
                    newCharaField.setVisible(true);
                }
                if (effectComboBox2.getValue() != "New Character\nAppears") {
                    newCharaField.setVisible(false);
                }
                if (effectComboBox2.getValue() == "Add Sound\nEffect") {
                    soundComboBox.setDisable(false);
                }
                if (effectComboBox1.getValue() != "Add Sound\nEffect"
                        && effectComboBox2.getValue() != "Add Sound\nEffect") {
                    soundComboBox.setDisable(true);
                }
            }
        });*/

        //firstLine btn that turns on/off the song ComboBox & aloneBtn
        firstLine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (firstLine.isSelected()) {
                    songComboBox.setDisable(false);
                    sameChara.setDisable(true);
                }
                if (!firstLine.isSelected()) {
                    songComboBox.setDisable(true);
                    sameChara.setDisable(false);
                    aloneBtnReminder.setVisible(false);
                    aloneBtn.setSelected(false);
                }
                if (firstLine.isSelected() || effectComboBox1.getValue() == "Screen Fades\nto Black") {
                    aloneBtn.setDisable(false);
                }
                if (!firstLine.isSelected() && effectComboBox1.getValue() != "Screen Fades\nto Black") {
                    aloneBtn.setDisable(true);
                }
            }
        });

        //action handlers for sameChara btn that turns disables/enables
        //"Same as previous emotion" choice in emotComboBox & other charaBtns
        chara1Btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (charaBtns.getSelectedToggle() == chara1Btn) {
                    String prev = emotComboBox.getValue().toString();
                    String prev2 = characters1.getValue().toString();

                    emotComboBox.setValue(null);
                    characters1.setValue(null);
                    characters1.setValue(prev2);
                    emotComboBox.setValue(prev);

                    effectComboBox1.setDisable(false);
                }
                aloneBtnReminder.setVisible(false);
                String support = supportArea.getText();
                String support2 = "";
                if (support.contains("\\n$Wc$Sbv40|1000|$Fo1000|$Ws")) {
                    int i = support.indexOf("\\n$Wc$Sbv40|1000|$Fo1000|$Ws");
                    support2 = support.substring(i);
                }

                if (support.contains("|3$") && !support.contains("|7$") && chara2Btn.isSelected()) {
                    aloneBtnReminder.setText("Select \"Character 2 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                if (!support.contains("|3$") && support.contains("|7$") && chara1Btn.isSelected()) {
                    aloneBtnReminder.setText("Select \"Character 1 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                if (support2.contains("|3$") && chara2Btn.isSelected()&& !support2.contains("|7$")) {
                    aloneBtnReminder.setText("Select \"Character 2 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                if (support2.contains("|7$") && chara1Btn.isSelected()&& !support2.contains("|3$")) {
                    aloneBtnReminder.setText("Select \"Character 1 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                else if (support.equals("")) {
                    aloneBtnReminder.setVisible(false);
                }
                else {
                    aloneBtnReminder.setVisible(false);
                }
            }
        });
        chara2Btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (charaBtns.getSelectedToggle() == chara2Btn) {
                    String prev = emotComboBox.getValue().toString();
                    String prev2 = characters2.getValue().toString();

                    emotComboBox.setValue(null);
                    characters2.setValue(null);
                    characters2.setValue(prev2);
                    emotComboBox.setValue(prev);

                    effectComboBox1.setDisable(false);
                }
                aloneBtnReminder.setVisible(false);
                String support = supportArea.getText();
                String support2 = "";
                if (support.contains("\\n$Wc$Sbv40|1000|$Fo1000|$Ws")) {
                    int i = support.indexOf("\\n$Wc$Sbv40|1000|$Fo1000|$Ws");
                    support2 = support.substring(i);
                }

                if (support.contains("|3$") && !support.contains("|7$") && chara2Btn.isSelected()) {
                    aloneBtnReminder.setText("Select \"Character 2 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                if (!support.contains("|3$") && support.contains("|7$") && chara1Btn.isSelected()) {
                    aloneBtnReminder.setText("Select \"Character 1 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                if (support2.contains("|3$") && chara2Btn.isSelected() && !support2.contains("|7$")) {
                    aloneBtnReminder.setText("Select \"Character 2 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                if (support2.contains("|7$") && chara1Btn.isSelected() && !support2.contains("|3$")) {
                    aloneBtnReminder.setText("Select \"Character 1 Appears\"");
                    aloneBtnReminder.setVisible(true);
                }
                else if (support.equals("")) {
                    aloneBtnReminder.setVisible(false);
                }
            }
        });
        sameChara.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (charaBtns.getSelectedToggle() == sameChara) {
                    emotComboBox.getItems().add(0, "Same as previous\nemotion");
                    emotComboBox.setValue("Same as previous\nemotion");
                    effectComboBox1.setDisable(true);
                }
            }
        });

        characters1.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                String prev = emotComboBox.getValue().toString();
                emotComboBox.setValue(null);
                emotComboBox.setValue(prev);
            }
        });

        characters2.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                String prev = emotComboBox.getValue().toString();
                emotComboBox.setValue(null);
                emotComboBox.setValue(prev);
            }
        });


        blushingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (blushingBtn.isSelected()) {
                    String prev = emotComboBox.getValue().toString();
                    emotComboBox.setValue(null);
                    emotComboBox.setValue(prev);
                }
                if (!blushingBtn.isSelected()) {
                    String prev = emotComboBox.getValue().toString();
                    emotComboBox.setValue(null);
                    emotComboBox.setValue(prev);
                }
            }
        });

        sweatBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (sweatBtn.isSelected()) {
                    String prev = emotComboBox.getValue().toString();
                    emotComboBox.setValue(null);
                    emotComboBox.setValue(prev);
                }
                if (!sweatBtn.isSelected()) {
                    String prev = emotComboBox.getValue().toString();
                    emotComboBox.setValue(null);
                    emotComboBox.setValue(prev);
                }
            }
        });

        //invisible window for MediaView
        final Stage musicStage = new Stage();
        musicStage.initModality(Modality.WINDOW_MODAL);
        musicStage.hide();

        //music player action events for start/pause buttons and listener change event for songComboBox
        //to stop music whenever its value is changed so that songs do not play over each other.
        songComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String song = songComboBox.getValue().toString();
                song = song.replace(" ", "_");
                song = song.substring(0, 1).toLowerCase() + song.substring(1);
                //System.out.print(song);
                URL songPath = this.getClass().getClassLoader().getResource("evt_" + song
                        + ".dspadpcm.mp3");

                Media media1 = new Media(songPath.toString());
                final MediaPlayer test = new MediaPlayer(media1);
                final MediaView mediaView = new MediaView(test);
                //Status status = test.getStatus();

                musicStage.setScene(new Scene(VBoxBuilder.create().
                        children(mediaView).
                        alignment(Pos.CENTER).padding(new Insets(5)).build()));


                playButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        test.setAutoPlay(true);

                        songComboBox.valueProperty().addListener(new ChangeListener() {
                            @Override
                            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                                test.stop();
                            }
                        }); //end of songComboBox change listener
                    }
                }); //end of playButton action event

                stopButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        test.pause();
                        test.setAutoPlay(false);
                    }
                }); //end of stopButton action event
            }
        }); //end of songComboBox action event



        /*
        *supportButton action event that will take the inputted
        *user choices and will code the dialogue line given accordingly
        */
        supportButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String dialogue = (dialogueArea.getText());
                String chara1 = (characters1.getValue().toString());
                if (chara1.contains("(")) {
                    chara1 = chara1.substring(chara1.indexOf("(") + 1, chara1.indexOf(")"));
                }
                String chara2 = (characters2.getValue().toString());
                if (chara2.contains("(")) {
                    chara2 = chara2.substring(chara2.indexOf("(") + 1, chara2.indexOf(")"));
                }
                String newChara = (newCharaField.getValue().toString());
                if (newChara.contains("(")) {
                    newChara = newChara.substring(newChara.indexOf("(") + 1, newChara.indexOf(")"));
                }
                String newChara2 = (newCharaField2.getValue().toString());
                if (newChara2.contains("(")) {
                    newChara2 = newChara2.substring(newChara2.indexOf("(") + 1, newChara2.indexOf(")"));
                }
                String supportLine = "";
                String effect = "";
                String emotEffect = "";
                String song = songComboBox.getSelectionModel().getSelectedItem().toString().toUpperCase();
                song = song.replace(" ", "_");

                if (chara1.equals("マイユニ女") || chara1.equals("マイユニ男")) {
                    chara1 = "username";
                }
                if (chara2.equals("マイユニ女") || chara2.equals("マイユニ男")) {
                    chara2 = "username";
                }
                if (dialogue.contains("\\n")) {
                    dialogue = dialogue.replace("\n", "");
                } else {
                    dialogue = dialogue.replace("\n", "\\n");
                }

                //adds a "\n" where necessary, if the user didn't input it already. This code doesn't place the "\n"
                //correctly, it ends up in the middle of words sometimes, so users should place it manually.
                Text txt = new Text(dialogueArea.getText());
                int l = 0;
                String s = "";
                txt.setWrappingWidth(288);
                if (!dialogue.contains("\\n")) {
                    if (txt.getBoundsInLocal().getHeight() > 19.951171875) {
                        for (int i = 1; i <= dialogue.length(); i++) {
                            double height = txt.getBoundsInLocal().getHeight();
                            if (height > 19.951171875) {
                                s = txt.getText();
                                s = s.substring(0, s.length() - 1);
                                txt.setText(s);
                                l = txt.getText().length();
                                //System.out.println(txt.getBoundsInLocal().getHeight() + " " + s);
                            }
                            /*if (height == 19.951171875) {
                                txt.setText(s.substring(0, s.lastIndexOf(" ")));
                                l = txt.getText().length();
                            }*/
                        }
                        dialogue = dialogue.substring(0, l) + "\\n" + dialogue.substring(l, dialogue.length());
                    }
                }

                //syntax corrections (mostly for mentions of the avatar)
                dialogue = dialogue.replace("…", "...");
                dialogue = dialogue.replace("’", "'");
                dialogue = dialogue.replace("\\N", "\\n");
                dialogue = dialogue.replace(" \\n", "\\n");
                dialogue = dialogue.replace("\\n ", "\\n");
                dialogue = dialogue.replace(" \\n ", "\\n");
                dialogue = dialogue.replace("[avatar]", "$Nu");
                dialogue = dialogue.replace("(avatar)", "$Nu");
                dialogue = dialogue.replace("avatar", "$Nu");
                dialogue = dialogue.replace("[Avatar]", "$Nu");
                dialogue = dialogue.replace("(Avatar)", "$Nu");
                dialogue = dialogue.replace("Avatar", "$Nu");
                dialogue = dialogue.replace("Corrin", "$Nu");
                dialogue = dialogue.replace("Kamui", "$Nu");
                dialogue = dialogue.replace("corrin", "$Nu");
                dialogue = dialogue.replace("kamui", "$Nu");
                dialogue = dialogue.replace("$nu", "$Nu");
                dialogue = dialogue.replace("lord/lady", "$GLord,Lady|");
                dialogue = dialogue.replace("Lord/Lady", "$GLord,Lady|");
                dialogue = dialogue.replace("lady/lord", "$GLord,Lady|");
                dialogue = dialogue.replace("Lady/Lord", "$GLord,Lady|");
                dialogue = dialogue.replace("his/her", "$Ghis,her|");
                dialogue = dialogue.replace("her/his", "$Ghis,her|");
                dialogue = dialogue.replace("His/Her", "$GHis,Her|");
                dialogue = dialogue.replace("Her/His", "$GHis,Her|");
                dialogue = dialogue.replace("she/he", "$Ghe,she|");
                dialogue = dialogue.replace("he/she", "$Ghe,she|");
                dialogue = dialogue.replace("She/He", "$GHe,She|");
                dialogue = dialogue.replace("He/She", "$GHe,She|");
                dialogue = dialogue.replace("She's/He's", "$GHe's,She's|");
                dialogue = dialogue.replace("He's/She's", "$GHe's,She's|");
                dialogue = dialogue.replace("she's/he's", "$Ghe's,she's|");
                dialogue = dialogue.replace("he's/she's", "$Ghe's,she's|");
                dialogue = dialogue.replace("herself/himself", "$Ghimself,herself|");
                dialogue = dialogue.replace("himself/herself", "$Ghimself,herself|");
                dialogue = dialogue.replace("Herself/Himself", "$GHimself,Herself|");
                dialogue = dialogue.replace("Himself/Herself", "$GHimself,Herself|");
                dialogue = dialogue.replace("Him/Her", "$GHim,Her|");
                dialogue = dialogue.replace("Her/Him", "$GHim,Her|");
                dialogue = dialogue.replace("her/him", "$Ghim,her|");
                dialogue = dialogue.replace("her/him", "$Ghim,her|");


                //facial features effect
                if (sweatBtn.isSelected()) {
                    emotEffect = "汗";
                }
                if (blushingBtn.isSelected()) {
                    emotEffect = "照";
                }
                if (sweatBtn.isSelected() && blushingBtn.isSelected()) {
                    emotEffect = "汗照";
                }

                //emotion configuration
                String emotion = emotComboBox.getValue().toString();
                if (emotion.contains("(")) {
                    emotion = "$E" + emotion.substring(emotion.indexOf("(") + 1, emotion.indexOf(")")) + "," + emotEffect + "|";
                }

                if (emotion.contains("通常") && !sweatBtn.isSelected()
                        && !blushingBtn.isSelected() && !sameChara.isSelected()) {
                    emotion = "";
                }

                //firstLineBtn configurations
                if (aloneBtn.isSelected() && firstLine.isSelected() && !song.equalsIgnoreCase("none")
                        && chara1Btn.isSelected()) {
                    supportLine = "$a$SbpSTRM_EVT_" + song + "|0|$t1$Wm" + chara1 + "|3$w0|$Ws"
                            + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (aloneBtn.isSelected() && firstLine.isSelected() && !song.equalsIgnoreCase("none")
                        && chara2Btn.isSelected()) {
                    supportLine = "$a$SbpSTRM_EVT_" + song + "|0|$t1$Wm" + chara2 + "|7$w0|$Ws"
                            + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (aloneBtn.isSelected() && firstLine.isSelected() && song.equalsIgnoreCase("none")
                        && chara1Btn.isSelected()) {
                    supportLine = "$a$t1$Wm" + chara1 + "|3$w0|$Ws" + chara1 + "|$Wa" + emotion
                            + dialogue + "$k";
                }
                if (aloneBtn.isSelected() && firstLine.isSelected() && song.equalsIgnoreCase("none")
                        && chara2Btn.isSelected()) {
                    supportLine = "$a$t1$Wm" + chara2 + "|7$w0|$Ws" + chara2 + "|$Wa" + emotion
                            + dialogue + "$k";
                }
                if (!aloneBtn.isSelected() && firstLine.isSelected() && !song.equalsIgnoreCase("none")
                        && chara1Btn.isSelected()) {
                    supportLine = "$a$SbpSTRM_EVT_" + song + "|0|$t1$Wm" + chara2 + "|3$Wm" + chara1 + "|7$w0|$Ws"
                            + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (!aloneBtn.isSelected() && firstLine.isSelected() && !song.equalsIgnoreCase("none")
                        && chara2Btn.isSelected()) {
                    supportLine = "$a$SbpSTRM_EVT_" + song + "|0|$t1$Wm" + chara2 + "|3$Wm" + chara1 + "|7$w0|$Ws"
                            + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (!aloneBtn.isSelected() && firstLine.isSelected() && song.equalsIgnoreCase("none")
                        && chara1Btn.isSelected()) {
                    supportLine = "$a$t1$Wm" + chara2 + "|7$Wm" + chara1 + "|3$w0|$Ws"
                            + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (!aloneBtn.isSelected() && firstLine.isSelected() && song.equalsIgnoreCase("none")
                        && chara2Btn.isSelected()) {
                    supportLine = "$a$t1$Wm" + chara2 + "|7$Wm" + chara1 + "|3$w0|$Ws"
                            + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }

                //configuration for lines after the first line
                if (!aloneBtn.isSelected() && !firstLine.isSelected() && !sameChara.isSelected()
                        && chara1Btn.isSelected()) {
                    supportLine = "\\n$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (!aloneBtn.isSelected() && !firstLine.isSelected() && !sameChara.isSelected()
                        && chara2Btn.isSelected()) {
                    supportLine = "\\n$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (emotComboBox.getValue() == "Same as previous\nemotion") {
                    emotion = "Same as previous\nemotion";
                }

                //$k$p configuration
                String doneSupport = supportArea.getText();
                if (doneSupport.contains("$Ws")) {
                    int i = doneSupport.lastIndexOf("$Ws");
                    int n = doneSupport.lastIndexOf("|$Wa");
                    String charaInstance = doneSupport.substring(i, n);
                    String emotInstance = doneSupport.substring(n);
                    if (charaInstance.contains(chara1) && chara1Btn.isSelected() && (!emotInstance.contains(emotion)
                            || !emotion.equals("Same as previous\nemotion"))) {
                        supportLine = "$p" + emotion + dialogue + "$k";
                    }
                    if (charaInstance.contains(chara1) && chara1Btn.isSelected() && (emotInstance.contains(emotion)
                            || emotion.equals("Same as previous\nemotion"))) {
                        supportLine = "$p" + dialogue + "$k";
                    }
                    if (charaInstance.contains(chara2) && chara2Btn.isSelected() && (!emotInstance.contains(emotion)
                            || !emotion.equals("Same as previous\nemotion"))) {
                        supportLine = "$p" + emotion + dialogue + "$k";
                    }
                    if (charaInstance.contains(chara2) && chara2Btn.isSelected() && (emotInstance.contains(emotion)
                            || emotion.equals("Same as previous\nemotion"))) {
                        supportLine = "$p" + dialogue + "$k";
                    }
                    if (charaInstance.contains(chara1) && chara2Btn.isSelected() && (emotComboBox.getValue() == ("Same as previous\nemotion"))) {
                        if (!emotInstance.contains("$E")) {
                            supportLine = "\\n$Ws" + chara2 + "|$Wa" + dialogue + "$k";
                        } else {
                            emotInstance = doneSupport.substring(n, doneSupport.lastIndexOf("|") + 1);
                            supportLine = "\\n$Ws" + chara2 + emotInstance + dialogue + "$k";
                        }
                    }
                    if (charaInstance.contains(chara2) && chara1Btn.isSelected() && (emotComboBox.getValue() == ("Same as previous\nemotion"))) {
                        if (!emotInstance.contains("$E")) {
                            supportLine = "\\n$Ws" + chara1 + "|$Wa" + dialogue + "$k";
                        } else {
                            emotInstance = doneSupport.substring(n, doneSupport.lastIndexOf("|") + 1);
                            supportLine = "\\n$Ws" + chara1 + emotInstance + dialogue + "$k";
                        }
                    }
                }


                //Support Line effects configurations
                if (effectComboBox1.getValue() == "Character 1 Appears" && chara1Btn.isSelected()) {
                    effect = "\\n$Wm" + chara1 + "|3";
                    supportLine =  effect + "$Ws" + chara1 + "|$Wa" + emotion + "$w0|" + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Character 2 Appears" && chara2Btn.isSelected()) {
                    effect = "\\n$Wm" + chara2 + "|7";
                    supportLine = effect + "$Ws" + chara2 + "|$Wa" + emotion + "$w0|" + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Character 1 Appears" && chara2Btn.isSelected()) {
                    effect = "\\n$Wm" + chara1 + "|3";
                    supportLine = effect + "$Ws" + chara2 + "|$Wa" + emotion + "$w0|" + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Character 2 Appears" && chara1Btn.isSelected()) {
                    effect = "\\n$Wm" + chara2 + "|7";
                    supportLine = effect + "$Ws" + chara1 + "|$Wa" + emotion + "$w0|" + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Chara 1 Appears &\nNew Chara Appears" /*&& effectComboBox2.getValue()
                        == "New Character\nAppears"*/ && chara1Btn.isSelected()) {
                    effect = "\\n$Ws" + chara2 + "|$Wd$w0|$Wm" + chara1 + "|3$w0|$Wm" + newChara + "|7$w0|";
                    supportLine = effect + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                    Object n = characters2.getValue();
                    characters2.setValue(newCharaField.getValue());
                    newCharaField.setValue(n);
                }
                if (effectComboBox1.getValue() == "Chara 2 Appears &\nNew Chara Appears" /*&& effectComboBox2.getValue()
                        == "New Character\nAppears"*/ && chara2Btn.isSelected()) {
                    effect = "\\n$Ws" + chara1 + "|$Wd$w0|$Wm" + chara2 + "|7$w0|$Wm" + newChara + "|3$w0|";
                    supportLine = effect + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                    Object n = characters1.getValue();
                    characters1.setValue(newCharaField.getValue());
                    newCharaField.setValue(n);
                }
                if (effectComboBox1.getValue() == "Chara 1 Appears &\nNew Chara Appears" /*&& effectComboBox2.getValue()
                        == "New Character\nAppears"*/ && chara2Btn.isSelected()) {
                    effect = "\\n$Ws" + chara2 + "|$Wd$w0|$Wm" + chara1 + "|3$w0|$Wm" + newChara + "|7$w0|";
                    supportLine = effect + "$Ws" + newChara + "|$Wa" + emotion + dialogue + "$k";
                    Object n = characters2.getValue();
                    characters2.setValue(newCharaField.getValue());
                    newCharaField.setValue(n);
                }
                if (effectComboBox1.getValue() == "Chara 2 Appears &\nNew Chara Appears" /*&& effectComboBox2.getValue()
                        == "New Character\nAppears"*/ && chara1Btn.isSelected()) {
                    effect = "\\n$Ws" + chara1 + "|$Wd$w0|$Ws" + chara2 + "|7$w0|$Wm" + newChara + "|3$w0|";
                    supportLine = effect + "$Ws" + newChara + "|$Wa" + emotion + dialogue + "$k";
                    Object n = characters1.getValue();
                    characters1.setValue(newCharaField.getValue());
                    newCharaField.setValue(n);
                }
                if (effectComboBox1.getValue() == "Charas 1 & 2 Replaced\nBy New Charas" && chara1Btn.isSelected()) {
                    effect = "\\n$Ws" + chara1 + "|$Wd$Ws" + chara2 + "|$Wd$w0|$Wm" + newChara + "|3$w0|$Wm"
                            + newChara2 + "|7$w0|";
                    supportLine = effect + "$Ws" + newChara + "|$Wa" + emotion + dialogue + "$k";
                    Object n = characters1.getValue();
                    Object n2 = characters2.getValue();
                    characters1.setValue(newCharaField.getValue());
                    characters2.setValue(newCharaField2.getValue());
                    newCharaField.setValue(n);
                    newCharaField2.setValue(n2);
                }
                if (effectComboBox1.getValue() == "Charas 1 & 2 Replaced\nBy New Charas" && chara2Btn.isSelected()) {
                    effect = "\\n$Ws" + chara1 + "|$Wd$Ws" + chara2 + "|$Wd$w0|$Wm" + newChara + "|3$w0|$Wm"
                            + newChara2 + "|7$w0|";
                    supportLine = effect + "$Ws" + newChara2 + "|$Wa" + emotion + dialogue + "$k";
                    Object n = characters1.getValue();
                    Object n2 = characters2.getValue();
                    characters1.setValue(newCharaField.getValue());
                    characters2.setValue(newCharaField2.getValue());
                    newCharaField.setValue(n);
                    newCharaField2.setValue(n2);
                }

                //configures screen fade according to aloneBtn and charaBtns
                if (effectComboBox1.getValue() == "Screen Fades to Black" && !aloneBtn.isSelected()
                        && chara1Btn.isSelected()) {
                    effect = "\\n$Wc$Sbv40|1000|$Fo1000|$Ws" + chara2 + "|$Wd$Ws" + chara1 + "|$Wd$w0|$Sbv100|1000|$Fi1000|$Wm"
                    + chara2 + "|7$Wm" + chara1 + "|3";
                            //"\\n$Wc$Sbv40|1000|$Fo1000|$Wd$w0|$Sbv100|1000|$Fi1000|" + "$t1$Wm" + chara2 + "|7$Wm" + chara1 + "|3$w0|";
                    supportLine = effect + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Screen Fades to Black" && !aloneBtn.isSelected()
                        && chara2Btn.isSelected()) {
                    effect = "\\n$Wc$Sbv40|1000|$Fo1000|$Ws" + chara2 + "|$Wd$Ws" + chara1 + "|$Wd$w0|$Sbv100|1000|$Fi1000|$Wm"
                            + chara2 + "|7$Wm" + chara1 + "|3";
                    supportLine = effect + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Screen Fades to Black" && aloneBtn.isSelected()
                        && chara1Btn.isSelected()) {
                    effect = "\\n$Wc$Sbv40|1000|$Fo1000|$Ws" + chara2 + "|$Wd$Ws" + chara1 + "|$Wd$w0|$Sbv100|1000|$Fi1000|$Wm"
                            + chara1 + "|3$w0|";
                    supportLine = effect + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Screen Fades to Black" && aloneBtn.isSelected()
                        && chara2Btn.isSelected()) {
                    effect = "\\n$Wc$Sbv40|1000|$Fo1000|$Ws" + chara2 + "|$Wd$Ws" + chara1 + "|$Wd$w0|$Sbv100|1000|$Fi1000|$Wm"
                            + chara2 + "|7$w0|";
                    supportLine = effect + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }


                //config for new character selection
                if (effectComboBox1.getValue() == "Character 1 Left" && chara2Btn.isSelected()) {
                    effect = "\\n$Ws" + chara1 + "|$Wd$w0|";
                    supportLine =  effect + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (effectComboBox1.getValue() == "Character 2 Left" && chara1Btn.isSelected()) {
                    effect = "\\n$Ws" + chara2 + "|$Wd$w0|";
                    supportLine =  effect + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }

                if (effectComboBox1.getValue() == "Chara 1 Replaced\nBy New Chara" && chara1Btn.isSelected()) {
                    effect = "\\n$Ws" + chara1 + "|$Wd$w0|$Wm" + newChara + "|3$w0|";
                    supportLine = effect + "$Ws" + newChara + "|$Wa" + emotion + dialogue + "$k";
                    characters1.setValue(newCharaField.getValue());
                }
                if (effectComboBox1.getValue() == "Chara 1 Replaced\nBy New Chara" && chara2Btn.isSelected()) {
                    effect = "\\n$Ws" + chara1 + "|$Wd$w0|$Wm" + newChara + "|7$w0|";
                    supportLine = effect + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                    characters1.setValue(newCharaField.getValue());
                }
                if (effectComboBox1.getValue() == "Chara 2 Replaced\nBy New Chara" && chara1Btn.isSelected()) {
                    effect = "\\n$Ws" + chara2 + "|$Wd$w0|$Wm" + newChara + "|7$w0|";
                    supportLine = effect + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                    characters2.setValue(newCharaField.getValue());
                }
                if (effectComboBox1.getValue() == "Chara 2 Replaced\nBy New Chara" && chara2Btn.isSelected()) {
                    effect = "\\n$Ws" + chara2 + "|$Wd$w0|$Wm" + newChara + "|7$w0|";
                    supportLine = effect + "$Ws" + newChara + "|$Wa" + emotion + dialogue + "$k";
                    characters2.setValue(newCharaField.getValue());
                }
                /*if (effectComboBox1.getValue() == "New Character\nReplaces Chara 1" && effectComboBox1.getValue()
                        == "Screen Fades\nto Black") {
                    supportLine = "\n\nYou have to select \"Character 1 or 2 Left\" in the 1st effect box to add a new character." +
                            " Check the ReadMe.txt file if you need help!";
                }
                if (effectComboBox2.getValue() == "New Character\nAppears" && effectComboBox1.getValue()
                        == "Add Sound\nEffect") {
                    supportLine = "\n\nYou have to select \"Character 1 or 2 Left\" in the 1st effect box to add a new character." +
                            " Check the ReadMe.txt file if you need help!";
                }*/


                //sound effect configuration
                if (soundComboBox.getValue() == "Body Fall" && effectComboBox1.getValue() == "None (Default)"
                        && chara1Btn.isSelected()) {
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_BODYFALL|$w800|" + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (soundComboBox.getValue() == "Body Fall" && effectComboBox1.getValue() == "None (Default)"
                        && chara2Btn.isSelected()) {
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_BODYFALL|$w800|" + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (soundComboBox.getValue() == "Body Fall" && effectComboBox1.getValue() != "None (Default)"
                        && (before.isSelected() || (!before.isSelected() && !after.isSelected()))) {
                    supportLine = supportLine.replace("\\n$", "$");
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_BODYFALL|$w800|" + supportLine;
                }
                if (soundComboBox.getValue() == "Body Fall" && after.isSelected()) {
                    supportLine = supportLine.replace(supportLine.substring(supportLine.indexOf("\\n$"), supportLine.lastIndexOf("$Ws")), "");
                    supportLine = supportLine.replace("\\n$", "$");
                    supportLine = effect + "$Wc$w200|$SspSE_EVT_BODYFALL|$w800|" + supportLine;

                }

                if (soundComboBox.getValue() == "Damage" && effectComboBox1.getValue() == "None (Default)"
                        && chara1Btn.isSelected()) {
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_DAMAGE1|$w800|" + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (soundComboBox.getValue() == "Damage" && effectComboBox1.getValue() == "None (Default)"
                        && chara2Btn.isSelected()) {
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_DAMAGE1|$w800|" + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (soundComboBox.getValue() == "Damage" && effectComboBox1.getValue() != "None (Default)"
                        && (before.isSelected() || (!before.isSelected() && !after.isSelected()))) {
                    supportLine = supportLine.replace("\\n$", "$");
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_DAMAGE1|$w800|" + supportLine;
                }
                if (soundComboBox.getValue() == "Damage" && after.isSelected()) {
                    supportLine = supportLine.replace(supportLine.substring(supportLine.indexOf("\\n$"), supportLine.lastIndexOf("$Ws")), "");
                    supportLine = supportLine.replace("\\n$", "$");
                    supportLine = effect + "$Wc$w200|$SspSE_EVT_DAMAGE1|$w800|" + supportLine;
                }

                if (soundComboBox.getValue() == "Dish Break" && effectComboBox1.getValue() == "None (Default)"
                        && chara1Btn.isSelected()) {
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_DISH_BREAK|$w800|" + "$Ws" + chara1 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (soundComboBox.getValue() == "Dish Break" && effectComboBox1.getValue() == "None (Default)"
                        && chara2Btn.isSelected()) {
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_DISH_BREAK|$w800|" + "$Ws" + chara2 + "|$Wa" + emotion + dialogue + "$k";
                }
                if (soundComboBox.getValue() == "Dish Break" && effectComboBox1.getValue() != "None (Default)"
                        && (before.isSelected() || (!before.isSelected() && !after.isSelected()))) {
                    supportLine = supportLine.replace("\\n$", "$");
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_DISH_BREAK|$w800|" + supportLine;
                }
                if (soundComboBox.getValue() == "Dish Break" && after.isSelected()) {
                    supportLine = supportLine.replace(supportLine.substring(supportLine.indexOf("\\n$"), supportLine.lastIndexOf("$Ws")), "");
                    supportLine = supportLine.replace("\\n$", "$");
                    supportLine = effect + "$Wc$w200|$SspSE_EVT_DISH_BREAK|$w800|" + supportLine;
                }

                if (soundComboBox.getValue() == "Damage &\nBody Fall") {
                    supportLine = supportLine.replace(supportLine.substring(supportLine.indexOf("\\n$"), supportLine.lastIndexOf("$Ws")), "");
                    supportLine = supportLine.replace("\\n$", "$");
                    effect = effect.replace("\\n$", "$");
                    supportLine = "\\n$Wc$w200|$SspSE_EVT_DAMAGE|$w800|" + effect + "$Wc$w200|$SspSE_EVT_BODY_FALL|$w800|"
                            + supportLine;
                }

                //todo: song change after first line
                if (songComboBox.getValue() != "None" && supportArea.getText().contains("EVT")) {

                }


                //reset all combo boxes & certain btns
                effectComboBox1.setValue("None (Default)");
                //effectComboBox2.setValue("No Other\nEffect");
                songComboBox.setValue("None");
                soundComboBox.setValue("None (Default)");
                aloneBtn.setSelected(false);
                sweatBtn.setSelected(false);
                blushingBtn.setSelected(false);
                firstLine.setSelected(false);
                aloneBtn.setDisable(true);
                sameChara.setDisable(false);
                songComboBox.setDisable(true);
                aloneBtnReminder.setVisible(false);
                after.setSelected(false);
                before.setSelected(false);
                after.setDisable(true);
                before.setDisable(true);


                //syntax corrections
                while (supportLine.contains(" $") || supportLine.contains("| ")) {
                    supportLine = supportLine.replace(" $", "$");
                    supportLine = supportLine.replace("| ", "|");
                }
                //add coded dialogue to supportArea
                supportArea.appendText(supportLine);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();


        //small window that displays the portrait of character chosen & emotion chosen
        final Stage stage2 = new Stage();
        stage2.setTitle("Portrait Viewer");
        final GridPane portraitViewer = new GridPane();
        portraitViewer.setAlignment(Pos.CENTER);
        portraitViewer.setHgap(20);
        portraitViewer.setVgap(20);
        portraitViewer.setPadding(new Insets(15, 15, 15, 15));
        final Scene scene2 = new Scene(portraitViewer, 256 * 1.50, 256 * 1.50);
        scene2.getStylesheets().add(this.getClass().getResource("font.css").toExternalForm());
        stage2.getIcons().add(icon);


        Button viewPortrait = new Button("View Portrait?");
        viewPortrait.getStyleClass().add("button1");

        HBox hbox4 = new HBox(0);
        hbox4.setAlignment(Pos.CENTER);
        hbox4.getChildren().add(viewPortrait);
        pane.add(hbox4, 0, 9, 1, 2);
        hbox4.setTranslateY(25);

        Image bg = new Image(getClass().getResourceAsStream("/portraits/SupportBG.png"));
        ImageView bgView = new ImageView(bg);
        bgView.setPreserveRatio(true);
        bgView.setFitHeight(bg.getHeight() * 1.60);
        bgView.setFitWidth(bg.getWidth() * 1.60);
        portraitViewer.getChildren().add(bgView);

        //characters1.appendText("エポニーヌ");
        //characters2.appendText("アクア");

        //gets portraits for selected characters & selected emotion
        emotComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                String chara1 = "";
                if (!characters1.getValue().equals("") && characters1.getValue() != null) {
                    chara1 = characters1.getValue().toString();
                }
                String chara2 = "";
                if (!characters2.getValue().equals("") && characters2.getValue() != null) {
                    chara2 = characters2.getValue().toString();
                }

                if (chara1.contains("(")) {
                    int a = chara1.indexOf("(") + 1;
                    int b = chara1.indexOf(")");
                    chara1 = chara1.substring(a, b);
                }
                if (chara2.contains("(")) {
                    int a = chara2.indexOf("(") + 1;
                    int b = chara2.indexOf(")");
                    chara2 = chara2.substring(a, b);
                }


                String emotion = emotComboBox.getValue().toString().substring(
                        emotComboBox.getValue().toString().indexOf("(") + 1,
                        emotComboBox.getValue().toString().indexOf(")"));
                String portraitPath = "";
                String portraitPath2 = "";
                String portraitPath3 = "";
                String portraitPath4 = "";

                chara1 = chara1.replaceAll(" ", "");
                chara2 = chara2.replaceAll(" ", "");

                if (chara1.equals("マイユニ女")) {
                    chara1 = "aマイユニ女2";
                }
                if (chara2.equals("マイユニ女")) {
                    chara2 = "aマイユニ女2";
                }
                if (chara1.equals("マイユニ男")) {
                    chara1 = "aマイユニ男1";
                }
                if (chara2.equals("マイユニ男")) {
                    chara2 = "aマイユニ男1";
                }


                if (chara1Btn.isSelected()) {
                    portraitPath = "/portraits/face/" + chara1 + "_st_" + emotion + ".png";
                    portraitPath3 = "/portraits/face/" + chara1 + "_st_汗.png";
                    portraitPath4 = "/portraits/face/" + chara1 + "_st_照.png";

                    if (chara1.equals("aマイユニ女2") || chara1.equals("aマイユニ男1")) {

                        chara1 = chara1.replace("a", "");
                        portraitPath2 = "/portraits/hair/" + chara1 + "_st_髪0.png";
                    }
                }
                if (chara2Btn.isSelected()) {
                    portraitPath = "/portraits/face/" + chara2 + "_st_" + emotion + ".png";
                    portraitPath3 = "/portraits/face/" + chara2 + "_st_汗.png";
                    portraitPath4 = "/portraits/face/" + chara2 + "_st_照.png";

                    if (chara2.equals("aマイユニ女2") || chara2.equals("aマイユニ男1")) {
                        chara2 = chara2.replace("a", "");
                        portraitPath2 = "/portraits/hair/" + chara2 + "_st_髪0.png";
                    }
                }

                final Image portrait = new Image(getClass().getResourceAsStream(portraitPath));
                final ImageView portrait2 = new ImageView(portrait);
                portrait2.setFitWidth(portrait.getWidth() * 1.50);
                portrait2.setFitHeight(portrait.getHeight() * 1.50);
                portraitViewer.getChildren().add(portrait2);
                portrait2.setTranslateX(128);

                final Image portrait3 = new Image(getClass().getResourceAsStream(portraitPath2));
                final ImageView portrait4 = new ImageView();
                portrait4.setImage(portrait3);
                portrait4.setFitWidth(portrait3.getWidth() * 1.50);
                portrait4.setFitHeight(portrait3.getHeight() * 1.50);
                portraitViewer.getChildren().add(portrait4);
                portrait4.setTranslateX(128);

                //TODO: Position sweat and blush images according to character (46% done - main characters done)
                final Image portrait5 = new Image(getClass().getResourceAsStream(portraitPath3));
                final ImageView portrait6 = new ImageView(portrait5);
                portrait6.setFitWidth(portrait5.getWidth() * 1.50);
                portrait6.setFitHeight(portrait5.getHeight() * 1.50);
                portrait6.setTranslateX(128);

                final Image portrait7 = new Image(getClass().getResourceAsStream(portraitPath4));
                final ImageView portrait8 = new ImageView(portrait7);
                portrait8.setFitWidth(portrait7.getWidth() * 1.50);
                portrait8.setFitHeight(portrait7.getHeight() * 1.50);
                portrait8.setTranslateX(128);

                if (sweatBtn.isSelected()) {
                    portraitViewer.getChildren().add(portrait6);
                }
                if (!sweatBtn.isSelected()) {
                    portraitViewer.getChildren().remove(portrait6);
                }
                if (blushingBtn.isSelected()) {
                    portraitViewer.getChildren().add(portrait8);
                }
                if (!blushingBtn.isSelected()) {
                    portraitViewer.getChildren().remove(portrait8);
                }

                emotComboBox.valueProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        portrait2.setImage(null);
                        portrait4.setImage(null);
                        portrait6.setImage(null);
                        portrait8.setImage(null);
                    }
                });
            }
        });


        viewPortrait.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage2.setScene(scene2);
                stage2.setResizable(false);
                stage2.sizeToScene();
                stage2.show();
                stage2.setAlwaysOnTop(true);
            }
        });


        //adds more emotion options if the characters chosen from characters1 and characters2 has more than the main 5
        characters1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String chara = characters1.getValue().toString();
                if (chara.contains("(")) {
                    int a = chara.indexOf("(") + 1;
                    int b = chara.indexOf(")");
                    chara = chara.substring(a, b);
                }

                String[] delete = {"Neutral (通常)", "Smile (笑)", "Distress (苦)", "Cocky (キメ)",
                        "Angry (怒)", "Shouting (やけくそ)", "Singing (歌う)", "Smile 2 (笑2)", "Demonic (超キメ)", "Surprised (びっくり)",
                        "Sad (落胆)", "Closed Eyes (気絶)", "Angry 2 (怒2)", "Smirk (企み)", "Shy/Shifty-Eyes (拗ね)", "Smile 2 (差分)",
                        "Smile 2 (微笑)", " Distress 2 (苦2)", "Neutral 2 (通常2)", "Possessed (囚)", "Possessed 2 (囚2)", "Smirk (にやり)",
                        "Closed Eyes (思案)", "Angry 2 (超怒)", "Surprised (焦り)", "Distress 2 (あらら)", "Closed Eyes (目閉)", "Same as previous\nemotion"};
                String[] add = {"Neutral (通常)", "Smile (笑)", "Distress (苦)", "Cocky (キメ)", "Angry (怒)", "Same as previous\nemotion"};

                if (chara.equals("アクア") || chara.equals("シグレ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Singing (歌う)");
                    if (chara.equals("アクア")) {
                        emotComboBox.getItems().add("Smile 2 (笑2)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("エリーゼ") || chara.equals("リズ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Surprised (びっくり)");
                    if (chara.equals("エリーゼ")) {
                        emotComboBox.getItems().addAll("Sad (落胆)", "Closed Eyes (気絶)", "Angry 2 (怒2)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("タクミ") || chara.equals("クリムゾン")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Possessed (囚)");
                    if (chara.equals("タクミ")) {
                        emotComboBox.getItems().addAll("Closed Eyes (気絶)", "Possessed 2 (囚2)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("サクラ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Shouting (やけくそ)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("アイク") || chara.equals("ジョーカー")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Closed Eyes (思案)");
                    if (chara.equals("ジョーカー")) {
                        emotComboBox.getItems().add("Demonic (超キメ)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ルーナ") || chara.equals("セレナ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smirk (企み)");
                    if (chara.equals("ルーナ")) {
                        emotComboBox.getItems().add("Shy/Shifty-Eyes (拗ね)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("フランネル")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Shy/Shifty-Eyes (拗ね)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("キヌ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smile 2 (差分)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("シノノメ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smile 2 (微笑)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ソレイユ") || chara.equals("ピエリ") || chara.equals("リリス") || chara.equals("影リリス")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add(" Distress 2 (苦2)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ニシキ") || chara.equals("ハロルド") || chara.equals("ラズワルド") || chara.equals("ルッツ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Neutral 2 (通常2)");
                    if (chara.equals("ラズワルド")) {
                        emotComboBox.getItems().add("Distress 2 (あらら)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("シャーロッテ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("(Angry 2 (超怒)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ゼロ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smirk (にやり)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("クロム右") || chara.equals("クロム左") || chara.equals("フェリシア")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Surprised (焦り)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ニシキ") || chara.equals("フレデリク") || chara.equals("リョウマ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Closed Eyes (目閉)");
                    emotComboBox.setValue("Neutral (通常)");
                }


                if (!chara.equals("タクミ") && !chara.equals("エリーゼ") && !chara.equals("サクラ") && !chara.equals("シノノメ")
                        && !chara.equals("ジョーカー") && !chara.equals("アクア") && !chara.equals("シグレ") && !chara.equals("リズ")
                        && !chara.equals("ルーナ") && !chara.equals("セレナ") && !chara.equals("フランネル") && !chara.equals("キヌ")
                        && !chara.equals("ソレイユ") && !chara.equals("ピエリ") && !chara.equals("リリス") && !chara.equals("影リリス")
                        && !chara.equals("ニシキ") && !chara.equals("ハロルド") && !chara.equals("ラズワルド") && !chara.equals("ルッツ")
                        && !chara.equals("クリムゾン") && !chara.equals("アイク") && !chara.equals("シャーロッテ") && !chara.equals("ゼロ")
                        && !chara.equals("クロム右") && !chara.equals("クロム左") && !chara.equals("フェリシア") && !chara.equals("アズール")
                        && !chara.equals("アズール") && !chara.equals("ラズワルド") && !chara.equals("リョウマ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.setValue("Neutral (通常)");
                }
            }
        });


        characters2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String chara = characters2.getValue().toString();
                if (chara.contains("(")) {
                    int a = chara.indexOf("(") + 1;
                    int b = chara.indexOf(")");
                    chara = chara.substring(a, b);
                }

                String[] delete = {"Neutral (通常)", "Smile (笑)", "Distress (苦)", "Cocky (キメ)",
                        "Angry (怒)", "Shouting (やけくそ)", "Singing (歌う)", "Smile 2 (笑2)", "Demonic (超キメ)", "Surprised (びっくり)",
                        "Sad (落胆)", "Closed Eyes (気絶)", "Angry 2 (怒2)", "Smirk (企み)", "Shy/Shifty-Eyes (拗ね)", "Smile 2 (差分)",
                        "Smile 2 (微笑)", " Distress 2 (苦2)", "Neutral 2 (通常2)", "Possessed (囚)", "Possessed 2 (囚2)", "Smirk (にやり)",
                        "Closed Eyes (思案)", "Angry 2 (超怒)", "Surprised (焦り)", "Distress 2 (あらら)", "Closed Eyes (目閉)", "Same as previous\nemotion"};
                String[] add = {"Neutral (通常)", "Smile (笑)", "Distress (苦)", "Cocky (キメ)", "Angry (怒)", "Same as previous\nemotion"};

                if (chara.equals("アクア") || chara.equals("シグレ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Singing (歌う)");
                    if (chara.equals("アクア")) {
                        emotComboBox.getItems().add("Smile 2 (笑2)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("エリーゼ") || chara.equals("リズ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Surprised (びっくり)");
                    if (chara.equals("エリーゼ")) {
                        emotComboBox.getItems().addAll("Sad (落胆)", "Closed Eyes (気絶)", "Angry 2 (怒2)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("タクミ") || chara.equals("クリムゾン")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Possessed (囚)");
                    if (chara.equals("タクミ")) {
                        emotComboBox.getItems().addAll("Closed Eyes (気絶)", "Possessed 2 (囚2)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("サクラ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Shouting (やけくそ)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("アイク") || chara.equals("ジョーカー")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Closed Eyes (思案)");
                    if (chara.equals("ジョーカー")) {
                        emotComboBox.getItems().add("Demonic (超キメ)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ルーナ") || chara.equals("セレナ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smirk (企み)");
                    if (chara.equals("ルーナ")) {
                        emotComboBox.getItems().add("Shy/Shifty-Eyes (拗ね)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("フランネル")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Shy/Shifty-Eyes (拗ね)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("キヌ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smile 2 (差分)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("シノノメ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smile 2 (微笑)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ソレイユ") || chara.equals("ピエリ") || chara.equals("リリス") || chara.equals("影リリス")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add(" Distress 2 (苦2)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ニシキ") || chara.equals("ハロルド") || chara.equals("ラズワルド") || chara.equals("ルッツ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Neutral 2 (通常2)");
                    if (chara.equals("ラズワルド")) {
                        emotComboBox.getItems().add("Distress 2 (あらら)");
                    }
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("シャーロッテ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("(Angry 2 (超怒)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ゼロ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Smirk (にやり)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("クロム右") || chara.equals("クロム左") || chara.equals("フェリシア")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Surprised (焦り)");
                    emotComboBox.setValue("Neutral (通常)");
                }
                if (chara.equals("ニシキ") || chara.equals("フレデリク") || chara.equals("リョウマ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.getItems().add("Closed Eyes (目閉)");
                    emotComboBox.setValue("Neutral (通常)");
                }


                if (!chara.equals("タクミ") && !chara.equals("エリーゼ") && !chara.equals("サクラ") && !chara.equals("シノノメ")
                        && !chara.equals("ジョーカー") && !chara.equals("アクア") && !chara.equals("シグレ") && !chara.equals("リズ")
                        && !chara.equals("ルーナ") && !chara.equals("セレナ") && !chara.equals("フランネル") && !chara.equals("キヌ")
                        && !chara.equals("ソレイユ") && !chara.equals("ピエリ") && !chara.equals("リリス") && !chara.equals("影リリス")
                        && !chara.equals("ニシキ") && !chara.equals("ハロルド") && !chara.equals("ラズワルド") && !chara.equals("ルッツ")
                        && !chara.equals("クリムゾン") && !chara.equals("アイク") && !chara.equals("シャーロッテ") && !chara.equals("ゼロ")
                        && !chara.equals("クロム右") && !chara.equals("クロム左") && !chara.equals("フェリシア") && !chara.equals("アズール")
                        && !chara.equals("アズール") && !chara.equals("ラズワルド") && !chara.equals("リョウマ")) {
                    emotComboBox.getItems().removeAll(delete);
                    emotComboBox.setItems(FXCollections.observableArrayList(add));
                    emotComboBox.setValue("Neutral (通常)");
                }
            }
        });

        //closes both leftover stages on primaryStage close
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                stage2.close();
                musicStage.close();
            }
        });
    }
