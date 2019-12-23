using LabCSharp.Entity;
using LabCSharp.Gateway;
using LabCSharp.Validator;

namespace LabCSharp.Service
{
	class TeamService: BaseService<Team>
	{
		public TeamService(): base(new TeamGateway(), new TeamValidator()) { }
	}
}
