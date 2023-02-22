package main;

import main.commands.view;
import main.welcome.welcomemsg;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.naming.Context;

public class main {

    public static void main(String[] args) throws InterruptedException {

        String prefix = "!";

        String status = "Auf discord";

        String token = "MTA3NzYwMzA5MTEwMjMwMjI3OA.G5BWon.9YUeg6R23M8PnS27jcDZnpj7vEr0nAYnQKLsrc";

        JDABuilder bauplan = JDABuilder.createDefault(token);

        bauplan.setChunkingFilter(ChunkingFilter.ALL);
        bauplan.setMemberCachePolicy(MemberCachePolicy.ALL);
        bauplan.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGES);

        bauplan.setStatus(OnlineStatus.DO_NOT_DISTURB);
        bauplan.setActivity(Activity.playing(status));

        bauplan.addEventListeners(new view());
        bauplan.addEventListeners(new welcomemsg());

        JDA bot = bauplan.build();
        System.out.println("Bot ist nun online");

        Guild server = bot.awaitReady().getGuildById("1039612481812844734");

        server.updateCommands().addCommands(
                Commands.slash("view","view a profile from a user")
                        .addOption(OptionType.USER,"member","wich members profile do you wont to see",true),
                Commands.context(Command.Type.USER,"view")
        ).queue();
    }
}
