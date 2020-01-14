using LabCSharp.Resources.Entity;
using System;
using System.Diagnostics;
using System.Windows.Forms;
using LabCSharp.Resources.Forms;
using LabCSharp.Resources.Service;

namespace LabCSharp
{
  public partial class Form1 : Form
  {
	  private readonly TeamService _teamService;
	  private readonly StudentService _studentService;
    public Form1()
    {
	    _teamService = new TeamService();
      _studentService = new StudentService();
      InitializeComponent();
    }

    private void Form1_Load(object sender, EventArgs e)
    {
	    _teamService.PopulateTeams();
      _studentService.PopulateStudents();
      TeamsView.DataSource = _teamService.GetAll();
      TeamsView.Columns.Remove("SchoolId");
      TeamsView.Columns.Remove("Id");
    }

    private void TeamsView_CellContentClick(object sender, DataGridViewCellEventArgs e)
    {

    }

    private void label1_Click(object sender, EventArgs e)
    {

    }

    private void button1_Click(object sender, EventArgs e)
    {
	    new GamePlayers().ShowDialog();
    }

    private void StudentCreate_Click(object sender, EventArgs e)
    {
	    new CreateStudent().ShowDialog();
    }

    private void button1_Click_1(object sender, EventArgs e)
    {
	    new AssignPlayer().ShowDialog();
    }

	  private void GameCreate_Click(object sender, EventArgs e)
	  {
		  new CreateGame().ShowDialog();
	  }

    private void ActivePlayerButton_Click(object sender, EventArgs e)
    {
	    new Resources.Forms.ActivePlayer().ShowDialog();
    }

    private void GamesPeriodButton_Click(object sender, EventArgs e)
    {
	    new GamesInPeriod().ShowDialog();
    }
  }
}
