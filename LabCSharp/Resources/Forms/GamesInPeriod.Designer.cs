namespace LabCSharp.Resources.Forms
{
	partial class GamesInPeriod
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
			this.FromDate = new System.Windows.Forms.DateTimePicker();
			this.ToDate = new System.Windows.Forms.DateTimePicker();
			this.GamesView = new System.Windows.Forms.DataGridView();
			((System.ComponentModel.ISupportInitialize)(this.GamesView)).BeginInit();
			this.SuspendLayout();
			// 
			// FromDate
			// 
			this.FromDate.Location = new System.Drawing.Point(13, 57);
			this.FromDate.Name = "FromDate";
			this.FromDate.Size = new System.Drawing.Size(200, 22);
			this.FromDate.TabIndex = 0;
			this.FromDate.ValueChanged += new System.EventHandler(this.FromDate_ValueChanged);
			// 
			// ToDate
			// 
			this.ToDate.Location = new System.Drawing.Point(12, 136);
			this.ToDate.Name = "ToDate";
			this.ToDate.Size = new System.Drawing.Size(200, 22);
			this.ToDate.TabIndex = 1;
			this.ToDate.ValueChanged += new System.EventHandler(this.ToDate_ValueChanged);
			// 
			// GamesView
			// 
			this.GamesView.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
			this.GamesView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.GamesView.Location = new System.Drawing.Point(464, 12);
			this.GamesView.Name = "GamesView";
			this.GamesView.ReadOnly = true;
			this.GamesView.RowHeadersVisible = false;
			this.GamesView.RowHeadersWidth = 51;
			this.GamesView.RowTemplate.Height = 24;
			this.GamesView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
			this.GamesView.Size = new System.Drawing.Size(324, 191);
			this.GamesView.TabIndex = 2;
			this.GamesView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.GamesView_CellContentClick);
			this.GamesView.SelectionChanged += new System.EventHandler(this.GamesView_SelectionChanged);
			// 
			// GamesInPeriod
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.GamesView);
			this.Controls.Add(this.ToDate);
			this.Controls.Add(this.FromDate);
			this.Name = "GamesInPeriod";
			this.Text = "GamesInPeriod";
			this.Load += new System.EventHandler(this.GamesInPeriod_Load);
			((System.ComponentModel.ISupportInitialize)(this.GamesView)).EndInit();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.DateTimePicker FromDate;
		private System.Windows.Forms.DateTimePicker ToDate;
		private System.Windows.Forms.DataGridView GamesView;
	}
}