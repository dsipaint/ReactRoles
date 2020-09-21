import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class StopListener extends ListenerAdapter
{
	public void onGuildMessageReceived(GuildMessageReceivedEvent e)
	{
		String msg = e.getMessage().getContentRaw();
		String[] args = msg.split(" ");
		
		if(e.getAuthor().getId().equals("475859944101380106"))
		{
			if(args[0].equalsIgnoreCase(Main.PREFIX + "disable") && args[1].equalsIgnoreCase("reactroles"))
			{
				e.getChannel().sendMessage("*Disabling reactroles...*").complete();
				e.getJDA().shutdown();
				System.exit(0);
			}
		}
	}
}
