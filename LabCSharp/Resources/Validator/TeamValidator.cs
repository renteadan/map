using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Exception;

namespace LabCSharp.Resources.Validator
{
	public class TeamValidator : Validator<Team>
	{
		public override void Validate(Team entity)
		{
			if (entity.Name == "")
				throw new ValidationException("Team name can't be empty!");
		}

		public TeamValidator(): base() { }
	}
}
