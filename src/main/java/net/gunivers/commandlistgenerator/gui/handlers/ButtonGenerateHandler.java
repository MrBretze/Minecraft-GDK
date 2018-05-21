package net.gunivers.commandlistgenerator.gui.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.gunivers.commandlistgenerator.gui.CommandListGeneratorController;
import net.gunivers.commandlistgenerator.util.Tag;

public class ButtonGenerateHandler implements EventHandler<ActionEvent> {

	private Button button;
	private TextField commandTextField;
	private TextArea output;

	public ButtonGenerateHandler(Button button, TextField textField, TextArea output) {
		this.button = button;
		this.commandTextField = textField;
		this.output = output;
	}

	@Override
	public void handle(ActionEvent event) {
		int maxSize = CommandListGeneratorController.CONTROLLER.getMaxCommand();
		HashMap<String, ArrayList<String>> replaceTag = new HashMap<>();

		for (Tag t : Tag.tags.values())
			replaceTag.put(t.getId() ,t.getType().generate(t.getParameters(), maxSize));
		ArrayList<String> commands = new ArrayList<>();
		String commandsList = "";
		for (int i = 0; i < maxSize; i++) {
			String command = commandTextField.getText();
			for (Entry<String, ArrayList<String>> entry : replaceTag.entrySet())
				command = command.replaceAll(Tag.tagDelimiter + entry.getKey() + Tag.tagDelimiter, entry.getValue().get(i));
			commands.add(command);
			commandsList += command;
			if (i < maxSize - 1)
				commandsList += "\n";
		}
		output.setText(commandsList);
	}

	public Button getButton() {
		return button;
	}

	public TextField getCommandTextField() {
		return commandTextField;
	}
}