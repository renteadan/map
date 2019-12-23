using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabCSharp.Validator
{
	interface IValidator<T>
	{
		void Validate(T Entity);
	}
}
