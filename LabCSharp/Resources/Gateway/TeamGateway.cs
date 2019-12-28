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

		public IEnumerable<Team> GetAllExcept(EntitySet<Team> team)
		{
			EntitySet<Team> set = new EntitySet<Team>();
			set.SetSource(GetAll());
			return set.Except(team, new TeamEqualityComparer());
		}
	}
}
