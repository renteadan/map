using System;
using System.Collections.Generic;
using System.Linq;
using LabCSharp.Resources.Entity;

namespace LabCSharp.Resources.Gateway
{
	class GameGateway: BaseGateway<Game>
	{

		public List<Game> GetGamesInPeriod(DateTime From, DateTime to)
		{
			var query = from game in Table
																where game.Date <= to && game.Date >= From
																select game;
			return query.ToList();
		}

		public List<ActivePlayer> GetTeamPlayersInGame(Team team, Game game)
		{
			var query = from activePlayer in Context.GetTable<ActivePlayer>()
				join player in Context.GetTable<Player>() on activePlayer.PlayerId equals player.Id
				where player.TeamId == team.Id && activePlayer.GameId == game.Id
				select activePlayer;
			return query.ToList();
		}

		public Dictionary<Team, int> GetGameWithScore(Game game)
		{
			var query = from activePlayer in Context.GetTable<ActivePlayer>()
				join player in Context.GetTable<Player>() on activePlayer.PlayerId equals player.Id
				join team in Context.GetTable<Team>() on player.TeamId equals team.Id
				where activePlayer.GameId == game.Id
				group activePlayer by team
				into teams
				select new {score = teams.Sum(player => player.PointsScored), team = teams.Key};
			return query.ToDictionary(t => t.team, t => (int) t.score);
		}
	}
}
