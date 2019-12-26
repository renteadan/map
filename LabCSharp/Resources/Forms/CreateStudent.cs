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
using LabCSharp.Resources.Gateway;

namespace LabCSharp.Resources.Forms
{
	public partial class CreateStudent : Form
	{
		private readonly BaseGateway<School> _gatewaySchool;
		private readonly BaseGateway<Student> _gatewayStudent;
		public CreateStudent()
		{
			InitializeComponent();
			_gatewaySchool = new BaseGateway<School>();
			_gatewayStudent = new BaseGateway<Student>();
		}

		private void CreateStudent_Load(object sender, EventArgs e)
		{
			SchoolSelect.DataSource = _gatewaySchool.GetAll();
		}

		private void AddButton_Click(object sender, EventArgs e)
		{
			School aux = (School) SchoolSelect.SelectedItem;
			Student student = new Student {Name = NameBox.Text, SchoolId = aux.Id};
			_gatewayStudent.InsertOne(student);
			Close();
		}

		private void NameBox_Enter(object sender, EventArgs e)
		{
			if (NameBox.Text == "Enter name here")
				NameBox.Text = "";
		}

		private void NameBox_Leave(object sender, EventArgs e)
		{
			if (NameBox.Text == "")
				NameBox.Text = "Enter name here";
		}
	}
}
