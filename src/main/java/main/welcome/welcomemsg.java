package main.welcome;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class welcomemsg extends ListenerAdapter {

    public void onGuildMemberJoin (GuildMemberJoinEvent event) {

        User user = event.getUser();

        String name = event.getUser().getName();

        String servername = event.getGuild().getName();

        String chanelid = "1077635602935197797";

        EmbedBuilder bauplan = new EmbedBuilder();

        bauplan.setTitle("Welcomme on " + servername + " " + name);
        bauplan.setThumbnail("https://cdn.discordapp.com/attachments/1076146363026378855/1076836673763168307/discord-discord-stickers.gif");
        bauplan.setDescription("thank you for joining " + servername);

        Button Rules = Button.link("https://discord.com/channels/1039612481812844734/1039612482542641315", "Rules").asEnabled().withEmoji(Emoji.fromFormatted("\uD83D\uDCD7")).asEnabled();

        event.getGuild().getTextChannelById(chanelid).sendMessageEmbeds(bauplan.build()).setActionRow(Rules).queue();
    }
}
