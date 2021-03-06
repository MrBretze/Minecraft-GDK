package net.gunivers.commandlistgenerator.functionality.list;

import java.util.ArrayList;

import net.gunivers.core.minecraft.Entity;
import net.gunivers.core.minecraft.EntityType;
import net.gunivers.core.utils.tuple.Tuple;

public class EntityList extends List
{
	private static final long serialVersionUID = 2L;

	public EntityList()
	{
		super("gui.list.item.entity");
		
		for (EntityType et : EntityType.values())
		{
			ArrayList<String> array = new ArrayList<String>();
			for(Entity e : Entity.filter(et))
			{
				array.add(e.toString().toLowerCase());
			}
			if(et.equals(EntityType.ALL))
				addSubList(Tuple.newTuple("gui.list.item." + et.toString().toLowerCase(), array.toArray(new String[array.size()])));
			else
				addSubList(Tuple.newTuple("gui.list.item.entity." + et.toString().toLowerCase(), array.toArray(new String[array.size()])));
		}
	}
}
