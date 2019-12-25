using System.Collections.Generic;

namespace LabCSharp.Resources.Service
{
	interface IService<T> where T: class
	{
		T FindOne(T Entity);
		T DeleteOne(T Entity);
		T UpdateOne(T Entity);
		void InsertOne(T Entity);

		List<T> GetAll();
	}
}
