package net.gunivers.commandlistgenerator;

import java.net.URL;

import com.jfoenix.controls.JFXDecorator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import net.gunivers.commandlistgenerator.functionality.*;
import net.gunivers.commandlistgenerator.gui.CommandListGeneratorController;
import net.gunivers.core.language.Language;
import net.gunivers.core.language.Locale;
import net.gunivers.updater.Updater;

public class CommandListGenerator extends Application
{

    public static Stage MAIN_STAGE;

    public static Language LANGUAGE = Language.getLanguage(Locale.FRENCH);

    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            for (int index = 0; args.length > index; index++)
            {
                String arg = args[index];

                if (arg.startsWith("-update"))
                {
                    launch(Updater.class, "-DUpdate-File=" + args[index].split("=")[1]);
                    index += 1;
                } else if (arg.startsWith("-debug"))
                {
                    Debug.initialize(arg);
                }
            }
        }

        try
        {
            launch(args);
        } catch (Exception e)
        {
            System.out.println("An error has been detected !");
        }
    }

    /**
     * Starting of interface
     *
     * @param primaryStage Default stage giving by JavaFX
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        CommandListGenerator.MAIN_STAGE = primaryStage;

        //Start of fxml load
        FXMLLoader loader = new FXMLLoader(new URL(getClass().getResource("/fxml/CommandListGenerator.fxml").toExternalForm()));

        //Set the controller of loader
        loader.setController(new CommandListGeneratorController());

        //Load the loader
        loader.load();

        //Decorator of window
        JFXDecorator decorator = new JFXDecorator(primaryStage, loader.getRoot(), false, true, true);

        //Set the tittle of window
        decorator.setText(LANGUAGE.get("gui.commandlistgenerator.title"));
        primaryStage.setTitle(LANGUAGE.get("gui.commandlistgenerator.title"));

        //Create new scene
        Scene scene = new Scene(decorator);

        //Make sure font is loaded
        Font.loadFont(CommandListGenerator.class.getResource("/css/font/Roboto-Regular.ttf").toExternalForm(), 10D);
        Font.loadFont(CommandListGenerator.class.getResource("/css/font/Roboto-Bold.ttf").toExternalForm(), 10D);

        //Clear all CSS option
        scene.getStylesheets().clear();

        //Add custom CSS value
        scene.getStylesheets().add(getClass().getResource("/css/Gunivers.css").toExternalForm());

        //Set the dimension of window
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(400);

        //Set the scene
        primaryStage.setScene(scene);

        //Show the scene
        primaryStage.show();

        //Init of functionalities
        boolean b = Functionality.register();
        if (!b) System.out.println("Functionality has been not correctly registered.");
    }
}
