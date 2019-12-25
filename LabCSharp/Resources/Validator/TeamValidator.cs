using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Exception;

namespace LabCSharp.Resources.Validator
{
	public class TeamValidator : IValidator<Team>
	{
		public void Validate(Team entity)
		{
			if (entity.Name == "")
				throw new ValidationException("Team name can't be empty!");
		}
	}
}
