using System.Collections.Generic;
using LabCSharp.Resources.Entity;
using System.Linq;

namespace LabCSharp.Resources.Gateway
{
	class TeamGateway: BaseGateway<Team>
	{
		public List<Player> GetTeamPlayers(Team team)
		{
			var query = from player in Context.GetTable<Player>()
									where player.TeamId == team.Id
									select player;
			return query.ToList();
		}

		public List<Player> GetTeamPlayersInGame(Team team, Game game)
		{
			var query = from activePlayer in Context.GetTable<ActivePlayer>()
				join player in Context.GetTable<Player>() on activePlayer.PlayerId equals player.Id
				where player.TeamId == team.Id && activePlayer.GameId == game.Id
				select player;
			return query.ToList();
		}
	}
}
