using System.Collections.Generic;
using System.Data.Linq;
using LabCSharp.Resources.Entity;
using System.Linq;

namespace LabCSharp.Resources.Gateway
{
	class TeamGateway: BaseGateway<Team>
	{

		public EntitySet<Player> GetTeamPlayers(Team team)
		{
			return Table.First(item => item.Id == team.Id).Players;
		}
	}
}
