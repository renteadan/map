
using System.Runtime.InteropServices.WindowsRuntime;
using LabCSharp.Resources.Entity;

namespace LabCSharp.Resources.Entity
{
	partial class ActivePlayer : IBaseEntity
	{
	}

	partial class Game : IBaseEntity
	{
		public override string ToString()
		{
			return $"{Team1} vs {Team} on {Date.ToLocalTime()}";
		}
	}

	partial class Player : IBaseEntity
	{
		public override string ToString()
		{
			return $"{Student}";
		}
	}

	partial class School : IBaseEntity
	{
		public override string ToString()
		{
			return Name.Trim();
		}
	}

	partial class Student : IBaseEntity
	{
		public override string ToString()
		{
			return Name.Trim();
		}
	}

	partial class Team : IBaseEntity
	{
		public override string ToString()
		{
			return Name.Trim();
		}
	}
}