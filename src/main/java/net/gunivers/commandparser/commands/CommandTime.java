package net.gunivers.commandparser.commands;

import net.gunivers.commandparser.Command;
import net.gunivers.commandparser.Node;

class CommandTime extends Command {

	public CommandTime() {
		super("time");
		
		Node add = new Node("add",		new Node("[0-9]"));
		Node query = new Node("query",	new Node("daytime"), new Node("gametime"));
		Node set = new Node("set",		new Node("day"),	 new Node("night"),		new Node("[0-9]"));
		
		this.setChildren(add, query, set);
	}
}