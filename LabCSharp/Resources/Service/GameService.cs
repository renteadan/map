using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using System.Threading.Tasks;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Gateway;
using LabCSharp.Resources.Validator;

namespace LabCSharp.Resources.Service
{
	class GameService: BaseService<Game>
	{
		private readonly GameGateway _gateway;
		public List<Game> GetGamesBetweenDates(DateTime from, DateTime to)
		{
			return _gateway.GetGamesInPeriod(from, to);
		}

		public GameService() : base(new GameGateway(), new GameValidator())
		{
			_gateway = new GameGateway();
		}

		public List<ActivePlayer> GetTeamPlayersInGame(Team team, Game game)
		{
			return _gateway.GetTeamPlayersInGame(team, game);
		}

		public Dictionary<Team, int> GetGameWithScore(Game game)
		{
			return _gateway.GetGameWithScore(game);
		}
	}
}
