namespace LabCSharp.Resources.Forms
{
	partial class AssignPlayer
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.Students = new System.Windows.Forms.ListBox();
			this.Players = new System.Windows.Forms.ListBox();
			this.TeamSelect = new System.Windows.Forms.ComboBox();
			this.MakePlayer = new System.Windows.Forms.Button();
			this.MakeStudent = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// Students
			// 
			this.Students.AllowDrop = true;
			this.Students.FormattingEnabled = true;
			this.Students.ItemHeight = 16;
			this.Students.Location = new System.Drawing.Point(354, 88);
			this.Students.Name = "Students";
			this.Students.Size = new System.Drawing.Size(120, 196);
			this.Students.TabIndex = 0;
			// 
			// Players
			// 
			this.Players.AllowDrop = true;
			this.Players.FormattingEnabled = true;
			this.Players.ItemHeight = 16;
			this.Players.Location = new System.Drawing.Point(561, 88);
			this.Players.Name = "Players";
			this.Players.Size = new System.Drawing.Size(120, 196);
			this.Players.TabIndex = 1;
			// 
			// TeamSelect
			// 
			this.TeamSelect.FormattingEnabled = true;
			this.TeamSelect.Location = new System.Drawing.Point(13, 88);
			this.TeamSelect.Name = "TeamSelect";
			this.TeamSelect.Size = new System.Drawing.Size(192, 24);
			this.TeamSelect.TabIndex = 2;
			this.TeamSelect.Text = "Select team...";
			this.TeamSelect.SelectedIndexChanged += new System.EventHandler(this.TeamSelect_SelectedIndexChanged);
			// 
			// MakePlayer
			// 
			this.MakePlayer.Location = new System.Drawing.Point(480, 137);
			this.MakePlayer.Name = "MakePlayer";
			this.MakePlayer.Size = new System.Drawing.Size(75, 23);
			this.MakePlayer.TabIndex = 3;
			this.MakePlayer.Text = ">";
			this.MakePlayer.UseVisualStyleBackColor = true;
			this.MakePlayer.Click += new System.EventHandler(this.MakePlayer_Click);
			// 
			// MakeStudent
			// 
			this.MakeStudent.Location = new System.Drawing.Point(480, 177);
			this.MakeStudent.Name = "MakeStudent";
			this.MakeStudent.Size = new System.Drawing.Size(75, 23);
			this.MakeStudent.TabIndex = 4;
			this.MakeStudent.Text = "<";
			this.MakeStudent.UseVisualStyleBackColor = true;
			this.MakeStudent.Click += new System.EventHandler(this.MakeStudent_Click);
			// 
			// AssignPlayer
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.MakeStudent);
			this.Controls.Add(this.MakePlayer);
			this.Controls.Add(this.TeamSelect);
			this.Controls.Add(this.Players);
			this.Controls.Add(this.Students);
			this.Name = "AssignPlayer";
			this.Text = "AssignPlayer";
			this.Load += new System.EventHandler(this.AssignPlayer_Load);
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.ListBox Students;
		private System.Windows.Forms.ListBox Players;
		private System.Windows.Forms.ComboBox TeamSelect;
		private System.Windows.Forms.Button MakePlayer;
		private System.Windows.Forms.Button MakeStudent;
	}
}