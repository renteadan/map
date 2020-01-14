using System;
using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LabCSharp.Resources.Entity;

namespace LabCSharp.Resources.Service
{
	class PlayerService: BaseService<Player>
	{

		public IEnumerable<Player> GetInTeamExcept(IEnumerable<Player> first, IEnumerable<ActivePlayer> second)
		{
			EntitySet<Player> aux = new EntitySet<Player>();
			foreach (var variable in second)
			{
				if (variable.PlayerId != null) aux.Add(new Player() {Id = (int) variable.PlayerId});
			}
			return first.Except(aux, new PlayerEqualityComparer());
		}

		private class PlayerEqualityComparer: IEqualityComparer<Player> {
			public bool Equals(Player x, Player y)
			{
				return x.Id == y.Id;
			}

			public int GetHashCode(Player obj)
			{
				return obj.Id.GetHashCode();
			}
		}
	}
}
