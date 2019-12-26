﻿#pragma warning disable 1591
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace LabCSharp.Resources.Entity
{
	using System.Data.Linq;
	using System.Data.Linq.Mapping;
	using System.Data;
	using System.Collections.Generic;
	using System.Reflection;
	using System.Linq;
	using System.Linq.Expressions;
	using System.ComponentModel;
	using System;
	
	
	[global::System.Data.Linq.Mapping.DatabaseAttribute(Name="NBA")]
	public partial class NBALeagueDataContext : System.Data.Linq.DataContext
	{
		
		private static System.Data.Linq.Mapping.MappingSource mappingSource = new AttributeMappingSource();
		
    #region Extensibility Method Definitions
    partial void OnCreated();
    partial void InsertTeam(Team instance);
    partial void UpdateTeam(Team instance);
    partial void DeleteTeam(Team instance);
    partial void InsertGame(Game instance);
    partial void UpdateGame(Game instance);
    partial void DeleteGame(Game instance);
    partial void InsertSchool(School instance);
    partial void UpdateSchool(School instance);
    partial void DeleteSchool(School instance);
    partial void InsertStudent(Student instance);
    partial void UpdateStudent(Student instance);
    partial void DeleteStudent(Student instance);
    partial void InsertActivePlayer(ActivePlayer instance);
    partial void UpdateActivePlayer(ActivePlayer instance);
    partial void DeleteActivePlayer(ActivePlayer instance);
    partial void InsertPlayer(Player instance);
    partial void UpdatePlayer(Player instance);
    partial void DeletePlayer(Player instance);
    #endregion
		
		public NBALeagueDataContext() : 
				base(global::LabCSharp.Properties.Settings.Default.NBAConnectionString, mappingSource)
		{
			OnCreated();
		}
		
		public NBALeagueDataContext(string connection) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public NBALeagueDataContext(System.Data.IDbConnection connection) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public NBALeagueDataContext(string connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public NBALeagueDataContext(System.Data.IDbConnection connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public System.Data.Linq.Table<Team> Teams
		{
			get
			{
				return this.GetTable<Team>();
			}
		}
		
		public System.Data.Linq.Table<Game> Games
		{
			get
			{
				return this.GetTable<Game>();
			}
		}
		
		public System.Data.Linq.Table<School> Schools
		{
			get
			{
				return this.GetTable<School>();
			}
		}
		
		public System.Data.Linq.Table<Student> Students
		{
			get
			{
				return this.GetTable<Student>();
			}
		}
		
		public System.Data.Linq.Table<ActivePlayer> ActivePlayers
		{
			get
			{
				return this.GetTable<ActivePlayer>();
			}
		}
		
		public System.Data.Linq.Table<Player> Players
		{
			get
			{
				return this.GetTable<Player>();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.Teams")]
	public partial class Team : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private int _Id;
		
		private string _Name;
		
		private int _SchoolId;
		
		private EntitySet<Game> _Games;
		
		private EntitySet<Game> _Games1;
		
		private EntitySet<Player> _Players;
		
		private EntityRef<School> _School;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnNameChanging(string value);
    partial void OnNameChanged();
    partial void OnSchoolIdChanging(int value);
    partial void OnSchoolIdChanged();
    #endregion
		
		public Team()
		{
			this._Games = new EntitySet<Game>(new Action<Game>(this.attach_Games), new Action<Game>(this.detach_Games));
			this._Games1 = new EntitySet<Game>(new Action<Game>(this.attach_Games1), new Action<Game>(this.detach_Games1));
			this._Players = new EntitySet<Player>(new Action<Player>(this.attach_Players), new Action<Player>(this.detach_Players));
			this._School = default(EntityRef<School>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", AutoSync=AutoSync.OnInsert, DbType="Int NOT NULL IDENTITY", IsPrimaryKey=true, IsDbGenerated=true)]
		public int Id
		{
			get
			{
				return this._Id;
			}
			set
			{
				if ((this._Id != value))
				{
					this.OnIdChanging(value);
					this.SendPropertyChanging();
					this._Id = value;
					this.SendPropertyChanged("Id");
					this.OnIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Name", DbType="NChar(50) NOT NULL", CanBeNull=false)]
		public string Name
		{
			get
			{
				return this._Name;
			}
			set
			{
				if ((this._Name != value))
				{
					this.OnNameChanging(value);
					this.SendPropertyChanging();
					this._Name = value;
					this.SendPropertyChanged("Name");
					this.OnNameChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_SchoolId", DbType="Int NOT NULL")]
		public int SchoolId
		{
			get
			{
				return this._SchoolId;
			}
			set
			{
				if ((this._SchoolId != value))
				{
					if (this._School.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnSchoolIdChanging(value);
					this.SendPropertyChanging();
					this._SchoolId = value;
					this.SendPropertyChanged("SchoolId");
					this.OnSchoolIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Team_Game", Storage="_Games", ThisKey="Id", OtherKey="GuestTeamId")]
		public EntitySet<Game> Games
		{
			get
			{
				return this._Games;
			}
			set
			{
				this._Games.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Team_Game1", Storage="_Games1", ThisKey="Id", OtherKey="HostTeamId")]
		public EntitySet<Game> Games1
		{
			get
			{
				return this._Games1;
			}
			set
			{
				this._Games1.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Team_Player", Storage="_Players", ThisKey="Id", OtherKey="TeamId")]
		public EntitySet<Player> Players
		{
			get
			{
				return this._Players;
			}
			set
			{
				this._Players.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="School_Team", Storage="_School", ThisKey="SchoolId", OtherKey="Id", IsForeignKey=true)]
		public School School
		{
			get
			{
				return this._School.Entity;
			}
			set
			{
				School previousValue = this._School.Entity;
				if (((previousValue != value) 
							|| (this._School.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._School.Entity = null;
						previousValue.Teams = null;
					}
					this._School.Entity = value;
					if ((value != null))
					{
						value.Teams = this;
						this._SchoolId = value.Id;
					}
					else
					{
						this._SchoolId = default(int);
					}
					this.SendPropertyChanged("School");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_Games(Game entity)
		{
			this.SendPropertyChanging();
			entity.Team = this;
		}
		
		private void detach_Games(Game entity)
		{
			this.SendPropertyChanging();
			entity.Team = null;
		}
		
		private void attach_Games1(Game entity)
		{
			this.SendPropertyChanging();
			entity.Team1 = this;
		}
		
		private void detach_Games1(Game entity)
		{
			this.SendPropertyChanging();
			entity.Team1 = null;
		}
		
		private void attach_Players(Player entity)
		{
			this.SendPropertyChanging();
			entity.Team = this;
		}
		
		private void detach_Players(Player entity)
		{
			this.SendPropertyChanging();
			entity.Team = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.Games")]
	public partial class Game : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private int _Id;
		
		private System.DateTime _Date;
		
		private int _HostTeamId;
		
		private int _GuestTeamId;
		
		private EntitySet<ActivePlayer> _ActivePlayers;
		
		private EntityRef<Team> _Team;
		
		private EntityRef<Team> _Team1;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnDateChanging(System.DateTime value);
    partial void OnDateChanged();
    partial void OnHostTeamIdChanging(int value);
    partial void OnHostTeamIdChanged();
    partial void OnGuestTeamIdChanging(int value);
    partial void OnGuestTeamIdChanged();
    #endregion
		
		public Game()
		{
			this._ActivePlayers = new EntitySet<ActivePlayer>(new Action<ActivePlayer>(this.attach_ActivePlayers), new Action<ActivePlayer>(this.detach_ActivePlayers));
			this._Team = default(EntityRef<Team>);
			this._Team1 = default(EntityRef<Team>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", DbType="Int NOT NULL", IsPrimaryKey=true)]
		public int Id
		{
			get
			{
				return this._Id;
			}
			set
			{
				if ((this._Id != value))
				{
					this.OnIdChanging(value);
					this.SendPropertyChanging();
					this._Id = value;
					this.SendPropertyChanged("Id");
					this.OnIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Date", DbType="DateTime2 NOT NULL")]
		public System.DateTime Date
		{
			get
			{
				return this._Date;
			}
			set
			{
				if ((this._Date != value))
				{
					this.OnDateChanging(value);
					this.SendPropertyChanging();
					this._Date = value;
					this.SendPropertyChanged("Date");
					this.OnDateChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_HostTeamId", DbType="Int NOT NULL")]
		public int HostTeamId
		{
			get
			{
				return this._HostTeamId;
			}
			set
			{
				if ((this._HostTeamId != value))
				{
					if (this._Team1.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnHostTeamIdChanging(value);
					this.SendPropertyChanging();
					this._HostTeamId = value;
					this.SendPropertyChanged("HostTeamId");
					this.OnHostTeamIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_GuestTeamId", DbType="Int NOT NULL")]
		public int GuestTeamId
		{
			get
			{
				return this._GuestTeamId;
			}
			set
			{
				if ((this._GuestTeamId != value))
				{
					if (this._Team.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnGuestTeamIdChanging(value);
					this.SendPropertyChanging();
					this._GuestTeamId = value;
					this.SendPropertyChanged("GuestTeamId");
					this.OnGuestTeamIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Game_ActivePlayer", Storage="_ActivePlayers", ThisKey="Id", OtherKey="GameId")]
		public EntitySet<ActivePlayer> ActivePlayers
		{
			get
			{
				return this._ActivePlayers;
			}
			set
			{
				this._ActivePlayers.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Team_Game", Storage="_Team", ThisKey="GuestTeamId", OtherKey="Id", IsForeignKey=true)]
		public Team Team
		{
			get
			{
				return this._Team.Entity;
			}
			set
			{
				Team previousValue = this._Team.Entity;
				if (((previousValue != value) 
							|| (this._Team.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Team.Entity = null;
						previousValue.Games.Remove(this);
					}
					this._Team.Entity = value;
					if ((value != null))
					{
						value.Games.Add(this);
						this._GuestTeamId = value.Id;
					}
					else
					{
						this._GuestTeamId = default(int);
					}
					this.SendPropertyChanged("Team");
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Team_Game1", Storage="_Team1", ThisKey="HostTeamId", OtherKey="Id", IsForeignKey=true)]
		public Team Team1
		{
			get
			{
				return this._Team1.Entity;
			}
			set
			{
				Team previousValue = this._Team1.Entity;
				if (((previousValue != value) 
							|| (this._Team1.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Team1.Entity = null;
						previousValue.Games1.Remove(this);
					}
					this._Team1.Entity = value;
					if ((value != null))
					{
						value.Games1.Add(this);
						this._HostTeamId = value.Id;
					}
					else
					{
						this._HostTeamId = default(int);
					}
					this.SendPropertyChanged("Team1");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_ActivePlayers(ActivePlayer entity)
		{
			this.SendPropertyChanging();
			entity.Game = this;
		}
		
		private void detach_ActivePlayers(ActivePlayer entity)
		{
			this.SendPropertyChanging();
			entity.Game = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.Schools")]
	public partial class School : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private int _Id;
		
		private string _Name;
		
		private EntityRef<Team> _Teams;
		
		private EntitySet<Student> _Students;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnNameChanging(string value);
    partial void OnNameChanged();
    #endregion
		
		public School()
		{
			this._Teams = default(EntityRef<Team>);
			this._Students = new EntitySet<Student>(new Action<Student>(this.attach_Students), new Action<Student>(this.detach_Students));
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", AutoSync=AutoSync.OnInsert, DbType="Int NOT NULL IDENTITY", IsPrimaryKey=true, IsDbGenerated=true)]
		public int Id
		{
			get
			{
				return this._Id;
			}
			set
			{
				if ((this._Id != value))
				{
					this.OnIdChanging(value);
					this.SendPropertyChanging();
					this._Id = value;
					this.SendPropertyChanged("Id");
					this.OnIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Name", DbType="NChar(50)")]
		public string Name
		{
			get
			{
				return this._Name;
			}
			set
			{
				if ((this._Name != value))
				{
					this.OnNameChanging(value);
					this.SendPropertyChanging();
					this._Name = value;
					this.SendPropertyChanged("Name");
					this.OnNameChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="School_Team", Storage="_Teams", ThisKey="Id", OtherKey="SchoolId", IsUnique=true, IsForeignKey=false)]
		public Team Teams
		{
			get
			{
				return this._Teams.Entity;
			}
			set
			{
				Team previousValue = this._Teams.Entity;
				if (((previousValue != value) 
							|| (this._Teams.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Teams.Entity = null;
						previousValue.School = null;
					}
					this._Teams.Entity = value;
					if ((value != null))
					{
						value.School = this;
					}
					this.SendPropertyChanged("Teams");
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="School_Student", Storage="_Students", ThisKey="Id", OtherKey="SchoolId")]
		public EntitySet<Student> Students
		{
			get
			{
				return this._Students;
			}
			set
			{
				this._Students.Assign(value);
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_Students(Student entity)
		{
			this.SendPropertyChanging();
			entity.School = this;
		}
		
		private void detach_Students(Student entity)
		{
			this.SendPropertyChanging();
			entity.School = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.Students")]
	public partial class Student : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private int _Id;
		
		private string _Name;
		
		private int _SchoolId;
		
		private EntityRef<Player> _Players;
		
		private EntityRef<School> _School;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnNameChanging(string value);
    partial void OnNameChanged();
    partial void OnSchoolIdChanging(int value);
    partial void OnSchoolIdChanged();
    #endregion
		
		public Student()
		{
			this._Players = default(EntityRef<Player>);
			this._School = default(EntityRef<School>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", AutoSync=AutoSync.OnInsert, DbType="Int NOT NULL IDENTITY", IsPrimaryKey=true, IsDbGenerated=true)]
		public int Id
		{
			get
			{
				return this._Id;
			}
			set
			{
				if ((this._Id != value))
				{
					this.OnIdChanging(value);
					this.SendPropertyChanging();
					this._Id = value;
					this.SendPropertyChanged("Id");
					this.OnIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Name", DbType="NChar(10)")]
		public string Name
		{
			get
			{
				return this._Name;
			}
			set
			{
				if ((this._Name != value))
				{
					this.OnNameChanging(value);
					this.SendPropertyChanging();
					this._Name = value;
					this.SendPropertyChanged("Name");
					this.OnNameChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_SchoolId", DbType="Int NOT NULL")]
		public int SchoolId
		{
			get
			{
				return this._SchoolId;
			}
			set
			{
				if ((this._SchoolId != value))
				{
					if (this._School.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnSchoolIdChanging(value);
					this.SendPropertyChanging();
					this._SchoolId = value;
					this.SendPropertyChanged("SchoolId");
					this.OnSchoolIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Student_Player", Storage="_Players", ThisKey="Id", OtherKey="StudentId", IsUnique=true, IsForeignKey=false)]
		public Player Players
		{
			get
			{
				return this._Players.Entity;
			}
			set
			{
				Player previousValue = this._Players.Entity;
				if (((previousValue != value) 
							|| (this._Players.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Players.Entity = null;
						previousValue.Student = null;
					}
					this._Players.Entity = value;
					if ((value != null))
					{
						value.Student = this;
					}
					this.SendPropertyChanged("Players");
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="School_Student", Storage="_School", ThisKey="SchoolId", OtherKey="Id", IsForeignKey=true)]
		public School School
		{
			get
			{
				return this._School.Entity;
			}
			set
			{
				School previousValue = this._School.Entity;
				if (((previousValue != value) 
							|| (this._School.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._School.Entity = null;
						previousValue.Students.Remove(this);
					}
					this._School.Entity = value;
					if ((value != null))
					{
						value.Students.Add(this);
						this._SchoolId = value.Id;
					}
					else
					{
						this._SchoolId = default(int);
					}
					this.SendPropertyChanged("School");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.ActivePlayers")]
	public partial class ActivePlayer : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private int _Id;
		
		private int _PlayerId;
		
		private int _GameId;
		
		private System.Nullable<int> _PointsScored;
		
		private bool _Played;
		
		private EntityRef<Game> _Game;
		
		private EntityRef<Player> _Player;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnPlayerIdChanging(int value);
    partial void OnPlayerIdChanged();
    partial void OnGameIdChanging(int value);
    partial void OnGameIdChanged();
    partial void OnPointsScoredChanging(System.Nullable<int> value);
    partial void OnPointsScoredChanged();
    partial void OnPlayedChanging(bool value);
    partial void OnPlayedChanged();
    #endregion
		
		public ActivePlayer()
		{
			this._Game = default(EntityRef<Game>);
			this._Player = default(EntityRef<Player>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", DbType="Int NOT NULL", IsPrimaryKey=true)]
		public int Id
		{
			get
			{
				return this._Id;
			}
			set
			{
				if ((this._Id != value))
				{
					this.OnIdChanging(value);
					this.SendPropertyChanging();
					this._Id = value;
					this.SendPropertyChanged("Id");
					this.OnIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_PlayerId", DbType="Int NOT NULL")]
		public int PlayerId
		{
			get
			{
				return this._PlayerId;
			}
			set
			{
				if ((this._PlayerId != value))
				{
					if (this._Player.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnPlayerIdChanging(value);
					this.SendPropertyChanging();
					this._PlayerId = value;
					this.SendPropertyChanged("PlayerId");
					this.OnPlayerIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_GameId", DbType="Int NOT NULL")]
		public int GameId
		{
			get
			{
				return this._GameId;
			}
			set
			{
				if ((this._GameId != value))
				{
					if (this._Game.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnGameIdChanging(value);
					this.SendPropertyChanging();
					this._GameId = value;
					this.SendPropertyChanged("GameId");
					this.OnGameIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_PointsScored", DbType="Int")]
		public System.Nullable<int> PointsScored
		{
			get
			{
				return this._PointsScored;
			}
			set
			{
				if ((this._PointsScored != value))
				{
					this.OnPointsScoredChanging(value);
					this.SendPropertyChanging();
					this._PointsScored = value;
					this.SendPropertyChanged("PointsScored");
					this.OnPointsScoredChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Played", DbType="Bit NOT NULL")]
		public bool Played
		{
			get
			{
				return this._Played;
			}
			set
			{
				if ((this._Played != value))
				{
					this.OnPlayedChanging(value);
					this.SendPropertyChanging();
					this._Played = value;
					this.SendPropertyChanged("Played");
					this.OnPlayedChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Game_ActivePlayer", Storage="_Game", ThisKey="GameId", OtherKey="Id", IsForeignKey=true)]
		public Game Game
		{
			get
			{
				return this._Game.Entity;
			}
			set
			{
				Game previousValue = this._Game.Entity;
				if (((previousValue != value) 
							|| (this._Game.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Game.Entity = null;
						previousValue.ActivePlayers.Remove(this);
					}
					this._Game.Entity = value;
					if ((value != null))
					{
						value.ActivePlayers.Add(this);
						this._GameId = value.Id;
					}
					else
					{
						this._GameId = default(int);
					}
					this.SendPropertyChanged("Game");
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Player_ActivePlayer", Storage="_Player", ThisKey="PlayerId", OtherKey="Id", IsForeignKey=true)]
		public Player Player
		{
			get
			{
				return this._Player.Entity;
			}
			set
			{
				Player previousValue = this._Player.Entity;
				if (((previousValue != value) 
							|| (this._Player.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Player.Entity = null;
						previousValue.ActivePlayers.Remove(this);
					}
					this._Player.Entity = value;
					if ((value != null))
					{
						value.ActivePlayers.Add(this);
						this._PlayerId = value.Id;
					}
					else
					{
						this._PlayerId = default(int);
					}
					this.SendPropertyChanged("Player");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.Players")]
	public partial class Player : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private int _Id;
		
		private int _TeamId;
		
		private int _StudentId;
		
		private EntitySet<ActivePlayer> _ActivePlayers;
		
		private EntityRef<Student> _Student;
		
		private EntityRef<Team> _Team;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnTeamIdChanging(int value);
    partial void OnTeamIdChanged();
    partial void OnStudentIdChanging(int value);
    partial void OnStudentIdChanged();
    #endregion
		
		public Player()
		{
			this._ActivePlayers = new EntitySet<ActivePlayer>(new Action<ActivePlayer>(this.attach_ActivePlayers), new Action<ActivePlayer>(this.detach_ActivePlayers));
			this._Student = default(EntityRef<Student>);
			this._Team = default(EntityRef<Team>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", AutoSync=AutoSync.OnInsert, DbType="Int NOT NULL IDENTITY", IsPrimaryKey=true, IsDbGenerated=true)]
		public int Id
		{
			get
			{
				return this._Id;
			}
			set
			{
				if ((this._Id != value))
				{
					this.OnIdChanging(value);
					this.SendPropertyChanging();
					this._Id = value;
					this.SendPropertyChanged("Id");
					this.OnIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_TeamId", DbType="Int NOT NULL")]
		public int TeamId
		{
			get
			{
				return this._TeamId;
			}
			set
			{
				if ((this._TeamId != value))
				{
					if (this._Team.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnTeamIdChanging(value);
					this.SendPropertyChanging();
					this._TeamId = value;
					this.SendPropertyChanged("TeamId");
					this.OnTeamIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_StudentId", DbType="Int NOT NULL")]
		public int StudentId
		{
			get
			{
				return this._StudentId;
			}
			set
			{
				if ((this._StudentId != value))
				{
					if (this._Student.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnStudentIdChanging(value);
					this.SendPropertyChanging();
					this._StudentId = value;
					this.SendPropertyChanged("StudentId");
					this.OnStudentIdChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Player_ActivePlayer", Storage="_ActivePlayers", ThisKey="Id", OtherKey="PlayerId")]
		public EntitySet<ActivePlayer> ActivePlayers
		{
			get
			{
				return this._ActivePlayers;
			}
			set
			{
				this._ActivePlayers.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Student_Player", Storage="_Student", ThisKey="StudentId", OtherKey="Id", IsForeignKey=true)]
		public Student Student
		{
			get
			{
				return this._Student.Entity;
			}
			set
			{
				Student previousValue = this._Student.Entity;
				if (((previousValue != value) 
							|| (this._Student.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Student.Entity = null;
						previousValue.Players = null;
					}
					this._Student.Entity = value;
					if ((value != null))
					{
						value.Players = this;
						this._StudentId = value.Id;
					}
					else
					{
						this._StudentId = default(int);
					}
					this.SendPropertyChanged("Student");
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="Team_Player", Storage="_Team", ThisKey="TeamId", OtherKey="Id", IsForeignKey=true)]
		public Team Team
		{
			get
			{
				return this._Team.Entity;
			}
			set
			{
				Team previousValue = this._Team.Entity;
				if (((previousValue != value) 
							|| (this._Team.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._Team.Entity = null;
						previousValue.Players.Remove(this);
					}
					this._Team.Entity = value;
					if ((value != null))
					{
						value.Players.Add(this);
						this._TeamId = value.Id;
					}
					else
					{
						this._TeamId = default(int);
					}
					this.SendPropertyChanged("Team");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_ActivePlayers(ActivePlayer entity)
		{
			this.SendPropertyChanging();
			entity.Player = this;
		}
		
		private void detach_ActivePlayers(ActivePlayer entity)
		{
			this.SendPropertyChanging();
			entity.Player = null;
		}
	}
}
#pragma warning restore 1591
