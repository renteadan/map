using System;
using System.Data.Linq;
using System.Linq;

using System.Windows.Forms;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Service;

namespace LabCSharp.Resources.Forms
{
	public partial class CreateGame : Form
	{
		private readonly TeamService _teamService = new TeamService();
		private readonly GameService _gameService = new GameService();
		private Team _hostTeam, _guestTeam;
		public CreateGame()
		{
			InitializeComponent();
		}

		private void CreateGame_Load(object sender, EventArgs e)
		{
			TeamSelect1.DataSource = _teamService.GetAll();
			DateSelect.Value = DateTime.Now;
		}

		private void TeamSelect1_SelectedIndexChanged(object sender, EventArgs e)
		{
			_hostTeam = (Team) TeamSelect1.SelectedItem;
			EntitySet<Team> aux = new EntitySet<Team> {_hostTeam};
			TeamSelect2.DataSource = _teamService.GetAllExcept(aux).ToList();
		}

		private void TeamSelect2_SelectedIndexChanged(object sender, EventArgs e)
		{
			_guestTeam = (Team)TeamSelect2.SelectedItem;
		}

		private void GameAdd_Click(object sender, EventArgs e)
		{
			Game game = new Game() {Date = DateSelect.Value, GuestTeamId = _guestTeam.Id, HostTeamId = _hostTeam.Id};
			try
			{
				_gameService.InsertOne(game);
			} catch(System.Exception)
			{
				Close();
			}
			Close();
		}

		private void DateSelect_ValueChanged(object sender, EventArgs e)
		{

		}
	}
}
