using LabCSharp.Gateway;
using LabCSharp.Entity;
using System;
using System.Diagnostics;
using System.Windows.Forms;
using LabCSharp.Service;

namespace LabCSharp
{
  public partial class Form1 : Form
  {
    public Form1()
    {
      InitializeComponent();
    }

    private void Form1_Load(object sender, EventArgs e)
    {
      TeamService Service = new TeamService();
      TeamsDataBind.DataSource = Service.GetAll();
      TeamsView.DataSource = TeamsDataBind;
    }

    private void TeamsView_CellContentClick(object sender, DataGridViewCellEventArgs e)
    {

    }
  }
}
