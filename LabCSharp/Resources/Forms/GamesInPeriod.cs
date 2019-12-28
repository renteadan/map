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
	public partial class GamesInPeriod : Form
	{
		private DateTime _from, _to;
		private readonly GameService _gameService = new GameService();
		public GamesInPeriod()
		{
			InitializeComponent();
		}

		private void ToDate_ValueChanged(object sender, EventArgs e)
		{
			_to = ToDate.Value;
			SetDataSource();
		}

		private void FromDate_ValueChanged(object sender, EventArgs e)
		{
			_from = FromDate.Value;
			SetDataSource();
		}

		private void FormatView()
		{
			GamesView.Columns["Id"].Visible = false;
			GamesView.Columns["HostTeamId"].Visible = false;
			GamesView.Columns["GuestTeamId"].Visible = false;
			GamesView.Columns["Team"].HeaderText = "Host Team";
			GamesView.Columns["Team1"].HeaderText = "Guest Team";
		}

		private void GamesInPeriod_Load(object sender, EventArgs e)
		{
			_from = DateTime.Now;
			_to = DateTime.Now;
			FromDate.Value = DateTime.Now;
			ToDate.Value = DateTime.Now;
			FromDate.Format = DateTimePickerFormat.Custom;
			ToDate.Format = DateTimePickerFormat.Custom;
			ToDate.CustomFormat = "MM/dd/yyyy h:mm tt";
			FromDate.CustomFormat = "MM/dd/yyyy h:mm tt";
			SetDataSource();
		}

		private void GamesView_CellContentClick(object sender, DataGridViewCellEventArgs e)
		{
			DataGridViewRow row = GamesView.Rows[e.RowIndex];
			Game auxGame = new Game() {Id = Convert.ToInt32(row.Cells["Id"].Value.ToString())};
			auxGame = _gameService.FindOne(auxGame);
			new GameDetails(auxGame).ShowDialog();
		}

		private void GamesView_SelectionChanged(object sender, EventArgs e)
		{
		}

		private void SetDataSource()
		{
			GamesView.DataSource = _gameService.GetGamesBetweenDates(_from, _to);
			FormatView();
		}
	}
}
