package fr.febscap.main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	public static void main(String[] arguments) throws Exception
	{
		String token = "OTc4NjIwODU1NjYxNzU2NDM3.GSCP3u.eZ_C8amtirAOk1fiOLMt3pmklkV7Y0o6GAKXcA";

	    JDA jda = JDABuilder.createDefault(token).build();
	    jda.awaitReady();
	    
	    jda.addEventListener(new Listener());
	    
	    jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("Mirror mirror..."));
		
		
		System.out.println("Bot Lunched");
	}
}

