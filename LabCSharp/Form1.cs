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
    public Form1()
    {
	    _teamService = new TeamService();
      InitializeComponent();
    }

    private void Form1_Load(object sender, EventArgs e)
    {
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
	    new GamePlayers().Show();
    }
  }
}
