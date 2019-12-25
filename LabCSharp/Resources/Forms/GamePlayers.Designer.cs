namespace LabCSharp.Resources.Forms
{
	partial class GamePlayers
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
			this.SelectGame = new System.Windows.Forms.ComboBox();
			this.ActivePlayersView = new System.Windows.Forms.DataGridView();
			this.SelectTeam = new System.Windows.Forms.ComboBox();
			((System.ComponentModel.ISupportInitialize)(this.ActivePlayersView)).BeginInit();
			this.SuspendLayout();
			// 
			// SelectGame
			// 
			this.SelectGame.FormattingEnabled = true;
			this.SelectGame.Location = new System.Drawing.Point(12, 12);
			this.SelectGame.Name = "SelectGame";
			this.SelectGame.Size = new System.Drawing.Size(204, 24);
			this.SelectGame.TabIndex = 0;
			this.SelectGame.Text = "Select game...";
			this.SelectGame.SelectedIndexChanged += new System.EventHandler(this.SelectGame_SelectedIndexChanged);
			// 
			// ActivePlayersView
			// 
			this.ActivePlayersView.AllowUserToAddRows = false;
			this.ActivePlayersView.AllowUserToDeleteRows = false;
			this.ActivePlayersView.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
			this.ActivePlayersView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.ActivePlayersView.Location = new System.Drawing.Point(390, 12);
			this.ActivePlayersView.Name = "ActivePlayersView";
			this.ActivePlayersView.ReadOnly = true;
			this.ActivePlayersView.RowHeadersVisible = false;
			this.ActivePlayersView.RowHeadersWidth = 51;
			this.ActivePlayersView.RowTemplate.Height = 24;
			this.ActivePlayersView.Size = new System.Drawing.Size(398, 335);
			this.ActivePlayersView.TabIndex = 1;
			// 
			// SelectTeam
			// 
			this.SelectTeam.FormattingEnabled = true;
			this.SelectTeam.Location = new System.Drawing.Point(12, 64);
			this.SelectTeam.Name = "SelectTeam";
			this.SelectTeam.Size = new System.Drawing.Size(204, 24);
			this.SelectTeam.TabIndex = 2;
			this.SelectTeam.Text = "Select team...";
			this.SelectTeam.Visible = false;
			this.SelectTeam.SelectedIndexChanged += new System.EventHandler(this.SelectTeam_SelectedIndexChanged);
			// 
			// GamePlayers
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.SelectTeam);
			this.Controls.Add(this.ActivePlayersView);
			this.Controls.Add(this.SelectGame);
			this.Name = "GamePlayers";
			this.Text = "GamePlayers";
			this.Load += new System.EventHandler(this.GamePlayers_Load);
			((System.ComponentModel.ISupportInitialize)(this.ActivePlayersView)).EndInit();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.ComboBox SelectGame;
		private System.Windows.Forms.DataGridView ActivePlayersView;
		private System.Windows.Forms.ComboBox SelectTeam;
	}
}