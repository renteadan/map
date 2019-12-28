using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace LabCSharp.Resources.Entity
{
	class TeamEqualityComparer: IEqualityComparer<Team>
	{
		public bool Equals(Team x, Team y)
		{
			return x.Id == y.Id;
		}

		public int GetHashCode(Team obj)
		{
			return obj.Id.GetHashCode();
		}
	}
}
