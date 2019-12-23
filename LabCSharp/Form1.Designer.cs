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
			this.components = new System.ComponentModel.Container();
			this.TeamsView = new System.Windows.Forms.DataGridView();
			this.TeamsDataBind = new System.Windows.Forms.BindingSource(this.components);
			((System.ComponentModel.ISupportInitialize)(this.TeamsView)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.TeamsDataBind)).BeginInit();
			this.SuspendLayout();
			// 
			// TeamsView
			// 
			this.TeamsView.AllowUserToAddRows = false;
			this.TeamsView.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
			this.TeamsView.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.AllCells;
			this.TeamsView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.TeamsView.Location = new System.Drawing.Point(487, 55);
			this.TeamsView.MultiSelect = false;
			this.TeamsView.Name = "TeamsView";
			this.TeamsView.RowHeadersVisible = false;
			this.TeamsView.RowHeadersWidth = 51;
			this.TeamsView.RowTemplate.Height = 24;
			this.TeamsView.Size = new System.Drawing.Size(240, 150);
			this.TeamsView.TabIndex = 0;
			this.TeamsView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.TeamsView_CellContentClick);
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.TeamsView);
			this.Name = "Form1";
			this.Text = "Form1";
			this.Load += new System.EventHandler(this.Form1_Load);
			((System.ComponentModel.ISupportInitialize)(this.TeamsView)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.TeamsDataBind)).EndInit();
			this.ResumeLayout(false);

    }

        #endregion

        private System.Windows.Forms.DataGridView TeamsView;
        private System.Windows.Forms.BindingSource TeamsDataBind;
    }
}

