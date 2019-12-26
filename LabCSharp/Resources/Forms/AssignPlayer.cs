using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Linq;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Gateway;
using LabCSharp.Resources.Service;

namespace LabCSharp.Resources.Forms
{
	public partial class AssignPlayer : Form
	{
		private TeamService _teamService = new TeamService();
		private readonly BaseService<Player> _playerService = new BaseService<Player>();
		private Team _selectedTeam;
		public AssignPlayer()
		{
			InitializeComponent();
		}

		private void AssignPlayer_Load(object sender, EventArgs e)
		{
			TeamSelect.DataSource = _teamService.GetAll();
		}

		private EntitySet<Student> FilterPlayers(EntitySet<Student> students, EntitySet<Player> players)
		{
			EntitySet<Student> aux = new EntitySet<Student>();
			foreach (var student in students)
			{
				if (players.All(player => player.StudentId != student.Id))
					aux.Add(student);
			}

			return aux;
		}

		private void TeamSelect_SelectedIndexChanged(object sender, EventArgs e)
		{
			SetDataSource();
		}

		private void SetDataSource()
		{
			_selectedTeam = (Team)TeamSelect.SelectedItem;
			_selectedTeam = _teamService.FindOne(_selectedTeam);
			Players.DataSource = _selectedTeam.Players;
			Students.DataSource = FilterPlayers(_selectedTeam.School.Students, _selectedTeam.Players);
			Players.Refresh();
			Students.Refresh();
		}

		private bool CheckTeam()
		{
			return _selectedTeam == null;
		}

		private void MakePlayer_Click(object sender, EventArgs e)
		{
			if (CheckTeam())
				return;
			if (Students.Items.Count == 0)
				return;
			Student student = (Student) Students.SelectedItem;
			Player player = new Player(){StudentId = student.Id, TeamId = _selectedTeam.Id};
			_playerService.InsertOne(player);
			SetDataSource();
		}

		private void MakeStudent_Click(object sender, EventArgs e)
		{
			if (CheckTeam())
				return;
			if (Players.Items.Count == 0)
				return;
			Player player = (Player) Players.SelectedItem;
			Player aux = new Player { Id = player.Id };
			_playerService.DeleteOne(aux);
			SetDataSource();
		}

		private void button1_Click(object sender, EventArgs e)
		{
			SetDataSource();
		}
	}
}
