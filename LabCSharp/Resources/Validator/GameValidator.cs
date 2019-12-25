using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Exception;

namespace LabCSharp.Resources.Validator
{
	class GameValidator: IValidator<Game>
	{
		public void Validate(Game entity)
		{
			if(entity.Date == null)
				throw new ValidationException("Game date is not set!");
			if (entity.GuestTeamId < 0 || entity.HostTeamId < 0)
				throw new ValidationException("Both teams must be set!");
		}
	}
}
