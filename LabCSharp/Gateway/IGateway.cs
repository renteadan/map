﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabCSharp.Gateway
{
	interface IGateway<T>
	{
		T FindOne(T Entity);
		T DeleteOne(T Entity);
		T UpdateOne(T Entity);
		void InsertOne(T Entity);

		List<T> GetAll();
	}
}
