import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactAddListener extends ListenerAdapter
{
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent e)
	{
		if(e.getMessageId().equals(Main.MESSAGE_ID))
		{
			switch(e.getReactionEmote().getName())
			{
				case "physics":
					e.getGuild().addRoleToMember(e.getMember(), e.getGuild().getRoleById(Main.PHYS_ROLE)).queue();
					break;
					
				case "chemistry":
					e.getGuild().addRoleToMember(e.getMember(), e.getGuild().getRoleById(Main.CHEM_ROLE)).queue();
					break;
					
				case "biology":
					e.getGuild().addRoleToMember(e.getMember(), e.getGuild().getRoleById(Main.BIO_ROLE)).queue();
					break;
					
				case "physicswithmaths":
					e.getGuild().addRoleToMember(e.getMember(), e.getGuild().getRoleById(Main.PHYS_WITH_MATHS_ROLE)).queue();
					break;
			}
		}
	}
}
