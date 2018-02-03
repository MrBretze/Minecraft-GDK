package net.gunivers.cmdlg.generators.material;

// Updated upstream:src/main/java/fr/gunivers/cmdlg/generators/material/BlockGenerator.java

import java.util.ArrayList;
import net.gunivers.cmdlg.util.GeneratorType;
import net.gunivers.cmdlg.util.Material;

public class BlockGenerator extends MaterialGenerator {

	private GeneratorType type = GeneratorType.BLOCK;

    /**
     * Generate Block Material
     *
     * @return ArrayList<String> commands
     */
    @Override
    public ArrayList<String> generate() {
        ArrayList<String> commands = new ArrayList<>();

        for (Material material : Material.values()) {
        	if (material.isBlock()) {
        		StringBuilder temp = new StringBuilder();
        		
        		for (int e = 0; e < getCommand().length - 1; e++) {
        			temp.append(getCommand()[e]).append(material.name());
        			
        			if (e == getCommand().length - 2) temp.append(getCommand()[e + 1]);
	           }
        		
        		commands.add(temp.toString());
        	}
        }
        return commands;
    }

    /**
     * Get the Materials to be generated
     *
     * @return ArrayList<Material> materialList
     */
    public Iterable<? extends Material> getMaterialList() {
    	ArrayList<Material> values = new ArrayList<Material>();
    	for (Material matos : Material.values()) if (matos.isBlock()) values.add(matos);
    	
        return values;
    }
}