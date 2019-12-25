namespace LabCSharp
{
  partial class Form1
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
			System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
			this.TeamsView = new System.Windows.Forms.DataGridView();
			this.label1 = new System.Windows.Forms.Label();
			this.button1 = new System.Windows.Forms.Button();
			((System.ComponentModel.ISupportInitialize)(this.TeamsView)).BeginInit();
			this.SuspendLayout();
			// 
			// TeamsView
			// 
			this.TeamsView.AllowUserToAddRows = false;
			this.TeamsView.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
			this.TeamsView.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.AllCells;
			this.TeamsView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.TeamsView.Location = new System.Drawing.Point(454, 55);
			this.TeamsView.MultiSelect = false;
			this.TeamsView.Name = "TeamsView";
			this.TeamsView.RowHeadersVisible = false;
			this.TeamsView.RowHeadersWidth = 51;
			dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
			this.TeamsView.RowsDefaultCellStyle = dataGridViewCellStyle1;
			this.TeamsView.RowTemplate.Height = 24;
			this.TeamsView.Size = new System.Drawing.Size(334, 185);
			this.TeamsView.TabIndex = 0;
			this.TeamsView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.TeamsView_CellContentClick);
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
			this.label1.Location = new System.Drawing.Point(448, 9);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(106, 32);
			this.label1.TabIndex = 1;
			this.label1.Text = "Teams";
			this.label1.Click += new System.EventHandler(this.label1_Click);
			// 
			// button1
			// 
			this.button1.Location = new System.Drawing.Point(13, 216);
			this.button1.Name = "button1";
			this.button1.Size = new System.Drawing.Size(75, 23);
			this.button1.TabIndex = 2;
			this.button1.Text = "button1";
			this.button1.UseVisualStyleBackColor = true;
			this.button1.Click += new System.EventHandler(this.button1_Click);
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.button1);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.TeamsView);
			this.Name = "Form1";
			this.Text = "Form1";
			this.Load += new System.EventHandler(this.Form1_Load);
			((System.ComponentModel.ISupportInitialize)(this.TeamsView)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();

    }

        #endregion

        private System.Windows.Forms.DataGridView TeamsView;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Button button1;
	}
}

