namespace LabCSharp.Resources.Forms
{
	partial class CreateStudent
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
			this.NameBox = new System.Windows.Forms.TextBox();
			this.SchoolSelect = new System.Windows.Forms.ComboBox();
			this.label1 = new System.Windows.Forms.Label();
			this.AddButton = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// NameBox
			// 
			this.NameBox.Location = new System.Drawing.Point(13, 125);
			this.NameBox.Name = "NameBox";
			this.NameBox.Size = new System.Drawing.Size(100, 22);
			this.NameBox.TabIndex = 0;
			this.NameBox.Enter += new System.EventHandler(this.NameBox_Enter);
			this.NameBox.Leave += new System.EventHandler(this.NameBox_Leave);
			// 
			// SchoolSelect
			// 
			this.SchoolSelect.FormattingEnabled = true;
			this.SchoolSelect.Location = new System.Drawing.Point(168, 123);
			this.SchoolSelect.Name = "SchoolSelect";
			this.SchoolSelect.Size = new System.Drawing.Size(165, 24);
			this.SchoolSelect.TabIndex = 1;
			this.SchoolSelect.Text = "Select school...";
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 22.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
			this.label1.Location = new System.Drawing.Point(50, 36);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(239, 44);
			this.label1.TabIndex = 2;
			this.label1.Text = "Add Student";
			// 
			// AddButton
			// 
			this.AddButton.Location = new System.Drawing.Point(12, 174);
			this.AddButton.Name = "AddButton";
			this.AddButton.Size = new System.Drawing.Size(75, 23);
			this.AddButton.TabIndex = 3;
			this.AddButton.Text = "Add";
			this.AddButton.UseVisualStyleBackColor = true;
			this.AddButton.Click += new System.EventHandler(this.AddButton_Click);
			// 
			// CreateStudent
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(345, 209);
			this.Controls.Add(this.AddButton);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.SchoolSelect);
			this.Controls.Add(this.NameBox);
			this.Name = "CreateStudent";
			this.Text = "CreateStudent";
			this.Load += new System.EventHandler(this.CreateStudent_Load);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.TextBox NameBox;
		private System.Windows.Forms.ComboBox SchoolSelect;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Button AddButton;
	}
}