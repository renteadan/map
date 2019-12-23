using LabCSharp.Entity;
using LabCSharp.Exception;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabCSharp.Validator
{
	public class TeamValidator : Validator<Team>
	{
		public override void Validate(Team Entity)
		{
			if (Entity.Name == "")
				throw new ValidationException("Team name can't be empty!");
		}

		public TeamValidator(): base() { }
	}
}
