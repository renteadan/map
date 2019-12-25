
using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
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

		public EntitySet<Player> GetPlayers(Team team)
		{
			return _gateway.GetTeamPlayers(team);
		}

		public new List<Team> GetAll()
		{
			return Gateway.GetAll();
		}
	}
}
