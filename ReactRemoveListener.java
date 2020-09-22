import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactRemoveListener extends ListenerAdapter
{
	public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent e)
	{	
		if(e.getMessageId().equals(Main.MESSAGE_ID))
		{	
			switch(e.getReactionEmote().getName())
			{
				//why does the api only return the user id and not let me use e.getMember() in this library? Because fuck you that's why
				//why is caching weird? Fuck you that's why
				case "physics":
					e.getGuild().retrieveMemberById(e.getUserId()).queue(member ->
					{
						e.getGuild().removeRoleFromMember(member, e.getGuild().getRoleById(Main.PHYS_ROLE)).queue();
					});
					break;
					
				case "chemistry":
					e.getGuild().retrieveMemberById(e.getUserId()).queue(member ->
					{
						e.getGuild().removeRoleFromMember(member, e.getGuild().getRoleById(Main.CHEM_ROLE)).queue();
					});
					break;
					
				case "biology":
					e.getGuild().retrieveMemberById(e.getUserId()).queue(member ->
					{
						e.getGuild().removeRoleFromMember(member, e.getGuild().getRoleById(Main.BIO_ROLE)).queue();
					});
					break;
					
				case "physicswithmaths":
					e.getGuild().retrieveMemberById(e.getUserId()).queue(member ->
					{
						e.getGuild().removeRoleFromMember(member, e.getGuild().getRoleById(Main.PHYS_WITH_MATHS_ROLE)).queue();
					});
					break;
			}
		}
	}
}
