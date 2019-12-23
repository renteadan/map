using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabCSharp.Validator
{
	public class Validator<T> : IValidator<T>
	{
		public virtual void Validate(T Entity)
		{
			if (Entity == null)
				throw new System.NullReferenceException();
		}

		public Validator() { }
	}
}
