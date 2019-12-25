
using System.Collections.Generic;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Gateway;
using LabCSharp.Resources.Validator;

namespace LabCSharp.Resources.Service
{
	class TeamService: BaseService<Team>
	{
		private readonly TeamGateway _gateway;
		public TeamService() : base(new TeamGateway(), new TeamValidator())
		{
			_gateway = new TeamGateway();
		}

		public List<Player> GetPlayers(Team team)
		{
			return _gateway.GetTeamPlayers(team);
		}

		public List<Player> GetTeamPlayersInGame(Team team, Game game)
		{
			return _gateway.GetTeamPlayersInGame(team, game);
		}
	}
}
