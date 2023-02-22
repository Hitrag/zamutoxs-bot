package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public class view extends ListenerAdapter {

    public void onSlashCommandInteraction (SlashCommandInteractionEvent event) {

        if (event.getName().equals("view")) {

            event.getOption("member").getAsString();

            Member member = event.getOption("member").getAsMember();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setAuthor("Zamutoxs Bot");
            bauplan.setTitle("User infos about " + member.getEffectiveName());
            bauplan.setThumbnail(member.getEffectiveAvatarUrl());
            bauplan.addField("User ID", member.getId(),true);
            bauplan.addField("Acount created",member.getTimeCreated().format(DateTimeFormatter.RFC_1123_DATE_TIME),true);
            bauplan.addField("ping", member.getAsMention(),true);

            Button ban = Button.danger("ban","ban");
            Button kick = Button.secondary("kick","kick");
            Button timeout = Button.secondary("timeout","Timeout");
            Button profile = Button.link(member.getEffectiveAvatarUrl(),"show Profile picktures");

            ban.asEnabled();
            kick.asEnabled();
            timeout.asEnabled();
            profile.asEnabled();



            event.replyEmbeds(bauplan.build()).addActionRow(ban, kick,timeout,profile).setEphemeral(false).queue();



        }




    }
    public void onUserContextInteraction (UserContextInteractionEvent event) {

        if (event.getName().equals("view")) {

            event.getOption("member").getAsString();

            Member member = event.getOption("member").getAsMember();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setAuthor("Zamutoxs Bot");
            bauplan.setTitle("User infos about " + member.getEffectiveName());
            bauplan.setThumbnail(member.getEffectiveAvatarUrl());
            bauplan.addField("User ID", member.getId(),true);
            bauplan.addField("Acount created",member.getTimeCreated().format(DateTimeFormatter.RFC_1123_DATE_TIME),true);
            bauplan.addField("ping", member.getAsMention(),true);

            Button ban = Button.danger("ban","ban");
            Button kick = Button.secondary("kick","kick");
            Button timeout = Button.secondary("timeout","Timeout");
            Button profile = Button.link(member.getEffectiveAvatarUrl(),"show Profile picktures");

            ban.asEnabled();
            kick.asEnabled();
            timeout.asEnabled();
            profile.asEnabled();



            event.replyEmbeds(bauplan.build()).addActionRow(ban, kick,timeout,profile).setEphemeral(false).queue();



        }




    }
    public void onButtonInteraction (ButtonInteractionEvent ereignis) {

        if (ereignis.getButton().equals("ban")) {

            if (ereignis.getMember().getPermissions().contains(Permission.BAN_MEMBERS)) {

                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setAuthor("Zamutoxsbot");
                bauplan.setTitle("the member that you wanted to ban is now banned");
                bauplan.setThumbnail("https://cdn.discordapp.com/attachments/1076864834773196912/1076868019185262693/9299-blurple-ban.png");

                ereignis.replyEmbeds(bauplan.build()).setEphemeral(true).queue();

            }

        }else if (ereignis.getButton().equals("kick")) {

            if (ereignis.getMember().getPermissions().contains(Permission.KICK_MEMBERS)) {

                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setAuthor("Zamutoxsbot");
                bauplan.setTitle("the member that you wanted to kicked of the server is niw gone");
                bauplan.setThumbnail("https://cdn.discordapp.com/attachments/1076864834773196912/1076868019185262693/9299-blurple-ban.png");

                ereignis.replyEmbeds(bauplan.build()).setEphemeral(true).queue();
            }

        }else if (ereignis.getButton().equals("timeout")) {

            if (ereignis.getMember().getPermissions().contains(Permission.MODERATE_MEMBERS)) {

                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setAuthor("Zamutoxsbot");
                bauplan.setTitle("the member that you wanted to be timeouted is now in timeout");
                bauplan.setThumbnail("https://cdn.discordapp.com/attachments/1076864834773196912/1076868019185262693/9299-blurple-ban.png");

                ereignis.replyEmbeds(bauplan.build()).setEphemeral(true).queue();
            }

        }else {

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setThumbnail("https://cdn.discordapp.com/attachments/1076864834773196912/1076872970288500868/3595-failed.png");
            bauplan.setAuthor("Zamutoxs Bot");
            bauplan.setTitle("you dont have the permissions to do that");

            ereignis.replyEmbeds(bauplan.build()).setEphemeral(true).queue();
        }
    }
}
