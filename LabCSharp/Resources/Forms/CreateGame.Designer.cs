namespace LabCSharp.Resources.Forms
{
	partial class CreateGame
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
			this.TeamSelect1 = new System.Windows.Forms.ComboBox();
			this.TeamSelect2 = new System.Windows.Forms.ComboBox();
			this.DateSelect = new System.Windows.Forms.DateTimePicker();
			this.GameAdd = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// TeamSelect1
			// 
			this.TeamSelect1.FormattingEnabled = true;
			this.TeamSelect1.Location = new System.Drawing.Point(32, 92);
			this.TeamSelect1.Name = "TeamSelect1";
			this.TeamSelect1.Size = new System.Drawing.Size(149, 24);
			this.TeamSelect1.TabIndex = 0;
			this.TeamSelect1.Text = "Select host team...";
			this.TeamSelect1.SelectedIndexChanged += new System.EventHandler(this.TeamSelect1_SelectedIndexChanged);
			// 
			// TeamSelect2
			// 
			this.TeamSelect2.FormattingEnabled = true;
			this.TeamSelect2.Location = new System.Drawing.Point(436, 92);
			this.TeamSelect2.Name = "TeamSelect2";
			this.TeamSelect2.Size = new System.Drawing.Size(146, 24);
			this.TeamSelect2.TabIndex = 1;
			this.TeamSelect2.Text = "Select guest team...";
			this.TeamSelect2.SelectedIndexChanged += new System.EventHandler(this.TeamSelect2_SelectedIndexChanged);
			// 
			// DateSelect
			// 
			this.DateSelect.CustomFormat = "MM/dd/yyyy h:mm tt";
			this.DateSelect.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
			this.DateSelect.Location = new System.Drawing.Point(175, 143);
			this.DateSelect.Name = "DateSelect";
			this.DateSelect.Size = new System.Drawing.Size(271, 22);
			this.DateSelect.TabIndex = 2;
			this.DateSelect.Value = new System.DateTime(2019, 12, 28, 12, 41, 30, 0);
			this.DateSelect.ValueChanged += new System.EventHandler(this.DateSelect_ValueChanged);
			// 
			// GameAdd
			// 
			this.GameAdd.Location = new System.Drawing.Point(32, 179);
			this.GameAdd.Name = "GameAdd";
			this.GameAdd.Size = new System.Drawing.Size(75, 23);
			this.GameAdd.TabIndex = 3;
			this.GameAdd.Text = "Add game";
			this.GameAdd.UseVisualStyleBackColor = true;
			this.GameAdd.Click += new System.EventHandler(this.GameAdd_Click);
			// 
			// CreateGame
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(623, 274);
			this.Controls.Add(this.GameAdd);
			this.Controls.Add(this.DateSelect);
			this.Controls.Add(this.TeamSelect2);
			this.Controls.Add(this.TeamSelect1);
			this.Name = "CreateGame";
			this.Text = "CreateGame";
			this.Load += new System.EventHandler(this.CreateGame_Load);
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.ComboBox TeamSelect1;
		private System.Windows.Forms.ComboBox TeamSelect2;
		private System.Windows.Forms.DateTimePicker DateSelect;
		private System.Windows.Forms.Button GameAdd;
	}
}