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
				case "physics":
					e.getGuild().removeRoleFromMember(e.getMember(), e.getGuild().getRoleById(Main.PHYS_ROLE)).queue();
					break;
					
				case "chemistry":
					e.getGuild().removeRoleFromMember(e.getMember(), e.getGuild().getRoleById(Main.CHEM_ROLE)).queue();
					break;
					
				case "biology":
					e.getGuild().removeRoleFromMember(e.getMember(), e.getGuild().getRoleById(Main.BIO_ROLE)).queue();
					break;
					
				case "physicswithmaths":
					e.getGuild().removeRoleFromMember(e.getMember(), e.getGuild().getRoleById(Main.PHYS_WITH_MATHS_ROLE)).queue();
					break;
			}
		}
	}
}
