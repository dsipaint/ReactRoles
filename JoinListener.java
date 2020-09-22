import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter
{
	public void onGuildMemberJoin(GuildMemberJoinEvent e)
	{
		//member role
		e.getGuild().addRoleToMember(e.getMember(), e.getGuild().getRoleById("757634890169843763")).queue();
	}
}
