package fr.febscap.main;

import java.awt.Color;
import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class Listener implements EventListener {

	public final static String prefix = "=";

	public final static String idCMirror = "978635054412607559";

	@Override
	public void onEvent(GenericEvent event) {
		if (event instanceof MessageReceivedEvent) {
			MessageReceivedEvent e = (MessageReceivedEvent) event;
			String msg = e.getMessage().getContentDisplay();
			List<Attachment> img = e.getMessage().getAttachments();
			if (!e.getAuthor().isBot() && !e.getChannel().getId().equals(idCMirror)) {
				EmbedBuilder msgBuilder = new EmbedBuilder();
				msgBuilder.setAuthor(e.getAuthor().getName() + " (" + e.getAuthor().getName() + ")", null,
						e.getAuthor().getAvatarUrl());
				msgBuilder.setDescription("New message in : " + e.getTextChannel().getAsMention());
				msgBuilder.addField("", msg, false);
				msgBuilder.setColor(new Color((int) (Math.random() * 0x1000000)));

				if (!img.isEmpty()) {
					if (img.get(0).isImage()) {
						msgBuilder.setImage(img.get(0).getUrl());
					}
				}

				e.getGuild().getTextChannelById(idCMirror).sendMessageEmbeds(msgBuilder.build()).queue();

			}

		}

	}

}
