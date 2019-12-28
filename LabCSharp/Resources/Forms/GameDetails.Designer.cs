namespace LabCSharp.Resources.Forms
{
	partial class GameDetails
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
			this.HostLabel = new System.Windows.Forms.Label();
			this.GuestLabel = new System.Windows.Forms.Label();
			this.HostBox = new System.Windows.Forms.TextBox();
			this.GuestBox = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// HostLabel
			// 
			this.HostLabel.AutoSize = true;
			this.HostLabel.Location = new System.Drawing.Point(27, 64);
			this.HostLabel.Name = "HostLabel";
			this.HostLabel.Size = new System.Drawing.Size(120, 17);
			this.HostLabel.TabIndex = 0;
			this.HostLabel.Text = "Host Team Points";
			// 
			// GuestLabel
			// 
			this.GuestLabel.AutoSize = true;
			this.GuestLabel.Location = new System.Drawing.Point(258, 64);
			this.GuestLabel.Name = "GuestLabel";
			this.GuestLabel.Size = new System.Drawing.Size(129, 17);
			this.GuestLabel.TabIndex = 1;
			this.GuestLabel.Text = "Guest Team Points";
			// 
			// HostBox
			// 
			this.HostBox.Enabled = false;
			this.HostBox.Location = new System.Drawing.Point(30, 135);
			this.HostBox.Name = "HostBox";
			this.HostBox.Size = new System.Drawing.Size(100, 22);
			this.HostBox.TabIndex = 2;
			// 
			// GuestBox
			// 
			this.GuestBox.Enabled = false;
			this.GuestBox.Location = new System.Drawing.Point(261, 135);
			this.GuestBox.Name = "GuestBox";
			this.GuestBox.Size = new System.Drawing.Size(100, 22);
			this.GuestBox.TabIndex = 3;
			// 
			// GameDetails
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(505, 319);
			this.Controls.Add(this.GuestBox);
			this.Controls.Add(this.HostBox);
			this.Controls.Add(this.GuestLabel);
			this.Controls.Add(this.HostLabel);
			this.Name = "GameDetails";
			this.Text = "GameDetails";
			this.Load += new System.EventHandler(this.GameDetails_Load);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label HostLabel;
		private System.Windows.Forms.Label GuestLabel;
		private System.Windows.Forms.TextBox HostBox;
		private System.Windows.Forms.TextBox GuestBox;
	}
}