
using System.Collections.Generic;
using System.Data.Linq;
using System.Diagnostics;
using System.Linq;
using System.Runtime.ExceptionServices;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Gateway;
using LabCSharp.Resources.Validator;

namespace LabCSharp.Resources.Service
{
	class TeamService: BaseService<Team>
	{
		private readonly TeamGateway _gateway;
		private readonly BaseGateway<School> _schoolGateway;
		public TeamService() : base(new TeamGateway(), new TeamValidator())
		{
			_gateway = new TeamGateway();
			_schoolGateway = new BaseGateway<School>();
		}

		public void PopulateTeams()
		{
			string[] teams = new string[]
			{
				"Scoala Gimnaziala Horea - Houston Rockets",
				"Scoala Gimnaziala Octavian Goga - Los Angeles Lakers",
				"Liceul Teoretic Lucian Blaga - LA Clippers",
				"Scoala Gimnaziala Ioan Bob - Chicago Bulls",
				"Scoala Gimnaziala Ion Creanga - Cleveland Cavaliers",
				"Colegiul National Pedagogic Gheorghe Lazar - Utah Jazz",
				"Scoala Gimnaziala Internationala SPECTRUM - Brooklyn Nets",
				"Colegiul National „Emil Racovita” - New Orleans Pelicans",
				"Colegiul National George Cosbuc - Indiana Pacers",
				"Scoala Gimnaziala Ion Agarbiceanu - Toronto Raptors",
				"Liceul Teoretic Avram Iancu - Charlotte Hornets",
				"Scoala Gimnaziala Constantin Brancusi - Phoenix Suns",
				"Liceul Teoretic Onisifor Ghibu - Portland TrailBlazers",
				"Liceul Teoretic Onisifor Ghibu - Golden State Warriors",
				"Liceul cu Program Sportiv Cluj-Napoca - Washington Wizards",
				"Liceul Teoretic Nicolae Balcescu - San Antonio Spurs",
				"Liceul Teoretic Gheorghe Sincai - Orlando Magic",
				"Scoala Nicolae Titulescu - Denver Nuggets",
				"Scoala Gimnaziala Liviu Rebreanu - Detroit Pistons",
				"Scoala Gimnaziala Iuliu Hatieganu - Atlanta Hawks",
				"Liceul Teoretic Bathory Istvan - Dallas Mavericks",
				"Colegiul National George Baritiu - Sacramento Kings",
				"Liceul Teoretic Apaczai Csere Janos - Oklahoma City Thunder",
				"Seminarul Teologic Ortodox - Boston Celtics",
				"Liceul de Informatica Tiberiu Popoviciu - New York Knicks",
				"Scoala Gimnaziala „Alexandru Vaida – Voevod - Minnesota Timberwolves",
				"Liceul Teoretic ELF - Miami Heat",
				"Scoala Gimnaziala Gheorghe Sincai Floresti - Milwaukee Bucks"
			};

			foreach (var VARIABLE in teams)
			{
				string[] names = VARIABLE.Split('-');
				School sch = new School();
				sch.Name = names[0].Trim();
				_schoolGateway.InsertOne(sch);
				Team aux = new Team();
				aux.Name = names[1].Trim();
				sch = _schoolGateway.FindOne(sch);
				aux.SchoolId = sch.Id;
				InsertOne(aux);
			}
		}

		public EntitySet<Player> GetPlayers(Team team)
		{
			return _gateway.GetTeamPlayers(team);
		}

		public new List<Team> GetAll()
		{
			return Gateway.GetAll();
		}

		public IEnumerable<Team> GetAllExcept(EntitySet<Team> team)
		{
			return _gateway.GetAllExcept(team);
		}
	}
}
