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
	public partial class GameDetails : Form
	{
		private readonly Game _game;
		private readonly GameService _gameService = new GameService();
		public GameDetails()
		{
			InitializeComponent();
		}

		public GameDetails(Game game)
		{
			_game = game;
			InitializeComponent();
		}

		private void GameDetails_Load(object sender, EventArgs e)
		{
			var host = false;
			var aux = _gameService.GetGameWithScore(_game);
			foreach (var pair in aux)
			{
				if (host)
				{
					HostBox.Text = pair.Value.ToString();
					HostLabel.Text += $@" {pair.Key.Name}";
					host = false;
				}
				else
				{
					GuestBox.Text = pair.Value.ToString();
					GuestLabel.Text += $@" {pair.Key.Name}";
					host = true;
				}

			}
		}
	}
}
