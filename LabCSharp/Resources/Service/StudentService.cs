using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Gateway;
using LabCSharp.Resources.Validator;

namespace LabCSharp.Resources.Service
{
	class StudentService: BaseService<Student>
	{
		private readonly BaseGateway<Student> _gateway;
		private readonly BaseGateway<School> _schoolGateway;

		public StudentService() : base(new BaseGateway<Student>(), new Validator<Student>() )
		{
			_gateway = new BaseGateway<Student>();
			_schoolGateway = new BaseGateway<School>();
		}
		public void PopulateStudents()
		{

			string[] names = { "Mahesh Chand", "Jeff Prosise", "Dave McCarter", "Allen O'neill",
				"Monica Rathbun", "Henry He", "Raj Kumar", "Mark Prime",
				"Rose Tracey", "Mike Crown" , "Optimus Prime", "Michael Jordan", "Roger Federer"};
			// Generate a random index less than the size of the array.  
			Random rand = new Random();
			foreach (var school in _schoolGateway.GetAll())
			{
				for (var i = 0; i < 15; i++)
				{
					int index = rand.Next(names.Length);
					string first = names[index].Split(' ')[0];
					index = rand.Next(names.Length);
					string second = names[index].Split(' ')[1];
					Student aux = new Student {SchoolId = school.Id, Name = $"{first} {second}"};
					InsertOne(aux);
				}
			}

		}
	}
}
