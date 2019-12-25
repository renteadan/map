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
	public partial class GamePlayers : Form
	{
		private readonly GameService _gameService;
		private Game _selectedGame;
		private Team _selectedTeam;
		public GamePlayers()
		{
			_gameService = new GameService();
			InitializeComponent();
			SelectGame.DataSource = _gameService.GetAll();
		}

		private void GamePlayers_Load(object sender, EventArgs e)
		{

		}

		private void SelectGame_SelectedIndexChanged(object sender, EventArgs e)
		{
			_selectedGame = (Game) SelectGame.SelectedItem;
			SelectTeam.Items.Clear();
			SelectTeam.Items.AddRange(new[]{ _selectedGame.Team, _selectedGame.Team1 });
			SelectTeam.Visible = true;
		}

		private void SelectTeam_SelectedIndexChanged(object sender, EventArgs e)
		{
			_selectedTeam = (Team) SelectTeam.SelectedItem;
			ActivePlayersView.DataSource = _gameService.GetTeamPlayersInGame(_selectedTeam, _selectedGame);
			RemoveColumns();
		}

		private void RemoveColumns()
		{
			ActivePlayersView.Columns.Remove("Id");
			ActivePlayersView.Columns.Remove("GameId");
			ActivePlayersView.Columns.Remove("PlayerId");
			ActivePlayersView.Columns.Remove("Game");
		}
	}
}
