package net.gunivers.listgenerator.functionality.material;

import net.gunivers.cmdlg.util.GeneratorType;
import net.gunivers.cmdlg.util.Material;
import net.gunivers.listgenerator.Call;
import net.gunivers.listgenerator.functionality.Functionality;

import java.util.ArrayList;

public class EdibleGenerator extends Functionality
{

    /**
     * Generate Edible Material
     *
     * @return ArrayList<String> commands
     */
    @Call
    public ArrayList<String> generate()
    {
        ArrayList<String> commands = new ArrayList<>();

        for (Material material : Material.values())
        {
            if (material.isEdible())
            {
                commands.add(material.name());
            }
        }
        return commands;
    }

	@Override
	public String toString() {
		return "EdibleGenerator";
	}
}