import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main
{
	static JDA jda;
	//change these values as needed
	static final String PREFIX = "^";
	static final String MESSAGE_ID = "757733232220569600";
	static final String CHANNEL_ID = "757732752329277541";
	static final String 
			PHYS_ROLE = "757727350363258962", 
			CHEM_ROLE = "757727395443900497", 
			BIO_ROLE = "757727453912498286", 
			PHYS_WITH_MATHS_ROLE = "757727489899626526";
	
	static final String GUILD_ID = "757630127252439090";
	
	public static void main(String[] args)
	{
		try
		{
			jda = JDABuilder.createDefault("")
					.enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_MEMBERS)
					.build();
		}
		catch (LoginException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			jda.awaitReady();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		jda.getGuildById(GUILD_ID).loadMembers();
		
		//add reactions (add your role names to the code here, or rewrite this section)
		jda.getTextChannelById(CHANNEL_ID).retrieveMessageById(MESSAGE_ID).queue(message ->
		{
			message.addReaction(jda.getGuildById(GUILD_ID).getEmotesByName("physics", false).get(0)).queue();
			message.addReaction(jda.getGuildById(GUILD_ID).getEmotesByName("chemistry", false).get(0)).queue();
			message.addReaction(jda.getGuildById(GUILD_ID).getEmotesByName("biology", false).get(0)).queue();
			message.addReaction(jda.getGuildById(GUILD_ID).getEmotesByName("physicswithmaths", false).get(0)).queue();
		});
		
		jda.addEventListener(new ReactAddListener());
		jda.addEventListener(new ReactRemoveListener());
		jda.addEventListener(new StopListener());
	}
}
