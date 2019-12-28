namespace LabCSharp.Resources.Forms
{
	partial class ActivePlayer
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
			this.TeamSelect = new System.Windows.Forms.ComboBox();
			this.PlayerSelect = new System.Windows.Forms.ComboBox();
			this.PlayerButton = new System.Windows.Forms.RadioButton();
			this.ReserveButton = new System.Windows.Forms.RadioButton();
			this.GameSelect = new System.Windows.Forms.ComboBox();
			this.PointsSelect = new System.Windows.Forms.NumericUpDown();
			this.CreateButton = new System.Windows.Forms.Button();
			((System.ComponentModel.ISupportInitialize)(this.PointsSelect)).BeginInit();
			this.SuspendLayout();
			// 
			// TeamSelect
			// 
			this.TeamSelect.FormattingEnabled = true;
			this.TeamSelect.Location = new System.Drawing.Point(12, 112);
			this.TeamSelect.Name = "TeamSelect";
			this.TeamSelect.Size = new System.Drawing.Size(121, 24);
			this.TeamSelect.TabIndex = 0;
			this.TeamSelect.Text = "Select team...";
			this.TeamSelect.Visible = false;
			this.TeamSelect.SelectedIndexChanged += new System.EventHandler(this.TeamSelect_SelectedIndexChanged);
			// 
			// PlayerSelect
			// 
			this.PlayerSelect.FormattingEnabled = true;
			this.PlayerSelect.Location = new System.Drawing.Point(12, 161);
			this.PlayerSelect.Name = "PlayerSelect";
			this.PlayerSelect.Size = new System.Drawing.Size(121, 24);
			this.PlayerSelect.TabIndex = 1;
			this.PlayerSelect.Text = "Select player...";
			this.PlayerSelect.Visible = false;
			this.PlayerSelect.SelectedIndexChanged += new System.EventHandler(this.PlayerSelect_SelectedIndexChanged);
			// 
			// PlayerButton
			// 
			this.PlayerButton.AutoSize = true;
			this.PlayerButton.Location = new System.Drawing.Point(356, 146);
			this.PlayerButton.Name = "PlayerButton";
			this.PlayerButton.Size = new System.Drawing.Size(69, 21);
			this.PlayerButton.TabIndex = 3;
			this.PlayerButton.TabStop = true;
			this.PlayerButton.Text = "Player";
			this.PlayerButton.UseVisualStyleBackColor = true;
			// 
			// ReserveButton
			// 
			this.ReserveButton.AutoSize = true;
			this.ReserveButton.Location = new System.Drawing.Point(356, 173);
			this.ReserveButton.Name = "ReserveButton";
			this.ReserveButton.Size = new System.Drawing.Size(82, 21);
			this.ReserveButton.TabIndex = 4;
			this.ReserveButton.TabStop = true;
			this.ReserveButton.Text = "Reserve";
			this.ReserveButton.UseVisualStyleBackColor = true;
			// 
			// GameSelect
			// 
			this.GameSelect.FormattingEnabled = true;
			this.GameSelect.Location = new System.Drawing.Point(13, 62);
			this.GameSelect.Name = "GameSelect";
			this.GameSelect.Size = new System.Drawing.Size(121, 24);
			this.GameSelect.TabIndex = 5;
			this.GameSelect.Text = "Select game...";
			this.GameSelect.SelectedIndexChanged += new System.EventHandler(this.GameSelect_SelectedIndexChanged);
			// 
			// PointsSelect
			// 
			this.PointsSelect.Location = new System.Drawing.Point(356, 84);
			this.PointsSelect.Name = "PointsSelect";
			this.PointsSelect.Size = new System.Drawing.Size(120, 22);
			this.PointsSelect.TabIndex = 6;
			// 
			// CreateButton
			// 
			this.CreateButton.Location = new System.Drawing.Point(12, 247);
			this.CreateButton.Name = "CreateButton";
			this.CreateButton.Size = new System.Drawing.Size(154, 23);
			this.CreateButton.TabIndex = 7;
			this.CreateButton.Text = "Create Active Player";
			this.CreateButton.UseVisualStyleBackColor = true;
			this.CreateButton.Click += new System.EventHandler(this.CreateButton_Click);
			// 
			// ActivePlayer
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.CreateButton);
			this.Controls.Add(this.PointsSelect);
			this.Controls.Add(this.GameSelect);
			this.Controls.Add(this.ReserveButton);
			this.Controls.Add(this.PlayerButton);
			this.Controls.Add(this.PlayerSelect);
			this.Controls.Add(this.TeamSelect);
			this.Name = "ActivePlayer";
			this.Text = "ActivePlayer";
			this.Load += new System.EventHandler(this.ActivePlayer_Load);
			((System.ComponentModel.ISupportInitialize)(this.PointsSelect)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.ComboBox TeamSelect;
		private System.Windows.Forms.ComboBox PlayerSelect;
		private System.Windows.Forms.RadioButton PlayerButton;
		private System.Windows.Forms.RadioButton ReserveButton;
		private System.Windows.Forms.ComboBox GameSelect;
		private System.Windows.Forms.NumericUpDown PointsSelect;
		private System.Windows.Forms.Button CreateButton;
	}
}