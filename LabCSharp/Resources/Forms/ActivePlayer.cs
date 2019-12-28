using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Service;

namespace LabCSharp.Resources.Forms
{
	public partial class ActivePlayer : Form
	{
		private TeamService _teamService = new TeamService();
		private readonly GameService _gameService = new GameService();
		private readonly PlayerService _playerService = new PlayerService();
		private readonly BaseService<Entity.ActivePlayer> _activePlayerService = new BaseService<Entity.ActivePlayer>();
		private Game _selectedGame;
		private Team _selectedTeam;
		private Player _selectedPlayer;
		public ActivePlayer()
		{
			InitializeComponent();
		}

		private void ActivePlayer_Load(object sender, EventArgs e)
		{
			GameSelect.DataSource = _gameService.GetAll();
			TeamSelect.Visible = false;
			PlayerSelect.Visible = false;
		}

		private void GameSelect_SelectedIndexChanged(object sender, EventArgs e)
		{
			_selectedGame = (Game) GameSelect.SelectedItem;
			TeamSelect.DataSource = new List<Team>() {_selectedGame.Team, _selectedGame.Team1};
			TeamSelect.Visible = true;
		}

		private void TeamSelect_SelectedIndexChanged(object sender, EventArgs e)
		{
			_selectedTeam = (Team) TeamSelect.SelectedItem;
			PlayerSelect.DataSource = _playerService.GetInTeamExcept(_selectedTeam.Players, _selectedGame.ActivePlayers).ToList();
			PlayerSelect.Visible = true;
		}

		private void PlayerSelect_SelectedIndexChanged(object sender, EventArgs e)
		{
			_selectedPlayer = (Player) PlayerSelect.SelectedItem;
		}

		private void CreateButton_Click(object sender, EventArgs e)
		{
			Entity.ActivePlayer activePlayer = new Entity.ActivePlayer()
			{
				GameId = _selectedGame.Id, PlayerId = _selectedPlayer.Id, PointsScored = (int) PointsSelect.Value,
				Played = PlayerButton.Checked, TeamId = _selectedTeam.Id
			};
			_activePlayerService.InsertOne(activePlayer);
			Close();
		}
	}
}
